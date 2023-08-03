package com.ys.sbbs.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ys.sbbs.entity.Anniversary;

@Service
public class SchedUtil {

	@Value("${holidaysApiKey}") private String holidaysApiKey;
	
	public boolean isLeapYear(int year) {
		if (year % 400 == 0)
			return true;
		if (year % 100 == 0)
			return false;
		if (year % 4 == 0)
			return true;
		return false;
	}

	public List<String> genTime() {
		List<String> list = new ArrayList<>();
		for (int hour=0; hour<24; hour++)
			for (int min=0; min<60; min+=30)
				list.add(String.format("%02d:%02d", hour, min));
		return list;
	}
	
	public List<Anniversary> getAnnivList(String option, int year) {
		
		String baseUrl = "http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/";

//		String[] gList = {"getRestDeInfo", "getAnniversaryInfo", "get24DivisionsInfo", "getSundryDayInfo"};
		String info = option.equals("24절기") ? "get24DivisionsInfo" : "getRestDeInfo";
		String param = "?_type=json&numOfRows=80&solYear=";
		
		List<Anniversary> list = new ArrayList<>();
		
		try {
			
			String apiUrl = baseUrl + info + param + year + "&ServiceKey=" + holidaysApiKey;
			
			URL url = new URL(apiUrl);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
			
			String line = null, result = "";
			while ( (line=br.readLine( )) != null) {
				result += line;
			}
			br.close();
			
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject) parser.parse(result);
			JSONObject response = (JSONObject) obj.get("response");
			JSONObject body = (JSONObject) response.get("body");
			JSONObject items = (JSONObject) body.get("items");
			JSONArray item = (JSONArray) items.get("item");

			for (int i = 0; i < item.size(); i++ ) {
				JSONObject data = (JSONObject) item.get(i);

				String aname = (String) data.get("dateName");
				if (aname.equals("1월1일")) aname = "신정";
				if (aname.equals("기독탄신일")) aname = "크리스마스";
				long adate =  (long) data.get("locdate") ;
				String isHoliday = (String) data.get("isHoliday");
				
				list.add(new Anniversary(aname, ""+adate, isHoliday.equals("Y") ? 1 : 0));			
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
}
