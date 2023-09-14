<%-- 
  지시어(directive) 
  1. page : page 설정, Java class import
  2. include : 다른 페이지를 현재 페이지에 포함할 때 사용
  3. taglib : JSTL(Java Standard Tag Library) 사용할 때 사용
--%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- HTML 주석 : "소스 보기"에서 보임, Java 관련 코드 주석처리 불가능 -->
<%-- JSP 주석 : "소스 보기"에서 안보임, Java 관련 코드 주석처리 가능--%>


<%-- 스크립트릿(scriptlet): Java 코드는 스크립트릿<% %>안에 넣음 --%>
<% int a = 10; %>

<%-- 표현식(expression): Java 값(변수, 반환값이 있는 메소드 호출) --%>
<div><%=a%></div>


<%-- 선언부(declaration): Java 메소드 정의 --%>
<%! 
  // 0~9 사이의 난수를 반환하는 getRandom() 메소드 정의하기
  public int getRandom(){
    return (int)(Math.random()*10);
  }
%>
<div>0~9 사이 난수: <%=getRandom()%></div>

<%-- 
  Java와 JavaScript의 관계 
  1. Java 변수를 JavaScript에서 사용할 수 있음
  2. JavaScript 변수를 Java에서 사용할 수 없음
--%>
<%-- Java 변수 선언 --%>
<%String msg="Hello World"; %>
<%-- Java 변수를 JavaScript에서 사용하기 --%>
<script>
  alert('<%=msg%>');
</script>

<%-- 연습1. 이름과 나이를 변수에 저장한 뒤 보여주기 --%>
<%
  String name = "홍길동";
  int age = 30;
%>
<ul>
  <li>이름: <%=name%></li>
  <li>나이: <%=age%></li>
</ul>

<%-- 연습2. getRandom() 호출 결과가 5 이상이면 큰 수 아니면 작은 수를 출력 --%>
<% if(getRandom()>=5){ %>
<div>큰 수</div>
<% } else { %>
<div>작은 수</div>
<% } %>


<%-- 연습3. <select> 태그에 1월~12월까지 등록해서 출력 --%>
<div>
  <select name="month">
    <% for(int month =1; month<=12; month++){ %>
      <option value="<%=month%>"><%=month%>월</option>
      <% } %>
  </select>
</div>

<%-- 연습4. 현재 날짜를 yyyy-MM-dd 형식의 문자열로 반환하는 getToday() 메소드를 만들고 호출 --%>
<%!
  public String getToday(){
    LocalDate today = LocalDate.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return dtf.format(today);
}
%>
<div>현재날짜: <%=getToday()%></div>
</body>
</html>