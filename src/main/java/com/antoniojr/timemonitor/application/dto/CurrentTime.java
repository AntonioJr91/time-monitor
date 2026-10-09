package com.antoniojr.timemonitor.application.dto;

public record CurrentTime(
        String abbreviation,
        String datetime,
        Integer dayOfWeek,
        Integer dayOfYear,
        Boolean dst,
        String dstFrom,
        Integer dstOffset,
        String dstUntil,
        Integer rawOffset,
        String timezone,
        Long unixtime,
        String utcDatetime,
        String utcOffset,
        Integer weekNumber,
        String clientIp
) {
}
