package applibrosznajdleder.server;

import java.util.HashMap;
import java.util.ResourceBundle;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class UFactory {

    private static HashMap<String, Object> instancias = new HashMap<>();

    public static Object getInstancia(String objName) {
        try {
            Object obj = instancias.get(objName);
            if (obj == null) {
                ResourceBundle rb = ResourceBundle.getBundle("applibrosznajdleder.server.db.factory");
                String sClassname = rb.getString(objName);
                obj = Class.forName(sClassname).getDeclaredConstructor().newInstance();
                instancias.put(objName, obj);
            }
            return obj;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
