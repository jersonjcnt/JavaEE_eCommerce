
package dao;
import conexion.clsConexion;
import modelos_JavaBeans.categoria;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class daoCategoria {

    private Connection connection = new clsConexion().getConnection();
    private List<categoria> catSup;
    private List<categoria> SubCat;
    private List<categoria> cat;
    
    public List<categoria> cargarListCategoriaSuperior() {
        catSup = new ArrayList<categoria>();
        try {
            CallableStatement st = connection.prepareCall("{CALL USP_CARGARLISTCATEGORIASUPERIOR}");
            ResultSet rs = st.executeQuery(); //ResultSet rs = (ResultSet) st.getObject(1);
            
            while (rs.next()) {
                categoria objCat = new categoria(); //Se crea el objeto de la clase empleado
                objCat.setIdcat(rs.getInt("IDCAT"));
                objCat.setNom(rs.getString("NOM_CAT"));
                objCat.setEst(rs.getInt("EST_CAT"));
                objCat.setCatsup(rs.getInt("CATSUP_CAT"));
                catSup.add(objCat); //Los datos se almacenan en el List
            }
            return catSup; //Retorna el List
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en Cargar");
        }
        return null;
    }
    
    public List<categoria> cargarListSubCategoria(int catsup) {
        SubCat = new ArrayList<categoria>();
        try {
            CallableStatement st = connection.prepareCall("{CALL USP_CARGARLISTSUBCATEGORIA(?)}");
            st.setInt(1,catsup);
            ResultSet rs = st.executeQuery(); //ResultSet rs = (ResultSet) st.getObject(2);
            
            while (rs.next()) {
                categoria objCat = new categoria(); //Se crea el objeto de la clase empleado
                objCat.setIdcat(rs.getInt("IDCAT"));
                objCat.setNom(rs.getString("NOM_CAT"));
                objCat.setEst(rs.getInt("EST_CAT"));
                objCat.setCatsup(rs.getInt("CATSUP_CAT"));
                SubCat.add(objCat); //Los datos se almacenan en el List
            }
            return SubCat; //Retorna el List
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en Cargar");
        }
        return null;
    }
    
    public int getNumeroSubCategoria(int catsup) {       
        try {
            CallableStatement st = connection.prepareCall("{CALL USP_GETNUMEROSUBCATEGORIA(?)}");
            st.setInt(1,catsup);
            ResultSet rs = st.executeQuery(); //ResultSet rs = (ResultSet) st.getObject(2);
                                            
            while (rs.next()) {
                rs.getInt(1);
                break;  
            }
            return rs.getInt(1);
            
//            int numeroSubCategoria = 0;
//            while (rs.next()) {
//                numeroSubCategoria = rs.getInt(1);
//                break;  
//            }
//            return numeroSubCategoria;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en Obtener");
        }              
        return 0;
    }
    
    public List<categoria> cargarListCategoria() {
        cat = new ArrayList<categoria>();
        try {
            CallableStatement st = connection.prepareCall("{CALL USP_CARGARLISTCATEGORIA}");
            ResultSet rs = st.executeQuery(); //ResultSet rs = (ResultSet) st.getObject(1);
            
            while (rs.next()) {
                categoria objCat = new categoria(); //Se crea el objeto de la clase empleado
                objCat.setIdcat(rs.getInt("IDCAT"));
                objCat.setNom(rs.getString("NOM_CAT"));
                objCat.setEst(rs.getInt("EST_CAT"));
                objCat.setCatsup(rs.getInt("CATSUP_CAT"));
                cat.add(objCat); //Los datos se almacenan en el List
            }
            return cat; //Retorna el List
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en Cargar");
        }
        return null;
    }
    
    public categoria obtenerCategoriaSuperior(int i) {
        return catSup.get(i);           
    }    
            
    public int tamañoCategoriaSuperior() { 
        return catSup.size();
    }
    
    public categoria obtenerSubCategoria(int i) {
        return SubCat.get(i);           
    }    
            
    public int tamañoSubCategoria() { 
        return SubCat.size();
    }
    
    public categoria obtenerCategoria(int i) {
        return cat.get(i);           
    }    
            
    public int tamañoCategoria() { 
        return cat.size();
    }
    
}
