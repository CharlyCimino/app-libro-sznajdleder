package applibrosznajdleder;

import java.sql.Connection;
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
        String sql = "DELETE FROM emp WHERE empno = ?";

        try ( Connection con = UConnection.getConnection();  PreparedStatement pstm = con.prepareStatement(sql);) {
            con.setAutoCommit(false);
            pstm.setInt(1, 56);
            int rtdo = pstm.executeUpdate();
            if (rtdo == 1) {
                con.commit();
            } else {
                con.rollback();
                throw new RuntimeException("Error...");
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
