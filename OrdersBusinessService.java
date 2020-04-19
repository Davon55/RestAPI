package business;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import Data.DataAccessInterface;

import beans.Order;


/**
 * Session Bean implementation class OrdersBusinessService
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
@Alternative 
public class OrdersBusinessService implements OrdersBusinessInterface {
	
	@EJB
	DataAccessInterface<Order> service;
	
	@Resource(mappedName="java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName="java:/jms/queue/Order")
	private Queue queue;


   List<Order> orders = new ArrayList<Order>();
   
    public OrdersBusinessService() {
    	
    	/*	
    		orders.add(new Order("0000001", "John", (float)220.00,1));
    		orders.add(new Order("0000002", "Davon", (float)100.00,1));
    		orders.add(new Order("0000003", "Ben", (float)100.00,1));
    		orders.add(new Order("0000004", "Jovon", (float)50.00,1));
    		orders.add(new Order("0000005", "Craig", (float)50.00,1));
    		orders.add(new Order("0000006", "Jasmine", (float)50.00,1));
    		orders.add(new Order("0000007", "Nick", (float)30.00,1));
    		orders.add(new Order("0000008", "Page", (float)30.00,1));
    		orders.add(new Order("0000009", "Mike", (float)30.00,1));
    		orders.add(new Order("0000010", "Courtney", (float)30.00,1));
    		
    		*/
    	
    }

	
    public void test() {
        // TODO Auto-generated method stub
    	System.out.println("Hello, from the OTHER side!!");
    }


	public List<Order> getOrders() {
		return service.findAll();
	}


	public void setOrders(List<Order> orders) {
		
	}


	@Override
	public void sendOrder(Order order) {
		try 
		{
			Connection connection = connectionFactory.createConnection();
			Session  session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer messageProducer = session.createProducer(queue);
			TextMessage message1 = session.createTextMessage();
			message1.setText("This is test message");
			messageProducer.send(message1);
			connection.close();
		} 
		catch (JMSException e) 
		{
			e.printStackTrace();
		}		

		
	}
    

}
