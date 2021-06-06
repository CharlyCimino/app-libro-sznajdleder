package applibrosznajdleder;

import java.util.Collection;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class Facade {

    public Collection<DeptDTO> obtenerDepartamentos() {
        DeptDAO deptDao = new DeptDAO();
        return deptDao.buscarTodos();
    }

    public Collection<EmpDTO> obtenerEmpleados(int deptno) {
        EmpDAO empDao = new EmpDAOSQLiteImpl();
        return empDao.buscarXDept(deptno);
    }

}
