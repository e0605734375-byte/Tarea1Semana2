/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/

import java.util.Scanner;

public class Main {

    // Creamos el objeto Scanner para recibir los datos ingresados por teclado.
    static Scanner entrada = new Scanner(System.in);

    // Este método permite ingresar las cédulas de los estudiantes en un arreglo.
    public static void ingresarCedulas(long[] arreglo, String materia) {

        // Recorremos todas las posiciones del arreglo para solicitar cada cédula.
        for (int i = 0; i < arreglo.length; i++) {

            // Solicitamos al usuario la cédula del estudiante correspondiente.
            System.out.print("Ingrese la cedula del estudiante " + (i + 1)
                    + " que reprobo " + materia + ": ");

            // Guardamos la cédula ingresada en la posición actual del arreglo.
            arreglo[i] = entrada.nextLong();
        }
    }

    // Este método compara los dos arreglos y encuentra las cédulas repetidas.
    public static long[] encontrarReprobados(long[] matematica, long[] ingles) {
        // Creamos un arreglo temporal para almacenar las cédulas coincidentes.
        long[] coincidencias = new long[matematica.length];
        // Esta variable permite llevar la cuenta de los estudiantes encontrados.
        int contador = 0;
        // Recorremos el primer arreglo para comparar cada cédula.
        for (int i = 0; i < matematica.length; i++) {
            // Recorremos el segundo arreglo para buscar la misma cédula.
            for (int j = 0; j < ingles.length; j++) {
                // Comprobamos si la cédula aparece en los dos arreglos.
                if (matematica[i] == ingles[j]) {
                    // Verificamos que la cédula no haya sido registrada anteriormente.
                    boolean existe = false;
                    // Recorremos las coincidencias encontradas hasta el momento.
                    for (int k = 0; k < contador; k++) {

                        // Comprobamos si la cédula ya se encuentra en el tercer arreglo.
                        if (coincidencias[k] == matematica[i]) {
                            existe = true;
                            break;
                        }
                    }
                    // Si la cédula no existe, la almacenamos como una nueva coincidencia.
                    if (!existe) {
                        coincidencias[contador] = matematica[i];
                        contador++;
                    }
                    // Dejamos de buscar esta cédula porque ya encontramos una coincidencia.
                    break;
                }
            }
        }
        // Creamos el arreglo definitivo con el tamaño exacto de las coincidencias.
        long[] resultado = new long[contador];
        // Copiamos las cédulas encontradas al arreglo definitivo.
        for (int i = 0; i < contador; i++) {
            resultado[i] = coincidencias[i];
        }
        // Retornamos el arreglo que contiene los estudiantes que reprobaron ambas materias.
        return resultado;
    }

    // Este método permite mostrar en pantalla los elementos de un arreglo.
    public static void mostrarArreglo(long[] arreglo, String materia) {

        // Mostramos el nombre del arreglo que se va a imprimir.
        System.out.println("\n" + materia + ":");

        // Verificamos si el arreglo no contiene elementos.
        if (arreglo.length == 0) {
            System.out.println("No existen estudiantes registrados.");
        } else {

            // Recorremos el arreglo para mostrar todas las cédulas almacenadas.
            for (int i = 0; i < arreglo.length; i++) {
                System.out.println("Cedula " + (i + 1) + ": " + arreglo[i]);
            }
        }
    }

    // Este es el método principal desde donde comienza la ejecución del programa.
    public static void main(String[] args) {

        // Solicitamos la cantidad de estudiantes que se van a registrar.
        System.out.print("Ingrese la cantidad de estudiantes (N): ");
        int n = entrada.nextInt();

        // Creamos el primer arreglo para almacenar las cédulas de Matemática.
        long[] matematica = new long[n];

        // Creamos el segundo arreglo para almacenar las cédulas de Inglés.
        long[] ingles = new long[n];

        // Solicitamos las cédulas de los estudiantes que reprobaron Matemática.
        System.out.println("\nREGISTRO DE ESTUDIANTES QUE REPROBARON MATEMATICA");
        ingresarCedulas(matematica, "MATEMATICA");

        // Solicitamos las cédulas de los estudiantes que reprobaron Inglés.
        System.out.println("\nREGISTRO DE ESTUDIANTES QUE REPROBARON INGLES");
        ingresarCedulas(ingles, "INGLES");

        // Buscamos las cédulas que aparecen en ambos arreglos.
        long[] ambasMaterias = encontrarReprobados(matematica, ingles);

        // Mostramos el arreglo de estudiantes que reprobaron Matemática.
        mostrarArreglo(matematica, "ESTUDIANTES QUE REPROBARON MATEMATICA");

        // Mostramos el arreglo de estudiantes que reprobaron Inglés.
        mostrarArreglo(ingles, "ESTUDIANTES QUE REPROBARON INGLES");

        // Mostramos el tercer arreglo con los estudiantes que reprobaron ambas materias.
        mostrarArreglo(ambasMaterias, "ESTUDIANTES QUE REPROBARON AMBAS MATERIAS");

        // Cerramos el objeto Scanner para liberar el recurso utilizado.
        entrada.close();
    }
}

