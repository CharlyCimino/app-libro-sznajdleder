package applibrosznajdleder;

import java.util.Collection;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class Facade {

    public Collection<EmpDTO> obtenerUltimosEmpleados(int n) {
        EmpDAO empDao = (EmpDAO) UFactory.getInstancia("EMP");
        return empDao.buscarUltimosEmpleados(n);
    }

    public Collection<DeptDTO> obtenerDepartamentos() {
        DeptDAO deptDao = (DeptDAO) UFactory.getInstancia("DEPT");
        return deptDao.buscarTodos();
    }

    public Collection<EmpDTO> obtenerEmpleados(int deptno) {
        EmpDAO empDao = (EmpDAO) UFactory.getInstancia("EMP");
        return empDao.buscarXDept(deptno);
    }

}
