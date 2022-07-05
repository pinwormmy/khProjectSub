package model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import model.dao.OrderDAO;
import model.dto.NuserCartDTO;

//서브 파일이다 원본파일이랑 구분 잘해라!!!

// 비회원 카트 삭제. 회원카트로 진행

public class OrderService {
	
	private static OrderService instance = new OrderService();

	public static OrderService getInstance() {
		return instance;
	}

	private OrderService() {
	}
	public List<NuserCartDTO> showNuserCart() {
		
        Connection conn = null;
        
        try {
            conn = ConnectionProvider.getConnection();
            OrderDAO orderDAO = OrderDAO.getInstance();
            
            return orderDAO.showNuserCart(conn);
            
        } catch (SQLException e) {
            JdbcUtil.printSQLException(e);
            JdbcUtil.close(conn);
        }
        return null;
    }
	
    public void addCart(int pId, int quantity) {
        Connection conn = null;
        try {
            conn = ConnectionProvider.getConnection();
            OrderDAO orderDAO = OrderDAO.getInstance();
            
            orderDAO.addCart(conn, pId, quantity);
            
        } catch (SQLException e) {
            JdbcUtil.printSQLException(e);
            JdbcUtil.close(conn);
        }   
    }

    public void deleteCart(int ncId) {
        
        Connection conn = null;
        try {
            conn = ConnectionProvider.getConnection();
            OrderDAO orderDAO = OrderDAO.getInstance();
            
            orderDAO.deleteCart(conn, ncId);
            
        } catch (SQLException e) {
            JdbcUtil.printSQLException(e);
            JdbcUtil.close(conn);
        }   
    }


}
