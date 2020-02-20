public class TimeIncrementer {

    public int hours;
    public int minutes;
    public int seconds;
    public boolean military;

    public TimeIncrementer(int hours, int minutes, int seconds, boolean military) {

        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;

        if (military)
            this.military = true;
        else
            this.military = false;

    }

    public String displayTime() {

        String hourString = String.format("%02d", hours);
        String minuteString = String.format("%02d", minutes);
        String secondString = String.format("%02d", seconds);
        if(military) {
            return hourString + ":" + minuteString + ":" + secondString;
        }
        else {
            if(hours < 12)
                return String.format("%02d", hours) + ":" + minuteString + ":" + secondString + " " + "AM";
            else
                return String.format("%02d", hours - 12) + ":" + minuteString + ":" + secondString + " " + "PM";
        }
    }

    public void incrementHour() {
        hours++;
        if(hours == 24) {
            hours = 0;
        }
    }

    public void incrementMinute() {
        minutes++;
        if(minutes == 60) {
            minutes = 0;
            incrementHour();
        }
    }

    public void incrementSecond() {
        seconds++;
        if(seconds == 60) {
            seconds = 0;
            incrementMinute();
        }
    }

    public void decrementHour() {
        hours--;
        if(hours == -1) {
            hours = 23;
        }
    }

    public void decrementMinute() {
        minutes--;
        if(minutes == -1) {
            minutes = 59;
            decrementHour();
        }
    }

    public void decrementSecond() {
        seconds--;
        if(seconds == -1) {
            seconds = 59;
            decrementMinute();
        }
    }
}
