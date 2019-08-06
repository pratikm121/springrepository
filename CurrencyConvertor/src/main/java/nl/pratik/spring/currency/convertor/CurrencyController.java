package nl.pratik.spring.currency.convertor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class CurrencyController {
	
	private static final Logger log = LoggerFactory.getLogger(CurrencyController.class);
	
	@Autowired 
	private JavaMailSender javaMailSender;
	
	@Value("${currencyConvertorAPI}") 
	private String currencyConvertorAPI;
	
	@RequestMapping("/checkRates")
	public String checkRates() {
		RestTemplate restTemplate = new RestTemplate();
		CurrencyResponseData quote = restTemplate.getForObject(currencyConvertorAPI, CurrencyResponseData.class);
		return "Value of euro is" +quote.getRates().getInr() + " . So send money to India if you want to.";
	}
	
	
	//	Cron to run every four hour 	0 0 0/4 1/1 * *
	//	Cron to run every one mintute 	0 0/1 * 1/1 * *
	@Scheduled(cron = "0 0 0/4 1/1 * *")
	public void scheduleTaskWithCronExpression() {
		sendEmail();
	}
	
	
	@RequestMapping("/sendmail")
	public void sendEmail() { 	
		RestTemplate restTemplate = new RestTemplate();
		CurrencyResponseData quote = restTemplate.getForObject(currencyConvertorAPI, CurrencyResponseData.class);
		log.debug("Current rate is "+ quote.getRates().getInr());
		if(quote.getRates().getInr() > 78) {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo("pratikm121@gmail.com","er.manvidoshi@gmail.com");
			msg.setSubject("Urgent Mail from Currency Convertor !!!"); 
			msg.setText("Value of euro is" +quote.getRates().getInr() + " . So send money to India if you want to.");
			javaMailSender.send(msg); 
			log.debug("Mail send");
		}	  
	}
	

}
