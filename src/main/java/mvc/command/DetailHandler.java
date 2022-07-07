package mvc.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.ReviewDTO;
import model.dto.UserCartDTO;
import model.service.ReviewService;
import mvc.command.CommandHandler;

public class DetailHandler implements CommandHandler {
    
    ReviewService reviewServie = ReviewService.getInstance();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		//req.setAttribute("hello", "안녕하세요!");
	    // 리뷰관련
	    int pId = Integer.parseInt(req.getParameter("pId"));
	    List<ReviewDTO> reviewList = reviewServie.showReviewList(pId);   
        req.setAttribute("reviewList", reviewList);
	    
		return "/WEB-INF/view/shop/productDetail.jsp";
	}

}
