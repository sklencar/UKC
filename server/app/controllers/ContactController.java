package controllers;

import org.apache.commons.mail.EmailException;
import org.json.JSONException;
import org.json.JSONObject;
import play.mvc.Controller;
import play.mvc.Result;
import utils.EmailMessage;
import utils.MailSender;

import javax.mail.internet.AddressException;

public class ContactController extends Controller {

    public Result sendMail(String json) {

        JSONObject obj = null;
        try {
            obj = new JSONObject(json);
            EmailMessage message = new EmailMessage();
            message.setName(obj.getString("name"));
            message.setEmail(obj.getString("email"));
            message.setBody(obj.getString("body"));
            message.setSubject(obj.getString("subject"));

            MailSender sender = new MailSender();
            sender.sendNotificationMail(message);
            return ok("Success!");
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (EmailException e) {
            e.printStackTrace();
        } catch (AddressException e) {
            e.printStackTrace();
        }
        return internalServerError("Failed to send mail!");
    };

    public Result signup() {
        return ok("Success!");
    }

}
