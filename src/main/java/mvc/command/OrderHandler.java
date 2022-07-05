package mvc.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.NuserCartDTO;
import model.service.OrderService;

public class OrderHandler implements CommandHandler {
    
    OrderService orderService = OrderService.getInstance();

    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) {        
        
        String fromPath = req.getRequestURI().substring(req.getContextPath().length());
        String toPath = null;
        
        if(fromPath.equals("/cart.do")) {                  

            List<NuserCartDTO> nCartList = orderService.showNuserCart();   
            req.setAttribute("cartList", nCartList); 
            
            toPath = "/WEB-INF/view/order/cart.jsp";
            
        }else if(fromPath.equals("/addCart.do")) {
            
            int pId = Integer.parseInt(req.getParameter("pId"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            
            orderService.addCart(pId, quantity);
            
            req.setAttribute("msg", "장바구니에 넣었습니다~");
            req.setAttribute("url", "cart.do"); // 테스트 확인 차원에서 카트로 이동 
            toPath = "/WEB-INF/view/alert.jsp";
                        
        }else if(fromPath.equals("/deleteCart.do")) {
            
            int ncId = Integer.parseInt(req.getParameter("ncId"));
            orderService.deleteCart(ncId);
            
            req.setAttribute("msg", "장바구니에 있던 상품을 삭제했습니다~");
            req.setAttribute("url", "cart.do");                            
            toPath = "/WEB-INF/view/alert.jsp";
            
        }else if(fromPath.equals("/checkout.do")) {     
            
            List<NuserCartDTO> nCartList = orderService.showNuserCart();
            req.setAttribute("cartList", nCartList); 
            
            toPath = "/WEB-INF/view/order/checkout.jsp";
        }else if(fromPath.equals("/confirmation.do")) {                       
            
            toPath = "/WEB-INF/view/order/confirmation.jsp";
            
        }else if(fromPath.equals("/order.do")) {                       
            
            toPath = "/WEB-INF/view/order/order.jsp";
            
        }else {
            toPath = "/WEB-INF/view/error.jsp";
        }
        
        return toPath;       
    }

}