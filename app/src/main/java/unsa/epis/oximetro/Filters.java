package unsa.epis.oximetro;

public class Filters {

    //a es un valor entre 0 y 1
    public static final float a= 0.8f;

    public Filters(){

    }

    public int lowPass(int current, int last){
        return Math.round(last*(1- a) + current*a);
    }

}
