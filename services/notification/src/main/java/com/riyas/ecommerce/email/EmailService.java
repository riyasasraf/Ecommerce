package com.riyas.ecommerce.email;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.riyas.ecommerce.kafka.order.Product;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {
  
  private final JavaMailSender mailSender;
  private final SpringTemplateEngine templateEngine;

  @Async
  public void sendPayment(
    String destination,
        String customerName,
            BigDecimal amount,
                String orderRefrence
  ) throws MessagingException {
    MimeMessage mimeMessage = mailSender.createMimeMessage();
    MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_RELATED,
        StandardCharsets.UTF_8.name());

    messageHelper.setFrom("contact@riyas.com");
    final String templateName = EmailTemplates.PAYMENT_CONFIRMATION.getTemplate();

    Map<String, Object> variables = new HashMap<>();
    variables.put("customerName", customerName);
    variables.put("amount", amount);
    variables.put("orderRefrence", orderRefrence);

    Context context = new Context();
    context.setVariables(variables);
    messageHelper.setSubject(EmailTemplates.PAYMENT_CONFIRMATION.getSubject());
    try {
      String htmlTemplate = templateEngine.process(templateName, context);
      messageHelper.setText(htmlTemplate, true);
      messageHelper.setTo(destination);
      mailSender.send(mimeMessage);
      log.info(String.format("Info - Email sucessfully sent to %s with template %s ", destination, templateName));
    } catch (MessagingException e) {
      log.warn("Warning - cannot send emai to {}", destination);
    }
  }

  
  @Async
  public void sentOrderConfirmation(
      String destination,
      String customerName,
      BigDecimal amount,
      String orderRefrence,
      List<Product> products) throws MessagingException {
    MimeMessage mimeMessage = mailSender.createMimeMessage();
    MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_RELATED,
        StandardCharsets.UTF_8.name());

    messageHelper.setFrom("contact@riyas.com");
    final String templateName = EmailTemplates.ORDER_CONFIRMATION.getTemplate();

    Map<String, Object> variables = new HashMap<>();
    variables.put("customerName", customerName);
    variables.put("totalAmount", amount);
    variables.put("orderRefrence", orderRefrence);
    variables.put("products", products);

    Context context = new Context();
    context.setVariables(variables);
    messageHelper.setSubject(EmailTemplates.ORDER_CONFIRMATION.getSubject());
    try {
      String htmlTemplate = templateEngine.process(templateName, context);
      messageHelper.setText(htmlTemplate, true);
      messageHelper.setTo(destination);
      mailSender.send(mimeMessage);
      log.info(String.format("Info - Email sucessfully sent to %s with template %s ", destination, templateName));
    } catch (MessagingException e) {
      log.warn("Warning - cannot send emai to {}", destination);
    }
  }
}
