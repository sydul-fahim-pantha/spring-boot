package sfp.mailer.controller;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class EmailDto {
	@NotEmpty
	private String to;
	@NotEmpty
	private String subject;
	@NotEmpty
	private String bodyText;
	@NotNull
	private MultipartFile attachement;
}
