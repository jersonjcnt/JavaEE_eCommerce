
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
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                categoria objCat = new categoria();
                objCat.setIdcat(rs.getInt("IDCAT"));
                objCat.setNom(rs.getString("NOM_CAT"));
                objCat.setEst(rs.getInt("EST_CAT"));
                objCat.setCatsup(rs.getInt("CATSUP_CAT"));
                catSup.add(objCat);
            }
            return catSup;
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
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                categoria objCat = new categoria();
                objCat.setIdcat(rs.getInt("IDCAT"));
                objCat.setNom(rs.getString("NOM_CAT"));
                objCat.setEst(rs.getInt("EST_CAT"));
                objCat.setCatsup(rs.getInt("CATSUP_CAT"));
                SubCat.add(objCat);
            }
            return SubCat;
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
            ResultSet rs = st.executeQuery();
                                            
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
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                categoria objCat = new categoria();
                objCat.setIdcat(rs.getInt("IDCAT"));
                objCat.setNom(rs.getString("NOM_CAT"));
                objCat.setEst(rs.getInt("EST_CAT"));
                objCat.setCatsup(rs.getInt("CATSUP_CAT"));
                cat.add(objCat);
            }
            return cat;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en Cargar");
        }
        return null;
    }        
    
}
