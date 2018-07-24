
package dao;
import conexion.clsConexion;
import modelos_JavaBeans.marca;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class daoMarca {
    
    private Connection connection = new clsConexion().getConnection();
    private List<marca> mar;
    
    public List<marca> cargarListMarca() {
        mar = new ArrayList<marca>();
        try {
            CallableStatement st = connection.prepareCall("{CALL USP_CARGARLISTMARCA}");
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                marca objCat = new marca();
                objCat.setIdmar(rs.getInt("IDMAR"));
                objCat.setNom(rs.getString("NOM_MAR"));
                objCat.setEst(rs.getInt("EST_MAR"));                
                mar.add(objCat);
            }
            return mar;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en Cargar");
        }
        return null;
    }
    
    public marca obtenerCategoria(int i) {
        return mar.get(i);           
    }    
            
    public int tamañoCategoria() { 
        return mar.size();
    }
    
}
