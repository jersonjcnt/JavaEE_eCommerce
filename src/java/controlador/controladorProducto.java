/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.daoProductoMoneda;
import modelos_JavaBeans.producto;
import modelos_JavaBeans.moneda;

import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.io.File;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author Jorge Baez
 */
public class controladorProducto extends HttpServlet {

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
//            out.println("<title>Servlet controladorProducto</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet controladorProducto at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
//        processRequest(request, response);    

//        String url = subirImagen(request);
//        response.sendRedirect("foto/" + url);
        
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");        
        Double precioMXN = Double.parseDouble(request.getParameter("precio-mxn"));
        Double precioNuevoMXN =  Double.parseDouble(request.getParameter("precio-nuevo-mxn"));                
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        int marca = Integer.parseInt(request.getParameter("marca"));
        int categoria = Integer.parseInt(request.getParameter("categoria"));
        int nuevo = (request.getParameter("nuevo").equalsIgnoreCase("ON"))? 1:0; // Estructura Condicional de una sola línea, el formulario que implementaremos enviara los datos por el método post        
        int recomendado = (request.getParameter("recomendado").equalsIgnoreCase("ON"))? 1:0;
        int estado = (request.getParameter("estado").equalsIgnoreCase("ON"))? 1:0;                
        String url = subirImagen(request);
        // Si el dato obtenido del formulario mediante el método post es igual a "ON"
        // Si es igual, retornamos un 1
        // Si no es igual, retornamos un 0
        
        producto objPro = new producto();
        objPro.setNom(nombre);
        objPro.setDes(descripcion);
        objPro.setPre(precioMXN);
        objPro.setPreNue(precioNuevoMXN);
        objPro.setSto(cantidad);
        objPro.setIdMar(marca);
        objPro.setIdCat(categoria);
        objPro.setNue(nuevo);
        objPro.setRec(recomendado);
        objPro.setEst(estado);
        objPro.setImg(url);
        
        Double precioUSD = Double.parseDouble(request.getParameter("precio-usd"));
        Double precioNuevoUSD =  Double.parseDouble(request.getParameter("precio-nuevo-usd"));        
        Double precioCOP = Double.parseDouble(request.getParameter("precio-cop"));
        Double precioNuevoCOP =  Double.parseDouble(request.getParameter("precio-nuevo-cop"));
        Double precioPEN = Double.parseDouble(request.getParameter("precio-pen"));
        Double precioNuevoPEN =  Double.parseDouble(request.getParameter("precio-nuevo-pen"));
        
        moneda objMon = new moneda();
        objMon.setNom("USD");      
        objMon.setPre(precioUSD);
        objMon.setPreNue(precioNuevoUSD);
        
        moneda objMon2 = new moneda();
        objMon2.setNom("COP");      
        objMon2.setPre(precioCOP);
        objMon2.setPreNue(precioNuevoCOP);
        
        moneda objMon3 = new moneda();
        objMon3.setNom("PEN");      
        objMon3.setPre(precioPEN);
        objMon3.setPreNue(precioNuevoPEN);
                        
        String accion = request.getParameter("accion"); 
        
        daoProductoMoneda objProMon = new daoProductoMoneda();
        
        if (accion.equalsIgnoreCase("Enviar")) {
            try {
                objProMon.insertProductoMoneda(objPro, objMon, objMon2, objMon3);
                request.setAttribute("Mensaje del Sistema", "¡Producto agregado con éxito!");
                request.getRequestDispatcher("WEB-INF/mantenimiento/index.jsp").forward(request, response); // Cuando accedemos al servlet Mantenimiento.java a travez de la url /mantenimiento, lo que hace el servlet es redirigirnos a index.jsp que esta dentro de WEB-INF/mantenimiento y que no puede ser accedido
            } catch(Exception e) {
                request.setAttribute("Mensaje del Sistema", "¡Producto agregado con éxito!");
                request.getRequestDispatcher("WEB-INF/mantenimiento/index.jsp").forward(request, response);
            }            
        }
    }
    
    private String subirImagen(HttpServletRequest request) {
        try {
            FileItemFactory file = new DiskFileItemFactory();
            
            ServletFileUpload servlet = new ServletFileUpload(file);            
            
            List items = servlet.parseRequest(request);
            
            String nombre = "";
            
            for (int i = 0; i < items.size(); i++) {
                FileItem item = (FileItem) items.get(i);
                if (!item.isFormField()) {
                    String ruta = request.getServletContext().getRealPath("/") + "foto/";
                    SimpleDateFormat date = new SimpleDateFormat("ddMMyyyyhhmmss");
                    String fecha = date.format(new Date());
                    nombre = fecha + new Random().nextLong() + item.getName();
                    String nuevoNombre = ruta + nombre;
                    File folder = new File(ruta);
                    if (!folder.exists()) {
                        folder.mkdirs();
                    }
                    File imagen = new File(nuevoNombre);
                    if (item.getContentType().contains("image")) {
                        item.write(imagen);
                        request.setAttribute("subida", true);
                        return nombre;
                    }
                }
            }
        } catch (FileUploadException ex) {
            request.setAttribute("subida", false);
            Logger.getLogger(controladorProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            request.setAttribute("subida", false);
            Logger.getLogger(controladorProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
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
