package beans;

import org.json.JSONException;
import org.json.JSONObject;



public class TUser extends AbstractTBean {

	private Long id;
	private String email;
	private String firstName;
	private String middleName;
	private String surname;

    @Override
	public JSONObject getJSONObject() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id", this.id);
			obj.put("email", this.email);
			obj.put("firstName", this.firstName);
			obj.put("middleName", this.middleName);
			obj.put("surname", this.surname);

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	//@Override
	public static TUser parseJSonObject(JSONObject obj) throws JSONException {
		TUser bean = new TUser();
		bean.setId(Long.valueOf(obj.get("id")+""));
		bean.setEmail((String)obj.get("email"));
		bean.setFirstName((String)obj.get("firstName"));
		//bean.setMiddleName((String)obj.get("middleName"));
		bean.setSurname((String)obj.get("surname"));
		return bean;
	}
	
	public String getWholeName() {
		StringBuilder sb = new StringBuilder();
		if (firstName != null && !firstName.equals("")) {
			sb.append(firstName).append(" ");
		}
		if (middleName != null && !middleName.equals("")) {
			sb.append(middleName).append(" ");
		}
		if (surname != null && !surname.equals("")) {
			sb.append(surname);
		}
		return sb.toString();
	}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
