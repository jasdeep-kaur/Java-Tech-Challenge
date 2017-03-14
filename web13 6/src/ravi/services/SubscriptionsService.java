package ravi.services;

import java.sql.SQLException;
import java.sql.Connection;

import dao.CreateDao;
import ravi.model.ParentBeans;

public class SubscriptionsService {

	private CreateDao c;

	public SubscriptionsService() {
		c=new CreateDao();
	}
	
	public boolean checkifExists(ParentBeans parentBeans, Connection con){
		String accountIdentifier=c.checkifAlreadyExists(parentBeans, con);
		if(accountIdentifier !=null && !accountIdentifier.isEmpty()){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean cancelSubscription(ParentBeans parentBeans, Connection con) throws SQLException{

		String accountIdentifier=c.checkifAlreadyExists(parentBeans, con);
		if(checkifExists(parentBeans, con)){
			System.out.println("Inside if");
			c.removeSubscription(parentBeans.getPayload().getAccount().getAccountIdentifier(), con);
			return true;
		}else{
			return false;
		}
	}

	public void save(ParentBeans parentBeans, Connection con) throws SQLException{
		c.saveOrder(parentBeans, con);
	}
	
	public String getAccountIdentifierforExisting(ParentBeans parentBeans, Connection con){
		return c.checkifAlreadyExists(parentBeans, con);
	}
	
	
	
}
