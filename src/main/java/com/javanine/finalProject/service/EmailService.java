package com.javanine.finalProject.service;

import javax.mail.MessagingException;

public interface EmailService {
    /**
     * Send simple message
     * @param to - addressee
     * @param subject - subject
     * @param text - body of message
     */
    void sendSimpleMessage(String to, String subject, String text);

    /**
     * Send message with attach
     * @param to - addressee
     * @param subject - subject
     * @param text - text
     * @param pathToAttachment - attachment
     * @throws MessagingException - missing message
     */
    void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) throws MessagingException;
}
