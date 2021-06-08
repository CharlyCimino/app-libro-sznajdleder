package applibrosznajdleder;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class TestServ1 {

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 5432);
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());
        // solicito servicio codigo 1
        dos.writeInt(1);
        
        // el server me indica cuantos deptos va a enviar
        int n = dis.readInt();
        
        for (int i = 0; i < n; i++) {
            System.out.println(dis.readUTF());
        }
        
        dis.close();
        dos.close();
        s.close();
    }
}
