package ravi.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by raviagrawal on 29/01/17.
 */
@WebServlet(name = "DBServlet")
public class DBServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        Connection con = (Connection) getServletContext().getAttribute("DBConnection");
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("select * from USER where USER_NAME=? limit 1");
            ps.setString(1, "Fame Issrani");
            rs = ps.executeQuery();

            if(rs != null && rs.next()){
                String name = rs.getString("USER_NAME");
                PrintWriter out= response.getWriter();
                out.println("User name is - " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("DB Connection problem.");
        }finally{
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }

        }
    }
}
