package ravi.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ravi.model.ParentBeans;
import ravi.services.SubscriptionsService;
import ravi.util.Utilities;

@WebServlet("/CancelSubscription")
public class CancelSubscription extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = (Connection) getServletContext().getAttribute("DBConnection");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		String eventUrl = (String) request.getParameter("e");
		System.out.println("Recieved SUBSCRIPTION_CANCEL url is :\n"+ eventUrl);
//		System.out.println(eventUrl);

		String jsonOutput = Utilities.getEventUrlJsonString(eventUrl);
		// output.toString();
		System.out.println(jsonOutput.toString());

		// Reading Json....
		try {
			ParentBeans parentBeans=Utilities.extractDataFromJson(jsonOutput);
			
			SubscriptionsService ss=new SubscriptionsService();
			
			if(ss.getAccountIdentifierforExisting(parentBeans, con).equals(parentBeans.getPayload().getAccount().getAccountIdentifier())){
//				
				boolean verifyCancel=ss.cancelSubscription(parentBeans, con);
				if(verifyCancel){
					System.out.println("Subscription Cancel successful");
					out.println(Utilities.sendSuccessResponse(response, parentBeans.getPayload().getAccount().getAccountIdentifier()));
				}
			}else{
				out.print(Utilities.sendFailureResponse(response));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	
}
