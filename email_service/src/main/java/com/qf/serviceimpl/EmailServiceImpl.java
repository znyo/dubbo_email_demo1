package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.entity.Email;
import com.qf.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;

@Service
public class EmailServiceImpl implements IEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public Email getEmail() {
        //创建一封邮件
        Email email=new Email();
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //提供一个帮助对象
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        try {
            //设置发送方
            mimeMessageHelper.setFrom("znznyo@sina.com");
            //设置接收方
            //to - 普通接收方
            //cc - 抄送方
            //bcc - 密送方
            mimeMessageHelper.addTo("1661755320@qq.com");
            mimeMessageHelper.setSubject("注册验证码");//设置标题
          int number = (int)(Math.random()*8999+1000);
            mimeMessageHelper.setText("验证码为："+number);
            String num=number+"";
            email.setContent(num);
            mimeMessageHelper.setSentDate(new Date());
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return email;
    }
}
