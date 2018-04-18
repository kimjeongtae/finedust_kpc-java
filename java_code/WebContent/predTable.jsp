<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<h1>${requestScope.cmise}</h1>
<table>
	<tr>
		<td></td>
		<td>After an hour</td>
		<td>After two hours</td>
		<td>After three hours</td>
	</tr>
	<tr>
		<td>미세먼지</td>
		<td>${requestScope.pmise1}</td>
		<td>${requestScope.pmise2}</td>
		<td>${requestScope.pmise3}</td>
	</tr>
	<tr>
		<td>초미세먼지</td>
		<td>${requestScope.pchoMise1}</td>
		<td>${requestScope.pchoMise2}</td>
		<td>${requestScope.pchoMise3}</td>
	</tr>
</table>