package controllers;

import beans.EventExtended;
import beans.Room;
import org.json.JSONException;
import org.json.JSONObject;
import play.db.Database;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationController extends Controller {
    @Inject
    Database db;

    public Result registerReservation(String json) {
        System.out.println("DEBUG:" + json);

        try {
            JSONObject obj = new JSONObject(json);

            PreparedStatement ps = db.getConnection().prepareStatement("INSERT INTO t_event (title,start_date, end_date, description, room_id, owner_id)\n" +
                    "VALUES (?, ? ,?,?,?,?);");
            int ix = 1;
            Timestamp startDate = new Timestamp(obj.getLong("start_date"));
            Timestamp endDate = new Timestamp(obj.getLong("end_date"));

            ps.setString(ix++,obj.getString("title"));
            ps.setTimestamp(ix++,startDate);
            ps.setTimestamp(ix++,endDate);
            ps.setString(ix++,obj.getString("comments"));
            ps.setLong(ix++,obj.getLong("room_id"));
            ps.setLong(ix++,obj.getLong("owner_id"));
            System.out.println(ps.toString());
            ps.executeUpdate();


            return ok("Success !");
        } catch (JSONException e) {
            return internalServerError("Error: Cannnot parse json data.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return internalServerError("Error!");
    }

    public Result getAllReservations() {
        try {
            // TODO filter past events;
            try (Connection c = db.getConnection()) {
                String sql = "SELECT * FROM t_event;";
                try (PreparedStatement ps = c.prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    List<EventExtended> results = getResults(rs);
                    String json = EventExtended.getEventsExtendedJSON(results);
                    System.out.println("DEBUG: number of events"+ results.size());
                    return ok(json);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return internalServerError("Error!");
    }

    public Result getReservation(Integer id) {
            // TODO filter past events;
        System.out.println("DEBUG get res");
            try (Connection c = db.getConnection()) {
                String sql = "SELECT * FROM t_event" +
                        ((id != null && id > 0) ? " WHERE id = " + id + ";" : ";");
                try (PreparedStatement ps = c.prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    List<EventExtended> results = getResults(rs);
                    String json = EventExtended.getEventsExtendedJSON(results);
                    return ok(json);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        return internalServerError("Error!");
    }


    private List<EventExtended> getResults(ResultSet rs) throws SQLException {
        List<EventExtended> results = new ArrayList<EventExtended>();
        while (rs.next()) {
            EventExtended bean = getBeanFromRS(rs);
            Room room = getRoomFromRS(rs);
            bean.setRoom(room);
            results.add(bean);
        }
        return results;
    }

    private Room getRoomFromRS(ResultSet rs) throws SQLException {
        Room r = new Room();
        r.setId(rs.getLong("room_id"));
        if (rs.wasNull())
            r.setId(null);
        r.setName(Room.getRoomByID(rs.getLong("room_id")));
        if (rs.wasNull())
            r.setName(null);
        return r;
    }

    private EventExtended getBeanFromRS(ResultSet rs) throws SQLException {
        EventExtended bean = new EventExtended();
        bean.setId(rs.getLong("id"));
        if (rs.wasNull())
            bean.setId(null);
        bean.setTitle(rs.getString("title"));
        if (rs.wasNull())
            bean.setTitle(null);
        bean.setDescription(rs.getString("description"));
        if (rs.wasNull())
            bean.setDescription(null);

        bean.setStartDate(rs.getTimestamp("start_date"));
        if (rs.wasNull())
            bean.setEndDate(null);
        bean.setStartDateTime(rs.getTimestamp("start_date").getTime());
        if (rs.wasNull())
            bean.setStartDateTime(null);
        bean.setEndDate(rs.getTimestamp("end_date"));
        if (rs.wasNull())
            bean.setEndDate(null);
        bean.setEndDateTime(rs.getTimestamp("end_date").getTime());
        if (rs.wasNull())
            bean.setEndDateTime(null);

        bean.setRoomId(rs.getLong("room_id"));
        if (rs.wasNull())
            bean.setRoomId(null);
        bean.setOwnerId(rs.getLong("owner_id"));
        if (rs.wasNull())
            bean.setOwnerId(null);
        return bean;
    }

}
