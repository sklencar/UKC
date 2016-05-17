package beans;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbstractTBean {
	
	public JSONObject getJSONObject() {
	    JSONObject obj = new JSONObject();
	    return obj;
	}
	
	public static AbstractTBean parseJSonObject(JSONObject obj) throws JSONException {
		return (AbstractTBean) new Object();
	}


}
