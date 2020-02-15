package servlets;

import accounts.UserService;
import dbService.dataSets.UsersDataSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {
    private final UserService userService;

    public SignUpServlet(UserService userService){
        this.userService = userService;
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException{
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        UsersDataSet user = userService.findUser(login);
        if (user == null) {
            userService.saveUser(new UsersDataSet(login, pass));
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("all right");
        } else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("takoi yzhe akk est'");
        }
    }
}
