package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Order;

/**
 * Session Bean implementation class AnotherBusinessService
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
@Alternative
public class AnotherOrdersBusinessService implements OrdersBusinessInterface {

	 List<Order> orders = new ArrayList<Order>();
    public AnotherOrdersBusinessService() {
    	
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
    }

	
    public void test() {
        // TODO Auto-generated method stub
    	System.out.println("Hello, from another business service!!");
    }


	public List<Order> getOrders() {
		return orders;
	}


	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	@Override
	public void sendOrder(Order order) {
		// TODO Auto-generated method stub
		
	}
    

}
