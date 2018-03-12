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
import java.util.Date;
import java.util.List;

@WebServlet(name = "InverseServlet", urlPatterns = "/InverseServlet")
public class InverseServlet extends HttpServlet {
    private TempDataService service = new TempDataServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List tempList = (List) request.getSession().getAttribute("tempList");
        String op = request.getParameter("op");

        if("allInverse".equals(op)){
            tempList.sort((Comparator<TempData>) (o1, o2) -> {
                if(o1.getTemperature()<o2.getTemperature()){
                    return -1;
                }else if(o1.getTemperature().equals(o2.getTemperature())){
                    return 0;
                }else{
                    return 1;
                }
            });
        }else if("allReversed".equals(op)){
            tempList.sort((Comparator<TempData>) (o1, o2) -> {
                if(o1.getTemperature()<o2.getTemperature()){
                    return 1;
                }else if(o1.getTemperature().equals(o2.getTemperature())){
                    return 0;
                }else{
                    return -1;
                }
            });
        }

        request.getSession().setAttribute("tempList", tempList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
