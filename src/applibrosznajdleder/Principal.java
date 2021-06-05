package applibrosznajdleder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usr, pwd);
            String sql = "SELECT empno,ename,hiredate,deptno FROM emp";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.print(rs.getInt("empno") + ", ");
                System.out.print(rs.getString("ename") + ", ");
                System.out.print(rs.getString("hiredate") + ", "); // Como String para evitar error de parseo
                System.out.println(rs.getInt("deptno"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }
    }
}
