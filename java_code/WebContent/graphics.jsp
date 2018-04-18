<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<img src="${requestScope.loc}" alt="" /></span>
<br><a>[현재 위치 (${requestScope.currLoc}) 미세먼지, 초미세먼지 추이]</a>
<img src="${requestScope.m25}" alt="" /></span>
<br><a>[서울 25개 행정구역 미세먼지 농도 3시간 예측]</a>
<img src="${requestScope.c25}" alt="" /></span>
<br><a>[서울 25개 행정구역 초미세먼지 농도 3시간 예측]</a>
<img src="${requestScope.map}" alt="" /></span>
<br><a>[전국 미세먼지 농도 분포도]</a>