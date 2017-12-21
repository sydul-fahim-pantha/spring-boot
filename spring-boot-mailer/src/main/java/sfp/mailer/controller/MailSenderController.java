package sfp.mailer.controller;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MailSenderController {

	@Value("${spring.mail.username}")
	private String from;

	@Autowired
	private JavaMailSender mailSender;

	@PostMapping(value = "/multipart-mail", consumes=MediaType.ALL_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public MailerStatus sendMailWithAttachment(@Valid @ModelAttribute EmailDto emailDto)
			throws MessagingException, IOException {

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		mimeMessageHelper.setFrom(from);
		mimeMessageHelper.setTo(emailDto.getTo());
		mimeMessageHelper.setSubject(emailDto.getSubject());
		mimeMessageHelper.setText(emailDto.getBodyText());

		MultipartFile multipartFile = emailDto.getAttachement();
		File file = null;
		try {
			file = new File(System.getProperty("catalina.base") + "/" + multipartFile.getOriginalFilename());
			multipartFile.transferTo(file);
			
			mimeMessageHelper.addAttachment(file.getName(), file);
			mailSender.send(mimeMessage);
		} finally {	if(file != null) file.delete();	}

		return new MailerStatus(true, "Email was sent successfully.");
	}
}
