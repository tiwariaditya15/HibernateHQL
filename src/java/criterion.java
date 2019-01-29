
import com.aditya.Employee;
import com.sun.xml.ws.tx.coord.common.types.CreateCoordinationContextType;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

@WebServlet(urlPatterns = {"/criterion"})
public class criterion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String source = "31-12-2018";
        Date date = null;
        try {
            date = new SimpleDateFormat("dd-mm-yyyy").parse(source);
        } catch (ParseException ex) {
            Logger.getLogger(criterion.class.getName()).log(Level.SEVERE, null, ex);
        }
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.add(Restrictions.gt("dateofjoin", date));
        //criteria.add(Restrictions.gt("salary", sal));
        //criteria.add(Restrictions.eq("dept", "IT"));
        List<Employee> results = criteria.list();
                
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet criterion</title>");            
            out.println("</head>");
            out.println("<body>");
            int i = 1;
            for (Employee result : results) {
              out.println("<h3>Record Number : " + i + "</h3>");  
              out.println("<h5>Employee id : " + result.getId() + "<br/> Name : "+ result.getName() + "<br/>Designation : " + result.getDesignation() + "<br/>Department : " + result.getDept() 
                      + "</br>Salary : " + result.getSalary() + "<br/>Date Of Join : " + result.getDateofjoin() + " </h5><br/><br/>");
               i++;
            }
            out.println("Done...");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
