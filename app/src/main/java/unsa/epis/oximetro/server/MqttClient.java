package unsa.epis.oximetro.server;

import android.content.Context;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import static unsa.epis.oximetro.server.Constants.MESSAGE_CONNECT;
import static unsa.epis.oximetro.server.Constants.MESSAGE_ERROR_CONNECT;
import static unsa.epis.oximetro.server.Constants.TOPIC_HEALTH;

public class MqttClient {
    private MqttAndroidClient client;
    private Context context;
    public MqttClient(Context context){
        this.context= context;
        String clientId = org.eclipse.paho.client.mqttv3.MqttClient.generateClientId();
        client =new MqttAndroidClient(context, Constants.SERVER_URI,
                        clientId);
        connect();
    }

    public void connect(){
        try {
            IMqttToken token = client.connect();
            token.setActionCallback(iMqttActionListener);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
    private void subscriptionRadiationUV(){
        try{
            client.subscribe(TOPIC_HEALTH,0);
        }catch(MqttException e){
            e.printStackTrace();
        }
    }

    public void publishOximeterMeasure(String measure){
        try{
            MqttMessage message= new MqttMessage((measure).getBytes());
            client.publish(TOPIC_HEALTH,message);
        }catch (MqttException e){
            e.printStackTrace();
        }
    }

    private MqttCallback mqttCallback= new MqttCallback() {
        @Override
        public void connectionLost(Throwable cause) {

        }
        @Override
        public void messageArrived(String topic, MqttMessage message) throws Exception {
//            if(topic.matches("healtopic/test")){
//                radiacion.setText(message.getPayload().toString());
//            }

        }
        @Override
        public void deliveryComplete(IMqttDeliveryToken token) {
        }
    };

    private IMqttActionListener iMqttActionListener= new IMqttActionListener() {
        @Override
        public void onSuccess(IMqttToken asyncActionToken) {
            Toast.makeText(context,MESSAGE_CONNECT, Toast.LENGTH_SHORT).show();
            //subscriptionRadiationUV();//SI hay conexión se suscribe al topic HEALTH TOPIC

        }
        @Override
        public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
            Toast.makeText(context,MESSAGE_ERROR_CONNECT, Toast.LENGTH_SHORT).show();
        }
    };



}
