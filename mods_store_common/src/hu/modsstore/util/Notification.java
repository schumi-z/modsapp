package hu.modsstore.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Notification {
	
	private static final String SMTP_HOST_NAME = "smtp.gmail.com";
    private static final int SMTP_HOST_PORT = 465;
    private static final String SMTP_AUTH_USER = "fundusf4";
    private static final String SMTP_AUTH_PWD  = "drscreen11111";

    public static void main(String[] args) throws Exception{
//       new Notification().send();
    }
    
    public void sendMailToOrder(String subject, String msg, String orderEmail) throws Exception{
//    	Properties props = new Properties();
//
//        props.put("mail.transport.protocol", "smtps");
//        props.put("mail.smtps.host", SMTP_HOST_NAME);
//        props.put("mail.smtps.auth", "true");
//        // props.put("mail.smtps.quitwait", "false");
//
//        Session mailSession = Session.getDefaultInstance(props);
//        mailSession.setDebug(true);
//        Transport transport = mailSession.getTransport();
//
//        MimeMessage message = new MimeMessage(mailSession);
//        message.setSubject(subject);
//        message.setContent(msg, "text/html;charset=ISO-8859-2");
//        
//        message.addRecipient(Message.RecipientType.TO,
//             new InternetAddress(orderEmail));/*a rendelo*/
//
//        transport.connect
//          (SMTP_HOST_NAME, SMTP_HOST_PORT, SMTP_AUTH_USER, SMTP_AUTH_PWD);
//
//        transport.sendMessage(message,
//            message.getRecipients(Message.RecipientType.TO));
//       
//        transport.close();
    }

    public void send(String subject, String msg) throws Exception{
//        Properties props = new Properties();
//
//        props.put("mail.transport.protocol", "smtps");
//        props.put("mail.smtps.host", SMTP_HOST_NAME);
//        props.put("mail.smtps.auth", "true");
//        // props.put("mail.smtps.quitwait", "false");
//
//        Session mailSession = Session.getDefaultInstance(props);
//        mailSession.setDebug(true);
//        Transport transport = mailSession.getTransport();
//
//        MimeMessage message = new MimeMessage(mailSession);
//        message.setSubject(subject);
//        message.setContent(msg, "text/html;charset=ISO-8859-2");
//
//        message.addRecipient(Message.RecipientType.BCC,
//                new InternetAddress("pistar.zoltan@gmail.com"));
//        message.addRecipient(Message.RecipientType.BCC,
//                new InternetAddress("uzonyib@gmail.com"));
//        message.addRecipient(Message.RecipientType.BCC,
//                new InternetAddress("pmne_erzsike@freemail.hu"));
//        
//        message.addRecipient(Message.RecipientType.TO,
//             new InternetAddress("modsoffice@freemail.hu"));/*modsoffice@freemail.hu*/
//
//        transport.connect
//          (SMTP_HOST_NAME, SMTP_HOST_PORT, SMTP_AUTH_USER, SMTP_AUTH_PWD);
//
//        transport.sendMessage(message,
//            message.getRecipients(Message.RecipientType.TO));
//        transport.sendMessage(message,
//                message.getRecipients(Message.RecipientType.BCC));
//        transport.close();
    }
    
    public void sendToEmailAddress(String subject, String msg, String msgFooter, String email) throws Exception{
        Properties props = new Properties();

        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", SMTP_HOST_NAME);
        props.put("mail.smtps.auth", "true");
        // props.put("mail.smtps.quitwait", "false");

        Session mailSession = Session.getDefaultInstance(props);
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject(subject);
        message.setContent(msg + msgFooter, "text/html;charset=ISO-8859-2");
        
        message.addRecipient(Message.RecipientType.TO,
             new InternetAddress(email));/*modsoffice@freemail.hu*/

        transport.connect
          (SMTP_HOST_NAME, SMTP_HOST_PORT, SMTP_AUTH_USER, SMTP_AUTH_PWD);

        transport.sendMessage(message,
            message.getRecipients(Message.RecipientType.TO));
        transport.close();
    }


}
