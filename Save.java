import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
@WebServlet("/Save")
public class Save extends HttpServlet {
    public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException
    {
        resp.setContentType("html/type");
        PrintWriter pr=resp.getWriter();
        try
        {
			Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","test","sql");
            Statement st=con.createStatement();
            String name='\''+req.getParameter("Name")+'\'';
            String age='\''+req.getParameter("Age")+'\'';
			String country='\''+req.getParameter("country")+'\'';
			String dob='\''+req.getParameter("dob")+'\'';
            String gender='\''+req.getParameter("gender")+'\'';
			String language='\''+req.getParameter("language")+'\'';
            String email='\''+req.getParameter("email_id")+'\'';
			String sttime='\''+req.getParameter("appt")+'\'';
			String cgpa='\''+req.getParameter("cgpa")+'\'';
            int i=st.executeUpdate("insert into formdet values ("+name+","+age+","+country+","+dob+","+gender+","+language+","+email+","+sttime+","+cgpa+")");
            if(i!=0)
            {
                pr.println("Registered Successfully");
            }
            else
            {
                pr.println("Register The form with The Correct Data");
            }
            con.close();
            pr.close();
        }
        catch(Exception e)
        {
            pr.println(e);
        }
    }
}
