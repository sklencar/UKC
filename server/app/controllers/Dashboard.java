package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

/**
 * User: yesnault
 * Date: 22/01/12
 */
@Security.Authenticated(Secured.class)
public class Dashboard extends Controller {

    public Result index() {
        //return ok(index.render(User.findByEmail(request().username())));
        return ok("TODO");
    }
}
