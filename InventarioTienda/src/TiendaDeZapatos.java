import java.util.Scanner;

public class TiendaDeZapatos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();

        while (true) {
            System.out.println("\nGestión de Inventario de la Tienda de Zapatos");
            System.out.println("1. Ingresar información de un producto");
            System.out.println("2. Vender producto");
            System.out.println("3. Duplicar inventario de un producto vendido totalmente");
            System.out.println("4. Mostrar información actualizada del inventario");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el precio del producto: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Ingrese la cantidad inicial del producto: ");
                    int cantidadInicial = scanner.nextInt();
                    Producto nuevoProducto = new Producto(nombre, precio, cantidadInicial);
                    inventario.agregarProducto(nuevoProducto);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del producto a vender: ");
                    String nombreVenta = scanner.nextLine();
                    Producto productoVenta = inventario.buscarProducto(nombreVenta);
                    if (productoVenta != null) {
                        System.out.print("Ingrese la cantidad a vender: ");
                        int cantidadVenta = scanner.nextInt();
                        productoVenta.vender(cantidadVenta);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del producto para duplicar inventario: ");
                    String nombreDuplicar = scanner.nextLine();
                    Producto productoDuplicar = inventario.buscarProducto(nombreDuplicar);
                    if (productoDuplicar != null) {
                        productoDuplicar.duplicarInventario();
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 4:
                    inventario.mostrarInventario();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
            }
        }
    }
}
