
package conexion;
//import conexion.clsConexion;
import modelos.categoria;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class daoCategoria {

    private Connection connection = new clsConexion().getConnection();
    private List<categoria> cat;
    
    public List<categoria> cargarListEmpleado() {
        cat = new ArrayList<categoria>();
        try {
            CallableStatement st = connection.prepareCall("{CALL USP_CARGARLISTCATEGORIASUPERIOR}");
            ResultSet rs = st.executeQuery(); //ResultSet rs = (ResultSet) st.getObject(1);
            
            while (rs.next()) {
                categoria objCat = new categoria(); //Se crea el objeto de la clase empleado
                objCat.setIdcat(rs.getInt("IDCAT"));
                objCat.setNom(rs.getString("NOM_CAT"));
                objCat.setEst(rs.getBoolean("EST_CAT"));
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
    
}
