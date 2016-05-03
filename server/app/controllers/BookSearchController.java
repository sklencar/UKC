package controllers;

import models.BookRecord;
import models.SearchBook;
import org.json.JSONException;
import org.json.JSONObject;
import play.db.Database;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookSearchController extends Controller {
    @Inject
    Database db;


    public final static String SQL_SELECT_BOOK_RECORDS = "SELECT b.title,\n"
            + "b.id, \n"
            // + "(SELECT GROUP_CONCAT(surname SEPARATOR ', ') FROM t_author WHERE id IN (SELECT id_t_author FROM t_authorship WHERE id_t_book = b.id )) AS author,\n"
            + "(SELECT surname FROM t_author WHERE id = (SELECT id_t_author FROM t_authorship WHERE id_t_book = b.id LIMIT 1)) AS author,\n"
            //+ "'' as author, "

            + "(SELECT id_t_user FROM t_rental WHERE id_t_book = b.id AND end_date IS NULL ORDER BY start_date ASC LIMIT 1) AS id_t_user\n"
            + "FROM t_book b\n";

    public final static String SELECT = "SELECT b.title,\n" +
            "            b.id, \n" +
            "\t\t\taut.surname AS author,\n" +
            "(SELECT id_t_user FROM t_rental WHERE id_t_book = b.id AND end_date IS NULL ORDER BY start_date ASC LIMIT 1) AS id_t_user \n"+

            "            FROM t_book b\n" +
            "            LEFT JOIN t_authorship a\n" +
            "            ON a.id_t_book = b.id\n" +
            "            LEFT JOIN t_author aut\n" +
            "            ON aut.id = a.id_t_author \n";

    public Result searchBy(String json) {
        System.out.println("DEBUG:" + json);

        try {
            JSONObject obj = new JSONObject(json);

            String select = SELECT;
            if (!obj.getString("author").equals("")) {
                select += "WHERE LOWER(aut.surname) LIKE LOWER('"+ obj.getString("author") + "') \n";
            }
            if (!obj.getString("title").equals("")) {
                select += "WHERE LOWER(b.title) LIKE LOWER('"+ obj.getString("title") + "') \n";
            }

            select +="LIMIT 100;";
            PreparedStatement ps = db.getConnection().prepareStatement(select);
            System.out.println(select);
            ResultSet rs = ps.executeQuery();
            List<SearchBook> results = getSearchResults(rs);
            String jsonResult = SearchBook.getJSON(results);
            return ok(jsonResult);
        } catch (JSONException e) {
            return internalServerError("Error: Cannnot parse json data.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return internalServerError("Error!");
    }


    private List<SearchBook> getSearchResults(ResultSet rs) throws SQLException {
        List<SearchBook> results = new ArrayList<SearchBook>();
        while (rs.next()) {
            SearchBook bean = new SearchBook();
            bean.setId(rs.getLong("id"));
            if (rs.wasNull())
                bean.setId(null);

            bean.setTitle(rs.getString("title"));
            if (rs.wasNull())
                bean.setTitle(null);

            bean.setSurname(rs.getString("author"));
            if (rs.wasNull())
                bean.setSurname(null);

            bean.setId_t_user(rs.getLong("id_t_user"));
            if (rs.wasNull())
                bean.setId_t_user(null);

            bean.setRented(bean.getId_t_user() != null);
            if (rs.wasNull())
                bean.setRented(false);


            results.add(bean);
        }
        return results;
    }

    private List<BookRecord> getResults(ResultSet rs) throws SQLException {
        List<BookRecord> results = new ArrayList<BookRecord>();
        while (rs.next()) {
            BookRecord bean = getBookFromRS(rs);
            results.add(bean);
        }
        return results;
    }

    private BookRecord getBookFromRS(ResultSet rs) throws SQLException {

        BookRecord bean = new BookRecord();
        bean.setId(rs.getLong("id"));
        if (rs.wasNull())
            bean.setId(null);

        bean.setTitle(rs.getString("title"));
        if (rs.wasNull())
            bean.setTitle(null);

        bean.setSubtitle(rs.getString("subtitle"));
        if (rs.wasNull())
            bean.setSubtitle(null);

        bean.setISBN(rs.getString("ISBN"));
        if (rs.wasNull())
            bean.setISBN(null);

        bean.setPublishDate(rs.getString("publishDate"));
        if (rs.wasNull())
            bean.setPublishDate(null);

        bean.setId_t_language(rs.getLong("id_t_language"));
        if (rs.wasNull())
            bean.setId_t_language(null);

        bean.setId_t_oroginal_language(rs.getLong("id_t_orig_language"));
        if (rs.wasNull())
            bean.setId_t_oroginal_language(null);

        bean.setId_t_shelf(rs.getLong("id_t_shelf"));
        if (rs.wasNull())
            bean.setId_t_shelf(null);

        if (!rs.wasNull() || rs.getInt("consistent_with_QR") == 1) {
            bean.setConsistent_with_QR(true);
        } else {
            bean.setConsistent_with_QR(false);
        }

        //extended
        bean.setSurname(rs.getString("author"));
        if (rs.wasNull())
            bean.setSurname(null);

        bean.setRented(true);
        if (rs.wasNull())
            bean.setRented(false);

        return bean;
    }

}
