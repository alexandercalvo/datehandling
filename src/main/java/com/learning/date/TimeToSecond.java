package com.learning.date;

public class TimeToSecond {

	public  int calculateTime(int hour, int minute, int second) {
		int secondsElapsed = 0;
		secondsElapsed = (hour * 3600) + (minute * 60) + second;
		return secondsElapsed;
	}
	
	
}
