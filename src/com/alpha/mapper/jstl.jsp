<%--
  Created by IntelliJ IDEA.
  User: oumar
  Date: 7/22/2021
  Time: 1:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%-- The different jstl tags--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<p></p>
<c:import url="home.jsp" var="alpha"/> //to inport or include
<c:out value="${alpha}"/>
<c:out value="${'Welcome to jstl'}"/> //to print out the string

<%--set--%>
<c:set value="20" var="alpha" scope="session"/>
<c:out value="${alpha}"/>

<%--remove--%>
<c:remove var="alpha"/> //remove the variable from the scope session
<c:out value="${alpha}"/> //alpha=null

<%--catch--%>
<c:catch var="alpha"><% int x=20/10 ;%></c:catch>
<c:if test="${alpha!=null}">
    <p>The exception is ${alpha.message}</p>
</c:if>

<%--choose  ,when, otherwise--%>
<c:choose>
    <c:when test="${alpha==10}"> The name is valuable</c:when>
    <c:when test="${alpha<9}"> The name is not valuable</c:when>
    <c:otherwise> The name is incorrect</c:otherwise>
</c:choose>

<%--foreach--%>
<c:forEach var="items" begin="1" end="5">
    The item<c:out value="items"/> <%-- item 1,item 2 , item 3 ,item 4, item 5--%>
</c:forEach>

<%--forTokens--%>
<c:forTokens items="Alpha-Oumar-Diallo" delims="-" var="name">
    <c:out value="${name}"/> <%-- Alpha Oumar Diallo in column (verticaly |)--%>
</c:forTokens>

<%--param--%>
<c:url value="home.jsp" var="alphaoumar">
    <c:param name="users" value="132"/>
    <c:param name="al" value="22"/>
</c:url>
<c:out value="${alphaoumar}"/>

<%--redirect--%>
<c:set var="url" value="0" scope="session"/>1
<c:if test="${url>0}" >
    <c:redirect url="home.jsp"/>
</c:if>
<c:if test="${url<0}">
    <c:redirect url="error.jsp"/>
</c:if>


<%--The jstl functions--%>
<c:set var="oumar" value="alphaoumar Diallo" />
<c:if test="${fn:contains(oumar, alphaoumar)}"> <p> The exception</p></c:if>
<c:if test="${fn:containsIgnoreCase(oumar, alphaoumar)}"> <p> The exception</p></c:if>
<c:if test="${fn:endsWith(oumar, alphaoumar)}"/>
<c:if test="${fn:indexOf(oumar, 'oumar')}"/>
<p>${fn:indexOf(oumar,"oumar")}</p>
<p>${fn:trim(oumar)}</p> <%--the output is alphaoumarDiallo--%>
<p>${fn:startsWith(oumar,"al" )}</p> //true
<p>${fn:split(oumar, " ")}</p>
<p>${fn:toLowerCase("ALPHA OUMAR DIALLO")}</p>
<p>${fn:toUpperCase(oumar)}</p>
<p>${fn:substring(oumar,5,9)}</p>
<p>${fn:substringAfter(oumar, "alpha")}</p>
<p>${fn:substringBefore(oumar, "Diallo")}</p>
<p>${fn:length(oumar)}</p>
<p>${fn:replace(oumar, "alphaoumar", "Bobacar")}

<%--The formatting tags--%>

<%--parseNumber--%>
<c:set var="amount" value="2725.252"/>
<fmt:parseNumber var="num" value="${amount}" type="number" >
        <c:out value="${num}"/><%--2725.252--%>
</fmt:parseNumber>
<fmt:parseNumber var="num" value="${amount}" type="number" integerOnly="true">
        <c:out value="${num}"/>  <%--2725--%>
</fmt:parseNumber>

<%--time zone and date, (parsing date)--%>
    <c:set var="date" value="<%=new java.util.Date()%>"/>
<c:forEach var="items" items="<%=java.util.TimeZone.getAvailableIDs()%>">
    <c:out value="${items}"/>
    <fmt:timeZone value="${items}">
    <%--  The different date formats  --%>
    <fmt:formatDate value="${date}"/>
    <fmt:formatDate value="${date}" dateStyle="short" timeStyle="short"/>
    <fmt:formatDate value="${date}" dateStyle="medium" timeStyle="medium"/>
    <fmt:formatDate value="${date}" dateStyle="long" timeStyle="long"/>
    </fmt:timeZone>
</c:forEach>
<%--    parsing the date--%>
<fmt:parseDate value="${date}" var="parsedDate" pattern="yyyy-MM-dd--HH-mm-ss"/>
<c:out value="${parsedDate}"/>

<%--formatNumber--%>
<fmt:formatNumber value="${amount}" type="currency"/>
<fmt:formatNumber value="${amount}" type="number" groupingUsed="true" />
<fmt:formatNumber value="${amount}" type="number" maxFractionDigits="1"/>
<fmt:formatNumber value="${amount}" type="number" maxIntegerDigits="7" />
<fmt:formatNumber value="${amount}" type="percent" maxIntegerDigits="6" />
<fmt:formatNumber value="${amount}" type="number" pattern="###.###$" /><%--重要--%>

<%--The sql tags--%>
<sql:setDataSource var="database" driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql//localhost/ssm"
                   user="root" password="bonjouroumar200"/>
<%--    query--%>
<sql:query dataSource="${database}" var="rs">
    select* from users;
</sql:query>
<%-- update--%>
<sql:update dataSource="${database}" var="rs">
    insert into users values(1,"alpha","M","Beijing");
</sql:update>


</body>
</html>
