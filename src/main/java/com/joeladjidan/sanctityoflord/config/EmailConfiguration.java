package com.joeladjidan.sanctityoflord.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ConfigurationProperties
public class EmailConfiguration  {

    private static final int GMAIL_SMTP_PORT = 587;

    @Value("${mail.host}")
    private String host;

    @Value("${mail.username}")
    private String username;

    @Value("${mail.password}")
    private String password;

    @Value("${mail.port}")
    private String port;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        // Set up Gmail config
        mailSender.setHost(host);
        mailSender.setPort(Integer.parseInt(port));

        // Set up email config (using udeesa email)
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        return mailSender;
    }
}
