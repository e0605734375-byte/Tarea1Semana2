/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/




import java.util.Scanner;

// Declaramos la clase principal con el nombre Main.
public class Main {

    // Creamos un objeto Scanner para ingresar datos por teclado.
    static Scanner entrada = new Scanner(System.in);

    // Metodo para registrar las ventas de cada vendedor en cada año.
    public static void registrarVentas(double[][] ventas) {

        // Recorremos las filas de la matriz, que representan a los vendedores.
        for (int i = 0; i < ventas.length; i++) {

            // Recorremos las columnas de la matriz, que representan los años.
            for (int j = 0; j < ventas[i].length; j++) {

                // Solicitamos las ventas del vendedor en el año correspondiente.
                System.out.print("Ingrese las ventas del vendedor " + (i + 1)
                        + " en el año " + (j + 1) + ": ");

                // Guardamos el valor ingresado en la posicion correspondiente.
                ventas[i][j] = entrada.nextDouble();
            }
        }
    }

    // Metodo para mostrar todas las ventas registradas en la matriz.
    public static void mostrarVentas(double[][] ventas) {

        // Mostramos el titulo de la matriz.
        System.out.println("\nMATRIZ DE VENTAS");

        // Recorremos las filas de la matriz para mostrar cada vendedor.
        for (int i = 0; i < ventas.length; i++) {

            // Mostramos el numero del vendedor correspondiente.
            System.out.print("Vendedor " + (i + 1) + "\t");

            // Recorremos las columnas para mostrar sus ventas por año.
            for (int j = 0; j < ventas[i].length; j++) {

                // Mostramos el valor de las ventas con dos decimales.
                System.out.printf("%.2f\t", ventas[i][j]);
            }

            // Realizamos un salto de linea para mostrar el siguiente vendedor.
            System.out.println();
        }
    }

    // Metodo para calcular el total de ventas acumulado por cada vendedor.
    public static double[] calcularVentasPorVendedor(double[][] ventas) {

        // Creamos un arreglo para almacenar el total de cada vendedor.
        double[] totalVendedores = new double[ventas.length];

        // Recorremos las filas de la matriz para identificar a cada vendedor.
        for (int i = 0; i < ventas.length; i++) {

            // Recorremos las columnas para sumar las ventas de todos los años.
            for (int j = 0; j < ventas[i].length; j++) {

                // Acumulamos las ventas de cada año en el total del vendedor.
                totalVendedores[i] += ventas[i][j];
            }
        }

        // Devolvemos el arreglo con los totales de cada vendedor.
        return totalVendedores;
    }

    // Metodo para calcular el total de ventas correspondiente a cada año.
    public static double[] calcularVentasPorAnio(double[][] ventas) {

        // Creamos un arreglo para almacenar el total de cada año.
        double[] totalAnios = new double[ventas[0].length];

        // Recorremos las columnas de la matriz, que representan los años.
        for (int j = 0; j < ventas[0].length; j++) {

            // Recorremos las filas para sumar las ventas de todos los vendedores.
            for (int i = 0; i < ventas.length; i++) {

                // Acumulamos las ventas de cada vendedor en el total del año.
                totalAnios[j] += ventas[i][j];
            }
        }

        // Devolvemos el arreglo con los totales correspondientes a cada año.
        return totalAnios;
    }

    // Metodo para calcular el total general de ventas de la empresa.
    public static double calcularTotalEmpresa(double[][] ventas) {

        // Inicializamos una variable para acumular todas las ventas.
        double totalEmpresa = 0;

        // Recorremos todas las filas de la matriz.
        for (int i = 0; i < ventas.length; i++) {

            // Recorremos todas las columnas de la matriz.
            for (int j = 0; j < ventas[i].length; j++) {

                // Sumamos cada valor al total general de la empresa.
                totalEmpresa += ventas[i][j];
            }
        }

        // Devolvemos el total acumulado de todas las ventas.
        return totalEmpresa;
    }

    // Metodo para mostrar el total de ventas acumulado por cada vendedor.
    public static void mostrarVentasPorVendedor(double[] totales) {

        // Mostramos el titulo de los resultados por vendedor.
        System.out.println("\nTOTAL DE VENTAS POR VENDEDOR");

        // Recorremos el arreglo que contiene los totales de cada vendedor.
        for (int i = 0; i < totales.length; i++) {

            // Mostramos el vendedor y su total de ventas con dos decimales.
            System.out.printf("Vendedor %d: $%.2f%n", (i + 1), totales[i]);
        }
    }

    // Metodo para mostrar el total de ventas correspondiente a cada año.
    public static void mostrarVentasPorAnio(double[] totales) {

        // Mostramos el titulo de los resultados por año.
        System.out.println("\nTOTAL DE VENTAS POR ANIO");

        // Recorremos el arreglo que contiene los totales de cada año.
        for (int i = 0; i < totales.length; i++) {

            // Mostramos el año y su total de ventas con dos decimales.
            System.out.printf("Anio %d: $%.2f%n", (i + 1), totales[i]);
        }
    }

    // Metodo principal desde donde comienza la ejecucion del programa.
    public static void main(String[] args) {

        // Solicitamos la cantidad de vendedores de la empresa.
        System.out.print("Ingrese la cantidad de vendedores: ");
        int n = entrada.nextInt();

        // Solicitamos la cantidad de años de operacion de la empresa.
        System.out.print("Ingrese la cantidad de años de operacion: ");
        int m = entrada.nextInt();

        // Verificamos que las cantidades ingresadas sean mayores que cero.
        if (n <= 0 || m <= 0) {

            // Informamos que las cantidades ingresadas no son validas.
            System.out.println("Error: las cantidades deben ser mayores que cero.");

        } else {

            // Creamos la matriz para almacenar las ventas de cada vendedor por año.
            double[][] ventas = new double[n][m];

            // Llamamos al metodo encargado de registrar las ventas.
            registrarVentas(ventas);

            // Llamamos al metodo encargado de mostrar la matriz registrada.
            mostrarVentas(ventas);

            // Calculamos las ventas acumuladas por cada vendedor.
            double[] totalVendedores = calcularVentasPorVendedor(ventas);

            // Calculamos las ventas correspondientes a cada año.
            double[] totalAnios = calcularVentasPorAnio(ventas);

            // Calculamos el total general de ventas de la empresa.
            double totalEmpresa = calcularTotalEmpresa(ventas);

            // Mostramos los resultados de las ventas por vendedor.
            mostrarVentasPorVendedor(totalVendedores);

            // Mostramos los resultados de las ventas por año.
            mostrarVentasPorAnio(totalAnios);

            // Mostramos el total general de ventas de la empresa.
            System.out.printf("\nTOTAL DE VENTAS DE LA EMPRESA: $%.2f%n",
                    totalEmpresa);
        }

        // Cerramos el objeto Scanner para liberar el recurso utilizado.
        entrada.close();
    }
}
