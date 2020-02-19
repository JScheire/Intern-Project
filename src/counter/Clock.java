package counter;

public class Clock {
	
	public int hours;
	public int minutes;
	public int seconds;
	public boolean military;

	public Clock(int hours, int minutes, int seconds, boolean military) {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
		this.military = military;
	}
	
	public String timeFormat() {
		String hourString = String.format("%02d", hours);
		String minuteString = String.format("%02d", minutes);
		String secondString = String.format("%02d,", seconds);
		return (hourString + ":" + minuteString + ":" + secondString);
	}

		

}
