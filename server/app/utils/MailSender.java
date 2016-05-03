package utils;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.Collection;

public class MailSender {

	private String username;
	private String password;

	public MailSender() {
		this.username = ScrumbleEggs.KC_MAIL;
		this.password = ScrumbleEggs.KC_PASS;
	}
	
	public boolean sendNotificationMail(EmailMessage m) throws EmailException, AddressException {
        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(ScrumbleEggs.KC_NAME, ScrumbleEggs.KC_PASS));
        email.setSSLOnConnect(true);
        email.setFrom(m.getEmail());
        Collection<InternetAddress> emailsTo = new ArrayList<InternetAddress>();
        emailsTo.add(new InternetAddress(ScrumbleEggs.KC_MAIL));
        email.setTo(emailsTo);
        email.setSubject(m.getSubject());
        email.setMsg(m.getBody());
        email.send();
        return true;
	}


}