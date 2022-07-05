package model.dao;

// 서브 파일이다 원본파일이랑 구분 잘해라!!!

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jdbc.JdbcUtil;
import model.dto.NuserCartDTO;

public class OrderDAO {
	
private static OrderDAO orderDAO = new OrderDAO();
	
	public static OrderDAO getInstance() {
		return orderDAO;
	}
	
	private OrderDAO() {}
	
	private NuserCartDTO makeNuserFromResultSet(ResultSet rs) throws SQLException {
		
	    NuserCartDTO nUserCartDTO = new NuserCartDTO();
        
	    nUserCartDTO.setNcId(rs.getInt("ncId"));
	    nUserCartDTO.setpId(rs.getInt("pId"));
	    nUserCartDTO.setQuantity(rs.getInt("quantity"));	    
	    nUserCartDTO.setpName(rs.getString("pName"));	    
	    nUserCartDTO.setPrice(rs.getInt("price"));	    
	    nUserCartDTO.setThumbnail(rs.getString("thumbnail"));	    
        
        return nUserCartDTO;
    }
	
	
	public List<NuserCartDTO> showNuserCart(Connection conn) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            pstmt = conn.prepareStatement("select a.ncId, a.pId, a.quantity, b.pName, b.price, b.thumbnail "
                    + "from nUserCart a, product b "
                    + "where a.pid = b.pid "
                    + "order by ncId desc");
                      
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                List<NuserCartDTO> nCartList = new ArrayList<NuserCartDTO>();
                
                do {
                    nCartList.add(makeNuserFromResultSet(rs));
                } while (rs.next());
                
                return nCartList;
                
            } else {
                return Collections.emptyList();
            }
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }

    public void deleteCart(Connection conn, int ncId) throws SQLException {
        
        PreparedStatement pstmt = null;        
        pstmt = conn.prepareStatement("delete from nUserCart where ncId= ?");
        pstmt.setInt(1, ncId);
        pstmt.executeUpdate();
    }

    public void addCart(Connection conn, int pId, int quantity) throws SQLException {
        // 원래 비회원 장바구니는 쿠키로 구현하는 게 효율적이다(다음 프로젝트에서 수정예정)
        PreparedStatement pstmt = null;        
        pstmt = conn.prepareStatement("insert into nUserCart values(ncId_seq.nextval, ?, ?)");
        pstmt.setInt(1, pId);
        pstmt.setInt(2, quantity);
        pstmt.executeUpdate();
    }
}
