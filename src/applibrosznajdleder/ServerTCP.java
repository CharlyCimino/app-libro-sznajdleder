package applibrosznajdleder;

import applibrosznajdleder.dao.DeptDAO;
import applibrosznajdleder.dao.EmpDAO;
import applibrosznajdleder.dto.DeptDTO;
import applibrosznajdleder.dto.EmpDTO;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class ServerTCP extends Thread {

    public static final int OBTENER_DEPARTAMENTOS = 1;
    public static final int OBTENER_EMPLEADOS = 2;
    private Socket socket = null;
    private DataInputStream dis = null;
    private DataOutputStream dos = null;

    public ServerTCP(Socket s) {
        this.socket = s;
    }

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5432);
        Socket s;
        while (true) {
            s = ss.accept();
            new ServerTCP(s).start();
        }
    }

    @Override
    public void run() {
        try ( DataInputStream dis = new DataInputStream(socket.getInputStream());  DataOutputStream dos = new DataOutputStream(socket.getOutputStream());) {

            int codSvr = dis.readInt();
            switch (codSvr) {
                case OBTENER_DEPARTAMENTOS:
                    obtenerDepartamentos(dis, dos);
                    break;
                case OBTENER_EMPLEADOS:
                    obtenerEmpleados(dis, dos);
                    break;

            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void obtenerDepartamentos(DataInputStream dis, DataOutputStream dos) {
        try {
            DeptDAO dao = (DeptDAO) UFactory.getInstancia("DEPT");
            // obtengo la coleccion de departamentos
            Collection<DeptDTO> coll = dao.buscarTodos();
            // envio el size al cliente
            int size = coll.size();
            dos.writeInt(size);
            // envio la coleccion de departamentos
            for (DeptDTO dto : coll) {
                dos.writeUTF(dto.toString());
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void obtenerEmpleados(DataInputStream dis, DataOutputStream dos) {
        try {
            EmpDAO dao = (EmpDAO) UFactory.getInstancia("EMP");
            // Leo del deptno
            int deptno = dis.readInt();
            // obtengo la coleccion de departamentos
            Collection<EmpDTO> coll = dao.buscarXDept(deptno);
            // envio el size al cliente
            int size = coll.size();
            dos.writeInt(size);
            // envio la coleccion de departamentos
            for (EmpDTO dto : coll) {
                dos.writeUTF(dto.toString());
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
