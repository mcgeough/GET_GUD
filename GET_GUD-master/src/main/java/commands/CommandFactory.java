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
                case "register":
                    c = new RegisterCommand(request, response);
                case "login":
                    c = new LoginCommand(request, response);

                
            }
        } else {
            String error = "No action supplied. Please try again.";
            c = new ErrorCommand(error, request);
        }

        return c;
    }
}
