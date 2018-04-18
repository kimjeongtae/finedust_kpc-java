<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
<head>
	<title>Let's make a beautiful world.</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="assets/css/main.css" />
	<link rel="stylesheet" href="assets/css/noscript.css" />
	<link rel="stylesheet" href="assets/css/w3.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/g/jquery.owlcarousel@1.31(owl.carousel.css+owl.theme.css)">
  	<link rel="stylesheet" href="https://cdn.jsdelivr.net/fontawesome/4.6.3/css/font-awesome.min.css">
	<link href="themes/5/js-image-slider.css" rel="stylesheet" type="text/css" />
		<style>
		    .map_wrap {position:relative;width:100%;height:500px;}
		    .title {font-weight:bold;display:block;}
		    .hAddr {position:absolute;left:10px;top:10px;border-radius: 2px;background:#fff;background:rgba(255,255,255,0.8);z-index:1;padding:5px;}
		    #centerAddr {display:block;margin-top:2px;font-weight: normal;}
		    .bAddr {padding:5px;text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
	</style>
	<script src="themes/5/js-image-slider.js" type="text/javascript"></script>
	<script type="text/javascript">
	   window.onload = function(){
		      selectGu('종로구');
		   }
	</script>
	<script type="text/javascript">
		function selectGu(v){
			var xhttp = new XMLHttpRequest();
			 xhttp.onreadystatechange = function() {
	             if (this.readyState == 4 && this.status == 200) {
	                 document.getElementById("predTable").innerHTML = this.responseText;
	             }
	          };
	          xhttp.open("GET", "dust.do?currLoc="+v, true);
	          xhttp.send();
	   }
	</script>
	
	<script type="text/javascript">
		function makeGraphics(){
			var currLoc=	document.getElementById("demo-category").value;
			var xhttp = new XMLHttpRequest();
			 xhttp.onreadystatechange = function() {
	             if (this.readyState == 4 && this.status == 200) {
	                 document.getElementById("Graphics_").innerHTML = this.responseText;
	             }
	          };
	          xhttp.open("GET", "graphic.do?currLoc="+currLoc, true);
	          xhttp.send();
	   }
	</script>
	
	<script type="text/javascript">
		function makeOutdoor(){
			var xhttp = new XMLHttpRequest();
			 xhttp.onreadystatechange = function() {
	             if (this.readyState == 4 && this.status == 200) {
	                 document.getElementById("Outdoor_").innerHTML = this.responseText;
	             }
	          };
	          xhttp.open("GET", "outdoor.do", true);
	          xhttp.send();
	   }
	</script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=15170a23809bf685a1f7359d93116e53"></script>
<script type="text/javascript">
function makeMap(){
	var loc=	document.getElementById("demo-category").value;
	
	var loc_list= {
	"강남구":{"lat":	37.50430125	,"lng":	127.0470316	},
	"강동구":{"lat":	37.54133948	,"lng":	127.1392141	},
	"강북구":{"lat":	37.63363443	,"lng":	127.0251299	},
	"강서구":{"lat":	37.54899457	,"lng":	126.8427036	},
	"관악구":{"lat":	37.48042886	,"lng":	126.9381584	},
	"광진구":{"lat":	37.54590901	,"lng":	127.0809986	},
	"구로구":{"lat":	37.49412458	,"lng":	126.8752064	},
	"금천구":{"lat":	37.46232943	,"lng":	126.8991631	},
	"노원구":{"lat":	37.64591511	,"lng":	127.0690267	},
	"도봉구":{"lat":	37.65793235	,"lng":	127.0390176	},
	"동대문구":{"lat":	37.5795089	,"lng":	127.0553336	},
	"동작구":{"lat":	37.49736067	,"lng":	126.94826	},
	"마포구":{"lat":	37.55225658	,"lng":	126.9296715	},
	"서대문구":{"lat":	37.57143667	,"lng":	126.9410706	},
	"서초구":{"lat":	37.49060608	,"lng":	127.0121622	},
	"성동구":{"lat":	37.55290223	,"lng":	127.0405071	},
	"성북구":{"lat":	37.60095481	,"lng":	127.0268697	},
	"송파구":{"lat":	37.50317851	,"lng":	127.1151609	},
	"양천구":{"lat":	37.52829561	,"lng":	126.8577697	},
	"영등포구":{"lat":	37.51428775	,"lng":	126.9056879	},
	"용산구":{"lat":	37.53644415	,"lng":	126.9779118	},
	"은평구":{"lat":	37.60743639	,"lng":	126.9180419	},
	"종로구":{"lat":	37.58015996	,"lng":	126.9913688	},
	"중구":{"lat":	37.5610545	,"lng":	127.0037654	},
	"중랑구":{"lat":	37.59565223	,"lng":	127.0881415	}
	}
	
	var lat=loc_list[loc].lat;
	var lng=loc_list[loc].lng;
	
   var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
         if (this.readyState == 4 && this.status == 200) {
               var positions = eval(this.responseText);
               //alert(positions[0].latlng);
               //alert(this.responseText);
              var mapContainer = document.getElementById('map'); // 지도를 표시할 di
              var mapOption = {
                    center: new daum.maps.LatLng(lat, lng), // 지도의 중심좌표
                    level: 7 // 지도의 확대 레벨
                    };
              var map = new daum.maps.Map(mapContainer, mapOption);
              
                     
              var imgSrc = 'icon/pin.png';//마커 생성
              for (var i = 0; i < positions.length; i ++) {//마커를 생성합니다
                 var imageSize = new daum.maps.Size(22, 25); // 마커 이미지의 이미지 크기 입니다
                 var markerImage = new daum.maps.MarkerImage(imgSrc, imageSize); // 마커 이미지를 생성합니다 
                 var marker = new daum.maps.Marker({// 마커를 생성합니다
                    map: map, // 마커를 표시할 지도
                      position: positions[i].latlng, // 마커를 표시할 위치
                      title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                      image : markerImage // 마커 이미지 
                 });
              }
         }
      };

      xhttp.open("GET", "indoor.do?currLoc="+loc, true);
      xhttp.send();
}

</script>
</head>

<body>
	<!-- ="location.href='dust.do?'" -->
	<div id="wrapper">
		<header id="header">
			<h2>미세, 美世</h2>
				<div class="content">
				<p>
				<div style="text-align:right">
				<div class="select-wrapper"  style="width: 25%; right: 0px; ">
					<select id="demo-category" onchange="selectGu(this.value)">
						<option value="강남구" >강남구</option>
						<option value="강동구">강동구</option>
						<option value="강북구">강남구</option>
						<option value="강서구">강서구</option>
						<option value="관악구">관악구</option>
						<option value="광진구">광진구</option>
						<option value="구로구">구로구</option>
						<option value="금천구">금천구</option>
						<option value="노원구">노원구</option>
						<option value="도봉구">도봉구</option>
						<option value="동대문구">동대문구</option>
						<option value="동작구">동작구</option>
						<option value="마포구">마포구</option>
						<option value="서대문구">서대문구</option>
						<option value="서초구">서초구</option>
						<option value="성동구">성동구</option>
						<option value="성북구">성북구</option>
						<option value="송파구">송파구</option>
						<option value="양천구">양천구</option>
						<option value="영등포구">영등포구</option>
						<option value="용산구">용산구</option>
						<option value="은평구">은평구</option>
						<option value="종로구" selected="selected">종로구</option>
						<option value="중구">중구</option>
						<option value="중랑구">중랑구</option>
					</select>
					</div>
			</div>

				<div class="inner">
				<div  id="predTable">
				</div>
				</div>
			</div>
			<nav>
				<ul>
					<li><a href="#intro">Intro</a></li>
					<li><a href="#Graphics" onclick="makeGraphics()">Graphics</a></li>
					<li><a href="#Indoor" onclick="makeMap()">Indoor</a></li>
					<li><a href="#Outdoor" onclick="makeOutdoor()">Outdoor</a></li>
					<li><a href="#contact">Contact</a></li>
					<!--<li><a href="#elements">Elements</a></li>-->
				</ul>
			</nav>
		</header>

		<!-- Main -->
		<div id="main">

			<!-- Intro -->
			<article id="intro">
				<h2 class="major">Intro : 분석배경</h2>
				<span class="image main"></span>
				
				<p>최근 들어 황사, 미세먼지, 초미세먼지 등 대기오염과 관련된 용어들이 각종 매체를 통해 연일 다뤄지고 있습니다. 몇 년 전만 해도 생소했던 이런 용어들이 날씨 예보와 함께 모든 뉴스 채널에서 전파를 타고 있습니다. 매스컴에서 언급되는 만큼 일반 시민들의 관심이 높아지고 있습니다.
				<p>우리가 몸이 아파서 병원에 가면 문진표 작성부터 시작하여 CT, MRI 등 다양한 검사를 바탕으로 진단을 내리고 그에 맞는 적절한 치료 방법을 찾듯이 미세먼지 현상도 다양한 진단을 통해 그 원인을 정확히 판단해야 개선이 가능합니다. 중앙 정부뿐 아니라 각 지자체에서도 미세먼지 성분을 분석하는 등 근본 원인을 밝혀내기 위한 측정망을 순차적으로 구축하고 있습니다.
				<p>결국 미세먼지 발생에 대한 원인 분석과 개선을 위한 정책 시행까지는 앞으로도 상당한 시일이 사료되며, 당분간은 시민들 스스로 고농도 미세먼지를 최대한 피해 생활하려는 노력이 필요합니다.
				<p> "몇 년 전 까지도 생소했던 미세먼지, 이제는 우리 삶과 행복을 위협하는 존재가 되었습니다. 언제 어디서 불어올지 모르는 미세먼지, <a> < 미세,美世 ></a> 의 합리적 분석과 예측 시스템을 통해 완벽한 하루를 만들어드리겠습니다."
			</article>

			<!-- Infographic -->
			<article id="Graphics">
				<h2 class="major">Graphics : 시각화</h2>
				<div id="Graphics_"></div>
			</article>

			<!-- Indoor -->
				<article id="Indoor">
					<span class=""></span>
					<h2 class="major">Indoor : 실내추천</h2>
					<i class="icon fa-refresh fa-2x fa-fw" style="right: 2.2rem; position:absolute;" onclick="makeMap()"></i>
					<p>
					<br>
					<div id="map" style="width:100%;height:500px;position:relative;"></div>
					<br>
				</article>


			<!-- Outdoor -->
			<article id="Outdoor">
				<h2 class="major">Outdoor :실외추천</h2>
				<i class="icon fa-refresh fa-2x fa-fw" onclick="makeOutdoor()" style="right: 2.2rem; position:absolute;"></i>
				<p>
				<br>
				<p>
				<div id="Outdoor_"></div>
			</article>

			<!-- Contact -->
			<article id="contact">
					<h2 class="major">Contact</h2>
						<form method="post" action="#">
							<div class="field half first">
								<label for="name">Name</label>
								<input type="text" name="name" id="name" />
							</div>
						<div class="field half">
								<label for="email">Email</label>
								<input type="text" name="email" id="email" />
							</div>
								<div class="field">
									<label for="message">Message</label>
									<textarea name="message" id="message" rows="4"></textarea>
								</div>
								<ul class="actions">
									<li><input type="submit" value="Send Message" class="special" /></li>
									<li><input type="reset" value="Reset" /></li>
								</ul>
							</form>
							<ul class="icons">
								<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
								<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
								<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
								<li><a href="#" class="icon fa-github"><span class="label">GitHub</span></a></li>
							</ul>
					</article>
	
		</div>

		<!-- Footer -->
		<footer id="footer">
			<p class="copyright">
				&copy; KPC, BIG DATA: <a href="https://html5up.net">TEAM 4</a>,
				JUNGLE.
			</p>
		</footer>

	</div>

	<!-- BG -->
	<div id="bg"></div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>
	<script defer src="https://use.fontawesome.com/releases/v5.0.9/js/all.js" integrity="sha384-8iPTk2s/jMVj81dnzb/iFR2sdA7u06vHJyyLlAd4snFpCl/SnyUjRrbdJsw1pGIl" crossorigin="anonymous"></script>	

</body>
</html>
