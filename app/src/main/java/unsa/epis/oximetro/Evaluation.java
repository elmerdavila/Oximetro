package unsa.epis.oximetro;

public class Evaluation {
    private int medida;
    private String fecha;
    public Evaluation(){

    }
    public Evaluation(int medida,String fecha){
        this.medida=medida;
        this.fecha=fecha;
    }
    public int getMedida(){
        return medida;
    }
    public String getFecha(){
        return fecha;
    }
    public void setMedida(int medida){
       this.medida=medida;
    }
    public void setFecha(String fecha){
        this.fecha=fecha;
    }
}
