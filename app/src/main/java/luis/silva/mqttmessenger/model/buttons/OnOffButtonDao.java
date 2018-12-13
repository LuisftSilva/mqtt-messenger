package luis.silva.mqttmessenger.model.buttons;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface OnOffButtonDao {

    @Query("SELECT * FROM onOffButton")
    List<OnOffButton> getAll();

    @Query("SELECT * FROM onOffButton where broker LIKE  :broker AND topic LIKE :topic")
    OnOffButton findByBrokerTopic(String broker, String topic);

    @Query("SELECT COUNT(*) from onOffButton")
    int countonOffButtons();

    @Insert
    void insertAll(OnOffButton... onOffButtons);

    @Delete
    void delete(OnOffButton onOffButton);
}
