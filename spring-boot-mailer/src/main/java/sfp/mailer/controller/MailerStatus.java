package sfp.mailer.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MailerStatus {
	private boolean status;
	private String message;
}
