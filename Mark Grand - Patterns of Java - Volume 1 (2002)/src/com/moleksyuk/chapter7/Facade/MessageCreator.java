package com.moleksyuk.chapter7.Facade;

import java.security.Security;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 7, 2011
 * 
 * @author moleksyuk
 */
public class MessageCreator {

	public final static int MIME = 1;
	public final static int MAPI = 2;

	private Map<String, String> headerFields = new HashMap<String, String>();
	@SuppressWarnings("unused")
	private RichText messageBody;
	private List<Object> attachments = new ArrayList<Object>();
	@SuppressWarnings("unused")
	private boolean signMessage;

	public MessageCreator(String to, String from, String subject) {
		this(to, from, subject, inferMessageType(to));
	}

	public MessageCreator(String to, String from, String subject,
			Object inferMessageType) {
		headerFields.put("to", to);
		headerFields.put("from", from);
		headerFields.put("subject", subject);
	}

	public void setMessageBody(String messageBody) {
		setMessageBody(new RichTextString(messageBody));
	}

	public void setMessageBody(RichText messageBody) {
		this.messageBody = messageBody;
	}

	public void addAttachment(Object attachment) {
		attachments.add(attachment);
	}

	public void setSignMessage(boolean signFlag) {
		this.signMessage = signFlag;
	}

	public void setHeaderField(String name, String value) {
		headerFields.put(name, value);
	}

	public void send() {

	}

	private static int inferMessageType(String address) {
		int type = 0;

		// ....

		return type;
	}

	@SuppressWarnings("unused")
	private Security createSecurity() {
		Security s = null;

		// ...

		return s;
	}

	@SuppressWarnings("unused")
	private void createMessageSender(Message msg) {

	}
}
