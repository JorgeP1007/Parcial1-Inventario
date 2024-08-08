public class Producto {

        private String nombre;
        private double precio;
        private int cantidadInicial;
        private int cantidadVendida;

        public Producto(String nombre, double precio, int cantidadInicial) {
            this.nombre = nombre;
            this.precio = precio;
            this.cantidadInicial = cantidadInicial;
            this.cantidadVendida = 0;
        }

        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public int getCantidadInicial() {
            return cantidadInicial;
        }

        public int getCantidadVendida() {
            return cantidadVendida;
        }

        public int getCantidadDisponible() {
            return cantidadInicial - cantidadVendida;
        }

        public void vender(int cantidad) {
            if (cantidad > getCantidadDisponible()) {
                System.out.println("No hay suficiente stock para la venta de " + cantidad + " unidades de " + nombre);
            } else {
                cantidadVendida += cantidad;
            }
        }

        public void duplicarInventario() {
            if (getCantidadDisponible() == 0) {
                cantidadInicial *= 2;
                cantidadVendida = 0;
            } else {
                System.out.println("El producto " + nombre + " todavía tiene stock disponible. No se puede duplicar el inventario.");
            }
        }

        public void mostrarInformacion() {
            System.out.println("Nombre del Producto: " + nombre);
            System.out.println("Precio: $" + precio);
            System.out.println("Cantidad Inicial: " + cantidadInicial);
            System.out.println("Cantidad Vendida: " + cantidadVendida);
            System.out.println("Cantidad Disponible: " + getCantidadDisponible());
        }
    }


