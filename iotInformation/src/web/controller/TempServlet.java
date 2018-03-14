package web.controller;

import service.TempDataService;
import service.impl.TempDataServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author super
 */
@WebServlet(name = "TempServlet", urlPatterns = "/TempServlet")
public class TempServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String min = request.getParameter("min");
        String max = request.getParameter("max");
        if("".equals(min)){
            min = "-1000";
        }
        if("".equals(max)){
            max = "1000";
        }
        double minV = Double.valueOf(min);
        double maxV = Double.valueOf(max);
        request.getSession().setAttribute("min", minV);
        request.getSession().setAttribute("max", maxV);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
