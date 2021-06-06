package applibrosznajdleder;

import java.util.Collection;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class Principal {

    public static void main(String[] args) {
        EmpDAO emp = new EmpDAO();

        Collection<EmpDTO> coll = emp.buscarXDept(2);
        for (EmpDTO e : coll) {
            System.out.println(e);
        }
    }
}
