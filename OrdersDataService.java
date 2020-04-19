package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import beans.Order;

@Stateless
@Local(DataAccessInterface.class)
@LocalBean
public class OrdersDataService implements DataAccessInterface<Order> {

	
	//Default Constructor 
	public OrdersDataService()
	{
		
	}
	
	//CRUD: Finder to find all entities
	public List<Order>findAll()
	{
		Connection conn = null;
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "Root";
		
		String sql = "SELECT * FROM testapp.ORDERS";
		List<Order> orders = new ArrayList<Order>();
		try
		{
			//connect to database
			conn = DriverManager.getConnection(url, username, password);
			
			//execute SQL query and loop over result set
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				orders.add(new Order(rs.getString("ORDER_NO"), rs.getString("PRODUCT_NAME"), rs.getFloat("PRICE"), rs.getInt("QUANTITY")));
			}
			rs.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//clean up database
			if (conn != null)
			{
				try
				{
					conn.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return orders;
	}
	
    
	//create an entity 
	public boolean create(Order order) {
		Connection conn = null;
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "Root";
		
		String sql = "INSERT INTO testapp.ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES('8888888888', 'My Product', 9,999,999.00, 100)";
		
		try
		{
			//connect to database
			conn = DriverManager.getConnection(url, username, password);
			
			//execute SQL query 
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//clean up database
			if (conn != null)
			{
				try
				{
					conn.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return true;
	}

	@Override
	public boolean update(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Order order) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
