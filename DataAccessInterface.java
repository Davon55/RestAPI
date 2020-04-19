package Data;

import java.util.List;

import beans.Order;

public interface DataAccessInterface <Orders> {
	
	public List<Orders> findAll();
	
	public boolean create(Order order);
	public boolean update(Order order);
	public boolean delete(Order order);

}
