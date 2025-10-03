package com.base.admin.quartz.email.service;

import java.nio.charset.StandardCharsets;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;

    public MailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(String fromEmail, String toEmail, String subject, String message) throws Exception {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, StandardCharsets.UTF_8.toString());
            messageHelper.setSubject(subject);
            messageHelper.setText(message, true);
            messageHelper.setFrom(fromEmail);
            messageHelper.setTo(toEmail);

            javaMailSender.send(mimeMessage);
        } catch (AddressException ex) {
            throw new AddressException("[sendEmail]: Incorrect email address");
        } catch (MessagingException ex) {
            throw new MessagingException("[sendEmail]: Error in sending email");
        } catch (Exception ex) {
            throw new Exception("[sendEmail]: Error in method ");
        }
    }
}
