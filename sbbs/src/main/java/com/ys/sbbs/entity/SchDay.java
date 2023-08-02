package com.ys.sbbs.entity;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class SchDay {
	private int day;
	private int date;	// 요일 (0-일요일, ..., 6-토요일)
	private int isHoliday;
	private int isOtherMonth;
	private String sdate;		// 20230214
	private List<String> annivList;
	private List<Schedule> schedList;
}
