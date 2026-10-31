/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/




import java.util.Scanner;

public class Main {

    // Creamos el objeto Scanner para ingresar información por teclado.
    static Scanner entrada = new Scanner(System.in);

    // Método para registrar los medicamentos en los arreglos.
    public static void registrarMedicamentos(
            String[] nombres, int[] stockActual,
            int[] stockMinimo, double[] precios) {

        // Recorremos las posiciones de los arreglos para registrar cada medicamento.
        for (int i = 0; i < nombres.length; i++) {

            // Solicitamos el nombre del medicamento.
            System.out.println("\nMedicamento " + (i + 1));
            System.out.print("Ingrese el nombre: ");
            nombres[i] = entrada.nextLine();

            // Solicitamos el stock actual y validamos que no sea negativo.
            do {
                System.out.print("Ingrese el stock actual: ");
                stockActual[i] = entrada.nextInt();

                if (stockActual[i] < 0) {
                    System.out.println("El stock no puede ser negativo.");
                }

            } while (stockActual[i] < 0);

            // Solicitamos el stock mínimo y validamos que no sea negativo.
            do {
                System.out.print("Ingrese el stock mínimo: ");
                stockMinimo[i] = entrada.nextInt();

                if (stockMinimo[i] < 0) {
                    System.out.println("El stock mínimo no puede ser negativo.");
                }

            } while (stockMinimo[i] < 0);

            // Solicitamos el precio unitario y validamos que sea mayor que cero.
            do {
                System.out.print("Ingrese el precio unitario: ");
                precios[i] = entrada.nextDouble();

                if (precios[i] <= 0) {
                    System.out.println("El precio debe ser mayor que cero.");
                }

            } while (precios[i] <= 0);

            // Limpiamos el salto de línea pendiente para el siguiente nombre.
            entrada.nextLine();
        }
    }

    // Método que muestra los medicamentos cuyo stock está por debajo del mínimo.
    public static void mostrarStockBajo(
            String[] nombres, int[] stockActual, int[] stockMinimo) {

        // Variable que permite identificar si existe algún medicamento con stock bajo.
        boolean encontrado = false;

        // Recorremos todos los medicamentos registrados.
        for (int i = 0; i < nombres.length; i++) {

            // Comparamos el stock actual con el stock mínimo.
            if (stockActual[i] < stockMinimo[i]) {

                // Mostramos los datos del medicamento que necesita reposición.
                System.out.println("\nMedicamento: " + nombres[i]);
                System.out.println("Stock actual: " + stockActual[i]);
                System.out.println("Stock mínimo: " + stockMinimo[i]);

                // Indicamos que se encontró al menos un medicamento con stock bajo.
                encontrado = true;
            }
        }

        // Si no se encontró ningún medicamento con stock bajo, mostramos un mensaje.
        if (!encontrado) {
            System.out.println("No existen medicamentos con stock por debajo del mínimo.");
        }
    }

    // Método que calcula el valor económico total del inventario.
    public static double calcularValorInventario(
            int[] stockActual, double[] precios) {

        // Inicializamos el acumulador del valor total en cero.
        double total = 0;

        // Recorremos todos los medicamentos registrados.
        for (int i = 0; i < stockActual.length; i++) {

            // Multiplicamos las unidades disponibles por su precio unitario.
            total += stockActual[i] * precios[i];
        }

        // Devolvemos el valor económico total calculado.
        return total;
    }

    // Método que permite actualizar el stock después de realizar una venta.
    public static void actualizarStock(
            String[] nombres, int[] stockActual) {

        // Solicitamos el nombre del medicamento que se desea vender.
        System.out.print("\nIngrese el nombre del medicamento vendido: ");
        String nombreBuscado = entrada.nextLine();

        // Buscamos el medicamento dentro del inventario.
        for (int i = 0; i < nombres.length; i++) {

            // Comparamos los nombres sin distinguir mayúsculas y minúsculas.
            if (nombres[i].equalsIgnoreCase(nombreBuscado)) {

                // Solicitamos la cantidad de unidades vendidas.
                System.out.print("Ingrese la cantidad vendida: ");
                int cantidad = entrada.nextInt();

                // Verificamos que la cantidad sea válida y exista suficiente stock.
                if (cantidad <= 0) {
                    System.out.println("La cantidad vendida debe ser mayor que cero.");

                } else if (cantidad > stockActual[i]) {
                    System.out.println("No existe suficiente stock para realizar la venta.");

                } else {

                    // Descontamos las unidades vendidas del stock actual.
                    stockActual[i] = stockActual[i] - cantidad;

                    // Informamos el nuevo stock disponible.
                    System.out.println("Venta registrada correctamente.");
                    System.out.println("Nuevo stock de " + nombres[i] + ": " + stockActual[i]);
                }

                // Limpiamos el salto de línea pendiente.
                entrada.nextLine();

                // Finalizamos la búsqueda porque encontramos el medicamento.
                return;
            }
        }

        // Informamos cuando el medicamento ingresado no existe en el inventario.
        System.out.println("El medicamento no se encuentra registrado.");
    }

    // Método que genera el reporte general del inventario.
    public static void mostrarReporte(
            String[] nombres, int[] stockActual,
            int[] stockMinimo, double[] precios) {

        // Mostramos el encabezado del reporte.
        System.out.println("\n========== REPORTE GENERAL DEL INVENTARIO ==========");

        // Recorremos todos los medicamentos registrados.
        for (int i = 0; i < nombres.length; i++) {

            // Calculamos el valor económico de las unidades de cada medicamento.
            double valor = stockActual[i] * precios[i];

            // Mostramos la información completa del medicamento.
            System.out.println("\nMedicamento: " + nombres[i]);
            System.out.println("Stock actual: " + stockActual[i]);
            System.out.println("Stock mínimo: " + stockMinimo[i]);
            System.out.printf("Precio unitario: $%.2f%n", precios[i]);
            System.out.printf("Valor en inventario: $%.2f%n", valor);

            // Indicamos si el medicamento necesita reposición.
            if (stockActual[i] < stockMinimo[i]) {
                System.out.println("Estado: STOCK BAJO - REQUIERE REPOSICIÓN");
            } else {
                System.out.println("Estado: STOCK DISPONIBLE");
            }
        }

        // Mostramos el valor económico total de todos los medicamentos.
        System.out.printf("\nVALOR TOTAL DEL INVENTARIO: $%.2f%n",
                calcularValorInventario(stockActual, precios));
    }

    // Método principal donde inicia la ejecución del programa.
    public static void main(String[] args) {

        // Solicitamos la cantidad de medicamentos que se van a registrar.
        System.out.print("Ingrese la cantidad de medicamentos: ");
        int n = entrada.nextInt();

        // CORRECCIÓN: limpiamos el salto de línea dejado por nextInt().
        entrada.nextLine();

        // Verificamos que la cantidad de medicamentos sea mayor que cero.
        if (n <= 0) {
            System.out.println("La cantidad debe ser mayor que cero.");
            entrada.close();
            return;
        }

        // Creamos el arreglo que almacenará los nombres de los medicamentos.
        String[] nombres = new String[n];

        // Creamos el arreglo que almacenará el stock actual.
        int[] stockActual = new int[n];

        // Creamos el arreglo que almacenará el stock mínimo.
        int[] stockMinimo = new int[n];

        // Creamos el arreglo que almacenará los precios unitarios.
        double[] precios = new double[n];

        // Registramos todos los medicamentos antes de mostrar el menú.
        registrarMedicamentos(nombres, stockActual, stockMinimo, precios);

        // Declaramos la variable que almacenará la opción seleccionada.
        int opcion;

        // Repetimos el menú hasta que el usuario seleccione salir.
        do {

            // Mostramos las opciones disponibles del programa.
            System.out.println("\n========== MENÚ DE INVENTARIO ==========");
            System.out.println("1. Mostrar medicamentos con stock bajo");
            System.out.println("2. Calcular valor total del inventario");
            System.out.println("3. Registrar una venta");
            System.out.println("4. Mostrar reporte general");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            // Leemos la opción seleccionada por el usuario.
            opcion = entrada.nextInt();

            // Limpiamos el salto de línea pendiente.
            entrada.nextLine();

            // Evaluamos la opción seleccionada.
            switch (opcion) {

                // Opción para mostrar los medicamentos con stock bajo.
                case 1:
                    mostrarStockBajo(nombres, stockActual, stockMinimo);
                    break;

                // Opción para calcular el valor económico total del inventario.
                case 2:
                    System.out.printf("Valor total del inventario: $%.2f%n",
                            calcularValorInventario(stockActual, precios));
                    break;

                // Opción para registrar una venta y actualizar el stock.
                case 3:
                    actualizarStock(nombres, stockActual);
                    break;

                // Opción para mostrar el reporte general del inventario.
                case 4:
                    mostrarReporte(nombres, stockActual, stockMinimo, precios);
                    break;

                // Opción para finalizar la ejecución del programa.
                case 5:
                    System.out.println("Saliendo del sistema de inventario.");
                    break;

                // Mensaje para las opciones que no se encuentran en el menú.
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

        } while (opcion != 5);

        // Cerramos el objeto Scanner al finalizar el programa.
        entrada.close();
    }
}
