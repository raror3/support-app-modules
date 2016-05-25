/**
 * 
 */
package com.sapient.mail.attachment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
@Import(AttachmentFileModuleOptionsMetadata.class)
public class ModuleConfiguration {

	@Bean
	public MessageChannel input() {
		return new DirectChannel();
	}

	@Bean
	MessageChannel output() {
		return new DirectChannel();
	}
	
	@Bean
	public IntegrationFlow extractorFlow() {
		return IntegrationFlows.from(this.input()).transform(new EmailTransformer()).split(new EmailSplitter()).channel(this.output()).get();
	}

	

}
