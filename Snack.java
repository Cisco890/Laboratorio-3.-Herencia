/** Juan Francisco Martínez 23617
  * Snacks
 
  * @param gramos,tamaño,sabor,aparte_de_los_que_extiende_de_productp
  * @throws Es la clase hija dedicada a las Snacks de la tienda

  */
public class Snack extends Producto {
    public int gramos;
    public String sabor;
    public String tamaño;

    public Snack(int id, String nombre, int cantidadDisponible, int cantidadVendidos, boolean disponible, double precio, int gramos, String sabor, String tamaño) {
        super(id, nombre, cantidadDisponible, cantidadVendidos, disponible, precio);
        this.gramos = gramos;
        this.sabor = sabor;
        this.tamaño = tamaño;
    }

    @Override
    public String getCategoria() {
        return "Snacks";//  Override para que la categoria del producto sea snacks
    }

    @Override
    public String toString() {
        return "ID: " + getId() + "\n" +
               "Nombre: " + getNombre() + "\n" +
               "Cantidad Disponible: " + getCantidadDisponible() + "\n" +
               "Cantidad Vendidos: " + getCantidadVendidos() + "\n" +
               "Disponible: " + isDisponible() + "\n" +
               "Precio: " + getPrecio() + "\n" +
               "Gramos: " + gramos + "\n" +
               "Sabor: " + sabor + "\n" +
               "Tamaño: " + tamaño;
    } // Override para que todos los datos del producto snacks sean string
}
