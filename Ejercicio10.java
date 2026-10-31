/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/





import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Creamos el objeto Scanner para ingresar información por teclado.
    static Scanner entrada = new Scanner(System.in);

    // Creamos la clase Pedido para almacenar la información de cada pedido.
    static class Pedido {

        // Variable que almacena el nombre del cliente.
        String nombreCliente;

        // Variable que almacena el plato solicitado.
        String plato;

        // Variable que almacena la cantidad solicitada.
        int cantidad;

        // Variable que almacena el precio unitario.
        double precioUnitario;

        // Constructor que recibe los datos de cada pedido.
        public Pedido(String nombreCliente, String plato,
                      int cantidad, double precioUnitario) {

            // Asignamos el nombre del cliente.
            this.nombreCliente = nombreCliente;

            // Asignamos el nombre del plato.
            this.plato = plato;

            // Asignamos la cantidad solicitada.
            this.cantidad = cantidad;

            // Asignamos el precio unitario.
            this.precioUnitario = precioUnitario;
        }
    }

    // Método que registra los pedidos y los almacena en una lista.
    public static void registrarPedidos(ArrayList<Pedido> pedidos) {

        // Solicitamos la cantidad de pedidos que se van a registrar.
        System.out.print("Ingrese la cantidad de pedidos: ");
        int n = entrada.nextInt();

        // Limpiamos el salto de línea pendiente.
        entrada.nextLine();

        // Verificamos que la cantidad de pedidos sea mayor que cero.
        if (n <= 0) {
            System.out.println("La cantidad de pedidos debe ser mayor que cero.");
            return;
        }

        // Recorremos la cantidad de pedidos que se van a registrar.
        for (int i = 0; i < n; i++) {

            // Declaramos las variables que almacenarán los datos numéricos.
            int cantidadTemporal;
            double precioTemporal;

            // Mostramos el número del pedido que se está registrando.
            System.out.println("\nPedido " + (i + 1));

            // Solicitamos el nombre del cliente.
            System.out.print("Ingrese el nombre del cliente: ");
            String nombreCliente = entrada.nextLine();

            // Solicitamos el nombre del plato.
            System.out.print("Ingrese el plato solicitado: ");
            String plato = entrada.nextLine();

            // Solicitamos la cantidad y validamos que sea mayor que cero.
            do {
                System.out.print("Ingrese la cantidad: ");
                cantidadTemporal = entrada.nextInt();

                if (cantidadTemporal <= 0) {
                    System.out.println("La cantidad debe ser mayor que cero.");
                }

            } while (cantidadTemporal <= 0);

            // Solicitamos el precio unitario y validamos que sea mayor que cero.
            do {
                System.out.print("Ingrese el precio unitario: ");
                precioTemporal = entrada.nextDouble();

                if (precioTemporal <= 0) {
                    System.out.println("El precio debe ser mayor que cero.");
                }

            } while (precioTemporal <= 0);

            // Limpiamos el salto de línea pendiente.
            entrada.nextLine();

            // Creamos un nuevo objeto Pedido con los datos ingresados.
            Pedido nuevoPedido = new Pedido(
                    nombreCliente, plato, cantidadTemporal, precioTemporal);

            // Agregamos el nuevo pedido a la lista.
            pedidos.add(nuevoPedido);

            // Informamos que el pedido fue registrado correctamente.
            System.out.println("Pedido registrado correctamente.");
        }
    }

    // Método que calcula el subtotal de un pedido.
    public static double calcularSubtotal(Pedido pedido) {

        // Multiplicamos la cantidad por el precio unitario.
        return pedido.cantidad * pedido.precioUnitario;
    }

    // Método que calcula el descuento aplicado a un pedido.
    public static double calcularDescuento(Pedido pedido) {

        // Calculamos el subtotal del pedido.
        double subtotal = calcularSubtotal(pedido);

        // Verificamos si el pedido supera los 50 dólares.
        if (subtotal > 50) {

            // Calculamos el descuento correspondiente al 10 por ciento.
            return subtotal * 0.10;
        }

        // Si el pedido no supera los 50 dólares, devolvemos cero.
        return 0;
    }

    // Método que calcula el total final que debe pagar cada cliente.
    public static double calcularTotalPedido(Pedido pedido) {

        // Calculamos el subtotal del pedido.
        double subtotal = calcularSubtotal(pedido);

        // Obtenemos el descuento correspondiente.
        double descuento = calcularDescuento(pedido);

        // Restamos el descuento al subtotal y devolvemos el total final.
        return subtotal - descuento;
    }

    // Método que muestra la información y el total de cada pedido.
    public static void mostrarPedidos(ArrayList<Pedido> pedidos) {

        // Verificamos si la lista contiene pedidos registrados.
        if (pedidos.isEmpty()) {
            System.out.println("No existen pedidos registrados.");
            return;
        }

        // Recorremos todos los pedidos almacenados en la lista.
        for (int i = 0; i < pedidos.size(); i++) {

            // Obtenemos el pedido correspondiente a la posición actual.
            Pedido pedido = pedidos.get(i);

            // Calculamos el subtotal del pedido.
            double subtotal = calcularSubtotal(pedido);

            // Calculamos el descuento aplicado.
            double descuento = calcularDescuento(pedido);

            // Calculamos el total final que debe pagar el cliente.
            double total = calcularTotalPedido(pedido);

            // Mostramos la información general del pedido.
            System.out.println("\nPedido " + (i + 1));
            System.out.println("Cliente: " + pedido.nombreCliente);
            System.out.println("Plato: " + pedido.plato);
            System.out.println("Cantidad: " + pedido.cantidad);
            System.out.printf("Precio unitario: $%.2f%n", pedido.precioUnitario);

            // Mostramos el subtotal antes de aplicar el descuento.
            System.out.printf("Subtotal: $%.2f%n", subtotal);

            // Mostramos el descuento aplicado.
            System.out.printf("Descuento: $%.2f%n", descuento);

            // Mostramos el total final del pedido.
            System.out.printf("Total a pagar: $%.2f%n", total);
        }
    }

    // Método que calcula el ingreso total del restaurante.
    public static double calcularIngresoTotal(ArrayList<Pedido> pedidos) {

        // Inicializamos el acumulador de ingresos en cero.
        double ingresoTotal = 0;

        // Recorremos todos los pedidos registrados.
        for (int i = 0; i < pedidos.size(); i++) {

            // Obtenemos el pedido de la posición actual.
            Pedido pedido = pedidos.get(i);

            // Sumamos el total final del pedido al ingreso acumulado.
            ingresoTotal += calcularTotalPedido(pedido);
        }

        // Devolvemos el ingreso total del restaurante.
        return ingresoTotal;
    }

    // Método que identifica y muestra el pedido de mayor valor.
    public static void mostrarPedidoMayorValor(ArrayList<Pedido> pedidos) {

        // Verificamos si existen pedidos registrados.
        if (pedidos.isEmpty()) {
            System.out.println("No existen pedidos para comparar.");
            return;
        }

        // Inicializamos el pedido de mayor valor con el primer elemento.
        Pedido mayor = pedidos.get(0);

        // Calculamos el valor final del primer pedido.
        double mayorValor = calcularTotalPedido(mayor);

        // Recorremos los pedidos restantes de la lista.
        for (int i = 1; i < pedidos.size(); i++) {

            // Obtenemos el pedido de la posición actual.
            Pedido pedido = pedidos.get(i);

            // Calculamos el total final del pedido actual.
            double total = calcularTotalPedido(pedido);

            // Comparamos el pedido actual con el de mayor valor.
            if (total > mayorValor) {

                // Actualizamos el pedido de mayor valor.
                mayor = pedido;

                // Actualizamos el importe más alto encontrado.
                mayorValor = total;
            }
        }

        // Mostramos la información del pedido de mayor valor.
        System.out.println("\n========== PEDIDO DE MAYOR VALOR ==========");
        System.out.println("Cliente: " + mayor.nombreCliente);
        System.out.println("Plato: " + mayor.plato);
        System.out.println("Cantidad: " + mayor.cantidad);
        System.out.printf("Total a pagar: $%.2f%n", mayorValor);
    }

    // Método principal donde comienza la ejecución del programa.
    public static void main(String[] args) {

        // Creamos una lista dinámica para almacenar los pedidos.
        ArrayList<Pedido> pedidos = new ArrayList<>();

        // Declaramos la variable que almacenará la opción del menú.
        int opcion;

        // Repetimos el menú hasta que el usuario seleccione salir.
        do {

            // Mostramos las opciones disponibles del programa.
            System.out.println("\n========== MENÚ DEL RESTAURANTE ==========");
            System.out.println("1. Registrar pedidos");
            System.out.println("2. Mostrar pedidos y calcular totales");
            System.out.println("3. Calcular ingreso total del restaurante");
            System.out.println("4. Mostrar pedido de mayor valor");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            // Leemos la opción seleccionada por el usuario.
            opcion = entrada.nextInt();

            // Limpiamos el salto de línea pendiente.
            entrada.nextLine();

            // Evaluamos la opción seleccionada.
            switch (opcion) {

                // Opción para registrar nuevos pedidos.
                case 1:
                    registrarPedidos(pedidos);
                    break;

                // Opción para mostrar los pedidos y sus respectivos totales.
                case 2:
                    mostrarPedidos(pedidos);
                    break;

                // Opción para calcular los ingresos totales del restaurante.
                case 3:
                    System.out.printf("Ingreso total del restaurante: $%.2f%n",
                            calcularIngresoTotal(pedidos));
                    break;

                // Opción para mostrar el pedido de mayor valor.
                case 4:
                    mostrarPedidoMayorValor(pedidos);
                    break;

                // Opción para finalizar la ejecución del programa.
                case 5:
                    System.out.println("Saliendo del sistema de pedidos.");
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
