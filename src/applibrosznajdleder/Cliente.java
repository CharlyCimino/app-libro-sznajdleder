package applibrosznajdleder;

import java.util.Collection;
import java.util.Scanner;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class Cliente {

    public static void main(String[] args) {
        Facade facade = new Facade();
        Collection<DeptDTO> collDepts = facade.obtenerDepartamentos();
        mostrarDepartamentos(collDepts);
        Scanner scanner = new Scanner(System.in);
        int deptno = scanner.nextInt();
        Collection<EmpDTO> collEmps = facade.obtenerEmpleados(deptno);
        mostrarEmpleados(collEmps, deptno);
    }

    private static void mostrarDepartamentos(Collection<DeptDTO> collDepts) {
        System.out.println("Departamentos: ");
        System.out.println("-------------------->");
        for (DeptDTO dto : collDepts) {
            System.out.print("| " + dto.getDeptno() + "\t");
            System.out.print("| " + dto.getDname() + "\t");
            System.out.println("| " + dto.getLoc() + "\t|");
        }
        System.out.println("<--------------------");
        System.out.print("Ingrese deptno: ");
    }

    private static void mostrarEmpleados(Collection<EmpDTO> collEmps, int deptno) {
        System.out.println("Empleados del departamento: " + deptno);
        System.out.println("-------------------->");
        for (EmpDTO dto : collEmps) {
            System.out.print("| " + dto.getEmpno() + "\t");
            System.out.print("| " + dto.getEname() + "\t");
            System.out.println("| " + dto.getHiredate() + "\t|");
        }
        System.out.println("<--------------------");
    }
}
