package com.study.java8to11;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateTime {

    public static void main(String[] args) {

        // Instant.now()
        Instant instant = Instant.now();
        System.out.println(instant);    // 기준시 UTC, GMT
        System.out.println(instant.atZone(ZoneId.of("UTC")));

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);

        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        System.out.println(zonedDateTime);

        // LocalDateTime.now():
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime nowPlus = now.plus(10, ChronoUnit.DAYS);

        // LocalDateTime.of()
        LocalDateTime today = LocalDateTime.of(2021, Month.OCTOBER, 14, 19, 34, 00);
        System.out.println(today);

        // ZonedDateTime.now()
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInKorea);

        // Instant atZone
        Instant nowInstant = Instant.now();
        nowInstant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInstant);

        // Period
        LocalDate localDateNow = LocalDate.now();
        LocalDate thisYearLastDay = LocalDate.of(2021, Month.DECEMBER, 31);
        Period period = Period.between(localDateNow, thisYearLastDay);
        System.out.println(period.getDays());

        Period util = localDateNow.until(thisYearLastDay);
        System.out.println(util.get(ChronoUnit.DAYS));

        // Duration.between()
        Instant plus = nowInstant.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(nowInstant, plus);
        System.out.println(between.getSeconds());

        // DateTimeFormatter
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(now.format(MMddyyyy));

        // LocalDate.parse()
        LocalDate parse = LocalDate.parse("10/14/2021", MMddyyyy);
        System.out.println(parse);

        // legacy API
        Date date = new Date();
        Instant dateInstant = date.toInstant();
        Date newDate = Date.from(dateInstant);

        // GregorianCalendar -> Instant, LocalDateTime
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        LocalDateTime dateTime = gregorianCalendar
                .toZonedDateTime()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        // ZonedDateTime -> GregorianCalendar
        ZonedDateTime zone = gregorianCalendar
                .toZonedDateTime()
                .toInstant()
                .atZone(ZoneId.systemDefault());
        GregorianCalendar from = GregorianCalendar.from(zone);

        // java.util.TimeZone -> java.time.ZoneId
        ZoneId toZoneId = TimeZone.getTimeZone("PST").toZoneId();

        // java.time.ZoneId -> java.util.TimeZone
        TimeZone timeZone = TimeZone.getTimeZone(toZoneId);

    }
}
