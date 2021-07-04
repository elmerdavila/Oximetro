package unsa.epis.oximetro.server;

public class Constants {
    //SERVER CONFIG
    public static final String SERVER_URI="tcp://192.168.1.49:1883";

    //MESSAGES
    public static final String MESSAGE_CONNECT="CONECTADO A DISPOSITIVO IoT";
    public static final String MESSAGE_ERROR_CONNECT="ERROR, No se pudo conectar a dispositivo IoT";
    //TOPICS
    public static final String TOPIC_HEALTH="oximeter/measure";

}
