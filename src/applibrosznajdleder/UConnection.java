package applibrosznajdleder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class UConnection {

    private static Connection con = null;

    public static Connection getConnection() {
        try {
            if (con == null) {
                Runtime.getRuntime().addShutdownHook(new MiShDwnHook());
                ResourceBundle rb = ResourceBundle.getBundle("applibrosznajdleder.db.jdbc");
                String driver = rb.getString("driver");
                String url = rb.getString("url");
                String pwd = rb.getString("pwd");
                String usr = rb.getString("usr");
                Class.forName(driver);
                con = DriverManager.getConnection(url, usr, pwd);
            }
            return con;
        } catch (Exception ex) {
            throw new RuntimeException("Error al crear la conexion", ex);
        }
    }

    static class MiShDwnHook extends Thread {
        public void run() {
            try {
                Connection con = UConnection.getConnection();
                con.close();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
