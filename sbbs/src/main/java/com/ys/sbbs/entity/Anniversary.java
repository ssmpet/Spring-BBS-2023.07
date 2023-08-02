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
public class Anniversary {

	private int aid;
	private String aname;
	private String adate;
	private int isHoliday;
	
	public Anniversary(String aname, String adate, int isHoliday) {
		this.aname = aname;
		this.adate = adate;
		this.isHoliday = isHoliday;
	}
}
