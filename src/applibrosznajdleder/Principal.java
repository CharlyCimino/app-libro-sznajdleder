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
        sql += "UPDATE dept SET dname = ? WHERE deptno = 4 ";

        try ( Connection con = DriverManager.getConnection(url, usr, pwd);  PreparedStatement pstm = con.prepareStatement(sql);) {
            Class.forName(driver);
            pstm.setString(1, "Logística");
            int rtdo = pstm.executeUpdate();
            System.out.println(rtdo + " filas actualizadas...");
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
}
