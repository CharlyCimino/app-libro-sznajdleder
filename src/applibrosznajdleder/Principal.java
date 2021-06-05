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
        sql += "DELETE FROM dept WHERE deptno = ? ";

        try ( Connection con = DriverManager.getConnection(url, usr, pwd);  PreparedStatement pstm = con.prepareStatement(sql);) {
            Class.forName(driver);
            for (int i = 100; i < 150; i++) {
                pstm.setInt(1, i);
                int rtdo = pstm.executeUpdate();
                if (rtdo > 1) {
                    String mssg = "Error: " + rtdo + " filas eliminadas...";
                    throw new RuntimeException(mssg);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
}
