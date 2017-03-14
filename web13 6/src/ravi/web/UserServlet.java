package ravi.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import ravi.model.TestJson;
import ravi.model.User;

/**
 * Created by raviagrawal on 29/01/17.
 */
@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        String eventUrl = (String) request.getParameter("eventUrl");

        ObjectMapper mapper = new ObjectMapper();
/*
        BufferedReader reader = request.getReader();
        User user1 = mapper.readValue(reader, User.class);
*/

        TestJson testJson = new TestJson();
        testJson.setEventUrl(eventUrl);
//        testJson.setUser(user1);

        String json = mapper.writeValueAsString(testJson);
        out.print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
//        User u1 = new User(1, "ravi");
//        String json = mapper.writeValueAsString(u1);
//        out.print(json);
    }
}
