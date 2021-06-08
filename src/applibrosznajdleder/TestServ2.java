package applibrosznajdleder;

import applibrosznajdleder.dto.EmpDTO;
import java.util.Collection;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class TestServ2 {

    public static void main(String[] args) {
        Collection<EmpDTO> coll;
        coll = ServiceLocatorTCP.obtenerEmpleados(1);
        for (EmpDTO emp : coll) {
            System.out.println(emp);
        }
    }

}
