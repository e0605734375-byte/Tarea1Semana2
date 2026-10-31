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

    // Este método permite registrar los precios de los artículos en cada sucursal.
    public static void registrarPrecios(double[][] precios) {

        // Recorremos todas las filas para registrar los precios de cada artículo.
        for (int i = 0; i < precios.length; i++) {

            // Recorremos las columnas para registrar los precios en cada sucursal.
            for (int j = 0; j < precios[i].length; j++) {

                // Solicitamos el precio del artículo en la sucursal correspondiente.
                System.out.print("Ingrese el precio del articulo " + (i + 1)
                        + " en la sucursal " + (j + 1) + ": ");

                // Guardamos el precio ingresado en la posición correspondiente de la matriz.
                precios[i][j] = entrada.nextDouble();
            }
        }
    }

    // Este método permite registrar las cantidades vendidas de cada artículo por sucursal.
    public static void registrarCantidades(int[][] cantidades) {

        // Recorremos todas las filas para registrar las ventas de cada artículo.
        for (int i = 0; i < cantidades.length; i++) {

            // Recorremos las columnas para registrar las cantidades vendidas en cada sucursal.
            for (int j = 0; j < cantidades[i].length; j++) {

                // Solicitamos la cantidad vendida del artículo en la sucursal correspondiente.
                System.out.print("Ingrese la cantidad vendida del articulo " + (i + 1)
                        + " en la sucursal " + (j + 1) + ": ");

                // Guardamos la cantidad ingresada en la posición correspondiente de la matriz.
                cantidades[i][j] = entrada.nextInt();
            }
        }
    }

    // Este método permite mostrar los precios registrados en la matriz.
    public static void mostrarPrecios(double[][] precios) {

        // Mostramos el título de la matriz de precios.
        System.out.println("\nMATRIZ DE PRECIOS");

        // Recorremos todas las filas de la matriz.
        for (int i = 0; i < precios.length; i++) {

            // Recorremos las columnas para mostrar los precios de cada sucursal.
            for (int j = 0; j < precios[i].length; j++) {

                // Mostramos el precio correspondiente con dos decimales.
                System.out.printf("%.2f\t", precios[i][j]);
            }

            // Realizamos un salto de línea para mostrar la siguiente fila.
            System.out.println();
        }
    }

    // Este método permite mostrar las cantidades vendidas de cada artículo por sucursal.
    public static void mostrarCantidades(int[][] cantidades) {

        // Mostramos el título de la matriz de cantidades vendidas.
        System.out.println("\nMATRIZ DE CANTIDADES VENDIDAS");

        // Recorremos todas las filas de la matriz.
        for (int i = 0; i < cantidades.length; i++) {

            // Recorremos las columnas para mostrar las cantidades de cada sucursal.
            for (int j = 0; j < cantidades[i].length; j++) {

                // Mostramos la cantidad vendida en la posición actual.
                System.out.print(cantidades[i][j] + "\t");
            }

            // Realizamos un salto de línea para mostrar la siguiente fila.
            System.out.println();
        }
    }

    // Este método calcula el total de ventas de cada artículo en todas las sucursales.
    public static double[] calcularVentasPorArticulo(double[][] precios, int[][] cantidades) {

        // Creamos un arreglo para almacenar el total de ventas de cada artículo.
        double[] totalArticulos = new double[precios.length];

        // Recorremos todas las filas para calcular las ventas de cada artículo.
        for (int i = 0; i < precios.length; i++) {

            // Recorremos las columnas para sumar las ventas de todas las sucursales.
            for (int j = 0; j < precios[i].length; j++) {

                // Multiplicamos el precio por la cantidad vendida y acumulamos el resultado.
                totalArticulos[i] += precios[i][j] * cantidades[i][j];
            }
        }

        // Retornamos el arreglo con los totales de ventas por artículo.
        return totalArticulos;
    }

    // Este método calcula el total de ventas de cada sucursal.
    public static double[] calcularVentasPorSucursal(double[][] precios, int[][] cantidades) {

        // Creamos un arreglo para almacenar el total de ventas de cada sucursal.
        double[] totalSucursales = new double[precios[0].length];

        // Recorremos todas las filas para considerar los diferentes artículos.
        for (int i = 0; i < precios.length; i++) {

            // Recorremos las columnas para calcular las ventas de cada sucursal.
            for (int j = 0; j < precios[i].length; j++) {

                // Multiplicamos el precio por la cantidad vendida y acumulamos el resultado.
                totalSucursales[j] += precios[i][j] * cantidades[i][j];
            }
        }

        // Retornamos el arreglo con los totales de ventas por sucursal.
        return totalSucursales;
    }

    // Este método muestra los resultados de las ventas por artículo.
    public static void mostrarVentasPorArticulo(double[] totalArticulos) {

        // Mostramos el título de los resultados de ventas por artículo.
        System.out.println("\nTOTAL DE VENTAS POR ARTICULO");

        // Recorremos el arreglo para mostrar el total correspondiente a cada artículo.
        for (int i = 0; i < totalArticulos.length; i++) {

            // Mostramos el número del artículo y su total de ventas.
            System.out.printf("Articulo %d: $%.2f%n", (i + 1), totalArticulos[i]);
        }
    }

    // Este método muestra los resultados de las ventas por sucursal.
    public static void mostrarVentasPorSucursal(double[] totalSucursales) {

        // Mostramos el título de los resultados de ventas por sucursal.
        System.out.println("\nTOTAL DE VENTAS POR SUCURSAL");

        // Recorremos el arreglo para mostrar el total correspondiente a cada sucursal.
        for (int i = 0; i < totalSucursales.length; i++) {

            // Mostramos el número de la sucursal y su total de ventas.
            System.out.printf("Sucursal %d: $%.2f%n", (i + 1), totalSucursales[i]);
        }
    }

    // Este es el método principal desde donde comienza la ejecución del programa.
    public static void main(String[] args) {
        // Solicitamos la cantidad de artículos que produce la fábrica.
        System.out.print("Ingrese la cantidad de articulos (N): ");
        int n = entrada.nextInt();
        // Solicitamos la cantidad de sucursales que tiene la empresa.
        System.out.print("Ingrese la cantidad de sucursales (M): ");
        int m = entrada.nextInt();
        // Verificamos que la cantidad de artículos y sucursales sean mayores que cero.
        if (n <= 0 || m <= 0) {
            // Informamos que las dimensiones ingresadas no son válidas.
            System.out.println("Error: la cantidad de articulos y sucursales debe ser mayor que cero.");

        } else {
            // Creamos la matriz para almacenar los precios de los artículos en cada sucursal.
            double[][] precios = new double[n][m];

            // Creamos la matriz para almacenar las cantidades vendidas de cada artículo.
            int[][] cantidades = new int[n][m];

            // Solicitamos los precios de todos los artículos en cada sucursal.
            System.out.println("\nREGISTRO DE PRECIOS");
            registrarPrecios(precios);

            // Solicitamos las cantidades vendidas de cada artículo en cada sucursal.
            System.out.println("\nREGISTRO DE CANTIDADES VENDIDAS");
            registrarCantidades(cantidades);

            // Mostramos la matriz con los precios registrados.
            mostrarPrecios(precios);

            // Mostramos la matriz con las cantidades vendidas.
            mostrarCantidades(cantidades);

            // Calculamos el total de ventas correspondiente a cada artículo.
            double[] totalArticulos = calcularVentasPorArticulo(precios, cantidades);

            // Calculamos el total de ventas correspondiente a cada sucursal.
            double[] totalSucursales = calcularVentasPorSucursal(precios, cantidades);

            // Mostramos los resultados de ventas por artículo.
            mostrarVentasPorArticulo(totalArticulos);

            // Mostramos los resultados de ventas por sucursal.
            mostrarVentasPorSucursal(totalSucursales);
        }

        // Cerramos el objeto Scanner para liberar el recurso utilizado.
        entrada.close();
    }
}
