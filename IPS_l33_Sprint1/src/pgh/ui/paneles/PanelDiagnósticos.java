package pgh.ui.paneles;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class PanelDiagnósticos {


//	MimeMessage message = new MimeMessage(session);
//
//	try {
//		message.setFrom(new InternetAddress("ips.l33.hospital@gmail.com"));
//
//		message.addRecipient(Message.RecipientType.TO, new InternetAddress(m.getEmailMedico()));
//
//		message.setSubject("Cita urgente n# " + citaDTO.idCita);
//		message.setText("Buenos dias  Marcos" +  ". \n"
//				+ "Este es un recordatorio de que se ha detectado una emfermedad "
//				+ citaDTO.idCita + " el dia " + citaDTO.fecha.toString() + ".\n"
//				+ "La ubicacion de la cita es: " + getUbicacionNombreCita(citaDTO.idUbicacion));
//
//		Transport t = session.getTransport("smtp");
//
//		t.connect("ips.l33.hospital@gmail.com", "IPSl33**__");
//
//		t.sendMessage(message, message.getAllRecipients());
//
//		t.close();
//
//	} catch (AddressException ae) {
//		ae.printStackTrace();
//	} catch (MessagingException me) {
//		me.printStackTrace();
//	}
}
