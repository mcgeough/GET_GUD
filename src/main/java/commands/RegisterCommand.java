/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commands;

import business.User;
import daos.UserDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterCommand implements Command {

    private HttpServletRequest request;
    private HttpServletResponse response;

    public RegisterCommand(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public String execute() {
        String forwardToJsp = "index.jsp";
        HttpSession session = request.getSession(true);
        String uname = request.getParameter("username");
        String pword = request.getParameter("password");
        String first = request.getParameter("fName");
        String last = request.getParameter("lName");

        if (uname != null && pword != null && !uname.isEmpty() && !pword.isEmpty() && first != null && !first.isEmpty() && last != null && !last.isEmpty()) {
            UserDao userDao = new UserDao("user_database");
            int id = userDao.addUser(uname, pword, first, last);
            if (id == -1) {
                forwardToJsp = "error.jsp";
                String error = "This user could not be added. Please <a href=\"register.jsp\">try again.</a>";
                session.setAttribute("errorMessage", error);
            } else {
                forwardToJsp = "loginSuccessful.jsp";
                session.setAttribute("username", uname);
                User u = new User(id, first, last, uname, pword);
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
