package luis.silva.mqttmessenger.model.sensor;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "sensor")
public class Sensor {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "broker")
    private String broker;

    @ColumnInfo(name = "topic")
    private String topic;

    @ColumnInfo(name = "scale")
    private String scale;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }
}
