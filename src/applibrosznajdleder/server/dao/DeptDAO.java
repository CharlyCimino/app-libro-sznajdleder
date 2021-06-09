
package applibrosznajdleder.server.dao;

import applibrosznajdleder.server.ConnectionPool;
import applibrosznajdleder.server.dto.DeptDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Charly Cimino
 * Aprendé más Java en mi canal: https://www.youtube.com/c/CharlyCimino
 * Encontrá más código en mi repo de GitHub: https://github.com/CharlyCimino
 */
public abstract class DeptDAO implements Dept {
    
    @Override
    public Collection<DeptDTO> buscarTodos() {
        String sql = "SELECT deptno, dname, loc FROM dept ";
        Connection con = ConnectionPool.getPool().getConnection();
        try ( PreparedStatement pstm = con.prepareStatement(sql);  ResultSet rs = pstm.executeQuery()) {
            ArrayList<DeptDTO> ret = new ArrayList<>();
            DeptDTO dto = null;
            
            while (rs.next()) {
                dto = new DeptDTO();
                dto.setDeptno(rs.getInt("deptno") );
                dto.setDname( rs.getString("dname") );
                dto.setLoc( rs.getString("loc") );
                ret.add(dto);
            }
            
            return ret;

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            if(con != null) {
                ConnectionPool.getPool().releaseConnection(con);
            }
        }
    }
}
