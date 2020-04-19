package controllers;





import java.text.DecimalFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Order;
import beans.User;
import business.MyTimerService;
import business.OrdersBusinessInterface;

@ManagedBean
@ViewScoped
public class FormController 
{
	@EJB
	MyTimerService timer;
	@Inject
	OrdersBusinessInterface service;
	public String onSubmit(User user)
	{

		
		//Call Business Service (for testing only and demo to CDI)
		service.test();
		
		//Call timer
		timer.setTimer(10000);
		
		//Forward to Test Response View along with the User Managed Bean
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		return "TestResponse.xhtml";
		
	}
	public String onSendOrder(User user)
	{
		//create order number based on current time
		DecimalFormat df = new DecimalFormat("0000000000000000");
		String orderNo = df.format(new Date().getTime());
		
		//call business service to send an order
		Order order = new Order();
		order.setOrderNumber(orderNo);
		order.setProductName("This is an ordered product");
		order.setPrice((float)1000.00);
		order.setQuantity(2000);
		service.sendOrder(order);
		//forward to the test response view along with the managed bean 
		return "OrderResponse.xhtml";
	}
	
	
	
	public OrdersBusinessInterface getService()
	{
		return service;
	}
}
