package mvc.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dto.OrderDTO;
import model.dto.UserCartDTO;
import model.service.OrderService;

public class OrderHandler implements CommandHandler {
    
    OrderService orderService = OrderService.getInstance();

    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) {        
        
        String fromPath = req.getRequestURI().substring(req.getContextPath().length());
        String toPath = null;
        
        if(fromPath.equals("/cart.do")) {      
            
            String mId = req.getParameter("mId");
            List<UserCartDTO> cartList = orderService.showUserCart(mId);   
            req.setAttribute("cartList", cartList); 
            
            toPath = "/WEB-INF/view/order/cart.jsp";
            
        }else if(fromPath.equals("/addCart.do")) {     
            
            UserCartDTO cart = new UserCartDTO();     
            
            String mId = req.getParameter("mId");
            int pId = Integer.parseInt(req.getParameter("pId"));
            int cQuantity = Integer.parseInt(req.getParameter("cQuantity"));
                        
            cart.setmId(mId);
            cart.setpId(pId);
            cart.setcQuantity(cQuantity);            
            orderService.addCart(cart);
            
            req.setAttribute("msg", "장바구니에 넣었습니다~");
            req.setAttribute("url", "cart.do?mId=" + mId);
            toPath = "/WEB-INF/view/alert.jsp";
                        
        }else if(fromPath.equals("/deleteCart.do")) {
            
            String mId = req.getParameter("mId");
            int ucId = Integer.parseInt(req.getParameter("ucId"));
            orderService.deleteCart(ucId);
            
            req.setAttribute("msg", "장바구니에 있던 상품을 삭제했습니다~");
            req.setAttribute("url", "cart.do?mId=" + mId);                            
            toPath = "/WEB-INF/view/alert.jsp";
            
        }else if(fromPath.equals("/checkout.do")) {     
            
            String mId = req.getParameter("mId");
            List<UserCartDTO> cartList = orderService.showUserCart(mId);
            req.setAttribute("cartList", cartList); 
            
            toPath = "/WEB-INF/view/order/checkout.jsp";
            
        }else if(fromPath.equals("/confirmation.do")) {  
        	
            toPath = "/WEB-INF/view/order/confirmation.jsp";
            
        }else if(fromPath.equals("/order.do")) { 
        	
        	String mId = req.getParameter("mId");
            List<OrderDTO> orderList = orderService.showOrderList(mId);   
            req.setAttribute("orderList", orderList); 
            
            toPath = "/WEB-INF/view/order/order.jsp";
            
        }else if(fromPath.equals("/addOrder.do")) { 
        	            
            String mId = req.getParameter("mId");            
            orderService.addOrder(mId);  
            orderService.resetCart(mId);             
            
            req.setAttribute("msg", "밀슐랭~주문~");
            req.setAttribute("url", "order.do?mId=" + mId);
            toPath = "/WEB-INF/view/alert.jsp";
            
        }else {
            toPath = "/WEB-INF/view/error.jsp";
        }
        
        return toPath;       
    }

}