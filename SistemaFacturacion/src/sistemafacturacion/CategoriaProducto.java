package sistemafacturacion;
public class CategoriaProducto{
    private String nombre;
    private int pasillo;

    CategoriaProducto(String nombre,int pasillo) throws Exception{
        if(nombre==null || nombre.trim().isEmpty()){
            throw new Exception("El nombre de la categoria no puede estar vacio o ser nulo.");
        }
        if(pasillo<=0){
            throw new Exception("El numero de pasillo debe ser mayor a 0.");
        }
        this.nombre=nombre;
        this.pasillo=pasillo;
    }
    
    void infoCategoriaProducto(){
        System.out.println(this.nombre+"\t\t"+this.pasillo);
    }
}
