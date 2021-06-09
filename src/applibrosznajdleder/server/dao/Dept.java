package applibrosznajdleder.dao;

import applibrosznajdleder.dto.DeptDTO;
import java.util.Collection;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public interface Dept {

    public Collection<DeptDTO> buscarTodos();
}
