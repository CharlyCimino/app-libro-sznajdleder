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
        String sql = "";
        sql += "SELECT e.empno AS empno";
        sql += " ,e.ename AS ename ";
        sql += " ,e.hiredate AS hiredate ";
        sql += " ,e.deptno AS deptno";
        sql += " ,d.dname AS dname ";
        sql += "FROM emp e, dept d ";
        sql += "WHERE e.empno = d.deptno ";

        try ( Connection con = DriverManager.getConnection(url, usr, pwd);  PreparedStatement pstm = con.prepareStatement(sql);  ResultSet rs = pstm.executeQuery();) {
            Class.forName(driver);
            while (rs.next()) {
                System.out.print(rs.getInt("empno") + ", ");
                System.out.print(rs.getString("ename") + ", ");
                System.out.print(rs.getInt("deptno") + " (");
                System.out.print(rs.getString("dname") + "), ");
                System.out.println(rs.getString("hiredate")); // Como String para evitar error de parseo
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
}
