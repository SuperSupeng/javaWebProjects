package web.controlers;

import domain.LinkMan;
import org.apache.commons.beanutils.BeanUtils;
import service.LinkManService;
import service.impl.LinkManServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "AddLinkManServlet")
public class AddLinkManServlet extends HttpServlet {
    private LinkManService lms = new LinkManServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LinkMan linkMan = new LinkMan();
        try {
            BeanUtils.populate(linkMan, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        lms.save(linkMan);
        response.sendRedirect(request.getContextPath()+"/ListLinkManServlet");
    }
}
