package ravi.web;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.

http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ravi.model.ParentBeans;
import ravi.services.SubscriptionsService;
import ravi.util.Utilities;

/**
 * Servlet implementation class CreateSubscription
 */
@WebServlet("/CreateSubscription")
public class CreateSubscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con = (Connection) getServletContext().getAttribute("DBConnection");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		String eventUrl = (String) request.getParameter("e");
		System.out.println("I am gonna print the url now \n");
		System.out.println(eventUrl);
		

		String output = Utilities.getEventUrlJsonString(eventUrl);
		// output.toString();
		System.out.println(output.toString());

		// Reading Json....
		try {
			ParentBeans parentBeans=Utilities.extractDataFromJson(output);
			SubscriptionsService ss=new SubscriptionsService();
			if(ss.checkifExists(parentBeans, con)){
					out.print(Utilities.sendFailureResponse(response));
//				out.print(Utilities.sendSuccessResponse(response, ss.getAccountIdentifierforExisting(parentBeans, con)));
			}else{
				ss.save(parentBeans, con);
				out.print(Utilities.sendSuccessResponse(response,ss.getAccountIdentifierforExisting(parentBeans, con)));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
