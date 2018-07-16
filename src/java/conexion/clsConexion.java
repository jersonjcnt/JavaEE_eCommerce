
package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;
//Juan Carlos Arcila Diaz
//package conexion;
//import java.sql.Connection;
//import java.sql.SQLException;
//import com.mysql.jdbc.jdbc2.optional.*;
public class clsConexion {
    
    private Connection connection;
    
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //Driver de MySQL
            String myDB = "jdbc:mysql://localhost:3306/javaee_ecommerce"; //Url de MySQL
            String user = "root";
            String password = "";
            
            connection = DriverManager.getConnection(myDB,user,password);
            
            return connection;
//            Juan Carlos Arcila Diaz
//            MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();
//            ds.setServerName("localhost");
//            ds.setPort(3306);
//            ds.setDatabaseName("target");
//            
//            connection = ds.getConnection("root","");
//            
//            return connection;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error estableciendo conexión con la base de datos");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(clsConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
