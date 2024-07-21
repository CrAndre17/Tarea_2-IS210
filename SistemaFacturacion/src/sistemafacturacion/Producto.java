package sistemafacturacion;
public class Producto{
    private String nombre;
    private double precio;
    private CategoriaProducto categoria;
    private int cantidad;

    Producto(String nombre,double precio,CategoriaProducto categoria,int cantidad) throws Exception{
        if(nombre==null || nombre.trim().isEmpty()){
            throw new Exception("El nombre no puede estar vacio o ser nulo.");
        }
        if(precio<=0){
            throw new Exception("El precio del producto debe ser mayor que cero.");
        }
        if(cantidad<=0){
            throw new Exception("La cantidad del producto debe ser mayor que cero.");
        }
        
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.cantidad = cantidad;
    }

    void infoProducto(){
        System.out.print(this.nombre+"\t\tL "+this.precio+"\t\t"+this.cantidad+"\t\t");
        this.categoria.infoCategoriaProducto();
    }

    public double getPrecio(){
        return precio;
    }

    public int getCantidad(){
        return cantidad;
    }
}
