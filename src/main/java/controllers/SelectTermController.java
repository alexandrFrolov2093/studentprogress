package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SelectTermController", urlPatterns = "/terms-select")

public class SelectTermController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idSelectedTerm = req.getParameter("selectTerm");
        req.setAttribute("idSelectedTerm", idSelectedTerm);
        resp.sendRedirect("/terms");

    }
}
