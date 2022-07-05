package model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import model.dao.OrderDAO;
import model.dto.OrderDTO;

public class OrderService {
	
	private static OrderService instance = new OrderService();

	public static OrderService getInstance() {
		return instance;
	}

	private OrderService() {
	}
	
	public List<OrderDTO> showOrder() {
		
        Connection conn = null;
        
        try {
            conn = ConnectionProvider.getConnection();
            OrderDAO orderDAO = OrderDAO.getInstance();
            
            return orderDAO.showOrder(conn);
            
        } catch (SQLException e) {
            JdbcUtil.printSQLException(e);
            JdbcUtil.close(conn);
        }
        return null;
    }
	
    public void addOrder(OrderDTO order) {
        Connection conn = null;
        try {
            conn = ConnectionProvider.getConnection();
            OrderDAO orderDAO = OrderDAO.getInstance();
            
            orderDAO.addOrder(conn, order);
            
        } catch (SQLException e) {
            JdbcUtil.printSQLException(e);
            JdbcUtil.close(conn);
        }   
    }

    public void deleteOrder(int oId) {
        
        Connection conn = null;
        try {
            conn = ConnectionProvider.getConnection();
            OrderDAO orderDAO = OrderDAO.getInstance();
            
            orderDAO.deleteOrder(conn, oId);
            
        } catch (SQLException e) {
            JdbcUtil.printSQLException(e);
            JdbcUtil.close(conn);
        }   
    }


}
