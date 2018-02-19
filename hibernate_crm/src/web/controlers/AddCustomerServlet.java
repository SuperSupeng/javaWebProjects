package web.controlers;

import domain.Customer;
import org.apache.commons.beanutils.BeanUtils;
import service.BusinessService;
import service.impl.BusinessServiceImpl;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "AddCustomerServlet", urlPatterns = "/AddCustomerServlet")
public class AddCustomerServlet extends javax.servlet.http.HttpServlet {
    private BusinessService s = new BusinessServiceImpl();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //1 获得参数并封装到Customer对象
        Customer c = new Customer();
        try {
            BeanUtils.populate(c, request.getParameterMap());
        }catch (Exception e) {
            e.printStackTrace();
        }
        s.save(c);
        response.sendRedirect(request.getContextPath()+"/ListCustomerServlet");
    }
}
