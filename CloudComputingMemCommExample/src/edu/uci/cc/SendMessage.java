package edu.uci.cc;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@SuppressWarnings("serial")
public class SendMessage extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
        String to = req.getParameter("to");
		String from = req.getParameter("from");
		String subject = req.getParameter("subject");
		String messageBody = req.getParameter("message");
		
		sendMail(to, from, subject, messageBody);
		
		try
 		{
 			req.setAttribute("Message", "Success");
				
			req.getRequestDispatcher("index.jsp").forward(req, resp);

		}
 		catch (ServletException e)
		{
			e.printStackTrace();
		}
		
	}
	
	private void sendMail(String to, String from, String subject, String messageBody)
	{
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        try
        {
            Message message = new MimeMessage(session);
            
            message.setFrom(new InternetAddress(from, "Application Admin"));
            message.addRecipient(Message.RecipientType.TO, 
                             new InternetAddress(to));
            message.setSubject(subject);
            message.setText(messageBody);
            Transport.send(message);

        }
        catch (AddressException e)
        {
			e.printStackTrace();
        }
        catch (MessagingException e)
        {
			e.printStackTrace();
        }
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
	}
}
