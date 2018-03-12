package web.controller;

import domain.TempData;
import service.TempDataService;
import service.impl.TempDataServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@WebServlet(name = "TempServlet", urlPatterns = "/TempServlet")
public class TempServlet extends HttpServlet {
    private TempDataService service = new TempDataServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Object min = request.getSession().getAttribute("min");
        Object max = request.getSession().getAttribute("max");
        if(min==null || "".equals(min)){
            min = Double.MIN_VALUE+"";
        }
        if(max==null || "".equals(max)){
            max = Double.MAX_VALUE + "";
        }
        double minV = Double.valueOf(min.toString());
        double maxV = Double.valueOf(max.toString());
        System.out.println(minV + ":" + maxV);
        request.getSession().setAttribute("min", minV);
        request.getSession().setAttribute("max", maxV);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
