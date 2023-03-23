/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commands;

import business.User;
import daos.UserDao;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mcgeo
 */
public class RegisterCommand implements Command {

    private HttpServletRequest request;
    private HttpServletResponse response;

    public RegisterCommand(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String execute() {
        String forwardToJsp = "index.jsp";
        HttpSession session = request.getSession(true);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        int isCritic = Integer.getInteger(request.getParameter("isCritic"));
        int isAdmin = Integer.getInteger(request.getParameter("isAdmin"));

        if (username != null && password != null && !username.isEmpty() && !password.isEmpty() && firstname != null && !lastname.isEmpty() && !lastname.isEmpty()) {
            UserDao userDao = new UserDao("getgud");
            int id = userDao.addUser(username, password, email, firstname, lastname, isCritic, isAdmin);
            if (id == -1) {
                forwardToJsp = "error.jsp";
                String error = "This user could not be added. Please <a href=\"register.jsp\">try again.</a>";
                session.setAttribute("errorMessage", error);
            } else {
                forwardToJsp = "loginSuccessful.jsp";
                session.setAttribute("username", username);
                User u = new User(id, username, password, email, firstname, lastname, isCritic, isAdmin);
                session.setAttribute("user", u);
                String msg = "Registration successful, you are now logged in!";
                session.setAttribute("msg", msg);
            }
        } else {
            forwardToJsp = "error.jsp";
            String error = "Some information was not supplied. Please <a href=\"register.jsp\">try again.</a>";
            session.setAttribute("errorMessage", error);
        }
        return forwardToJsp;

    }

}
