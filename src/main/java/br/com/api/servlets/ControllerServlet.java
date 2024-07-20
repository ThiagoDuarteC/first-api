package br.com.api.servlets;

import br.com.api.actions.Action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionName = request.getParameter("action");
        String pacote = "br.com.api.actions.";

        try {
            Class<?> classe = Class.forName(pacote + actionName);
            Action action = (Action) classe.newInstance();

            String result = action.exec(request, response);

            RequestDispatcher dispatcher = request.getRequestDispatcher(result);
            dispatcher.forward(request, response);

//            switch (actionName) {
//                case "ListDespesas":
//                    new ListDespesas().exec(request, response);
//                    break;
//                case "CreateDespesa":
//                    new CreateDespesa().exec(request, response);
//                    break;
//                case "DeleteDespesa":
//                    new DeleteDespesa().exec(request, response);
//                    break;
//            }
        } catch (Exception e) {

        }
    }
}
