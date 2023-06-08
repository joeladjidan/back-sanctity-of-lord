package com.joeladjidan.sanctityoflord.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@Slf4j
public class MailSenderService {

    @Autowired
    public JavaMailSender javaMailSender;

    public void sendEmailWithAttachment() throws MessagingException {
        log.info("Debut de l'envois de mail du compte rendue des activité de anagkazo");
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo("joeladjidan@gmail.com");
        helper.setSubject("Compte Rendue d'activité ANAGKAZO");

        String htmlContent = "<html><body><h1>This is a test email</h1><p>Hello, world!</p></body></html>";
        helper.setText(htmlContent, true);

        ClassPathResource file = new ClassPathResource("C:/jar/logs/application-dev.log");
        helper.addAttachment("application-dev.log", file);

    //    FileSystemResource file = new FileSystemResource(new File("C:/jar/logs/application-dev.log"));
   //     helper.addAttachment("application-dev.log", file);

        try {
            javaMailSender.send(message);
        } catch (MailException e) {
            e.printStackTrace();
            log.error("Erreur detectée lors de l'envois de mail de compte rendue d'activité " + e.getMessage());
        }
        log.info("Fin de l'envois de mail du compte rendue des activité de anagkazo");
    }

}
