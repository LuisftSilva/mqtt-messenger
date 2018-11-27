package luis.silva.mqttmessenger.model.sensor;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;

@Dao
public interface SensorDao {

    @Query("SELECT * FROM sensor")
    List<Sensor> getAll();

    @Query("SELECT * FROM sensor where broker LIKE  :broker AND topic LIKE :topic")
    Sensor findByBrokerTopic(String broker, String topic);

    @Query("SELECT COUNT(*) from sensor")
    int countSensors();

    @Insert
    void insertAll(Sensor... sensors);

    @Delete
    void delete(Sensor sensor);
}
