<%@page import="ex04_el.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--
  Jsp binding 영역 (어떤 값을 속성(Attribute)의 형태로 저장할 때 사용하는 영역)
  1. pageContext : this, 현재 페이지에서만 접근 가능
  2. request : HttpServletRequest, 응답 전까지 접근 가능
  3. session : HttpSession, 브라우저를 닫기 전까지 접근 가능
  4. application : ServletContext, 애플리케이션 종료 전까지 접근 가능
  
  Jsp binding 우선 순위 (동일한 이름의 속성이 서로 다른 영역에 존재하는 경우 사용 우선순위)
  높음                               낮음
  pageContext > request > session > application
  
  Jsp binding 영역에 저장된 속성(Attribute)은 모두 표현언어(EL)로 표현할 수 있음
  
 --%>

  <%--
    표현언어(EL)
    1. Expression Language
    2. binding 영역에 저장된 값을 나타낼 때 사용할 수 있는 언어
    3. Jsp 표현식 <%=값%>을 대체할 수 있음
    4. 형식 
      ${값}
    5. binding 영역 EL 내장 객체
      1) pageContext를 의미하는 pageScope 객체
      2) request를 의미하는 requestScope 객체
      3) session을 의미하는 sessionScope 객체
      4) application을 의미하는 applicationScope 객체  
   --%>
   
   <%-- 각 영역에 속성 msg 저장하기 --%>
   <%
     pageContext.setAttribute("msg", "pageContext");
     request.setAttribute("msg", "request");
     session.setAttribute("msg", "session");
     application.setAttribute("msg", "application");
   %>
   
   <%-- 우선 순위 확인하기 (가장 높은 우선순위 pageContext가 나옴) --%>
   <div>${msg}</div>
   
   <%-- 각 영역의 속성 확인하기 --%>
   <div>${pageScope.msg}</div>
   <div>${requestScope.msg}</div>
   <div>${sessionScope.msg}</div>
   <div>${applicationScope.msg}</div>
   
   <%-- 객체 사용하기 --%>
   <%
    // 객체를 만든 뒤 EL 사용이 가능한 binding 영역에 넣는다
    Person person = new Person();
    person.setName("홍길동");
    person.setAge(30);
    pageContext.setAttribute("person", person);
   %>
   <div>이름: ${person.name}</div> <%-- EL은 person.name을 person.getName() 방식으로 호출해서 보여줌 --%>
   <div>나이: ${person.age}</div> <%-- EL은 person.age를 person.getAge() 방식으로 호출해서 보여줌 --%>
</body>
</html>