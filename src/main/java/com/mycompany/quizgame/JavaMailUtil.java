/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizgame;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author SAKTHIMICRO
 */
public class JavaMailUtil {
    public  void sendMail(String recepient) throws Exception{
        System.out.println("preparing send mail");
        Properties  properties =  new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
         properties.put("mail.smtp.port", "587");
         
         String myAccountEmail ="s.mahan19com@gmail.com";
         String password="rvtlnrkiaxaluggi";
         
         Session session = Session.getInstance(properties, new Authenticator(){
             @Override
             protected PasswordAuthentication getPasswordAuthentication(){
                 return new PasswordAuthentication(myAccountEmail,password);
             }
         });
         Message message  = preparemessage(session,myAccountEmail,recepient);
         Transport.send(message);
         System.out.println("send successfully");
        
     }
    
    private  Message preparemessage(Session session,String myAccountEmail,String recepient){
        try {
            Message message  = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Registration confirmation");
            message.setText("Welcome to quiz Game. You are successfully registered this game thank you");
             return message;
        } catch (Exception e) {
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE,null,e);
        }
        return null;
    }
}
