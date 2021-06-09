package applibrosznajdleder.client;

import applibrosznajdleder.server.dto.DeptDTO;
import applibrosznajdleder.server.dto.EmpDTO;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class ServiceLocatorTCP {

    public static final String SERVER_IP = "127.0.0.1";
    public static final int SERVER_PORT = 5432;
    
    public static Collection<DeptDTO> obtenerDepartamentos() {
        try (Socket s = new Socket(SERVER_IP, SERVER_PORT);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream()); ) {
            // solicito servicio codigo 1
            dos.writeInt(1);
            
            // el server me indica cuantos deptos va a enviar
            int n = dis.readInt();
            
            ArrayList<DeptDTO> ret = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                String aux = dis.readUTF();
                ret.add( UDto.stringToDeptDTO(aux) );
            }
            
            return ret;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
     
    public static Collection<EmpDTO> obtenerEmpleados(int deptno) {
        try (Socket s = new Socket(SERVER_IP, SERVER_PORT);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream()); ) {
            // solicito servicio codigo 1
            dos.writeInt(2);
            
            // envio el nro de depto
            dos.writeInt(deptno);
            
            // el server me indica cuantos deptos va a enviar
            int n = dis.readInt();
            
            ArrayList<EmpDTO> ret = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                String aux = dis.readUTF();
                ret.add( UDto.stringToEmpDTO(aux) );
            }
            
            return ret;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
