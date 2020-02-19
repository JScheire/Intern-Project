package counter;

public class TimeIncrementer {
	
	public Clock setTime(int hour, int minute, int second) {
		return new Clock(hour, minute, second);
	}
	
	public void displayTime(Clock currentTime) {
		System.out.println(currentTime.timeFormat());
	}
	
	public Clock incrementHour(Clock currentTime) {
		Clock newTime = new Clock(currentTime.hours+1, currentTime.minutes, currentTime.seconds);
		return newTime;
		if(newTime.isMilitary() && newTime.hours == 24) {
			return new Clock(0,0,0);
		}
	}
	
	public Clock incrementMinutes(Clock currentTime) {
		Clock newTime = new Clock(currentTime.hours, currentTime.minutes+1, currentTime.seconds);
		if(newTime.minutes == 60) {
			newTime.hours++;
			newTime.minutes = 0;
			if(newTime.isMilitary() && newTime.hours == 24) {
					return new Clock(0,0,0);
				}
			}
		return newTime;
	}
	
	public Clock incrementSeconds(Clock currentTime) {
		Clock newTime = new Clock(currentTime.hours, currentTime.minutes, currentTime.seconds+1);
		if(newTime.seconds == 60) {
			newTime.minutes++;
			newTime.seconds = 0;
			if(newTime.minutes == 60) {
				newTime.hours++;
				newTime.minutes = 0;
				if(newTime.isMilitary() && newTime.hours == 24) {
						return new Clock(0,0,0);
					
				}
			}
		}
		return newTime;
	}
	
}
