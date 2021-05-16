package com.moneytransfer.webapi.dto;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;


public class SendEmail {

    private String username = null;
    private String password = null;
    private Authenticator auth = null;
    private MimeMessage mimeMessage =null;
    private Properties pros = null;
    private Multipart multipart = null;
    private BodyPart bodypart= null;

    public SendEmail(String username,String password){
        this.username = username;
        this.password = password;
    }

    public void initMessage(){
        this.auth = new Email_Autherticator();
        Session session = Session.getDefaultInstance(pros,auth);
        //session.setDebug(true); //设置获取 debug 信息
        mimeMessage = new MimeMessage(session);
    }

    public void setPros(Map<String,String> map){
        pros = new Properties();
        for(Map.Entry<String,String> entry:map.entrySet()){
            pros.setProperty(entry.getKey(), entry.getValue());
        }
    }

    public class Email_Autherticator extends Authenticator
    {
        public PasswordAuthentication getPasswordAuthentication()
        {
            return new PasswordAuthentication(username, password);
        }
    }

    public void setDefaultMessagePros(String sub,String text,String rec) throws MessagingException, UnsupportedEncodingException{
        mimeMessage.setSubject(sub);
        mimeMessage.setText(text);
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(rec));
        mimeMessage.setSentDate(new Date());
        mimeMessage.setFrom(new InternetAddress(username,username));
    }

    public void  setSubject(String subject) throws MessagingException{
        mimeMessage.setSubject(subject);
    }

    public void  setDate(Date date) throws MessagingException{
        mimeMessage.setSentDate(new Date());
    }

    public void setText(String text) throws MessagingException{
        mimeMessage.setText(text);
    }

    public void setHeader(String arg0,String arg1) throws MessagingException{
        mimeMessage.setHeader(arg0, arg1);
    }

    public void setRecipient(String recipient) throws MessagingException{
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
    }

    public String setRecipients(List<String> recs) throws AddressException, MessagingException{
        if(recs.isEmpty()){
            return "Receiver is empty!";
        }
        for(String str:recs){
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(str));
        }
        return "Receiver added successfully";
    }

    @SuppressWarnings("static-access")
    public String setRecipients(StringBuffer sb) throws AddressException, MessagingException{
        if(sb==null||"".equals(sb)){
            return "Receiver is empty!";
        }
        Address []address = new InternetAddress().parse(sb.toString());
        mimeMessage.addRecipients(Message.RecipientType.TO, address);
        return "Receiver added successfully";
    }
    public void setFrom(String from) throws UnsupportedEncodingException, MessagingException{
        mimeMessage.setFrom(new InternetAddress(username,from));
    }
    public String sendMessage() throws MessagingException{
        Transport.send(mimeMessage);
        return "Email sent successfully";
    }

    public void setMultipart(String file) throws MessagingException, IOException{
        if(multipart==null){
            multipart = new MimeMultipart();
        }
        multipart.addBodyPart(writeFiles(file));
        mimeMessage.setContent(multipart);
    }

    public void setMultiparts(List<String> fileList) throws MessagingException, IOException{
        if(multipart==null){
            multipart = new MimeMultipart();
        }
        for(String s:fileList){
            multipart.addBodyPart(writeFiles(s));
        }
        mimeMessage.setContent(multipart);
    }

    public void setContent(String s,String type) throws MessagingException{
        if(multipart==null){
            multipart = new MimeMultipart();
        }
        bodypart = new MimeBodyPart();
        bodypart.setContent(s, type);
        multipart.addBodyPart(bodypart);
        mimeMessage.setContent(multipart);
        mimeMessage.saveChanges();
    }

    public BodyPart writeFiles(String filePath)throws IOException, MessagingException{
        File file = new File(filePath);
        if(!file.exists()){
            throw new IOException("File does not exist");
        }
        bodypart = new MimeBodyPart();
        DataSource dataSource = new FileDataSource(file);
        bodypart.setDataHandler(new DataHandler(dataSource));
        //文件名要加入编码，不然出现乱码
        bodypart.setFileName(MimeUtility.encodeText(file.getName()));
        return bodypart;
    }

}
