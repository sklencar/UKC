package controllers;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class SignupController extends Controller {

    public Result signup() {
        return ok("Success!");
    }

}
