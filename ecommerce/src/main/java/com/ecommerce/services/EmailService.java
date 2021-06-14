package com.ecommerce.services;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.ecommerce.entities.Pedidos;
import com.ecommerce.entities.ProdutosPedidos;
import com.ecommerce.exception.EmailException;
import com.ecommerce.repositories.ProdutosPedidosRepository;
import com.ecommerce.vo.ProdutosPedidosVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
	@Autowired
	private JavaMailSender emailSender;

	@Value("${spring.mail.username}")
	private String emailRemetente;
	
	@Value("${spring.mail.host}")
	private String emailServerHost;
	
	@Value("${spring.mail.port}")
	private Integer emailServerPort;
	
	@Value("${spring.mail.username}")
	private String emailServerUserName;
	
	@Value("${spring.mail.password}")
	private String emailServerPassword;
	
	@Value("${spring.mail.protocol}")
	private String emailServerProtocol;
	
	public JavaMailSender javaMailSender() {

		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		Properties prop = new Properties();

		mailSender.setHost(emailServerHost);
		mailSender.setPort(emailServerPort);
		mailSender.setUsername(emailServerUserName);
		mailSender.setPassword(emailServerPassword);
		mailSender.setProtocol("smtp");
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", false);
		mailSender.setJavaMailProperties(prop);

		return mailSender;

	}



	public void emailPedidos(Pedidos pedido) throws MessagingException, EmailException {
      
       // for(ProdutosPedidos produtosPedidos: pedido.getListProdutosPedidos()){
       // System.out.println(produtosPedidos.getPreco());
       // System.out.println("AQUIiiiiiiiiiiiiii");
       // }

		this.emailSender = javaMailSender();

		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
      

		try {
			helper.setFrom(emailRemetente);
			helper.setTo("grupo2apiserra@gmail.com");
			helper.setSubject("Pedido Nº " + pedido.getIdPedidos());



			SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm:ss");
			DecimalFormat dfMoeda = new DecimalFormat("R$ ,##0.00");

			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("<html>\r\n");
			sBuilder.append("	<body>\r\n");
			sBuilder.append("		<div align=\"center\">\r\n");
			sBuilder.append("			NOTA FISCAL\r\n");
			sBuilder.append("		</div>\r\n");
			sBuilder.append("		<br/>\r\n");
			sBuilder.append("		<center>\r\n");
			sBuilder.append("		<table border='1' cellpadding='5'  >\r\n");
			sBuilder.append("<tr><th>Data de Entrega</th><th>Produto</th><th>Quantidade</th><th>Valor final</th></tr>\r\n");

           // for(ProdutosPedidos produtosPedidos: pedido.getListProdutosPedidos()){

			sBuilder.append("		<tr>\r\n");
			sBuilder.append("			<td>\r\n");
			sBuilder.append(sdfData.format(pedido.getDataPedido().getTime()));
			sBuilder.append("			</td>\r\n");
			sBuilder.append("			<td>\r\n");
			sBuilder.append("");//(produtosPedidos.getProdutoId().getNome());
			sBuilder.append("			</td>\r\n");
			sBuilder.append("			<td>\r\n");
			sBuilder.append("");//produtosPedidos.getQuantidade());
			sBuilder.append("			</td>\r\n");
			sBuilder.append("			<td>\r\n");
			sBuilder.append(dfMoeda.format(pedido.getTotalPedido()));
			sBuilder.append("			</td>\r\n");
			sBuilder.append("		</tr>\r\n");

			sBuilder.append("		</table>\r\n");
			sBuilder.append("		</center>\r\n");
			sBuilder.append("	</body>\r\n");
			sBuilder.append("</html>");

			helper.setText(sBuilder.toString(), true);

			emailSender.send(message);
           // }
		} catch (Exception e) {
			throw new EmailException("Houve erro ao enviar o email Finalização de Pedido: " + e.getMessage());
		}

	}
}