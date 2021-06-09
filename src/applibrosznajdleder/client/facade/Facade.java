
package applibrosznajdleder;

import applibrosznajdleder.dto.DeptDTO;
import applibrosznajdleder.dto.EmpDTO;
import java.util.Collection;

/**
 *
 * @author Charly Cimino
 * Aprendé más Java en mi canal: https://www.youtube.com/c/CharlyCimino
 * Encontrá más código en mi repo de GitHub: https://github.com/CharlyCimino
 */
interface Facade {
    public Collection<DeptDTO> obtenerDepartamentos();
    public Collection<EmpDTO> obtenerEmpleados(int deptno);
}
