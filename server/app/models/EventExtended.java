package models;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Vito on 21. 4. 2016.
 */
public class EventExtended extends Event{

    String roomName;
    Room room;
    TUser owner;

    Long startDateTime;
    Long endDateTime;



    public static String getEventsExtendedJSON(List<EventExtended> events) {

        Gson gson = new Gson();
        String json = gson.toJson(events);
        System.out.println("DEBUG json: \n" + json);
        return json;
    }

    public Long getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Long startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Long getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Long endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public TUser getOwner() {
        return owner;
    }

    public void setOwner(TUser owner) {
        this.owner = owner;
    }
}
