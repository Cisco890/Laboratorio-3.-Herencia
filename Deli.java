/** Juan Francisco Martínez 23617
  * Deli
 
  * @param pan,queso,jamon,aderezo,aparte_de_los_que_extiende_de_productp
  * @throws Es la clase hija dedicada a los Deli de la tienda, deli es el nombre que llevan los panes de la tienda

  */
  public class Deli extends Producto {
    public String pan;
    public String queso;
    public String jamon;
    public String aderezo;

    public Deli(int id, String nombre, int cantidadDisponible, int cantidadVendidos, boolean disponible, double precio, String pan, String queso, String jamon, String aderezo) {
        super(id, nombre, cantidadDisponible, cantidadVendidos, disponible, precio);
        this.pan = pan;
        this.queso = queso;
        this.jamon = jamon;
        this.aderezo = aderezo;
    }

    @Override
    public String getCategoria() {
        return "Deli";
    }//  Override para que la categoria del producto sea deli

    @Override
    public String toString() {
        return "ID: " + getId() + "\n" +
               "Nombre: " + getNombre() + "\n" +
               "Cantidad Disponible: " + getCantidadDisponible() + "\n" +
               "Cantidad Vendidos: " + getCantidadVendidos() + "\n" +
               "Disponible: " + isDisponible() + "\n" +
               "Precio: " + getPrecio() + "\n" +
               "Pan: " + pan + "\n" +
               "Queso: " + queso + "\n" +
               "Jamon: " + jamon + "\n" +
               "Aderezo: " + aderezo;
    }// Override para que todos los datos del producto deli sean string
}
