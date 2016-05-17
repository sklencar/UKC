package controllers;

import models.User;
import models.utils.AppException;
import models.utils.Hash;
import org.json.JSONException;
import org.json.JSONObject;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.UUID;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class SignupController extends Controller {

    public Result signup(String json) {

        try {
            JSONObject obj = new JSONObject(json);

            User user = new User();
            user.email = obj.getString("email");
            user.fullname = obj.getString("fullname");
            user.passwordHash = Hash.createPassword(obj.getString("password"));
            user.confirmationToken = UUID.randomUUID().toString();

            user.save();


            return ok("Success !");
        } catch (JSONException e) {
            return internalServerError("Error: Cannnot parse json data.");
        } catch (AppException e) {
            e.printStackTrace();
        }
        return internalServerError("Error!");


    }

}
