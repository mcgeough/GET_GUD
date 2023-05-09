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

    @Override
    public String execute() {
        String forwardToJsp = "index.jsp";
        HttpSession session = request.getSession(true);
        String uname = request.getParameter("username");
        System.out.println(uname);
        String pword = request.getParameter("password");
        System.out.println(pword);
        String mail = request.getParameter("email");
        System.out.println(mail);
        String first = request.getParameter("firstName");
        System.out.println(first);
        String last = request.getParameter("lastName");
        System.out.println(last);
        String dob = request.getParameter("dob");
        System.out.println(dob);
        int isCrit = Integer.valueOf(request.getParameter("critic"));
        System.out.println(isCrit);
        int isAd = Integer.valueOf(request.getParameter("admin"));
        System.out.println(isAd);

        if (uname != null && pword != null && !uname.isEmpty() && !pword.isEmpty() && first != null && !first.isEmpty() && last != null && !last.isEmpty()) {
            UserDao userDao = new UserDao("getgud");
            int id = userDao.addUser(uname, pword, mail, first, last, dob, isCrit, isAd);
            if (id == -1) {
                forwardToJsp = "error.jsp";
                String error = "This user could not be added. Please <a href=\"register.jsp\">try again.</a>";
                session.setAttribute("errorMessage", error);
            } else {
                forwardToJsp = "loginSuccessful.jsp";
                session.setAttribute("username", uname);
                User u = new User(id, uname, pword, mail, first, last, dob, isCrit, isAd);
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
