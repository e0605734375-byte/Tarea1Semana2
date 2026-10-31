/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/







import java.util.Scanner;

// Declaramos la clase principal del programa.
public class Main {

    // Creamos un objeto Scanner para ingresar datos por teclado.
    static Scanner entrada = new Scanner(System.in);

    // Metodo para registrar los datos de todos los trabajadores.
    public static void registrarTrabajadores(String[] codigos,
            double[] horasAusencia, int[] defectuosos, int[] producidos) {

        // Recorremos los arreglos para registrar la informacion de cada trabajador.
        for (int i = 0; i < codigos.length; i++) {

            // Solicitamos el codigo del trabajador.
            System.out.print("\nIngrese el codigo del trabajador " + (i + 1) + ": ");

            // Guardamos el codigo ingresado.
            codigos[i] = entrada.next();

            // Solicitamos las horas de ausencia del trabajador.
            System.out.print("Ingrese las horas de ausencia: ");
            horasAusencia[i] = entrada.nextDouble();

            // Verificamos que las horas de ausencia no sean negativas.
            while (horasAusencia[i] < 0) {

                // Informamos que el valor ingresado no es valido.
                System.out.println("Error: las horas no pueden ser negativas.");

                // Solicitamos nuevamente las horas de ausencia.
                System.out.print("Ingrese las horas de ausencia: ");
                horasAusencia[i] = entrada.nextDouble();
            }

            // Solicitamos la cantidad de pupitres defectuosos.
            System.out.print("Ingrese la cantidad de pupitres defectuosos: ");
            defectuosos[i] = entrada.nextInt();

            // Verificamos que la cantidad de pupitres defectuosos no sea negativa.
            while (defectuosos[i] < 0) {

                // Informamos que el valor ingresado no es valido.
                System.out.println("Error: la cantidad no puede ser negativa.");

                // Solicitamos nuevamente la cantidad de pupitres defectuosos.
                System.out.print("Ingrese la cantidad de pupitres defectuosos: ");
                defectuosos[i] = entrada.nextInt();
            }

            // Solicitamos la cantidad de pupitres producidos.
            System.out.print("Ingrese la cantidad de pupitres producidos: ");
            producidos[i] = entrada.nextInt();

            // Verificamos que la cantidad de pupitres producidos no sea negativa.
            while (producidos[i] < 0) {

                // Informamos que el valor ingresado no es valido.
                System.out.println("Error: la cantidad no puede ser negativa.");

                // Solicitamos nuevamente la cantidad de pupitres producidos.
                System.out.print("Ingrese la cantidad de pupitres producidos: ");
                producidos[i] = entrada.nextInt();
            }
        }
    }

    // Metodo para calcular el grado de eficiencia de un trabajador.
    public static int calcularGrado(double horas, int defectuosos, int producidos) {

        // Evaluamos si el trabajador cumple la primera condicion.
        boolean condicion1 = horas <= 3;

        // Evaluamos si el trabajador cumple la segunda condicion.
        boolean condicion2 = defectuosos < 300;

        // Evaluamos si el trabajador cumple la tercera condicion.
        boolean condicion3 = producidos > 10000;

        // Verificamos si el trabajador cumple las tres condiciones.
        if (condicion1 && condicion2 && condicion3) {

            // Asignamos el grado 20 cuando cumple todas las condiciones.
            return 20;

        // Verificamos si cumple solamente la primera y segunda condicion.
        } else if (condicion1 && condicion2 && !condicion3) {

            // Asignamos el grado 12.
            return 12;

        // Verificamos si cumple solamente la primera y tercera condicion.
        } else if (condicion1 && !condicion2 && condicion3) {

            // Asignamos el grado 13.
            return 13;

        // Verificamos si cumple solamente la segunda y tercera condicion.
        } else if (!condicion1 && condicion2 && condicion3) {

            // Asignamos el grado 15.
            return 15;

        // Verificamos si cumple solamente la primera condicion.
        } else if (condicion1 && !condicion2 && !condicion3) {

            // Asignamos el grado 7.
            return 7;

        // Verificamos si cumple solamente la segunda condicion.
        } else if (!condicion1 && condicion2 && !condicion3) {

            // Asignamos el grado 8.
            return 8;

        // Verificamos si cumple solamente la tercera condicion.
        } else if (!condicion1 && !condicion2 && condicion3) {

            // Asignamos el grado 9.
            return 9;

        // Si no cumple ninguna condicion, se ejecuta esta alternativa.
        } else {

            // Asignamos el grado 5.
            return 5;
        }
    }

    // Metodo para calcular el grado de eficiencia de todos los trabajadores.
    public static int[] calcularGrados(double[] horasAusencia,
            int[] defectuosos, int[] producidos) {

        // Creamos un arreglo para almacenar el grado de cada trabajador.
        int[] grados = new int[horasAusencia.length];

        // Recorremos los arreglos para evaluar a cada trabajador.
        for (int i = 0; i < horasAusencia.length; i++) {

            // Llamamos al metodo que determina el grado de eficiencia.
            grados[i] = calcularGrado(horasAusencia[i],
                    defectuosos[i], producidos[i]);
        }

        // Devolvemos el arreglo con los grados calculados.
        return grados;
    }

    // Metodo para mostrar toda la informacion de los trabajadores.
    public static void mostrarResultados(String[] codigos,
            double[] horasAusencia, int[] defectuosos,
            int[] producidos, int[] grados) {

        // Mostramos el titulo de los resultados.
        System.out.println("\nREPORTE DE EFICIENCIA DE LOS TRABAJADORES");

        // Recorremos los arreglos para mostrar la informacion de cada trabajador.
        for (int i = 0; i < codigos.length; i++) {

            // Mostramos el codigo del trabajador.
            System.out.println("\nCodigo del trabajador: " + codigos[i]);

            // Mostramos las horas de ausencia registradas.
            System.out.println("Horas de ausencia: " + horasAusencia[i]);

            // Mostramos la cantidad de pupitres defectuosos.
            System.out.println("Pupitres defectuosos: " + defectuosos[i]);

            // Mostramos la cantidad de pupitres producidos.
            System.out.println("Pupitres producidos: " + producidos[i]);

            // Mostramos el grado de eficiencia obtenido.
            System.out.println("Grado de eficiencia: " + grados[i]);

            // Mostramos una linea para separar la informacion de cada trabajador.
            System.out.println("----------------------------------------");
        }
    }

    // Metodo principal desde donde comienza la ejecucion del programa.
    public static void main(String[] args) {

        // Solicitamos la cantidad de trabajadores de la fabrica.
        System.out.print("Ingrese la cantidad de trabajadores: ");
        int n = entrada.nextInt();

        // Verificamos que la cantidad de trabajadores sea mayor que cero.
        if (n <= 0) {

            // Informamos que la cantidad ingresada no es valida.
            System.out.println("Error: debe ingresar al menos un trabajador.");

        } else {

            // Creamos un arreglo para almacenar los codigos de los trabajadores.
            String[] codigos = new String[n];

            // Creamos un arreglo para almacenar las horas de ausencia.
            double[] horasAusencia = new double[n];

            // Creamos un arreglo para almacenar los pupitres defectuosos.
            int[] defectuosos = new int[n];

            // Creamos un arreglo para almacenar los pupitres producidos.
            int[] producidos = new int[n];

            // Llamamos al metodo para registrar los datos de los trabajadores.
            registrarTrabajadores(codigos, horasAusencia, defectuosos, producidos);

            // Calculamos el grado de eficiencia de cada trabajador.
            int[] grados = calcularGrados(horasAusencia, defectuosos, producidos);

            // Mostramos toda la informacion y los grados de eficiencia calculados.
            mostrarResultados(codigos, horasAusencia, defectuosos, producidos, grados);
        }

        // Cerramos el objeto Scanner para liberar el recurso utilizado.
        entrada.close();
    }
}
