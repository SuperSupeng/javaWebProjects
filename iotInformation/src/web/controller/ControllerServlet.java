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
import java.util.Date;
import java.util.List;

@WebServlet(name = "ControllerServlet", urlPatterns = "/ControllerServlet")
public class ControllerServlet extends HttpServlet {
    private TempDataService service = new TempDataServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        Date sDate = new Date(startDate);
        Date eDate = new Date(endDate);


        if("all".equals(op)){


            List<TempData> allData = service.findAllData(sDate, eDate, true);
            request.getSession().setAttribute("tempList", allData);
        }else if("allInverse".equals(op)){

        }else if("allReversed".equals(op)){

        }


        request.getRequestDispatcher(request.getContextPath() + "/index.jsp").forward(request, response);
    }
}
