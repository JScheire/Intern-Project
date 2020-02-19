package counter;

public class Clock {
	
	public int hours;
	public int minutes;
	public int seconds;

	public Clock(int hours, int minutes, int seconds) {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	public String timeFormat() {
		String hourString = String.format("%02d", hours);
		String minuteString = String.format("%02d", minutes);
		String secondString = String.format("%02d,", seconds);
		return (hourString + ":" + minuteString + ":" + secondString);
	}

		

}
