package applibrosznajdleder.server.daoImpl;

import applibrosznajdleder.server.dao.EmpDAO;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class EmpDAOSQLiteImpl extends EmpDAO {

    @Override
    protected String queryBuscarUltimosEmpleados() {
        String sql = "";
        sql += "SELECT empno, ename, hiredate, deptno ";
        sql += "FROM emp ";
        sql += "ORDER BY hiredate DESC ";
        sql += "LIMIT ? ";
        return sql;
    }

    

}
