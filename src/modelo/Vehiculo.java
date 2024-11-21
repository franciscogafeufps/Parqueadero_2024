
package modelo;


public class Vehiculo {
    
    private String placa;
    private int modelo;
    private int tipo;
    private int valor;

    public Vehiculo() {
    }

    public Vehiculo(String placa, int Modelo, int tipo, int valor) {
        this.placa = placa;
        this.modelo = Modelo;
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int Modelo) {
        this.modelo = Modelo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getValor() {
        
        if(this.modelo < 2023){
            if(this.tipo == 1){
                valor = 2000;
            }
            else{
                valor = 1000;
            }
        }else{
            if(this.tipo == 1){
                valor = 2500;
                if(this.modelo == 2024){
                    valor = ((int)(2500*0.2)+ 2500);
                }
                else{
                    valor = 1200;
                    if(this.modelo == 2024){
                        valor = ((int)(1200*0.1)+1200);
                    }
                }
            }
        }
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
    
    
}
