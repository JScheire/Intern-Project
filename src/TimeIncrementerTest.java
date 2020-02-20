import static org.junit.jupiter.api.Assertions.*;

class TimeIncrementerTest {

    @org.junit.jupiter.api.Test
    void testDisplayTime() {
        TimeIncrementer counter = new TimeIncrementer(13, 32, 15, true);
        assertEquals("13:32:15", counter.displayTime());
    }

    @org.junit.jupiter.api.Test
    void testNonMilitaryTime() {
        TimeIncrementer counter = new TimeIncrementer(13, 32, 15, false);
        assertEquals("01:32:15 PM", counter.displayTime());
    }

    @org.junit.jupiter.api.Test
    void testIncrementHour() {
        TimeIncrementer counter = new TimeIncrementer(13, 32, 15, true);
        counter.incrementHour();
        assertEquals(14, counter.hours);
    }

    @org.junit.jupiter.api.Test
    void testIncrementMinute() {
        TimeIncrementer counter = new TimeIncrementer(13, 32, 15, true);
        counter.incrementMinute();
        assertEquals(33, counter.minutes);
    }

    @org.junit.jupiter.api.Test
    void testIncrementSecond() {
        TimeIncrementer counter = new TimeIncrementer(13, 32, 15, true);
        counter.incrementSecond();
        assertEquals(16, counter.seconds);
    }

    @org.junit.jupiter.api.Test
    void testDecrementHour() {
        TimeIncrementer counter = new TimeIncrementer(13, 32, 15, true);
        counter.decrementHour();
        assertEquals(12, counter.hours);
    }

    @org.junit.jupiter.api.Test
    void testDecrementMinute() {
        TimeIncrementer counter = new TimeIncrementer(13, 32, 15, true);
        counter.decrementMinute();
        assertEquals(31, counter.minutes);
    }

    @org.junit.jupiter.api.Test
    void testDecrementSecond() {
        TimeIncrementer counter = new TimeIncrementer(13, 32, 15, true);
        counter.decrementSecond();
        assertEquals(14, counter.seconds);
    }

    @org.junit.jupiter.api.Test
    void testIncrementHourRollover() {
        TimeIncrementer counter = new TimeIncrementer(23, 32, 15, true);
        counter.incrementHour();
        assertEquals("00:32:15", counter.displayTime());
    }

    @org.junit.jupiter.api.Test
    void testIncrementMinuteRollover() {
        TimeIncrementer counter = new TimeIncrementer(23, 59, 15, true);
        counter.incrementMinute();
        assertEquals("00:00:15", counter.displayTime());
    }

    @org.junit.jupiter.api.Test
    void testIncrementSecondRollover() {
        TimeIncrementer counter = new TimeIncrementer(23, 59, 59, true);
        counter.incrementSecond();
        assertEquals("00:00:00", counter.displayTime());
    }

    @org.junit.jupiter.api.Test
    void testDecrementHourRollover() {
        TimeIncrementer counter = new TimeIncrementer(0, 32, 15, true);
        counter.decrementHour();
        assertEquals("23:32:15", counter.displayTime());
    }

    @org.junit.jupiter.api.Test
    void testDecrementMinuteRollover() {
        TimeIncrementer counter = new TimeIncrementer(1, 0, 15, true);
        counter.decrementMinute();
        assertEquals("00:59:15", counter.displayTime());
    }

    @org.junit.jupiter.api.Test
    void testDecrementSecondRollover() {
        TimeIncrementer counter = new TimeIncrementer(1, 1, 0, true);
        counter.decrementSecond();
        assertEquals("01:00:59", counter.displayTime());
    }

    @org.junit.jupiter.api.Test
    void testRollover() {
        TimeIncrementer counter = new TimeIncrementer(23, 59, 59, true);
        counter.incrementSecond();
        assertEquals("00:00:00", counter.displayTime());
    }

    @org.junit.jupiter.api.Test
    void testRollunder() {
        TimeIncrementer counter = new TimeIncrementer(0, 0, 0, true);
        counter.decrementSecond();
        assertEquals("23:59:59", counter.displayTime());
    }

}