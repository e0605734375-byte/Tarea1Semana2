/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/

import java.util.Scanner;

public class Main {
    // Creamos un objeto Scanner para recibir los datos ingresados por teclado.
    static Scanner entrada = new Scanner(System.in);
    // Este método permite registrar los códigos y nombres de los empleados.
    public static void registrarEmpleados(String[] codigos, String[] nombres) {
        // Recorremos los arreglos para registrar la información de cada empleado.
        for (int i = 0; i < codigos.length; i++) {
            // Solicitamos el código del empleado que se va a registrar.
            System.out.print("Ingrese el codigo del empleado " + (i + 1) + ": ");
            // Guardamos el código ingresado en la posición correspondiente del arreglo.
            codigos[i] = entrada.nextLine();
            // Solicitamos el nombre del empleado que se está registrando.
            System.out.print("Ingrese el nombre del empleado " + (i + 1) + ": ");
            // Guardamos el nombre en la misma posición que ocupa su código.
            nombres[i] = entrada.nextLine();
        }
    }

    // Este método busca un empleado utilizando el código ingresado por el usuario.
    public static void buscarEmpleado(String[] codigos, String[] nombres, String codigoBuscado) {
        // Creamos una variable para verificar si el empleado fue encontrado.
        boolean encontrado = false;
        // Recorremos el arreglo de códigos para buscar una coincidencia.
        for (int i = 0; i < codigos.length; i++) {
            // Comparamos el código buscado con el código almacenado en la posición actual.
            if (codigos[i].equalsIgnoreCase(codigoBuscado)) {
                // Mostramos el nombre del empleado que corresponde al código encontrado.
                System.out.println("\nEmpleado encontrado:");
                System.out.println("Codigo: " + codigos[i]);
                System.out.println("Nombre: " + nombres[i]);
                // Indicamos que el empleado fue encontrado.
                encontrado = true;
                // Finalizamos la búsqueda porque ya encontramos el código.
                break;
            }
        }
        // Comprobamos si el código ingresado no se encuentra registrado.
        if (!encontrado) {
            // Informamos al usuario que no existe un empleado con ese código.
            System.out.println("\nNo se encontro ningun empleado con el codigo ingresado.");
        }
    }

    // Este es el método principal desde donde comienza la ejecución del programa.
    public static void main(String[] args) {
        // Solicitamos la cantidad de empleados que se desea registrar.
        System.out.print("Ingrese la cantidad de empleados: ");
        int n = entrada.nextInt();
        // Consumimos el salto de línea que queda después de ingresar el número.
        entrada.nextLine();
        // Creamos el primer arreglo para almacenar los códigos de los empleados.
        String[] codigos = new String[n];
        // Creamos el segundo arreglo para almacenar los nombres de los empleados.
        String[] nombres = new String[n];
        // Mostramos un mensaje para iniciar el registro de los empleados.
        System.out.println("\nREGISTRO DE EMPLEADOS");
        // Ejecutamos el método encargado de registrar los códigos y nombres.
        registrarEmpleados(codigos, nombres);
        // Solicitamos el código del empleado que se desea buscar.
        System.out.print("\nIngrese el codigo del empleado que desea buscar: ");
        String codigoBuscado = entrada.nextLine();
        // Ejecutamos el método encargado de buscar y mostrar al empleado correspondiente.
        buscarEmpleado(codigos, nombres, codigoBuscado);
        // Cerramos el objeto Scanner para liberar el recurso utilizado.
        entrada.close();
    }
}