
package com.sapient.mail.attachment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.messaging.Message;
import org.springframework.integration.annotation.Splitter;
import org.springframework.integration.file.FileHeaders;
import org.springframework.integration.support.MessageBuilder;

public class EmailSplitter {

	@Splitter
	public List<Message<?>> splitIntoMessages(final List<EmailFragment> emailFragments) {

		final List<Message<?>> messages = new ArrayList<Message<?>>();

		for (EmailFragment emailFragment : emailFragments) {
			Message<?> message = MessageBuilder.withPayload(emailFragment.getData())
											.setHeader(FileHeaders.FILENAME, emailFragment.getFilename())
											.setHeader("directory", emailFragment.getDirectory())
											.build();
			messages.add(message);
		}

		return messages;
	}

}
