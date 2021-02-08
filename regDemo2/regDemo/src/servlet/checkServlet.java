package servlet;

import dao.RegisterDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/check")
public class checkServlet extends HttpServlet {
    private RegisterDao registerDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        registerDao = new RegisterDao();
        try {

            registerDao.updateUser(id);
        }catch (Exception e){

        }
        response.sendRedirect(request.getContextPath()+"/success.jsp");

    }
}
