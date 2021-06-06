package applibrosznajdleder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class EmpDAO {

    public Collection<EmpDTO> buscarXDept(int deptno) {
        String sql = "";
        sql += "SELECT empno, ename, hiredate, deptno ";
        sql += "FROM emp ";
        sql += "WHERE deptno = ? ";
        Connection con = UConnection.getConnection();
        try ( PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setInt(1, deptno);
            try ( ResultSet rs = pstm.executeQuery();) {
                ArrayList<EmpDTO> ret = new ArrayList<>();
                EmpDTO dto = null;

                while (rs.next()) {
                    dto = new EmpDTO();
                    dto.setEmpno(rs.getInt("empno"));
                    dto.setEname(rs.getString("ename"));
                    dto.setHiredate(rs.getString("hiredate"));
                    ret.add(dto);
                }

                return ret;
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
