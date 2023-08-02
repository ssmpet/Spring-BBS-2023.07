package com.ys.sbbs.entity;

import java.time.LocalDateTime;

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
public class Schedule {
	private int sid;
	private String uid;
	private String sdate;
	private String title;
	private String place;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private int isImportant;
	private String memo;
	
	public Schedule(String uid, String sdate, String title, String place, LocalDateTime startTime,
			LocalDateTime endTime, int isImportant, String memo) {
		this.uid = uid;
		this.sdate = sdate;
		this.title = title;
		this.place = place;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isImportant = isImportant;
		this.memo = memo;
	}
}
