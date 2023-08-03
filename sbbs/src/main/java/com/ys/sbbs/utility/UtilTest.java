package com.ys.sbbs.utility;

import java.util.List;

import com.ys.sbbs.entity.Anniversary;

public class UtilTest {

	public static void main(String[] args) {
//		AsideUtil au = new AsideUtil();
//		
//		String roadAddr =  au.getRoadAddr("경기도 수원시 장안구청");
////		System.out.println(roadAddr);
//		
//		List<String> list = au.getGeoCode(roadAddr);
//		String lon = list.get(0);
//		String lat = list.get(1);
//		
////		System.out.println("위도 : " + lat + ", 경도 : " + lon );
//		
//		System.out.println(au.getWeather(lon, lat));

		// 휴일 정보 가져오기 테스트
		SchedUtil su = new SchedUtil();
		
		List<Anniversary> list = su.getAnnivList("24절기", 2023);
		
		for ( Anniversary ann : list ) {
			System.out.println(ann.getAname() + ", " + ann.getAdate() + ", " + ann.getIsHoliday() );
		}

	}

}
