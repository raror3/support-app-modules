/**
 * 
 */
package com.sapient.transformer.csvtojson;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageChannel;

/**
 * @author aamol
 *
 */
@Configuration
@EnableIntegration
public class ModuleConfiguration {

	@Bean
	public MessageChannel input() {
		return new DirectChannel();
	}

	@Bean
	MessageChannel output() {
		return new DirectChannel();
	}

	@Value("${fieldNames}")
	String fieldNames;

	@Bean
	public IntegrationFlow extractorFlow() {
		return IntegrationFlows.from(this.input()).transform(new CsvToJsonTransformer(fieldNames))
				.channel(this.output()).get();
	}

}
