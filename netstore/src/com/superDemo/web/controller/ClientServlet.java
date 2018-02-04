package com.superDemo.web.controller;

import com.superDemo.commons.Page;
import com.superDemo.domain.Book;
import com.superDemo.domain.Category;
import com.superDemo.domain.Customer;
import com.superDemo.service.BusinessService;
import com.superDemo.service.impl.BusinessServiceImpl;
import com.superDemo.util.FillBeanUtil;
import com.superDemo.util.SendMail;
import com.superDemo.web.beans.Cart;
import com.superDemo.web.beans.CartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ClientServlet", urlPatterns = "/ClientServlet")
public class ClientServlet extends HttpServlet {
    private BusinessService s = new BusinessServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        if("showIndex".equals(op)){
            showIndex(request, response);
        }else if("showCategoryBooks".equals(op)){
            showCategoryBooks(request, response);
        }else if("showBookDetails".equals(op)){
            showBookDetails(request, response);
        }else if("buyBook".equals(op)){
            buyBook(request, response);
        }else if("changeNum".equals(op)){
            changeNum(request,response);
        }else if("delOneItem".equals(op)){
            delOneItem(request,response);
        }else if("registCustomer".equals(op)){
            registCustomer(request, response);
        }
    }

    //新用户注册，并发送激活邮件
    private void registCustomer(HttpServletRequest request,
                                HttpServletResponse response)  throws ServletException, IOException {
        Customer c = FillBeanUtil.fillBean(request, Customer.class);
        String code = UUID.randomUUID().toString();
        c.setCode(code);
        SendMail sm = new SendMail(c);
        sm.start();
        s.regitsCustomer(c);
        request.setAttribute("msg", "注册成功！我们已经发送了一封激活邮件到您的"+c.getEmail()+"邮箱中，请及时激活您的账户");
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

    private void delOneItem(HttpServletRequest request,
                            HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("bookId");
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.getItems().remove(bookId);
        response.sendRedirect(request.getContextPath()+"/showCart.jsp");
    }

    private void changeNum(HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("bookId");
        String newNum = request.getParameter("num");//修改的新的数量
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        CartItem item = cart.getItems().get(bookId);
        item.setQuantity(Integer.parseInt(newNum));
        response.sendRedirect(request.getContextPath()+"/showCart.jsp");
    }


    private void buyBook(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("bookId");
        Book book = s.findBookById(bookId);

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        cart.addBook(book);
        request.setAttribute("msg", "书籍已经放入您的购物车，<a href='"+request.getContextPath()+"'>继续购物</a>");
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

    private void showBookDetails(HttpServletRequest request,
                                 HttpServletResponse response) throws ServletException, IOException{
        String bookId = request.getParameter("bookId");
        Book book = s.findBookById(bookId);
        request.setAttribute("book", book);
        request.getRequestDispatcher("/showDetails.jsp").forward(request, response);
    }

    private void showCategoryBooks(HttpServletRequest request,
                                   HttpServletResponse response) throws ServletException, IOException{
        String num = request.getParameter("num");
        String categoryId = request.getParameter("categoryId");

        //查询所有的分类
        List<Category> cs = s.findAllCategories();
        //查询所有的分页书籍
        Page page = s.findAllBookPageRecords(num, categoryId);
        page.setUrl("/ClientServlet?op=showCategoryBooks&categoryId="+categoryId);

        request.setAttribute("cs",cs);
        request.setAttribute("page", page);

        request.getRequestDispatcher("/listAllBooks.jsp").forward(request, response);

    }

    private void showIndex(HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException{
        String num = request.getParameter("num");
        List<Category> cs = s.findAllCategories();
        Page page = s.findAllBookPageRecords(num);
        page.setUrl("/ClientServlet?op=showIndex");
        request.setAttribute("cs", cs);
        request.setAttribute("page", page);

        request.getRequestDispatcher("/listAllBooks.jsp").forward(request, response);
    }

}
