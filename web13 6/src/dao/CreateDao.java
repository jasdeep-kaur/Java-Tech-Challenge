package dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import ravi.model.ParentBeans;
import ravi.util.Utilities;

public class CreateDao {

	public void saveOrder(ParentBeans parentBeans, Connection con) throws SQLException {
		String fname = parentBeans.getCreator().getFirstName();
		String uuid = parentBeans.getCreator().getUuid();
		String accountIdentifier = Utilities.getNewAccountIdentifier(fname, uuid);
		PreparedStatement pst = con.prepareStatement("Insert into sub_create values (null,?,?,?,?,?,?,?,?)");
		pst.setString(1, parentBeans.getType());
		pst.setString(2, parentBeans.getCreator().getFirstName());
		System.out.println(parentBeans.getCreator().getEmail());
		pst.setString(3, parentBeans.getCreator().getEmail());
		pst.setString(4, parentBeans.getCreator().getUuid());
		pst.setString(5, parentBeans.getPayload().getCompany().getUuid());
		pst.setString(6, parentBeans.getPayload().getOrder().getPricingDuration());
		pst.setInt(7, 1);
		pst.setString(8, accountIdentifier);

		pst.execute();
		System.out.println("User Data has been saved to databse with accountIdentifier : " + accountIdentifier);
	}

	public String checkifAlreadyExists(ParentBeans parentBeans, Connection con) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String accountIdentifier = null;
		String fname = parentBeans.getCreator().getFirstName();
		String uuid = parentBeans.getCreator().getUuid();

		try {
			ps = con.prepareStatement("select * from sub_create where fname=? and creatoruuid=? limit 1");
			ps.setString(1, fname);
			ps.setString(2, uuid);
			rs = ps.executeQuery();

			if (rs != null && rs.next()) {
				accountIdentifier = rs.getString("accountIdentifier");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return accountIdentifier;
	}

	public void removeSubscription(String accountIdentifier, Connection con) throws SQLException {
		try {
			String sql = "Delete from sub_create where accountidentifier=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, accountIdentifier);
			pst.execute();
			System.out.println("Account with Account Identifier value:" + accountIdentifier + " has been removed");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}