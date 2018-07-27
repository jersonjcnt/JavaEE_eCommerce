/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.daoProductoMoneda;
import modelos_JavaBeans.producto;
import modelos_JavaBeans.moneda;
import static dao.daoProductoMoneda.insertProductoMoneda_SQLException;

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

        recibirDatos(request);
        
//        Esto es asi por que en el momento de cargar la lista de datos de la tabla producto, cargamos el nombre de la categoria y no su id
//        public String getIdCategoria(){        
//            return String.valueOf(cboCategoria.getSelectedIndex() + 1);
//        }
        
        String nombre = request.getAttribute("nombre").toString();
        String descripcion = request.getAttribute("descripcion").toString();
        Double precioMXN = Double.parseDouble(request.getAttribute("precio-mxn").toString());
        Double precioNuevoMXN =  Double.parseDouble(request.getAttribute("precio-nuevo-mxn").toString());                
        int stock = Integer.parseInt(request.getAttribute("cantidad").toString());
        String marca = request.getAttribute("marca").toString();
        String categoria = request.getAttribute("categoria").toString();
        int nuevo;
        int recomendado;
        int estado;
        try {
            nuevo = request.getAttribute("nuevo").toString().equalsIgnoreCase("ON")? 1:0; // Estructura Condicional de una sola línea, el formulario que implementaremos enviara los datos por el método post                                
        } catch (Exception e) {
            System.out.println(e);
            nuevo = 0;
        }
        try {
            recomendado = request.getAttribute("recomendado").toString().equalsIgnoreCase("ON")? 1:0;            
        } catch (Exception e) {
            System.out.println(e);
            recomendado = 0;
        }        
        try {
            estado = request.getAttribute("visible").toString().equalsIgnoreCase("ON")? 1:0;
        } catch (Exception e) {
            System.out.println(e);
            estado = 0;
        }
        // Si el dato obtenido del formulario mediante el método post es igual a "ON"
        // Si es igual, retornamos un 1
        // Si no es igual, retornamos un 0
        String url = request.getAttribute("imagen").toString();        
        
        String nombreUSD = "USD";
        Double precioUSD = Double.parseDouble(request.getAttribute("precio-usd").toString());
        Double precioNuevoUSD =  Double.parseDouble(request.getAttribute("precio-nuevo-usd").toString());        
        String nombreCOP = "COP";
        Double precioCOP = Double.parseDouble(request.getAttribute("precio-cop").toString());
        Double precioNuevoCOP =  Double.parseDouble(request.getAttribute("precio-nuevo-cop").toString());
        String nombrePEN = "PEN";
        Double precioPEN = Double.parseDouble(request.getAttribute("precio-pen").toString());
        Double precioNuevoPEN =  Double.parseDouble(request.getAttribute("precio-nuevo-pen").toString());                        
        
        producto objPro = new producto();
        objPro.setNom(nombre);
        objPro.setDes(descripcion);
        objPro.setPre(precioMXN);
        objPro.setPreNue(precioNuevoMXN);
        objPro.setSto(stock);
        objPro.setIdMar(marca);
        objPro.setIdCat(categoria);
        objPro.setNue(nuevo);
        objPro.setRec(recomendado);
        objPro.setEst(estado);
        objPro.setImg(url);                
        
        moneda objMon = new moneda();
        objMon.setNom(nombreUSD);      
        objMon.setPre(precioUSD);
        objMon.setPreNue(precioNuevoUSD);
        
        moneda objMon2 = new moneda();
        objMon2.setNom(nombreCOP);      
        objMon2.setPre(precioCOP);
        objMon2.setPreNue(precioNuevoCOP);
        
        moneda objMon3 = new moneda();
        objMon3.setNom(nombrePEN);      
        objMon3.setPre(precioPEN);
        objMon3.setPreNue(precioNuevoPEN);
                        
        String accion = request.getAttribute("action").toString();                
        
        daoProductoMoneda objProMon = new daoProductoMoneda();        
        if (accion.equalsIgnoreCase("Enviar")) {
            if (objProMon.insertProductoMoneda(objPro, objMon, objMon2, objMon3) == true) {
                request.setAttribute("mensajeExito", "<div class=\"alert alert-success\" id=\"mensajeExito\">Producto agregado con éxito</div>");                
            } else {
                request.setAttribute("mensajeError", "<div class=\"alert alert-danger\" id=\"mensajeError\">No se pudo agregar producto</div>");
                request.setAttribute("insertProductoMoneda_SQLException", "<div class=\"alert alert-danger\" id=\"mensajeError\">" + insertProductoMoneda_SQLException + "</div>");                
            }
        } else {            
            request.setAttribute("mensajeError2", "<div class=\"alert alert-danger\" id=\"mensajeError\">Error</div>");
        }
        request.setAttribute("Datos", "<div class=\"alert alert-success\" id=\"mensajeExito\">"
                + nombre + ", " + descripcion + ", " + precioMXN + ", " + precioNuevoMXN + ", " + stock + ", " + marca + ", " 
                + categoria + ", " + nuevo + ", " + recomendado + ", " + estado + ", " + url + ", "
                + nombreUSD + ", " + precioUSD + ", " + precioNuevoUSD + ", "
                + nombreCOP + ", " + precioCOP + ", " + precioNuevoCOP + ", " 
                + nombrePEN + ", " + precioPEN + ", " + precioNuevoPEN + "</div>");
        request.getRequestDispatcher("WEB-INF/mantenimiento/index.jsp").forward(request, response); // Cuando accedemos al servlet Mantenimiento.java a travez de la url /mantenimiento, lo que hace el servlet es redirigirnos a index.jsp que esta dentro de WEB-INF/mantenimiento y que no puede ser accedido
    }
    
    private void recibirDatos(HttpServletRequest request) {
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
                        request.setAttribute(item.getFieldName(), nombre); // item.getFieldName() obtiene el nombre del campo que se envio, en este caso seria imagen
                    }
                } else {
                    request.setAttribute(item.getFieldName(), item.getString());
                }
            }
        } catch (FileUploadException ex) {
            Logger.getLogger(controladorProducto.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("subida", false);
        } catch (Exception ex) {
            Logger.getLogger(controladorProducto.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("subida", false);
        }       
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
