package model.dao;

// 서브 파일이다 원본파일이랑 구분 잘해라!!!

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jdbc.JdbcUtil;
import model.dto.OrderDTO;
import model.dto.UserCartDTO;

public class OrderDAO {
	
    private static OrderDAO orderDAO = new OrderDAO();	
	public static OrderDAO getInstance() {
		return orderDAO;
	}	
	private OrderDAO() {}
	
	private UserCartDTO makeUserFromResultSet(ResultSet rs) throws SQLException {
		
	    UserCartDTO userCart = new UserCartDTO();
        
	    userCart.setUcId(rs.getInt("ucId"));
	    userCart.setpId(rs.getInt("pId"));
	    userCart.setmId(rs.getString("mId"));
	    userCart.setQuantity(rs.getInt("quantity"));	    
	    userCart.setpName(rs.getString("pName"));	    
	    userCart.setPrice(rs.getInt("price"));	    
	    userCart.setThumbnail(rs.getString("thumbnail"));	    
        
        return userCart;
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
	
	public List<UserCartDTO> showUserCart(Connection conn) throws SQLException {
	    
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            pstmt = conn.prepareStatement("select a.ucId, a.pId, a.quantity, b.pName, b.price, b.thumbnail "
                    + "from nUserCart a, product b "
                    + "where a.pid = b.pid "
                    + "order by ucId desc");
                      
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                List<UserCartDTO> cartList = new ArrayList<UserCartDTO>();
                
                do {
                    cartList.add(makeUserFromResultSet(rs));
                } while (rs.next());
                
                return cartList;
                
            } else {
                return Collections.emptyList();
            }
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }

    public void deleteCart(Connection conn, int ucId) throws SQLException {
        
        PreparedStatement pstmt = null;        
        pstmt = conn.prepareStatement("delete from userCart where ucId= ?");
        pstmt.setInt(1, ucId);
        pstmt.executeUpdate();
    }

    public void addCart(Connection conn, int pId, int quantity) throws SQLException {
        
        PreparedStatement pstmt = null;        
        pstmt = conn.prepareStatement("insert into userCart values(ucId_seq.nextval, ?, ?)");
        pstmt.setInt(1, pId);
        pstmt.setInt(2, quantity);
        pstmt.executeUpdate();
    }
    
    public List<OrderDTO> showOrder(Connection conn) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            pstmt = conn.prepareStatement("select oId, mId, pId, quantity, oDate, price, status"
                    + "from userorder"
                    + "where oId"
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
    
    public void addOrder(Connection conn, OrderDTO order) throws SQLException {
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;

        pstmt = conn.prepareStatement("intser int userorder (oId,mId,pId,quantity,oDate,price,status)"
                + "values(oIdseq.nextval, ?, ?, ?, ?, ?, ?)");
        try {
            pstmt.setInt(1, order.getoId());
            pstmt.setString(1, order.getmId());
            pstmt.setInt(2, order.getpId());
            pstmt.setInt(3, order.getQuantity());
            pstmt.setDate(4, (Date) order.getoDate());
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
}
