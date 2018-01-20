package com.superDemo.web.controller;

import com.superDemo.domain.Customer;
import com.superDemo.service.BusinessService;
import com.superDemo.service.impl.BusinessServiceImpl;
import com.superDemo.util.FormBeanUtil;
import com.superDemo.web.bean.CustomerFormBean;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

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
    private String encoding = "UTF-8";
    private BusinessService s = new BusinessServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset="+encoding);

        String op = request.getParameter("op");
        if("showAllCustomers".equals(op)){
            showAllCustomers(request,response);
        }else if("addCustomer".equals(op)){
            addCustomer(request,response);
        }else if("delCustomer".equals(op)){
            delCustomer(request,response);
        }
    }

    private void delCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String customerId = request.getParameter("customerId");
        s.deleteCustomerById(customerId);
        response.getWriter().write("删除成功。2秒后自动转向主页");
        response.setHeader("Refresh", "2;URL="+request.getContextPath());
    }

    //保存客户信息
    private void addCustomer(HttpServletRequest request,
                             HttpServletResponse response) throws ServletException, IOException{
        try {
            //封装数据到formbean
            CustomerFormBean formBean = FormBeanUtil.fillBean(request, CustomerFormBean.class);
            if(!formBean.validate()){
                request.setAttribute("formBean", formBean);
                request.getRequestDispatcher("/addCustomer.jsp").forward(request, response);
                return;
            }
            //填充模型
            Customer c = new Customer();
            ConvertUtils.register(new DateLocaleConverter(), Date.class);
            BeanUtils.copyProperties(c, formBean);
            //单独处理爱好
            String hobbies[] = request.getParameterValues("hobbies");
            if(hobbies!=null&&hobbies.length>0){
                StringBuffer sb = new StringBuffer();
                for(int i=0;i<hobbies.length;i++){
                    if(i>0)
                        sb.append(",");
                    sb.append(hobbies[i]);
                }
                c.setHobby(sb.toString());
            }

            s.saveCustomer(c);
            response.getWriter().write("保存成功。2秒后自动转向主页");
            response.setHeader("Refresh", "2;URL="+request.getContextPath());

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("服务器忙");
        }
    }
    //查询所有客户信息
    private void showAllCustomers(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException{
        List<Customer> cs = s.findAllCustomers();
        request.setAttribute("cs", cs);
        request.getRequestDispatcher("/listCustomers.jsp").forward(request, response);
    }
}
