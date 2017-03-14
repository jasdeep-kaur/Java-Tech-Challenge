package ravi.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import ravi.model.ParentBeans;
import ravi.model.ResponseSuccess;
import ravi.services.SubscriptionsService;
import ravi.util.Utilities;

/**
 * Servlet implementation class UodateSubscription
 */
@WebServlet("/UodateSubscription")
public class UpdateSubscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.setContentType("application/json");
//		PrintWriter out = response.getWriter();
//        String eventUrl = (String) request.getParameter("eventUrl");
//        ObjectMapper mapper = new ObjectMapper();
//        response.setStatus(200);
//        ResponseSuccess responseObject=new ResponseSuccess(true, "new-account-identifier");
//        String json = mapper.writeValueAsString(responseObject);
//        out.print(json);
//        System.out.println(eventUrl);
//	}
	
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
			if(ss.getAccountIdentifierforExisting(parentBeans, con) == parentBeans.getPayload().getAccount().getAccountIdentifier()){
				boolean verifyCancel=ss.cancelSubscription(parentBeans, con);
				if(verifyCancel){
					System.out.println("Subscription Cancel successful");
					out.println(Utilities.sendFailureResponse(response));
				}
					
					out.print(Utilities.sendFailureResponse(response));
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
