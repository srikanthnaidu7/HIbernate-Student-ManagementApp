package com.sri.sm.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.sri.sm.constants.StudentConstants;
import com.sri.sm.controller.StudentController;

@Component
public class StudentEmailServiceImpl implements StudentEmailService {

	Logger logger = Logger.getLogger(StudentEmailServiceImpl.class.getName());
	@Autowired
	private JavaMailSender javaMailSenderImpl;

	/*
	 * @Autowired private StudentConstants studentConstants;
	 */

	@Override
	public void sendEmail(String studentEmail, String name) {

		if (null != studentEmail && null != name) {
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setTo(studentEmail);
			simpleMailMessage.setSubject(StudentConstants.STUDENT_MAIL_SUBJECT);
			simpleMailMessage.setText("Hi " + name + "\nWelcome. Your Student Profile is created Successfully.");
			logger.info("MAIL_TO::->"+studentEmail);
			logger.info("->> email content done...");

			try {
				javaMailSenderImpl.send(simpleMailMessage);
				logger.info("->> message sent successfully...");
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
		}

	}

}
