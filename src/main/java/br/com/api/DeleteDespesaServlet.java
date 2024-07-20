package br.com.api;

import br.com.codandosimples.dao.DespesaDAO;
import br.com.codandosimples.infra.ConnectionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("deleteDespesa")
public class DeleteDespesaServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = ConnectionFactory.getConnection();
        DespesaDAO dao = new DespesaDAO(connection);
        String id = request.getParameter("id");
        dao.delete(Long.valueOf(id));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/listDespesas");
        dispatcher.forward(request, response);
    }
}
