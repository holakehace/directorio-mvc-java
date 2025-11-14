package Vista;

import Modelo.Producto;

import java.util.List;
import java.util.Scanner;

public class InventarioVista {
    private Scanner scanner;

    public InventarioVista() {
        scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\n--- MENÚ INVENTARIO ---");
        System.out.println("1. Agregar nuevo producto");
        System.out.println("2. Buscar producto por SKU");
        System.out.println("3. Mostrar todos los productos");
        System.out.println("4. Eliminar producto por SKU");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");

        String linea = scanner.nextLine();
        try {
            int opcion = Integer.parseInt(linea.trim());
            return opcion;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public Producto pedirDatosUsuario() {
        System.out.println("\n--- AGREGAR PRODUCTO ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("SKU: ");
        String sku = scanner.nextLine().trim();

        int cantidad = 0;
        while (true) {
            System.out.print("Cantidad (entero): ");
            String cantidadLine = scanner.nextLine().trim();
            try {
                cantidad = Integer.parseInt(cantidadLine);
                if (cantidad < 0) {
                    System.out.println("La cantidad no puede ser negativa.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número entero.");
            }
        }

        double precio = 0.0;
        while (true) {
            System.out.print("Precio unitario (ej: 12.50): ");
            String precioLine = scanner.nextLine().trim();
            try {
                precio = Double.parseDouble(precioLine);
                if (precio < 0) {
                    System.out.println("El precio no puede ser negativo.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número decimal válido.");
            }
        }

        return new Producto(nombre, sku, cantidad, precio);
    }

    public String pedirSku() {
        System.out.print("Ingrese el SKU: ");
        return scanner.nextLine().trim();
    }

    public void mostrarProducto(Producto producto) {
        if (producto == null) {
            System.out.println("Producto no encontrado.");
        } else {
            System.out.println(producto.toString());
        }
    }

    public void mostrarProductos(List<Producto> productos) {
        if (productos == null || productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }
        System.out.println("\n--- LISTADO DE PRODUCTOS ---");
        for (Producto p : productos) {
            System.out.println(p.toString());
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrar() {
        if (scanner != null) {
            scanner.close();
        }
    }
}