package applibrosznajdleder.client;

import applibrosznajdleder.server.dto.DeptDTO;
import applibrosznajdleder.server.dto.EmpDTO;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class UDto {

    public static DeptDTO stringToDeptDTO(String s) {
        DeptDTO dto = new DeptDTO();
        StringTokenizer st = new StringTokenizer(s, ",");
        dto.setDeptno(Integer.parseInt(st.nextToken()));
        dto.setDname(st.nextToken());
        dto.setLoc(st.nextToken());
        return dto;
    }

    public static EmpDTO stringToEmpDTO(String s) {
        EmpDTO dto = new EmpDTO();
        StringTokenizer st = new StringTokenizer(s, ",");
        dto.setEmpno(Integer.parseInt(st.nextToken()));
        dto.setEname(st.nextToken());
        dto.setHiredate(st.nextToken());
        dto.setDeptno(Integer.parseInt(st.nextToken().trim()));
        return dto;
    }
}
