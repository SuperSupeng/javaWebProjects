package web.controlers;

import domain.Customer;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import service.BusinessService;
import service.impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListCustomerServlet", urlPatterns = "/ListCustomerServlet")
public class ListCustomerServlet extends HttpServlet {
    private BusinessService s = new BusinessServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cust_name = request.getParameter("cust_name");
        DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
        if(cust_name!=null && !"".equals(cust_name.trim())){
            dc.add(Restrictions.like("cust_name","%"+cust_name+"%"));
        }

        List<Customer> list = s.findAll(dc);
        request.setAttribute("list", list);
        request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request, response);
    }
}
