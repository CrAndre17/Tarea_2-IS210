package sistemafacturacion;
public class Cliente{
    private String nombre;
    private String rtn;
    private String direccion;
    private String telefono;

    Cliente(String nombre,String rtn,String direccion,String telefono) throws Exception{
        if(nombre==null || nombre.trim().isEmpty()){
            throw new Exception("El nombre del cliente no puede estar vacio.");
        }
        if(rtn==null || rtn.trim().isEmpty()){
            throw new Exception("El RTN del cliente no puede estar vacio.");
        }
        if(direccion==null || direccion.trim().isEmpty()){
            throw new Exception("La direccion del cliente no puede estar vacia.");
        }
        if(telefono==null || telefono.trim().isEmpty()){
            throw new Exception("El numero de telefono del cliente no puede estar vacio.");
        }
        
        this.nombre=nombre;
        this.rtn=rtn;
        this.direccion=direccion;
        this.telefono=telefono;
    }

    void infoCliente(){
        System.out.println("Nombre del Cliente: \t"+this.nombre+"\nRTN: \t\t\t"+this.rtn+"\nDireccion: \t\t"+this.direccion+"\nTelefono: \t\t"+this.telefono);
    }
}
