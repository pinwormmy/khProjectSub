package mvc.command;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dto.MemberDTO;
import model.service.MemberService;

public class MemberHandler implements CommandHandler {
	
	MemberService memberService = MemberService.getInstance();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		
		String fromPath = req.getRequestURI().substring(req.getContextPath().length());
        String toPath = null;
        
        if(fromPath.equals("/login.do")) {            
            toPath = "WEB-INF/view/member/login.jsp";
            
        }else if(fromPath.equals("/submitLogin.do")){	
	    	
	    	MemberDTO member = new MemberDTO();
	    	HttpSession session = req.getSession();	    	
	    	
	    	String id = req.getParameter("mId");
	    	String pw = req.getParameter("pw");    
	    	String saveId = req.getParameter("saveId");
	    	
	    	member = memberService.submitLogin(id, pw);	 
	    	
	    	if(member != null) {	    		
	    		session.setAttribute("member", member);	
	    		
	    		// 아이디 저장 기능
	    		if(saveId != null) {
	                Cookie cookieSaveId = new Cookie("saveId",id);	                
	                cookieSaveId.setMaxAge(60*60*24*7); //(초단위 입력 = 7일)
	                res.addCookie(cookieSaveId);	                
	    		}
	    		
		    	toPath = "WEB-INF/view/index.jsp";
		    	    
	    	}else{
	    		req.setAttribute("msg", "로그인 오류!! 아디와 비번 확인해주세요~!");
                req.setAttribute("url", "login.do");    
	    		toPath = "WEB-INF/view/alert.jsp";
	    	}	  	
	    	
	    }else if(fromPath.equals("/logout.do")) {	        
	    
	    	HttpSession session = req.getSession();
    		session.invalidate();
            toPath = "WEB-INF/view/index.jsp";   
            
	    }else if(fromPath.equals("/signUp.do")) {
            toPath = "WEB-INF/view/member/signUp.jsp";   
            
	    }else if(fromPath.equals("/submitSignUp.do")) {
	    		        
	    	MemberDTO member = new MemberDTO();
	    	HttpSession session = req.getSession();
	    	
	    	member.setmId(req.getParameter("mId"));
	    	member.setPw(req.getParameter("pw"));
	    	member.setmName(req.getParameter("mName"));
	    	member.setEmail(req.getParameter("email"));
	    	member.setPhone(req.getParameter("phone"));
	    	member.setAddress(req.getParameter("address"));
	    	
	    	memberService.submitSignUp(member);
	    	
	    	req.setAttribute("msg", "회원가입되었습니다. 환영합니다~~~~");
            req.setAttribute("url", "index.do");    
                       
            session.setAttribute("member", member); // 회원가입 이후 해당 아이디로 로그인처리까지
            
    		toPath = "WEB-INF/view/alert.jsp";
            
	    }else if(fromPath.equals("/checkUniqueId.do")) {
	    	
	    	String inputedId = req.getParameter("mId");
	    	boolean result = memberService.checkUniqueId(inputedId);
	    	req.setAttribute("result", result);
	    	
	    	toPath = "WEB-INF/view/member/checkUniqueId.jsp";
	    	
	    }else if(fromPath.equals("/checkUniqueEmail.do")) {
            
            String inputedEamil = req.getParameter("email");
            boolean result = memberService.checkUniqueEmail(inputedEamil);
            req.setAttribute("result", result);
            
            toPath = "WEB-INF/view/member/checkUniqueEmail.jsp";
            
        }else if(fromPath.equals("/forgetPwd.do")) {
            toPath = "WEB-INF/view/member/forgetPwd.jsp";   
            
	    }else if(fromPath.equals("/changePwd.do")) {
            toPath = "WEB-INF/view/member/changePwd.jsp";
            
	    }else {
            toPath = "WEB-INF/view/error.jsp";
        }
		return toPath;
	}

}