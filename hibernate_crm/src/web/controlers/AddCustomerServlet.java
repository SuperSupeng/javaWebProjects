package web.controlers;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "AddCustomerServlet", urlPatterns = "/AddCustomerServlet")
public class AddCustomerServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
