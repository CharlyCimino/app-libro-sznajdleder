package applibrosznajdleder;

import applibrosznajdleder.dto.DeptDTO;
import java.util.Collection;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class TestServ1 {

    public static void main(String[] args) {
        Collection<DeptDTO> coll;
        coll = ServiceLocatorTCP.obtenerDepartamentos();
        for (DeptDTO dto : coll) {
            System.out.println(dto);
        }
    }

}
