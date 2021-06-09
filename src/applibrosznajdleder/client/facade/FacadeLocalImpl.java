package applibrosznajdleder.client.facade;

import applibrosznajdleder.server.UFactory;
import applibrosznajdleder.server.dao.DeptDAO;
import applibrosznajdleder.server.dao.EmpDAO;
import applibrosznajdleder.server.dto.DeptDTO;
import applibrosznajdleder.server.dto.EmpDTO;
import java.util.Collection;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class FacadeLocalImpl implements Facade {

    @Override
    public Collection<DeptDTO> obtenerDepartamentos() {
        DeptDAO deptDao = (DeptDAO) UFactory.getInstancia("DEPT");
        return deptDao.buscarTodos();
    }

    @Override
    public Collection<EmpDTO> obtenerEmpleados(int deptno) {
        EmpDAO empDao = (EmpDAO) UFactory.getInstancia("EMP");
        return empDao.buscarXDept(deptno);
    }

}
