package com.lgcns.example.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class TimeCalculation {

	public static void main(String[] args) {
		ZonedDateTime time1 = ZonedDateTime.now();
		int year = 2020;
		int month = 6;
		int dayOfMonth = 25;
		int hour = 14;
		int minute = 0;
		int second = 0;
		int nanoOfSecond = 0;
		ZoneId zone =  ZoneId.systemDefault();
		System.out.println(String.format("zone.getId():%s, zone.toString():%s", zone.getId(), zone.toString()));
		ZonedDateTime time2 = ZonedDateTime.of(year, month, dayOfMonth, hour, minute, second, nanoOfSecond, zone);
		ZonedDateTime time3 = time2.plusSeconds(30);
		
		long between1 = ChronoUnit.SECONDS.between(time1, time2);
		System.out.println("time1, time2 between=" + between1);
		
		long between2 = ChronoUnit.SECONDS.between(time2, time3);
		System.out.println("time2, time3 between=" + between2);
		
	}

}
