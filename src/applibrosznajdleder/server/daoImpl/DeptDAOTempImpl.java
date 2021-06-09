package applibrosznajdleder.daoImpl;

import applibrosznajdleder.dao.DeptDAO;
import applibrosznajdleder.dto.DeptDTO;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class DeptDAOTempImpl extends DeptDAO {

    @Override
    public Collection<DeptDTO> buscarTodos() {
        DeptDTO d1 = new DeptDTO();
        d1.setDeptno(1);
        d1.setDname("Ventas");
        d1.setLoc("Capital");
        DeptDTO d2 = new DeptDTO();
        d2.setDeptno(2);
        d2.setDname("Compras");
        d2.setLoc("Capital");
        DeptDTO d3 = new DeptDTO();
        d3.setDeptno(3);
        d3.setDname("RRHH");
        d3.setLoc("Buenos Aires");
        ArrayList<DeptDTO> v = new ArrayList<>();
        v.add(d1);
        v.add(d2);
        v.add(d3);
        return v;
    }

}
