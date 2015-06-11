var mapContainer = document.getElementById('divMap'), // 지도를 표시할 div
mapOption = {
	center : new daum.maps.LatLng(*, *), // 지도의 중심좌표
	level : 3
// 지도의 확대 레벨
};

var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

var imageSrc = 'bus.png', // 마커이미지의 주소입니다
imageSize = new daum.maps.Size(64, 69), // 마커이미지의 크기입니다
imageOption = {
	offset : new daum.maps.Point(27, 69)
}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

map.setZoomable(false);    


function setMarker(latitude, longitude){

	// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
	var markerImage = new daum.maps.MarkerImage(imageSrc, imageSize, imageOption),

	// 마커가 표시될 위치입니다
	markerPosition = new daum.maps.LatLng(latitude, longitude);

	// 마커를 생성합니다
	var marker = new daum.maps.Marker({
		position : markerPosition,
		image : markerImage
	});
	
    var moveLatLon = new daum.maps.LatLng(latitude, longitude);
    
    // 지도 중심을 이동 시킵니다
    map.setCenter(moveLatLon);
	
	marker.setMap(map);	
	


	
}
