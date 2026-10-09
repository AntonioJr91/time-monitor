package com.antoniojr.timemonitor.infrastructure.adapter.out;

record TimeApiResponse(
        String abbreviation,
        String datetime,
        Integer day_of_week,
        Integer day_of_year,
        Boolean dst,
        String dst_from,
        Integer dst_offset,
        String dst_until,
        Integer raw_offset,
        String timezone,
        Long unixtime,
        String utc_datetime,
        String utc_offset,
        Integer week_number,
        String client_ip
) {
}
