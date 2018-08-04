import dao.UserDao;
import model.User;
import util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name="/LoginServlet")
public class LoginServlet extends HttpServlet {
    DbUtil dbUtil = new DbUtil();
    UserDao userDao = new UserDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("连接请求");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        Connection connection = null ;
        User user = new User(userName,password);
        connection = dbUtil.getConnection() ;
        User currentUser = null;
        try {
            currentUser = userDao.login(connection,user);
            if(null == currentUser){
                System.out.println("登录失败！");
                request.setAttribute("error","userName or Password invalid");
                request.setAttribute("userName",userName);
                request.setAttribute("password",password);
                request.getRequestDispatcher("login.jsp").forward(request,response);
                //转发
            }else{
                System.out.println("登录成功！");
                HttpSession session = request.getSession();
                session.setAttribute("currentUser",currentUser);
                response.sendRedirect("main.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}