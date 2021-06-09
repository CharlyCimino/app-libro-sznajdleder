package applibrosznajdleder.client.facade;

import applibrosznajdleder.client.ServiceLocatorTCP;
import applibrosznajdleder.server.dto.DeptDTO;
import applibrosznajdleder.server.dto.EmpDTO;
import java.util.Collection;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class FacadeTCPImpl implements Facade {

    @Override
    public Collection<DeptDTO> obtenerDepartamentos() {
        return ServiceLocatorTCP.obtenerDepartamentos();
    }

    @Override
    public Collection<EmpDTO> obtenerEmpleados(int deptno) {
        return ServiceLocatorTCP.obtenerEmpleados(deptno);
    }

}
