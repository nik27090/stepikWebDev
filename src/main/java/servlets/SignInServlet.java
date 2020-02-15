package servlets;

import accounts.UserService;
import dbService.dataSets.UsersDataSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {
    private final UserService userService;

    public SignInServlet(UserService userService){
        this.userService = userService;
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException{
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        UsersDataSet user = userService.findUser(login);
        response.setContentType("text/html;charset=utf-8");
        if (user == null){
            response.getWriter().println("Unauthorized");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } else if (pass.equals(user.getPassword())) {
            response.getWriter().println("Authorized: " + login);
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.getWriter().println("Unauthorized(Неверный пароль)");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
