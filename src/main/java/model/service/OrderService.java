package model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import model.dao.OrderDAO;
import model.dto.OrderDTO;
import model.dto.UserCartDTO;

//서브 파일이다 원본파일이랑 구분 잘해라!!!

// 비회원 카트 삭제. 회원카트로 진행

public class OrderService {
	
	private static OrderService instance = new OrderService();
	public static OrderService getInstance() {
		return instance;
	}	
	private OrderService() {
	}
	
	public List<UserCartDTO> showUserCart(String id) {
		
        Connection conn = null;
        
        try {
            conn = ConnectionProvider.getConnection();
            OrderDAO orderDAO = OrderDAO.getInstance();
            
            return orderDAO.showUserCart(conn, id);
            
        } catch (SQLException e) {
            JdbcUtil.printSQLException(e);
            JdbcUtil.close(conn);
        }
        return null;
    }
	
    public void addCart(UserCartDTO cart) {
        Connection conn = null;
        try {
            conn = ConnectionProvider.getConnection();
            OrderDAO orderDAO = OrderDAO.getInstance();
            
            orderDAO.addCart(conn, cart);
            
        } catch (SQLException e) {
            JdbcUtil.printSQLException(e);
            JdbcUtil.close(conn);
        }   
    }

    public void deleteCart(int ucId) {
        
        Connection conn = null;
        try {
            conn = ConnectionProvider.getConnection();
            OrderDAO orderDAO = OrderDAO.getInstance();
            
            orderDAO.deleteCart(conn, ucId);
            
        } catch (SQLException e) {
            JdbcUtil.printSQLException(e);
            JdbcUtil.close(conn);
        }   
    }
    
    public void resetCart(String mId) {
        
        Connection conn = null;
        try {
            conn = ConnectionProvider.getConnection();
            OrderDAO orderDAO = OrderDAO.getInstance();
            
            orderDAO.resetCart(conn, mId);
            
        } catch (SQLException e) {
            JdbcUtil.printSQLException(e);
            JdbcUtil.close(conn);
        }   
    }

	public List<OrderDTO> showOrderList(String mId) {
		Connection conn = null;
        
        try {
            conn = ConnectionProvider.getConnection();
            OrderDAO orderDAO = OrderDAO.getInstance();
            
            return orderDAO.showOrderList(conn, mId);
            
        } catch (SQLException e) {
            JdbcUtil.printSQLException(e);
            JdbcUtil.close(conn);
        }
        return null;
	}
	public void addOrder(String mId) {
		
		Connection conn = null;
        try {
            conn = ConnectionProvider.getConnection();
            OrderDAO orderDAO = OrderDAO.getInstance();
            
            orderDAO.addOrder(conn, mId);
            
        } catch (SQLException e) {
            JdbcUtil.printSQLException(e);
            JdbcUtil.close(conn);
        }   
	}
	
	public boolean checkEmptyCart(String mId) {
		
		Connection conn = null;
        try {
            conn = ConnectionProvider.getConnection();
            OrderDAO orderDAO = OrderDAO.getInstance();
            
            return orderDAO.checkEmptyCart(conn, mId);
            
        } catch (SQLException e) {
            JdbcUtil.printSQLException(e);
            JdbcUtil.close(conn);
        }   
        
        return true;
	}

}
