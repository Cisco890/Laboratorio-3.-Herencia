/** Juan Francisco Martínez 23617
  * Producto
 
  * @param id,nombre,cantidadDisponible,CantidadVendidos,Disponible,Precio
  * @throws Es la clase padre del programa, se encarga de definir todos los atrbutos que son comunes estre las clases hijas

  */
public  class Producto {
    public int id;
    public String nombre;
    public int cantidadDisponible;
    public int cantidadVendidos;
    public boolean disponible;
    public double precio;

    public Producto(int id, String nombre, int cantidadDisponible, int cantidadVendidos, boolean disponible, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadDisponible = cantidadDisponible;
        this.cantidadVendidos = cantidadVendidos;
        this.disponible = disponible;
        this.precio = precio;
    }// cración del objeto producto con todos sus atributos

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public int getCantidadVendidos() {
        return cantidadVendidos;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public double getPrecio() {
        return precio;
    }

    public  String getCategoria(){
        return "Producto";
    }

    public void mostrarDetalles() {
        System.out.println("ID: " + id + ", Nombre: " + nombre + ", Precio: " + precio);
    }
}// getters de los objetos productos