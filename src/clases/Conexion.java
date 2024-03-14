package clases;
import java.sql.*;

public class Conexion {
    //Coneccion Local
    public static Connection conectar(){
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/maquina_cafe", "root","");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en coneccion local" + e);
        }
        return(null);
    }
}
