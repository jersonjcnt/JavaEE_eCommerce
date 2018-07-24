
package dao;
import conexion.clsConexion;
import modelos_JavaBeans.producto;
import modelos_JavaBeans.moneda;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class daoProductoMoneda {
    
    private Connection connection = new clsConexion().getConnection();
    private List<producto> pro;
    public static String SQLException;
    
    public List<producto> cargarListProducto(String nom) {
        pro = new ArrayList<producto>();
        try {
            CallableStatement st = connection.prepareCall("{CALL USP_CARGARLISTPRODUCTO(?)}");
            st.setString(1,nom);
            ResultSet rs = st.executeQuery(); //ResultSet rs = (ResultSet) st.getObject(1);
            
            while (rs.next()) {
                producto objPro = new producto(); //Se crea el objeto de la clase empleado
                objPro.setIdPro(rs.getInt("IDPRO"));
                objPro.setNom(rs.getString("NOM_PRO"));
                objPro.setDes(rs.getString("DES_PRO"));                
                if (!nom.equalsIgnoreCase("MXN")) {
                    objPro.setPre(rs.getDouble("mon.PRE_PRO"));
                    objPro.setPreNue(rs.getDouble("mon.PRENUE_PRO"));
                } else {
                    objPro.setPre(rs.getDouble("p.PRE_PRO"));
                    objPro.setPreNue(rs.getDouble("p.PRENUE_PRO"));
                }                                
                objPro.setSto(rs.getInt("STO_PRO"));
                objPro.setIdMar(rs.getString("NOM_MAR"));
                objPro.setIdCat(rs.getString("NOM_CAT"));
                objPro.setNue(rs.getInt("NUE_PRO"));
                objPro.setRec(rs.getInt("REC_PRO"));
                objPro.setEst(rs.getInt("EST_PRO"));
                objPro.setImg(rs.getString("IMG_PRO"));
                pro.add(objPro); //Los datos se almacenan en el List
            }
            return pro; //Retorna el List
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en Cargar");
        }
        return null;
    }
    
    public boolean insertProductoMoneda(producto objPro, moneda objMon, moneda objMon2, moneda objMon3) {
        try {
            CallableStatement st = connection.prepareCall("{CALL USP_INSERTPRODUCTOMONEDA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            st.setString(1,objPro.getNom());
            st.setString(2,objPro.getDes());
            st.setDouble(3,objPro.getPre());
            st.setDouble(4,objPro.getPreNue());
            st.setInt(5,objPro.getSto());
            st.setString(6,objPro.getIdMar());
            st.setString(7,objPro.getIdCat());
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
            return true;
        } catch (SQLException ex) {                 
            System.out.println(ex.getMessage());
            System.out.println("Error en Insertar");
            SQLException = ex.getMessage();
        }
        return false;
    }        
    
}
