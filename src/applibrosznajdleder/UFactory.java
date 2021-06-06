package applibrosznajdleder;

import java.util.ResourceBundle;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class UFactory {

    public static Object getInstancia(String objName) {
        try {
            ResourceBundle rb = ResourceBundle.getBundle("applibrosznajdleder.db.factory");
            String sClassname = rb.getString(objName);
            Object ret = Class.forName(sClassname).getDeclaredConstructor().newInstance();
            return ret;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
