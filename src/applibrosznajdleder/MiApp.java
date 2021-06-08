package applibrosznajdleder;

import applibrosznajdleder.dto.DeptDTO;
import applibrosznajdleder.dto.EmpDTO;
import java.util.Collection;
import java.util.Scanner;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class MiApp {

    /*
    Si vamos a correr el cliente y el servidor en la misma máquina o vamos a utilizar la implementación local del
    façade entonces en el archivo factory.properties tendremos que tener tanto la denición
    del façade como las deniciones de los DAOs. En cambio, si el cliente y el servidor correrán cada uno en su propio host entonces en cada máquina tendremos que tener un
    archivo factory.properties. En la del cliente solo necesitaremos la denición del façade
    mientras que en la del servidor solo necesitaremos la denición de los DAOs.
     */
    public static void main(String[] args) {
        Facade facade = (Facade) UFactory.getInstancia("FACADE");

        Collection<DeptDTO> collDeptos = facade.obtenerDepartamentos();
        mostrarColl(collDeptos);
        System.out.print("Seleccione depto: ");
        Scanner scanner = new Scanner(System.in);
        int deptno = scanner.nextInt();
        Collection<EmpDTO> collEmps = facade.obtenerEmpleados(deptno);
        mostrarColl(collEmps);
    }

    private static void mostrarColl(Collection<?> col) {
        for (Object o : col) {
            System.out.println(o);
        }
    }

}
