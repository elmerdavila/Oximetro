package unsa.epis.oximetro;

public class Evaluation {
    private String medida;
    private String fecha;
    public Evaluation(){

    }
    public Evaluation(String medida,String fecha){
        this.medida=medida;
        this.fecha=fecha;
    }
    public String getMedida(){
        return medida;
    }
    public String getFecha(){
        return fecha;
    }
    public void setMedida(){
       this.medida=medida;
    }
    public void setFecha(){
        this.fecha=fecha;
    }
}
