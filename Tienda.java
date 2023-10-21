/** Juan Francisco Martínez 23617
  * Bebida
 
  * @param ml,tipo,aparte_de_los_que_extiende_de_productp
  * @throws Es la clase hija dedicada a las bebidas de la tienda

  */
import java.util.Scanner;
//importar las librerias
public class Tienda {
    public static void main(String[] args) {
        Data tienda = new Data();
        tienda.cargarProductosDesdeCSV("productos.csv");

        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("Menú de la Tienda:");
            System.out.println("1. Buscar un producto por ID");
            System.out.println("2. Buscar productos por categoría");
            System.out.println("3. Calcular ventas y comisión");
            System.out.println("4. Cerrar el programa");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();// cracion del switch para el menu de opciones

            switch (opcion) {
                case 1:// caso 1 imprimir el producto que se busca por medio del ID
                    System.out.print("Ingrese el ID del producto que desea buscar: ");
                    int idBuscado = scanner.nextInt();
                    Producto productoEncontrado = tienda.buscarProductoPorID(idBuscado);
                    if (productoEncontrado != null) {
                        System.out.println("Nombre: " + productoEncontrado.getNombre());
                        System.out.println("Cantidad Disponible: " + productoEncontrado.getCantidadDisponible() + " unidades");
                        System.out.println("Disponible: " + productoEncontrado.isDisponible());
                        System.out.println("Precio: Q " + productoEncontrado.getPrecio());
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 2:// caso 2 Ver los poductos de la tienda por categoria
                    System.out.print("Ingrese la categoría de productos que desea ver (bebidas, snacks, deli): ");
                    scanner.nextLine();
                    String categoriaDeseada = scanner.nextLine().toLowerCase();
                    System.out.println("Productos en la categoría '" + categoriaDeseada + "':");
                    tienda.listarProductosPorCategoria(categoriaDeseada);
                    break;
                case 3:// calcular el total de ventas, ventas por categoria y comision de deli
                    double ventasTotales = tienda.calcularTotalVentas();
                    double ventasBebidas = tienda.calcularVentasPorCategoria("Bebidas");
                    double ventasSnacks = tienda.calcularVentasPorCategoria("Snacks");
                    double ventasDeli = tienda.calcularVentasPorCategoria("Deli");
                    double comisionDeli = tienda.calcularComisionDeli();
                   
                    System.out.println("Ventas totales: Q " + ventasTotales);
                    System.out.println("Ventas de Bebidas: Q " + ventasBebidas);
                    System.out.println("Ventas de Snacks: Q " + ventasSnacks);
                    System.out.println("Ventas de Deli: Q " + ventasDeli);
                    System.out.println("Porcentaje de comisión de Deli: Q " + comisionDeli);
                    break;
                case 4:// cerrar el programa
                    System.out.println("Cerrando el programa de Inventario de la Tienda");
                    break;
                default:// defensa por si se ingresa otro numero
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);// funcion de que cuando se presione 4 se cierre el programa

        scanner.close();
    }
}

