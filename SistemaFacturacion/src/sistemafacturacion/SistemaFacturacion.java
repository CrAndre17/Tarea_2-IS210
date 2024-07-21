package sistemafacturacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class SistemaFacturacion {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        Random random=new Random();
        int numf=random.nextInt(99);
        LocalDate fecha=LocalDate.now();
        String fechaS=fecha.toString();
        final String color="\u001B[1m";
        final String resetcolor="\u001B[0m";
        
        System.out.print("Sistema de generacion de facturas\n"+color+"\nIngrese el nombre del cliente: "+resetcolor);
        String name=scan.nextLine();
        System.out.print(color+"Ingrese el numero de cedula del cliente: "+resetcolor);
        String ced=scan.nextLine();
        System.out.print(color+"Ingrese la direccion cliente: "+resetcolor);
        String dir=scan.nextLine();
        System.out.print(color+"Ingrese el numero de telefono del cliente: "+resetcolor);
        String tel=scan.nextLine();
        
        Cliente cliente1=null;
        CategoriaProducto cat=null;
        CategoriaProducto cat1=null;
        Producto producto1=null;
        Producto producto2=null;
        Producto producto3=null;
        
        //Cliente
        try{
            cliente1=new Cliente(name,ced,dir,tel);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
        //CategoriaProducto
        try{
            cat=new CategoriaProducto("Viveres",1);
            cat1=new CategoriaProducto("Tecno",7);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
        //Productos
        try{
            producto1=new Producto("Frijoles rojos",9.99,cat,2);
            producto2=new Producto("Frijoles negros",8.99,cat,5);
            producto3=new Producto("Laptop Gamer",999,cat1,1);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
        //Factura
        Factura fact1=null;
        
        try{
            fact1=new Factura(numf,fechaS,cliente1);
            if(producto1!=null) fact1.agregarProducto(producto1);
            if(producto2!=null) fact1.agregarProducto(producto2);
            if(producto3!=null) fact1.agregarProducto(producto3);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        if(fact1!=null){
            fact1.infoFactura();
            System.out.println("\n\t\t\t\t\t\tSu total a pagar es: \tL "+pagarFactura(fact1));
            System.out.println("--------------------------------------------------------------------------------");
        }else{
            System.out.println("No se pudo generar la factura.");
        }
    }
    
    public static double pagarFactura(Factura factura){
        double total=0;
        ArrayList<Producto> productos=factura.getProductos();
        for(int i=0;i<productos.size();i++){
            Producto producto=productos.get(i);
            total+=producto.getPrecio()*producto.getCantidad();
        }
        return total;
    }
}
