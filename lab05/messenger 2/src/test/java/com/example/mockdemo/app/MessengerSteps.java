package com.example.mockdemo.app;

import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.MessageServiceSimpleImpl;

public class MessengerSteps {
	private static final String VALID_SERVER = "inf.ug.edu.pl";
	private static final String INVALID_SERVER = "inf.ug.edu.eu";

	private static final String VALID_MESSAGE = "some message";
	private static final String INVALID_MESSAGE = "ab";

	private Messenger messenger;
	private MessageService ms;
	
	private static String server;
	private static String message;
	
	@Given("a messenger")
	public void messengerSetup() throws MalformedRecipientException{
		ms = new MessageServiceSimpleImpl();
		messenger = new Messenger(ms);		
	}
	
	@When("connecting with VALID_SERVER")
	public void setValidServer(){
		server = VALID_SERVER;
	}
	
	@When("connecting with INVALID_SERVER")
	public void setInvalidServer(){
		server = INVALID_SERVER;
	}
	
	@When("sending valid message")
	public void setValidMessage(){
		message = VALID_MESSAGE;
	}
	
	@When("sending invalid message")
	public void setInvalidMessage(){
		message = INVALID_MESSAGE;
	}
	
	@Then("message status on VALID_SERVER should return $result1 or $result2")
	public void testValMsgValSrv(int result1, int result2){
		assertThat(messenger.sendMessage(VALID_SERVER, message), either(equalTo(result1)).or(equalTo(result2)));
	}
	
	@Then("connection status should return $result")
	    public void checkServer(int result){
	        assertEquals(result, messenger.testConnection(server));
	    }
	
	@Then("message status on INVALID_SERVER should return $result")
	public void testValMsgInvalSrv(int result){
		assertEquals(result, messenger.sendMessage(INVALID_SERVER, message));
	}	
}
