package hu.modsstore.util;

/*  This program is working correctly. It uses gmail to send message.  Download javamail api from sun 
 Add mail.jar, smtp.jar in WEB-INF/lib folder..     */

import java.security.Security;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//=========================================  

public class SendMailUsingAuthentication {

	private static final String SMTP_HOST_NAME = "smtp.gmail.com";
	private static final String SMTP_AUTH_USER = "fundusf4"; // no @gmail.com
																// here
	private static final String SMTP_AUTH_PWD = "drscreen11111";

	private static final String emailMsgTxt = "Message text";
	private static final String emailSubjectTxt = "subject";
	private static final String emailFromAddress = "fundusf4@gmail.com";

	// Add List of Email address to who email needs to be sent to
	private static final String[] emailList = { "pzoli@mschumacher.com" };

	public static void order(String args[]) throws Exception {
		SendMailUsingAuthentication smtpMailSender = new SendMailUsingAuthentication();
		smtpMailSender.postMail(new String[] { args[0] }, args[1], args[2],
				emailFromAddress);
		System.out.println("Sucessfully Sent mail to All Users");
	}

	public static void main(String args[]) throws Exception {
		SendMailUsingAuthentication smtpMailSender = new SendMailUsingAuthentication();
		smtpMailSender.postMail(emailList, emailSubjectTxt, emailMsgTxt,
				emailFromAddress);
		System.out.println("Sucessfully Sent mail to All Users");
	}

	public void postMail(String recipients[], String subject, String message,
			String from) throws MessagingException {
		boolean debug = true;
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		// Set the host smtp address
		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtps.auth", "true");
		//props.put("mail.smtp.starttls.enable","true");
		//props.put("mail.debug", "true");
		props.put("mail.smtp.port", 25);
		props.put("mail.smtp.socketFactory.port", 25);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.put("mail.smtps.quitwait", "false");

		Authenticator auth = new SMTPAuthenticator();
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(SMTP_AUTH_USER, SMTP_AUTH_PWD);
					}
				});

		session.setDebug(debug);

		// create a message
		Message msg = new MimeMessage(session);

		// set the from and to address
		InternetAddress addressFrom = new InternetAddress(from);
		msg.setFrom(addressFrom);

		InternetAddress[] addressTo = new InternetAddress[recipients.length];
		for (int i = 0; i < recipients.length; i++) {
			addressTo[i] = new InternetAddress(recipients[i]);
		}
		msg.setRecipients(Message.RecipientType.TO, addressTo);

		// Setting the Subject and Content Type
		msg.setSubject(subject);
		msg.setContent(message, "text/plain");
		Transport.send(msg);
	}

	/**
	 * SimpleAuthenticator is used to do simple authentication when the SMTP
	 * server requires it.
	 */
	private class SMTPAuthenticator extends javax.mail.Authenticator {

		public PasswordAuthentication getPasswordAuthentication() {
			String username = SMTP_AUTH_USER;
			String password = SMTP_AUTH_PWD;
			return new PasswordAuthentication(username, password);
		}
	}

}
