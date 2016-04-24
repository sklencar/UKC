package models;

import com.google.gson.Gson;

import java.util.Date;
import java.util.List;


public class Event {
    Long id;
    String title;
    Date startDate;
    Date endDate;
    String description;
    Long roomId;
    Long ownerId;


    public static String getEventsJSON(List<Event> events) {

        // create a new Gson instance
        Gson gson = new Gson();
        // convert your list to json
        String json = gson.toJson(events);
        // print your generated json
        System.out.println("jsonCartList: \n" + json);

       /* JSONObject responseDetailsJson = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        List<Event> cartList = new Vector<Event>(cartMap.keySet().size());
        for(Event p : cartMap.keySet()) {
            cartList.add(p);
            JSONObject formDetailsJson = new JSONObject();
            formDetailsJson.put("id", "1");
            formDetailsJson.put("name", "name1");
            jsonArray.add(formDetailsJson);
        }
        responseDetailsJson.put("forms", jsonArray);//Here you can see the data in json format

        return cartList;*/
        return json;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
