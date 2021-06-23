package org.sergeyzhirkov.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyServlet", urlPatterns = "/product")
public class MyServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(MyServlet.class);


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Log: MyServlet");
        resp.setContentType("text");
        PrintWriter out = resp.getWriter();
        for (int i = 0; i < 10; i++) {
            out.println(new Product(i));
        }

        out.close();
    }
}
