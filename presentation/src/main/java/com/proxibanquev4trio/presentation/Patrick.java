package com.proxibanquev4trio.presentation;

import com.proxibanquev4trio.services.UnService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Guillaume on 06/10/2016.
 */
@WebServlet(name = "patrick", urlPatterns = "/patrick", loadOnStartup = 1)
public class Patrick extends HttpServlet {

    UnService unService = new UnService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("=========================================================");
        unService.doSomething();
        System.out.println("=========================================================");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("");
        requestDispatcher.forward(req,resp);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
