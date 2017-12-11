package controller;

import entity.Utilizator;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.SessionUtilizator;
import session.SessionUtilizatorLocal;

@WebServlet(name = "ServletAutentificare", urlPatterns = {"/ServletAutentificare"})
public class ServletAutentificare extends HttpServlet {
    @EJB
    private SessionUtilizatorLocal utilizator;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");    
        try (PrintWriter out = response.getWriter()) {
            String nume_de_utilizator = request.getParameter("nume_de_utilizator");
            String parola = request.getParameter("parola");
             Utilizator user = utilizator.login(nume_de_utilizator, parola);
            
            if(user != null ){
                switch(user.getTip()){
                    case 1:
                        
                    break;
                    
                    case 2:
                        
                    break;
                    
                    case 3:
                        
                    break;
                    
                    case 4:
                        response.sendRedirect("paginautilizator.jsp");
                    break;
                    
                    default:
                        response.sendRedirect("index.jsp");
                    break;
                    
                    
                }
                
                
            }else{
                try{
                  out.println("Date eronate. <a href=autentificare.jsp>Incearca din nou</a>");
                } finally {
                    out.close();
                }
            }
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
