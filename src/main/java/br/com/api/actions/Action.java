package br.com.api.actions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Action {

    String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
