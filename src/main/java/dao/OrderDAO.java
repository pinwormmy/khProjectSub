package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.sql.Date;

import jdbc.JdbcUtil;
import model.dto.OrderDTO;

public class OrderDAO {

	private static OrderDAO orderDAO = new OrderDAO();

	public static OrderDAO getInstance() {
		return orderDAO;
	}

	private OrderDAO() {
	}
	
	private OrderDTO makeOrderFromResultSet(ResultSet rs) throws SQLException {
		
		OrderDTO orderDTO = new OrderDTO();
		
		orderDTO.setoId(rs.getInt("oId"));
		orderDTO.setmId("mid");
		orderDTO.setpId(rs.getInt("pId"));
		orderDTO.setQuantity(rs.getInt("quantity"));
		orderDTO.setoDate(rs.getDate("oDate"));
		orderDTO.setPrice(rs.getInt("price"));
		orderDTO.setStatus(rs.getString("status"));
		
		return orderDTO;
	}

	public void deleteOrder(Connection conn, int oId) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("delete from userorder where oId = ?");
			pstmt.setInt(1, oId);
			pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

	public void addOrder(Connection conn, OrderDTO order) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		pstmt = conn.prepareStatement("intser into userorder (oId,mId,pId,quantity,oDate,price,status)"
				+ "values(oIdseq.nextval, ?, ?, ?, ?, ?, ?)");
		try {
		pstmt.setInt(1,  order.getoId());
		pstmt.setString(1, order.getmId());
		pstmt.setInt(2,  order.getpId());
		pstmt.setInt(3,  order.getQuantity());
		pstmt.setDate(4, (Date)order.getoDate());
		pstmt.setInt(5, order.getPrice());
		pstmt.setString(6, order.getStatus());
				
		pstmt.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JdbcUtil.close(rs);
		JdbcUtil.close(stmt);
		JdbcUtil.close(pstmt);
	}
	}

	public List<OrderDTO> showOrder(Connection conn) throws SQLException {
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
    		pstmt = conn.prepareStatement("select oId, mId, pId, quantity, oDate, price, status"
                    + "from userorder"
                    + "order by oId desc");
    		
			rs = pstmt.executeQuery();
    				
			if(rs.next()) {
				List<OrderDTO> orderList = new ArrayList<OrderDTO>();
				
				do {
					orderList.add(makeOrderFromResultSet(rs));
				} while (rs.next());
    		
    			return orderList;
			} else {
				
				return Collections.emptyList();
			}
    	} finally {
    		JdbcUtil.close(rs);
    		JdbcUtil.close(pstmt);
    	}
    }

}
