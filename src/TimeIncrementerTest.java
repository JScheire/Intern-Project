import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TimeIncrementerTest {

    @Test
    void testDisplayTime() {
        TimeIncrementer counter = new TimeIncrementer(13, 32, 15);
        assertEquals("13:32:15", counter.displayTime(true));
    }

    @Test
    void testNonMilitaryTime() {
        TimeIncrementer counter = new TimeIncrementer(13, 32, 15);
        assertEquals("01:32:15 PM", counter.displayTime(false));
    }

    @Test
    void testIncrementHour() {
        TimeIncrementer counter = new TimeIncrementer(13, 32, 15);
        counter.incrementHour();
        assertEquals(14, counter.hours);
    }

    @Test
    void testIncrementMinute() {
        TimeIncrementer counter = new TimeIncrementer(13, 32, 15);
        counter.incrementMinute();
        assertEquals(33, counter.minutes);
    }

    @Test
    void testIncrementSecond() {
        TimeIncrementer counter = new TimeIncrementer(13, 32, 15);
        counter.incrementSecond();
        assertEquals(16, counter.seconds);
    }

    @Test
    void testDecrementHour() {
        TimeIncrementer counter = new TimeIncrementer(13, 32, 15);
        counter.decrementHour();
        assertEquals(12, counter.hours);
    }

    @Test
    void testDecrementMinute() {
        TimeIncrementer counter = new TimeIncrementer(13, 32, 15);
        counter.decrementMinute();
        assertEquals(31, counter.minutes);
    }

    @Test
    void testDecrementSecond() {
        TimeIncrementer counter = new TimeIncrementer(13, 32, 15);
        counter.decrementSecond();
        assertEquals(14, counter.seconds);
    }

    @Test
    void testIncrementHourRollover() {
        TimeIncrementer counter = new TimeIncrementer(23, 32, 15);
        counter.incrementHour();
        assertEquals("00:32:15", counter.displayTime(true));
    }

    @Test
    void testIncrementMinuteRollover() {
        TimeIncrementer counter = new TimeIncrementer(23, 59, 15);
        counter.incrementMinute();
        assertEquals("00:00:15", counter.displayTime(true));
    }

    @Test
    void testIncrementSecondRollover() {
        TimeIncrementer counter = new TimeIncrementer(23, 59, 59);
        counter.incrementSecond();
        assertEquals("00:00:00", counter.displayTime(true));
    }

    @Test
    void testDecrementHourRollover() {
        TimeIncrementer counter = new TimeIncrementer(0, 32, 15);
        counter.decrementHour();
        assertEquals("23:32:15", counter.displayTime(true));
    }

    @Test
    void testDecrementMinuteRollover() {
        TimeIncrementer counter = new TimeIncrementer(1, 0, 15);
        counter.decrementMinute();
        assertEquals("00:59:15", counter.displayTime(true));
    }

    @Test
    void testDecrementSecondRollover() {
        TimeIncrementer counter = new TimeIncrementer(1, 1, 0);
        counter.decrementSecond();
        assertEquals("01:00:59", counter.displayTime(true));
    }

    @Test
    void testRollover() {
        TimeIncrementer counter = new TimeIncrementer(23, 59, 59);
        counter.incrementSecond();
        assertEquals("00:00:00", counter.displayTime(true));
    }

    @Test
    void testRollunder() {
        TimeIncrementer counter = new TimeIncrementer(0, 0, 0);
        counter.decrementSecond();
        assertEquals("23:59:59", counter.displayTime(true));
    }

}