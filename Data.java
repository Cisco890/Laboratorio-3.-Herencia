/** Juan Francisco Martínez 23617
  * Data
 
  * @param ml,tipo,aparte_de_los_que_extiende_de_productp
  * @throws Es la clase Encargada de leer el CSV, calcular las ventas (totales, por categoría y comisión), buscar los productos por su ID, listar los productos por categoría y calcular
  *NOTA: Esta clase no se encontraba en el análisis de datos, pero la decidí agragar para que el main (Tienda) fuera más limpio y agradable de leer
  */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//importar las librerias necesarias
public class Data {
    private ArrayList<Producto> productos = new ArrayList<>();// crea un array de los guardar todos los productos

    public void cargarProductosDesdeCSV(String archivo) {// funcion para leer el archivo CSV
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            boolean primeraLinea = true; // identificar la primera linea
            while ((linea = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false; // Omitir la primera línea 
                    continue;
                }
                String[] datos = linea.split(",");
                
                if (datos.length < 7) {
                    continue; // Ignorar líneas que no tienen suficientes campos
                }
                
                int id = Integer.parseInt(datos[0].trim());
                String nombre = datos[2].trim();
                int cantDisponible = Integer.parseInt(datos[3].trim());
                int cantVendidos = Integer.parseInt(datos[4].trim());
                boolean disponibilidad = Boolean.parseBoolean(datos[5].trim());
                double precio = Double.parseDouble(datos[6].trim());
                String categoria = datos[1].trim();

                Producto producto = null;
                if (categoria.equals("Bebidas") && datos.length >= 8) {
                    int ml = Integer.parseInt(datos[7].trim());
                    producto = new Bebida(id, nombre, cantDisponible, cantVendidos, disponibilidad, precio, ml, "");
                } else if (categoria.equals("Snacks") && datos.length >= 10) {
                    int gramos = Integer.parseInt(datos[9].trim());
                    String sabor = datos[10].trim();
                    String tamaño = datos.length >= 11 ? datos[11].trim() : "";
                    producto = new Snack(id, nombre, cantDisponible, cantVendidos, disponibilidad, precio, gramos, sabor, tamaño);
                } else if (categoria.equals("Deli") && datos.length >= 16) {
                    String pan = datos[12].trim();
                    String queso = datos[13].trim();
                    String jamon = datos[14].trim();
                    String aderezo = datos[15].trim();
                    producto = new Deli(id, nombre, cantDisponible, cantVendidos, disponibilidad, precio, pan, queso, jamon, aderezo);
                } else {
                    producto = new Producto(id, nombre, cantDisponible, cantVendidos, disponibilidad, precio);
                }

                productos.add(producto);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Producto buscarProductoPorID(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }// buscar un producto por su ID

    public void listarProductosPorCategoria(String categoria) {
        for (Producto producto : productos) {
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                producto.mostrarDetalles();
            }
        }
    }// Sacar una lista de todos los productos que hay en una categoría

    public double calcularTotalVentas() {
        double totalVentas = 0;
        for (Producto producto : productos) {
            totalVentas += producto.getPrecio() * producto.getCantidadVendidos();
        }
        return totalVentas;
    }// calcular el total de ventas de la tienda
      public double calcularVentasPorCategoria(String categoria) {
        double ventasCategoria = 0;
        for (Producto producto : productos) {
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                ventasCategoria += producto.getPrecio() * producto.getCantidadVendidos();
            }
        }
        return ventasCategoria;
    }// calcular las ventas por categoría
    public double calcularComisionDeli() {
        double totalVentasDeli =calcularVentasPorCategoria("Deli");
        return (totalVentasDeli * 0.20); // Supongamos una comisión del 20% para la categoría Deli
    }// calcular las ventas de la categoria Deli, la que yo propuse
 

  
}
