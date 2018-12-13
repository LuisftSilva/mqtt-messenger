package luis.silva.mqttmessenger.model.buttons;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "onOffButton")
public class OnOffButton {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "broker")
    private String broker;

    @ColumnInfo(name = "topic")
    private String topic;

    @ColumnInfo(name = "onCommand")
    private String onCommand;

    @ColumnInfo(name = "offCommand")
    private String offCommand;

    @ColumnInfo(name = "feedback")
    private String feedback;

    @ColumnInfo(name = "feedbackTopic1")
    private String feedbackTopic1;

    @ColumnInfo(name = "feedbackMessage1")
    private String feedbackMessage1;

    @ColumnInfo(name = "feedbackTopic2")
    private String feedbackTopic2;

    @ColumnInfo(name = "feedbackMessage2")
    private String feedbackMessage2;

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

    public String getOnCommand() {
        return onCommand;
    }

    public void setOnCommand(String onCommand) {
        this.onCommand = onCommand;
    }

    public String getOffCommand() {
        return offCommand;
    }

    public void setOffCommand(String offCommand) {
        this.offCommand = offCommand;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getFeedbackTopic1() {
        return feedbackTopic1;
    }

    public void setFeedbackTopic1(String feedbackTopic1) {
        this.feedbackTopic1 = feedbackTopic1;
    }

    public String getFeedbackMessage1() {
        return feedbackMessage1;
    }

    public void setFeedbackMessage1(String feedbackMessage1) {
        this.feedbackMessage1 = feedbackMessage1;
    }

    public String getFeedbackTopic2() {
        return feedbackTopic2;
    }

    public void setFeedbackTopic2(String feedbackTopic2) {
        this.feedbackTopic2 = feedbackTopic2;
    }

    public String getFeedbackMessage2() {
        return feedbackMessage2;
    }

    public void setFeedbackMessage2(String feedbackMessage2) {
        this.feedbackMessage2 = feedbackMessage2;
    }

}
