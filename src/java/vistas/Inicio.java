/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static controlador.controladorMoneda.thisIsNotThreadsafe;

/**
 *
 * @author Jorge Baez
 */
public class Inicio extends HttpServlet {        
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet home</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet home at " + request.getContextPath() + "</h1>");            
//            out.println("</body>");
//            out.println("</html>");
//        }
        HttpSession sesion = request.getSession();        
        if (thisIsNotThreadsafe == null) {
            thisIsNotThreadsafe = null;
            sesion.setAttribute("nombreMoneda", "$ Pesos Mexicanos");
            sesion.setAttribute("tipoMoneda", "MXN");            
        } else {
            switch (thisIsNotThreadsafe) {
                case "MXN":
                    thisIsNotThreadsafe = null;
                    sesion.setAttribute("nombreMoneda", "$ Pesos Mexicanos");
                    sesion.setAttribute("tipoMoneda", "MXN");                    
                break;

                case "COP":
                    thisIsNotThreadsafe = null;
                    sesion.setAttribute("nombreMoneda", "Pesos Colombianos");
                    sesion.setAttribute("tipoMoneda", "COP");                    
                break;

                case "USD":
                    thisIsNotThreadsafe = null;
                    sesion.setAttribute("nombreMoneda", "Dolar Estadounidense");
                    sesion.setAttribute("tipoMoneda", "USD");                    
                break;

                case "PEN":
                    thisIsNotThreadsafe = null;
                    sesion.setAttribute("nombreMoneda", "Sol Peruano");
                    sesion.setAttribute("tipoMoneda", "PEN");                    
                break;                                                                
            }
        }
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
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
