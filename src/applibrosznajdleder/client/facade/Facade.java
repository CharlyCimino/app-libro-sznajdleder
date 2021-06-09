
package applibrosznajdleder.client.facade;

import applibrosznajdleder.server.dto.DeptDTO;
import applibrosznajdleder.server.dto.EmpDTO;
import java.util.Collection;

/**
 *
 * @author Charly Cimino
 * Aprendé más Java en mi canal: https://www.youtube.com/c/CharlyCimino
 * Encontrá más código en mi repo de GitHub: https://github.com/CharlyCimino
 */
public interface Facade {
    public Collection<DeptDTO> obtenerDepartamentos();
    public Collection<EmpDTO> obtenerEmpleados(int deptno);
}