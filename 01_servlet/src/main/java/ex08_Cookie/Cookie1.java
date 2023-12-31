package ex08_Cookie;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cookie1
 */
@WebServlet("/cookie1")
public class Cookie1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cookie1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  /*
	   * 쿠키
	   * 1. 클라이언트측에 저장되는 정보를 의미
	   * 2. 보안에 취약하므로 개인정보같은 민감정보는 저장하지 않는다
	   */
	  
	  // 쿠키 만들기 ("쿠키이름", "값")
	  Cookie cookie1 = new Cookie("name", "홍길동");
	  Cookie cookie2 = new Cookie("age", "20"); // 모든 쿠키 값은 String 타입으로만 저장 가능
	  Cookie cookie3 = new Cookie("address", URLEncoder.encode("서울특별시 종로구","UTF-8")); //공백 포함시 유효하지 않은 문자이므로 인코딩 필요
	  
	  // 쿠키가 저장될 경로 설정하기 (생략하면 컨텍스트패스 경로에 저장)
	  cookie1.setPath("/servlet"); //컨텍스트패스(request.getContextPath() 이용해서 알아낼 수 있음)에 저장
	  cookie2.setPath("/servlet/cookie1"); // 서블릿 경로(request.getRequestURI()로 알아낼 수 있음)에 저장
	  // cookie3은 경로 설정 생략했으므로 컨텍스트패스에 저장
	  
	  // 쿠키가 유지되는 시간 설정하기 (생략하면 세션쿠키가 된다 = 브라우저 닫으면 지워짐)
	  cookie1.setMaxAge(60 * 60); // 1시간
	  cookie2.setMaxAge(60 * 60 * 24 * 7); // 1주일
	  // cookie3은 시간 설정 생략했으므로 세션쿠키가 됨
	  
	  // 쿠키를 브라우저에 저장하기 (응답으로 처리)
	  response.addCookie(cookie1);
	  response.addCookie(cookie2);
	  response.addCookie(cookie3);
	  
	  // Cookie2 서블릿으로 redirect 이동
	  response.sendRedirect("/servlet/cookie2");
	  
	  
	  
	  
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
