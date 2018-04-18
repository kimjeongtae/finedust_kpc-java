<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<link rel="stylesheet" type="text/css" href="assets/css/content.css">
<img src="${requestScope.img1}" style="width:100%;"/>

<div class="thumbWrap">
<figure>
<div class="top-container"><br>
         <figcaption>
            <ul>
               <li>
                  <b>행사이름</b>
                  <span>${requestScope.festival_name}</span>
               </li>                           
               <li>
                  <b>행사기간</b>
                  <span>${requestScope.period}</span>
               </li>

               <li>
                  <b>위치</b>
                  <span>${requestScope.loc}</span>
               </li>
               <li>
                  <b>연 락 처</b>
                  <span>${requestScope.num}</span>
               </li>

               <li>
                  <b>홈페이지</b>
                  <span><a href="${requestScope.home}">${requestScope.home}</span></a>
               </li>
            </ul>
         </figcaption>
</div>
</figure>
</div>