package com.example.mqttmessenger;

import org.eclipse.paho.client.mqttv3.MqttMessage;

interface MqttCallback {
    void messageArrived(String topic, MqttMessage message);
}
