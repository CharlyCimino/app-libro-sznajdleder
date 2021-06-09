package applibrosznajdleder.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class ConnectionPool {

    private ArrayList<Connection> libres;
    private ArrayList<Connection> usadas;
    private String url;
    private String driver;
    private String usr;
    private String pwd;
    private int minsize;
    private int maxsize;
    private int steep;
    private static ConnectionPool pool = null;

    private ConnectionPool() {
        try {
            ResourceBundle rb = ResourceBundle.getBundle("applibrosznajdleder.server.db.jdbc");
            this.driver = rb.getString("driver");
            this.url = rb.getString("url");
            this.pwd = rb.getString("pwd");
            this.usr = rb.getString("usr");
            Class.forName(driver);
            this.minsize = Integer.parseInt(rb.getString("minsize"));
            this.maxsize = Integer.parseInt(rb.getString("maxsize"));
            this.steep = Integer.parseInt(rb.getString("steep"));
            libres = new ArrayList<>();
            usadas = new ArrayList<>();
            instanciar(minsize);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public synchronized static ConnectionPool getPool() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }

    public synchronized Connection getConnection() {
        if (libres.isEmpty()) {
            if (!crearMasConexiones()) {
                throw new RuntimeException("No hay conexiones disponibles");
            }
        }
        Connection con = libres.remove(0);
        usadas.add(con);
        return con;
    }

    public synchronized void releaseConnection(Connection con) {
        boolean ok = usadas.remove(con);
        if (ok) {
            libres.add(con);
        } else {
            throw new RuntimeException("Me devuelve una conexion que no es mia...");
        }
    }

    private boolean crearMasConexiones() {
        int actuales = libres.size() + usadas.size();
        int n = Math.min(maxsize - actuales, steep);
        if (n > 0) {
            System.out.println("Creando " + n + " conexiones nuevas...");
            instanciar(n);
        }
        return n > 0;
    }

    private void instanciar(int n) {
        Connection con;
        for (int i = 0; i < n; i++) {
            try {
                con = DriverManager.getConnection(url, usr, pwd);
                con.setAutoCommit(false);
                libres.add(con);
            } catch (Exception ex) {
                throw new RuntimeException();
            }
        }

    }

    public synchronized void close() {
        try {
            // cierro las conexiones libres
            for (Connection con : libres) {
                con.close();
            }
            // cierro las conexiones usadas
            for (Connection con : usadas) {
                con.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public String toString() {
        return "libres: " + libres.size()
                + ", usadas: " + usadas.size();
    }
}
