package beans;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import business.OrdersBusinessInterface;


@ManagedBean
@ViewScoped
public class Orders {
	
	@Inject
	OrdersBusinessInterface service;
	 
 List <Order> orders = new ArrayList <Order>();
	
	
	@PostConstruct
	public void init()
	{
		orders = service.getOrders();
	}
	public List<Order> getOrders()
	{
		return orders;
	}
	public void setOrders(List<Order> order)
	{
		this.orders = order;
	}
}
