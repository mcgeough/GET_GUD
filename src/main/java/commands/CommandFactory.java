/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandFactory {

    public Command createCommand(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        Command c = null;
        if (action != null) {
            switch (action) {
                case "login":
                    c = new LoginCommand(request, response);
                    break;
                case "register":
                    c = new RegisterCommand(request, response);
                    break;
                case "logout":
                    c = new LogoutCommand(request, response);
                    break;

                default:
                    String error = "No such action defined for this application. Please try again.";
                    c = new ErrorCommand(error, request);
            }
        } else {
            String error = "No action supplied. Please try again.";
            c = new ErrorCommand(error, request);
        }

        return c;
    }
}
