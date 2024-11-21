
package modelo;


public class Operaciones {
    
    public static Integer tipo(String tipo){
        if(tipo.equals("Carro")){
            return 1;
        }else{
            return 2;
        }
    }
    
    public static Boolean validarAuto(Vehiculo v){
        if(v.getPlaca().length()==6 && v.getTipo()==1){
            return true;
        }else if(v.getPlaca().length()==5 && v.getTipo()==2){
            return true;
        }else {
            return false;
        }
    }
    
    
}
