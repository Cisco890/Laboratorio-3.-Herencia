/** Juan Francisco Martínez 23617
  * Bebida
 
  * @param ml,tipo,aparte_de_los_que_extiende_de_productp
  * @throws Es la clase hija dedicada a las bebidas de la tienda

  */
public class Bebida extends Producto {
    public int ml;
    public String tipo;

    public Bebida(int id, String nombre, int cantidadDisponible, int cantidadVendidos, boolean disponible, double precio, int ml, String tipo) {
        super(id, nombre, cantidadDisponible, cantidadVendidos, disponible, precio);
        this.ml = ml;
        this.tipo = tipo;
    }// creación de los objetos bebidas

    @Override
    public String getCategoria() {
        return "Bebidas";// Override para que la categoria del producto sea bebida
    }

    @Override
    public String toString() {
        return "ID: " + getId() + "\n" +
               "Nombre: " + getNombre() + "\n" +
               "Cantidad Disponible: " + getCantidadDisponible() + "\n" +
               "Cantidad Vendidos: " + getCantidadVendidos() + "\n" +
               "Disponible: " + isDisponible() + "\n" +
               "Precio: " + getPrecio() + "\n" +
               "Mililitros: " + ml + "\n" +
               "Tipo: " + tipo;
    }// Override para que todos los datos del producto bebida sean string
}
