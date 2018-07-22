
package dao;
import conexion.clsConexion;
import modelos_JavaBeans.producto;
import modelos_JavaBeans.moneda;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
public class daoProductoMoneda {
    
    private Connection connection = new clsConexion().getConnection();
    
    public void insertProductoMoneda(producto objPro,moneda objMon,moneda objMon2,moneda objMon3) {
        try {
            CallableStatement st = connection.prepareCall("{CALL USP_INSERTPRODUCTOMONEDA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            st.setString(1,objPro.getNom());
            st.setString(2,objPro.getDes());
            st.setDouble(3,objPro.getPre());
            st.setDouble(4,objPro.getPreNue());
            st.setInt(5,objPro.getSto());
            st.setInt(6,objPro.getIdMar());
            st.setInt(7,objPro.getIdCat());
            st.setInt(8,objPro.getNue());
            st.setInt(9,objPro.getRec());
            st.setInt(10,objPro.getEst());
            st.setString(11,objPro.getImg());
            
            st.setString(12,objMon.getNom());
            st.setDouble(13,objMon.getPre());
            st.setDouble(14,objMon.getPreNue());
            
            st.setString(15,objMon2.getNom());
            st.setDouble(16,objMon2.getPre());
            st.setDouble(17,objMon2.getPreNue());
            
            st.setString(18,objMon3.getNom());
            st.setDouble(19,objMon3.getPre());
            st.setDouble(20,objMon3.getPreNue());
            
            st.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en Insertar");
        }
    }
    
}
