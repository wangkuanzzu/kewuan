package com.wink.learn.jdk8.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * description: JDK8DateTime <br>
 * date: 2021/4/19 下午4:31 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class JDK8DateTime {

    public static void main(String[] args) {

        //获取今天日期
        LocalDate today = LocalDate.now();
        System.out.println("今天的日期="+today);

        //获取年月日
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();

        System.out.println("year:"+year);
        System.out.println("month:"+month);
        System.out.println("day:"+day);

        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("一周后的日期为:"+nextWeek);

        LocalDate nextMonth = today.plusMonths(1);
        System.out.println("一月后的日期为:"+nextMonth);

        LocalDate previousYear = today.minus(1, ChronoUnit.YEARS);
        System.out.println("一年前的日期 : " + previousYear);

        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("一年后的日期:"+nextYear);

        LocalDate tomorrow = LocalDate.of(2021,4,21);
        if(tomorrow.isAfter(today)){
            System.out.println("之后的日期:"+tomorrow);
        }

        LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);
        if(yesterday.isBefore(today)){
            System.out.println("之前的日期:"+yesterday);
        }

        //是否闰年
        if(today.isLeapYear()){
            System.out.println("This year is Leap year");
        }else {
            System.out.println("2021 is not a Leap year");
        }

        //计算两个日期间 月数或天数
        LocalDate java8Release = LocalDate.of(2021, 12, 14);
        Period periodToNextJavaRelease = Period.between(today, java8Release);
        System.out.println("Months left between today and Java 8 release : "
                + periodToNextJavaRelease.getMonths() );
        System.out.println("Days left between today and Java 8 release : "
                + periodToNextJavaRelease.getDays() );

        //获取当前时间
        LocalTime time = LocalTime.now();
        System.out.println("今天的时间="+time);

        //获取时分秒 毫秒
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        int nano = time.getNano();
        System.out.println("hour="+hour);
        System.out.println("minute="+minute);
        System.out.println("second="+second);
        System.out.println("nano="+nano);

        LocalTime localTime = time.plusHours(1).plusMinutes(1).plusSeconds(1).plusNanos(1);
        System.out.println("时间回溯 = " + localTime);

        LocalDate localDate = LocalDate.of(2021, 5, 20);
        LocalDate localDate1 = LocalDate.of(2021, Month.SEPTEMBER, 20);
        LocalDate localDate2 = LocalDate.ofYearDay(2021, 120);
        System.out.println("localDate = " + localDate);
        System.out.println("localDate1 = " + localDate1);
        System.out.println("localDate2 = " + localDate2);


        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.of(2018,2,5);
        if(date1.equals(date2)){
            System.out.println("时间相等");
        }else{
            System.out.println("时间不等");
        }

        LocalDate date3 = LocalDate.now();
        LocalDate date4 = LocalDate.of(2020,4,19);
        MonthDay birthday = MonthDay.of(date3.getMonth(),date3.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(date4);

        if(currentMonthDay.equals(birthday)){
            System.out.println("是你的生日");
        }else{
            System.out.println("你的生日还没有到");
        }

        // Returns the current time based on your system clock and set to UTC.
        Clock clock = Clock.systemUTC();
        System.out.println("Clock : " + clock.millis());

        // Returns time based on system clock zone
        Clock defaultClock = Clock.systemDefaultZone();
        System.out.println("Clock : " + defaultClock.millis());


        // Date and time with timezone in Java 8
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime localtDateAndTime = LocalDateTime.now();
        ZonedDateTime dateAndTimeInNewYork  = ZonedDateTime.of(localtDateAndTime, america );
        System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork);

        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());
        YearMonth creditCardExpiry = YearMonth.of(2021, Month.APRIL);
        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);


        Instant timestamp = Instant.now();
        System.out.println("What is value of this instant " + timestamp.toEpochMilli());

        String dayAfterTommorrow = "20210520";
        LocalDate formatted = LocalDate.parse(dayAfterTommorrow,
                DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(dayAfterTommorrow+"  格式化后的日期为:  "+formatted);


        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        //日期转字符串
        String strFromDate = date.format(format1);

        System.out.println("日期时间转换为字符串:"+strFromDate);

        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        //字符串转日期
        LocalDate dateFromStr = LocalDate.parse(strFromDate,format2);
        System.out.println("字符串转换日期类型:"+dateFromStr);
        LocalDateTime dateTimeFromStr = LocalDateTime.parse(strFromDate, format2);
        System.out.println("字符串转换日期时间类型:"+dateTimeFromStr);
    }
}
