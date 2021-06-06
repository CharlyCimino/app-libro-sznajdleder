package applibrosznajdleder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class Principal {

    public static void main(String[] args) {
        String sql = "";
        sql += "SELECT e.empno AS empno ";
        sql += " , e.ename AS ename ";
        sql += " , e.hiredate AS fecha ";
        sql += " , e.deptno AS deptno ";
        sql += " , d.dname AS dname ";
        sql += " , d.loc AS loc ";
        sql += "FROM emp e, dept d ";
        sql += "WHERE e.deptno = d.deptno ";

        try ( Connection con = UConnection.getConnection();  PreparedStatement pstm = con.prepareStatement(sql);  ResultSet rs = pstm.executeQuery()) {
            ResultSetMetaData md = rs.getMetaData();
            mostrarMetaData(md);
            mostrarData(rs);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private static void mostrarMetaData(ResultSetMetaData md) throws Exception {
        int cantCols = md.getColumnCount();
        System.out.println(cantCols + " columnas obtenidas");
        System.out.println();
        for (int i = 1; i <= cantCols; i++) {
            System.out.print("Columna Nro. " + i + ", ");
            System.out.print("Label: " + md.getColumnLabel(i) + ", ");
            System.out.print("Type: " + md.getColumnType(i) + " (");
            System.out.print(md.getColumnTypeName(i) + "), ");
            System.out.println("Precision: " + md.getPrecision(i));
        }
        System.out.println();
    }

    private static void mostrarData(ResultSet rs) throws Exception {
        int cantCols = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= cantCols; i++) {
                System.out.print(rs.getString(i));
                System.out.print(i < cantCols ? " ," : " ");
            }
            System.out.println();
        }
    }
}
