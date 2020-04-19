package business;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import Data.OrdersDataService;
import beans.Order;



/**
 * Message-Driven Bean implementation class for: OrderMessageService
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/queue/Order"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "java:/jms/queue/Order")
public class OrderMessageService implements MessageListener {

   @EJB
   OrdersDataService service;
    public OrderMessageService() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) 
    {
    	try
    	{    
    		//if a text message then just print the message to the console else if an object then insert Order to database using DAO service
    		if(message instanceof TextMessage)
    		{
    			System.out.println("=======OrderMessageService.onMessage() with a text message: " + ((TextMessage)message).getText());
    		}
    		else if (message instanceof ObjectMessage)
    		{
    			System.out.println("=======OrderMessageService.onMessage() with a send order message. ");
    			service.create((Order)((ObjectMessage)message).getObject());
    		}
    		else
    		{
    			System.out.println("=======OrderMessageService.onMessage() with UNKNOWN message type. ");
    		}
    	}
    	catch (JMSException e)
    	{
    		e.printStackTrace();
    	}
    }

}
