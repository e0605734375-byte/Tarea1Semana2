/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/

import java.util.Scanner;
import java.util.Random;

public class Main {

    // Creamos un objeto Scanner para recibir los datos ingresados por teclado.
    static Scanner entrada = new Scanner(System.in);

    // Creamos un objeto Random para generar los números aleatorios.
    static Random aleatorio = new Random();

    // Este método llena una matriz con números enteros aleatorios.
    public static void llenarMatriz(int[][] matriz) {

        // Recorremos todas las filas de la matriz.
        for (int i = 0; i < matriz.length; i++) {

            // Recorremos todas las columnas de la fila actual.
            for (int j = 0; j < matriz[i].length; j++) {

                // Generamos un número aleatorio entre 1 y 10 y lo almacenamos.
                matriz[i][j] = aleatorio.nextInt(10) + 1;
            }
        }
    }

    // Este método permite mostrar los elementos de una matriz.
    public static void mostrarMatriz(int[][] matriz, String mensaje) {

        // Mostramos el nombre de la matriz que se va a imprimir.
        System.out.println("\n" + mensaje);

        // Recorremos todas las filas de la matriz.
        for (int i = 0; i < matriz.length; i++) {

            // Recorremos las columnas para mostrar cada elemento de la fila.
            for (int j = 0; j < matriz[i].length; j++) {

                // Imprimimos el elemento actual dejando un espacio entre valores.
                System.out.print(matriz[i][j] + "\t");
            }

            // Realizamos un salto de línea para mostrar la siguiente fila.
            System.out.println();
        }
    }

    // Este método realiza la suma de dos matrices.
    public static int[][] sumarMatrices(int[][] matrizA, int[][] matrizB) {

        // Creamos una matriz para almacenar los resultados de la suma.
        int[][] resultado = new int[matrizA.length][matrizA[0].length];

        // Recorremos todas las filas de las matrices.
        for (int i = 0; i < matrizA.length; i++) {

            // Recorremos todas las columnas de las matrices.
            for (int j = 0; j < matrizA[i].length; j++) {

                // Sumamos los elementos que ocupan la misma posición en ambas matrices.
                resultado[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }

        // Retornamos la matriz que contiene los resultados de la suma.
        return resultado;
    }

    // Este método realiza la resta de dos matrices.
    public static int[][] restarMatrices(int[][] matrizA, int[][] matrizB) {

        // Creamos una matriz para almacenar los resultados de la resta.
        int[][] resultado = new int[matrizA.length][matrizA[0].length];

        // Recorremos todas las filas de las matrices.
        for (int i = 0; i < matrizA.length; i++) {

            // Recorremos todas las columnas de las matrices.
            for (int j = 0; j < matrizA[i].length; j++) {

                // Restamos los elementos que ocupan la misma posición en ambas matrices.
                resultado[i][j] = matrizA[i][j] - matrizB[i][j];
            }
        }

        // Retornamos la matriz que contiene los resultados de la resta.
        return resultado;
    }

    // Este método realiza la multiplicación de dos matrices.
    public static int[][] multiplicarMatrices(int[][] matrizA, int[][] matrizB) {

        // Creamos una matriz para almacenar el resultado de la multiplicación.
        int[][] resultado = new int[matrizA.length][matrizB[0].length];

        // Recorremos las filas de la primera matriz.
        for (int i = 0; i < matrizA.length; i++) {

            // Recorremos las columnas de la segunda matriz.
            for (int j = 0; j < matrizB[0].length; j++) {

                // Recorremos las columnas de la primera matriz para realizar las multiplicaciones.
                for (int k = 0; k < matrizA[0].length; k++) {

                    // Multiplicamos los elementos correspondientes y acumulamos el resultado.
                    resultado[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }

        // Retornamos la matriz que contiene el resultado de la multiplicación.
        return resultado;
    }

    // Este método obtiene la matriz transpuesta de una matriz original.
    public static int[][] trasponerMatriz(int[][] matriz) {

        // Creamos una nueva matriz intercambiando la cantidad de filas por columnas.
        int[][] transpuesta = new int[matriz[0].length][matriz.length];

        // Recorremos todas las filas de la matriz original.
        for (int i = 0; i < matriz.length; i++) {

            // Recorremos todas las columnas de la matriz original.
            for (int j = 0; j < matriz[i].length; j++) {

                // Intercambiamos las posiciones de filas y columnas.
                transpuesta[j][i] = matriz[i][j];
            }
        }

        // Retornamos la matriz transpuesta.
        return transpuesta;
    }

    // Este es el método principal desde donde comienza la ejecución del programa.
    public static void main(String[] args) {

        // Solicitamos al usuario la cantidad de filas que tendrán las matrices.
        System.out.print("Ingrese el numero de filas (M): ");
        int m = entrada.nextInt();

        // Solicitamos al usuario la cantidad de columnas que tendrán las matrices.
        System.out.print("Ingrese el numero de columnas (N): ");
        int n = entrada.nextInt();

        // Verificamos que las dimensiones ingresadas sean mayores que cero.
        if (m <= 0 || n <= 0) {

            // Informamos que las dimensiones de las matrices no son validas.
            System.out.println("Error: las dimensiones deben ser mayores que cero.");

        } else {

            // Creamos la primera matriz con las dimensiones ingresadas.
            int[][] matrizA = new int[m][n];

            // Creamos la segunda matriz con las mismas dimensiones.
            int[][] matrizB = new int[m][n];

            // Llenamos la primera matriz con números enteros aleatorios.
            llenarMatriz(matrizA);

            // Llenamos la segunda matriz con números enteros aleatorios.
            llenarMatriz(matrizB);

            // Mostramos los elementos generados en la primera matriz.
            mostrarMatriz(matrizA, "MATRIZ A");

            // Mostramos los elementos generados en la segunda matriz.
            mostrarMatriz(matrizB, "MATRIZ B");

            // Presentamos las operaciones que el usuario puede seleccionar.
            System.out.println("\nMENU DE OPERACIONES");
            System.out.println("1. Sumar matrices");
            System.out.println("2. Restar matrices");
            System.out.println("3. Multiplicar matrices");
            System.out.println("4. Trasponer matrices");

            // Solicitamos al usuario que seleccione una operación.
            System.out.print("Seleccione una opcion: ");
            int opcion = entrada.nextInt();

            // Evaluamos la opción seleccionada para ejecutar la operación correspondiente.
            switch (opcion) {

                // Ejecutamos la suma de las dos matrices.
                case 1:

                    // Llamamos al método que realiza la suma de matrices.
                    int[][] suma = sumarMatrices(matrizA, matrizB);

                    // Mostramos el resultado de la suma.
                    mostrarMatriz(suma, "RESULTADO DE LA SUMA");
                    break;

                // Ejecutamos la resta de las dos matrices.
                case 2:

                    // Llamamos al método que realiza la resta de matrices.
                    int[][] resta = restarMatrices(matrizA, matrizB);

                    // Mostramos el resultado de la resta.
                    mostrarMatriz(resta, "RESULTADO DE LA RESTA");
                    break;

                // Ejecutamos la multiplicación de las dos matrices.
                case 3:

                    // Verificamos si las matrices cumplen la condición para multiplicarse.
                    if (n == m) {

                        // Llamamos al método que realiza la multiplicación de matrices.
                        int[][] multiplicacion = multiplicarMatrices(matrizA, matrizB);

                        // Mostramos el resultado de la multiplicación.
                        mostrarMatriz(multiplicacion, "RESULTADO DE LA MULTIPLICACION");

                    } else {

                        // Informamos que las dimensiones no permiten realizar la multiplicación.
                        System.out.println("No es posible multiplicar las matrices.");
                        System.out.println("El numero de columnas de la primera matriz "
                                + "debe coincidir con el numero de filas de la segunda.");
                    }
                    break;

                // Ejecutamos la transposición de las dos matrices.
                case 4:

                    // Obtenemos la transpuesta de la primera matriz.
                    int[][] transpuestaA = trasponerMatriz(matrizA);

                    // Obtenemos la transpuesta de la segunda matriz.
                    int[][] transpuestaB = trasponerMatriz(matrizB);

                    // Mostramos la transpuesta de la primera matriz.
                    mostrarMatriz(transpuestaA, "TRANSPUESTA DE LA MATRIZ A");

                    // Mostramos la transpuesta de la segunda matriz.
                    mostrarMatriz(transpuestaB, "TRANSPUESTA DE LA MATRIZ B");
                    break;

                // Informamos cuando el usuario selecciona una opción que no existe.
                default:
                    System.out.println("Opcion no valida. Seleccione una opcion del 1 al 4.");
                    break;
            }
        }

        // Cerramos el objeto Scanner para liberar el recurso utilizado.
        entrada.close();
    }
}