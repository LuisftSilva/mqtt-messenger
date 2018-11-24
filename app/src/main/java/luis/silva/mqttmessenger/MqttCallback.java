package luis.silva.mqttmessenger;

import org.eclipse.paho.client.mqttv3.MqttMessage;

interface MqttCallback {
    void messageArrived(String topic, MqttMessage message);
}
