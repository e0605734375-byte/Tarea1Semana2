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
    // Declaramos una constante para indicar que todos los estudiantes cursan 8 materias.
    static final int MATERIAS = 8;
    // Metodo para registrar los codigos de los estudiantes.
    public static void registrarCodigos(String[] codigos) {

        // Recorremos el arreglo para ingresar el codigo de cada estudiante.
        for (int i = 0; i < codigos.length; i++) {

            // Solicitamos el codigo del estudiante correspondiente.
            System.out.print("Ingrese el codigo del estudiante " + (i + 1) + ": ");

            // Guardamos el codigo ingresado en el arreglo.
            codigos[i] = entrada.next();
        }
    }

    // Metodo para registrar las calificaciones de todos los estudiantes.
    public static void registrarCalificaciones(String[] codigos, double[][] calificaciones) {
        // Recorremos las filas de la matriz, que representan a los estudiantes.
        for (int i = 0; i < calificaciones.length; i++) {
            // Recorremos las columnas de la matriz, que representan las materias.
            for (int j = 0; j < calificaciones[i].length; j++) {
                // Declaramos una variable para almacenar la nota ingresada.
                double nota;
                // Solicitamos la calificacion hasta que se ingrese un valor valido.
                do {
                    // Indicamos el estudiante y la materia de la calificacion.
                    System.out.print("Ingrese la nota del estudiante "
                            + codigos[i] + " en la materia " + (j + 1) + ": ");

                    // Leemos la calificacion ingresada.
                    nota = entrada.nextDouble();

                    // Verificamos que la calificacion se encuentre entre 0 y 10.
                    if (nota < 0 || nota > 10) {

                        // Informamos que la calificacion ingresada no es valida.
                        System.out.println("Error: la nota debe estar entre 0 y 10.");
                    }

                // Repetimos el ingreso mientras la nota no sea valida.
                } while (nota < 0 || nota > 10);
                // Guardamos la calificacion en la posicion correspondiente de la matriz.
                calificaciones[i][j] = nota;
            }
        }
    }

    // Metodo para mostrar la matriz con las calificaciones registradas.
    public static void mostrarCalificaciones(String[] codigos, double[][] calificaciones) {

        // Mostramos el titulo de la matriz.
        System.out.println("\nMATRIZ DE CALIFICACIONES");

        // Recorremos las filas para mostrar los datos de cada estudiante.
        for (int i = 0; i < calificaciones.length; i++) {

            // Mostramos el codigo del estudiante.
            System.out.print(codigos[i] + "\t");

            // Recorremos las columnas para mostrar sus calificaciones.
            for (int j = 0; j < calificaciones[i].length; j++) {

                // Imprimimos cada calificacion con dos decimales.
                System.out.printf("%.2f\t", calificaciones[i][j]);
            }

            // Realizamos un salto de linea para continuar con el siguiente estudiante.
            System.out.println();
        }
    }

    // Metodo para calcular el promedio de cada estudiante.
    public static double[] calcularPromediosEstudiantes(double[][] calificaciones) {

        // Creamos un arreglo para almacenar el promedio de cada estudiante.
        double[] promedios = new double[calificaciones.length];

        // Recorremos las filas de la matriz para identificar a cada estudiante.
        for (int i = 0; i < calificaciones.length; i++) {

            // Inicializamos una variable para acumular sus calificaciones.
            double suma = 0;

            // Recorremos las ocho materias del estudiante.
            for (int j = 0; j < calificaciones[i].length; j++) {

                // Sumamos la calificacion de cada materia.
                suma += calificaciones[i][j];
            }

            // Dividimos la suma para el numero de materias y guardamos el promedio.
            promedios[i] = suma / calificaciones[i].length;
        }

        // Devolvemos el arreglo con los promedios de todos los estudiantes.
        return promedios;
    }

    // Metodo para calcular el promedio de calificaciones de cada materia.
    public static double[] calcularPromediosMaterias(double[][] calificaciones) {

        // Creamos un arreglo para almacenar el promedio de cada materia.
        double[] promedios = new double[calificaciones[0].length];

        // Recorremos las columnas de la matriz, que representan las materias.
        for (int j = 0; j < calificaciones[0].length; j++) {

            // Inicializamos una variable para acumular las calificaciones.
            double suma = 0;

            // Recorremos las filas para obtener las notas de todos los estudiantes.
            for (int i = 0; i < calificaciones.length; i++) {

                // Sumamos la calificacion del estudiante en la materia correspondiente.
                suma += calificaciones[i][j];
            }

            // Dividimos la suma para la cantidad de estudiantes.
            promedios[j] = suma / calificaciones.length;
        }

        // Devolvemos el arreglo con los promedios de cada materia.
        return promedios;
    }

    // Metodo para identificar al estudiante con el mayor promedio.
    public static void mostrarMayorPromedio(String[] codigos, double[] promedios) {

        // Inicializamos el mayor promedio con el del primer estudiante.
        double mayor = promedios[0];

        // Recorremos los promedios para encontrar el valor mas alto.
        for (int i = 1; i < promedios.length; i++) {

            // Comparamos el promedio actual con el mayor encontrado.
            if (promedios[i] > mayor) {

                // Actualizamos el mayor promedio cuando encontramos uno superior.
                mayor = promedios[i];
            }
        }
        // Mostramos el titulo del resultado.
        System.out.println("\nESTUDIANTE CON MAYOR PROMEDIO");

        // Recorremos nuevamente los promedios para identificar al estudiante.
        for (int i = 0; i < promedios.length; i++) {

            // Verificamos si el estudiante tiene el mayor promedio.
            if (promedios[i] == mayor) {

                // Mostramos el codigo y el promedio del estudiante.
                System.out.printf("Codigo: %s - Promedio: %.2f%n",
                        codigos[i], promedios[i]);
            }
        }
    }

    // Metodo para contar los estudiantes aprobados en cada materia.
    public static int[] contarAprobados(double[][] calificaciones) {
        // Creamos un arreglo para almacenar los aprobados de cada materia.
        int[] aprobados = new int[calificaciones[0].length];
        // Recorremos las columnas de la matriz para analizar cada materia.
        for (int j = 0; j < calificaciones[0].length; j++) {

            // Recorremos las filas para revisar la nota de cada estudiante.
            for (int i = 0; i < calificaciones.length; i++) {

                // Verificamos si la nota es mayor o igual a 7 y menor o igual a 10.
                if (calificaciones[i][j] >= 7 && calificaciones[i][j] <= 10) {

                    // Incrementamos el contador de aprobados de esa materia.
                    aprobados[j]++;
                }
            }
        }
        // Devolvemos el arreglo con la cantidad de aprobados por materia.
        return aprobados;
    }

    // Metodo para contar los estudiantes reprobados en cada materia.
    public static int[] contarReprobados(double[][] calificaciones) {

        // Creamos un arreglo para almacenar los reprobados de cada materia.
        int[] reprobados = new int[calificaciones[0].length];

        // Recorremos las columnas de la matriz para analizar cada materia.
        for (int j = 0; j < calificaciones[0].length; j++) {

            // Recorremos las filas para revisar la nota de cada estudiante.
            for (int i = 0; i < calificaciones.length; i++) {

                // Verificamos si la calificacion es menor que 7.
                if (calificaciones[i][j] < 7) {

                    // Incrementamos el contador de reprobados de esa materia.
                    reprobados[j]++;
                }
            }
        }

        // Devolvemos el arreglo con la cantidad de reprobados por materia.
        return reprobados;
    }

    // Metodo para mostrar el promedio de cada estudiante.
    public static void mostrarPromediosEstudiantes(String[] codigos, double[] promedios) {

        // Mostramos el titulo de los resultados.
        System.out.println("\nPROMEDIO POR ESTUDIANTE");

        // Recorremos el arreglo de promedios.
        for (int i = 0; i < promedios.length; i++) {

            // Mostramos el codigo y el promedio de cada estudiante.
            System.out.printf("Estudiante %s: %.2f%n", codigos[i], promedios[i]);
        }
    }

    // Metodo para mostrar el promedio de cada materia.
    public static void mostrarPromediosMaterias(double[] promedios) {

        // Mostramos el titulo de los resultados.
        System.out.println("\nPROMEDIO POR MATERIA");

        // Recorremos el arreglo de promedios de las materias.
        for (int i = 0; i < promedios.length; i++) {

            // Mostramos el numero de la materia y su promedio.
            System.out.printf("Materia %d: %.2f%n", (i + 1), promedios[i]);
        }
    }

    // Metodo para mostrar la cantidad de aprobados y reprobados por materia.
    public static void mostrarResultadosMaterias(int[] aprobados, int[] reprobados) {

        // Mostramos el titulo de los resultados.
        System.out.println("\nESTUDIANTES APROBADOS Y REPROBADOS POR MATERIA");

        // Recorremos las materias para mostrar sus respectivos resultados.
        for (int i = 0; i < aprobados.length; i++) {

            // Mostramos el numero de materia y la cantidad de aprobados y reprobados.
            System.out.println("Materia " + (i + 1)
                    + " - Aprobados: " + aprobados[i]
                    + " - Reprobados: " + reprobados[i]);
        }
    }

    // Metodo principal desde donde comienza la ejecucion del programa.
    public static void main(String[] args) {

        // Solicitamos la cantidad de estudiantes del grupo.
        System.out.print("Ingrese la cantidad de estudiantes: ");
        int n = entrada.nextInt();

        // Verificamos que la cantidad de estudiantes sea mayor que cero.
        if (n <= 0) {

            // Informamos que la cantidad ingresada no es valida.
            System.out.println("Error: debe ingresar al menos un estudiante.");

        } else {

            // Creamos un arreglo para almacenar los codigos de los estudiantes.
            String[] codigos = new String[n];

            // Creamos la matriz para almacenar las calificaciones de los estudiantes.
            double[][] calificaciones = new double[n][MATERIAS];

            // Llamamos al metodo para registrar los codigos de los estudiantes.
            registrarCodigos(codigos);

            // Llamamos al metodo para registrar las calificaciones de las ocho materias.
            registrarCalificaciones(codigos, calificaciones);

            // Mostramos la matriz con todas las calificaciones registradas.
            mostrarCalificaciones(codigos, calificaciones);

            // Calculamos el promedio de cada estudiante.
            double[] promediosEstudiantes =
                    calcularPromediosEstudiantes(calificaciones);

            // Calculamos el promedio de cada materia.
            double[] promediosMaterias =
                    calcularPromediosMaterias(calificaciones);

            // Identificamos y mostramos al estudiante con mayor promedio.
            mostrarMayorPromedio(codigos, promediosEstudiantes);

            // Contamos los estudiantes aprobados en cada materia.
            int[] aprobados = contarAprobados(calificaciones);

            // Contamos los estudiantes reprobados en cada materia.
            int[] reprobados = contarReprobados(calificaciones);

            // Mostramos los promedios individuales de los estudiantes.
            mostrarPromediosEstudiantes(codigos, promediosEstudiantes);

            // Mostramos los promedios correspondientes a cada materia.
            mostrarPromediosMaterias(promediosMaterias);

            // Mostramos la cantidad de aprobados y reprobados por materia.
            mostrarResultadosMaterias(aprobados, reprobados);
        }

        // Cerramos el objeto Scanner para liberar el recurso utilizado.
        entrada.close();
    }
}
