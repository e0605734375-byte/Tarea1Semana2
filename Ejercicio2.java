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

    // Este método llena el vector con 20 números enteros aleatorios.
    public static void llenarVector(int[] vector) {

        // Recorremos todas las posiciones del vector para asignarles un valor.
        for (int i = 0; i < vector.length; i++) {

            // Generamos un número aleatorio entre 1 y 100 y lo guardamos en el vector.
            vector[i] = aleatorio.nextInt(100) + 1;
        }
    }

    // Este método permite mostrar todos los elementos de un vector.
    public static void mostrarVector(int[] vector, String mensaje) {

        // Mostramos un mensaje para identificar el vector que se va a imprimir.
        System.out.println("\n" + mensaje);

        // Recorremos el vector para mostrar sus elementos.
        for (int i = 0; i < vector.length; i++) {

            // Imprimimos el índice y el valor almacenado en esa posición.
            System.out.println("Indice " + i + ": " + vector[i]);
        }
    }

    // Este método busca un número dentro del vector original.
    public static void buscarNumero(int[] vector, int numero) {
        // Creamos una variable para comprobar si el número fue encontrado.
        boolean encontrado = false;
        // Recorremos el vector para comparar sus elementos con el número buscado.
        for (int i = 0; i < vector.length; i++) {
            // Comprobamos si el elemento actual coincide con el número ingresado.
            if (vector[i] == numero) {
                // Mostramos el índice donde se encontró el número.
                System.out.println("El numero " + numero
                        + " se encuentra en el indice: " + i);
                // Indicamos que el número fue encontrado.
                encontrado = true;
            }
        }
        // Verificamos si el número no apareció en ninguna posición del vector.
        if (!encontrado) {

            // Informamos al usuario que el número no existe en el vector.
            System.out.println("El numero " + numero + " no se encuentra en el vector.");
        }
    }

    // Este método crea un segundo vector con los elementos de índices impares.
    public static int[] obtenerIndicesImpares(int[] vector) {
        // Creamos un segundo vector con la mitad de los elementos del original.
        int[] segundoVector = new int[vector.length / 2];
        // Creamos un contador para controlar las posiciones del segundo vector.
        int contador = 0;
        // Recorremos el vector original para identificar los índices impares.
        for (int i = 0; i < vector.length; i++) {
            // Comprobamos si el índice actual es impar.
            if (i % 2 != 0) {
                // Copiamos el elemento del vector original al segundo vector.
                segundoVector[contador] = vector[i];
                // Aumentamos el contador para utilizar la siguiente posición disponible.
                contador++;
            }
        }
        // Retornamos el segundo vector con los elementos seleccionados.
        return segundoVector;
    }

    // Este método cuenta los elementos mayores a 20 dentro del segundo vector.
    public static int contarMayoresA20(int[] vector) {
        // Inicializamos un contador para registrar cuántos elementos cumplen la condición.
        int contador = 0;
        // Recorremos todos los elementos del segundo vector.
        for (int i = 0; i < vector.length; i++) {
            // Comprobamos si el elemento actual es mayor a 20.
            if (vector[i] > 20) {
                // Aumentamos el contador cuando se cumple la condición.
                contador++;
            }
        }
        // Retornamos la cantidad de elementos mayores a 20.
        return contador;
    }

    // Este es el método principal desde donde comienza la ejecución del programa.
    public static void main(String[] args) {
        // Creamos el vector original con capacidad para almacenar 20 números enteros.
        int[] vectorOriginal = new int[20];
        // Generamos y almacenamos los números aleatorios en el vector original.
        llenarVector(vectorOriginal);
        // Mostramos los elementos del vector original para que el usuario pueda observarlos.
        mostrarVector(vectorOriginal, "VECTOR ORIGINAL");
        // Solicitamos al usuario un número entero para buscarlo en el vector.
        System.out.print("\nIngrese un numero para buscar en el vector: ");
        int numero = entrada.nextInt();
        // Ejecutamos el método encargado de buscar el número ingresado.
        buscarNumero(vectorOriginal, numero);
        // Creamos el segundo vector utilizando los elementos de índices impares.
        int[] segundoVector = obtenerIndicesImpares(vectorOriginal);
        // Mostramos los elementos almacenados en el segundo vector.
        mostrarVector(segundoVector, "SEGUNDO VECTOR - INDICES IMPARES");
        // Contamos cuántos elementos del segundo vector son mayores a 20.
        int cantidadMayores = contarMayoresA20(segundoVector);
        // Mostramos la cantidad de elementos que cumplen la condición.
        System.out.println("\nCantidad de elementos mayores a 20: " + cantidadMayores);
        // Cerramos el objeto Scanner para liberar el recurso utilizado.
        entrada.close();
    }
}
