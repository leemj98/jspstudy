package ex08_Cookie;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cookie2
 */
@WebServlet("/cookie2")
public class Cookie2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cookie2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  // 요청한 곳의 모든 쿠키 가져오기 (골라서 가져올 수 없음)
	  Cookie[] cookies = request.getCookies();
	  
	  // 쿠키 확인하기
	  if(cookies != null) {
	    for (int i = 0; i < cookies.length; i++) {
	      // 쿠키 이름
	      String name = cookies[i].getName();
	      // 쿠키 값
	      String value = URLDecoder.decode(cookies[i].getValue(), "UTF-8"); //cookie3 인코딩해줬으니까 디코딩도 해주기
	      // 쿠키 경로
	      String path = cookies[i].getPath();
	      // 쿠키 유지시간
	      int expire = cookies[i].getMaxAge();
	      
	      System.out.println(name+","+value+","+path+","+expire);
      }
	  }
	  
	  // 쿠키 삭제 (같은 이름의 쿠키를 만든 뒤 쿠키 유지시간을 0으로 설정하고 저장(덮어쓰기))
	  Cookie cookie = new Cookie("name", "값은아무의미가없다"); //값은 어차피 지울거라서 아무렇게나
	  cookie.setMaxAge(0);
	  response.addCookie(cookie);
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
