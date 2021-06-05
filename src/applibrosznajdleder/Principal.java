package applibrosznajdleder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class Principal {

    public static void main(String[] args) {
        String usr = "";
        String pwd = "";
        String driver = "org.sqlite.JDBC"; // Ajustado a db SQLite
        String url = "jdbc:sqlite:src/applibrosznajdleder/db/empleados.db"; // Ajustado a db SQLite
        String sql = "";
        sql += "INSERT INTO dept (deptno, dname, loc) ";
        sql += "VALUES(?,?,?)";

        try ( Connection con = DriverManager.getConnection(url, usr, pwd);  PreparedStatement pstm = con.prepareStatement(sql);) {
            Class.forName(driver);
            pstm.setInt(1, 4);
            pstm.setString(2, "Logistica");
            pstm.setString(3, "Mar del Plata");
            int rtdo = pstm.executeUpdate();
            if (rtdo == 1) {
                System.out.println("1 fila correctamente insertada");
            } else {
                throw new RuntimeException("No se pudo insertar la fila");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
}