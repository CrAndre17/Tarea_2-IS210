package sistemafacturacion;

import java.util.ArrayList;

public class Factura{
    private final String empresa="Servicios Tecnologicos Trikitrakatelas";
    private final String rtn="13123456-7";
    private final String cai="35BD6A-0195F4-B34BAA-8B7D13-37791A-2D";
    private int numero;
    private String fecha;
    private Cliente cliente;
    private ArrayList<Producto> productos;

    Factura(int numero,String fecha,Cliente cliente) throws Exception{
        if(numero<0){
            throw new Exception("El numero de factura no puede ser negativo.");
        }
        if(fecha==null || fecha.trim().isEmpty()){
            throw new Exception("La fecha no puede estar vacia.");
        }
        this.numero=numero;
        this.fecha=fecha;
        this.cliente=cliente;
        this.productos=new ArrayList<>();
    }

    public void agregarProducto(Producto nuevoProducto){
        productos.add(nuevoProducto);
    }

    void infoFactura(){
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(empresa+"\nRTN: "+rtn+"\nCAI: "+cai+"\n");
        cliente.infoCliente();
        
        System.out.println("\nN. Factura: 000-001-01-0"+this.numero+"");
        System.out.println("Fecha: "+this.fecha);
        
        System.out.println("\nProducto\t\tPrecio\t\tCantidad\tCategoria\tPasillo\t");
        for(int i=0;i<productos.size();i++){
            Producto productolist=productos.get(i);
            productolist.infoProducto();
        }
    }

    public ArrayList<Producto> getProductos(){
        return productos;
    }
}
