package com.kotlin.library.utils

import java.time.ZoneOffset
import java.time.*
import java.time.format.DateTimeFormatter
import java.sql.Timestamp
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import java.text.SimpleDateFormat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.*

@Service
class DateUtils {    
    
    @Value("\${formatter.date-time}")
    private var default_formatter_date_time = ""

    @Value("\${formatter.date}")
    private var default_formatter_date = ""
    
    private val thaiLocale = Locale("th", "TH")

    private val timeZone = TimeZone.getTimeZone("Asia/Bangkok")

    fun currentDateTime() : Timestamp{
        val simpleDateFormat = SimpleDateFormat(default_formatter_date_time)
        simpleDateFormat.timeZone = timeZone
        val date = simpleDateFormat.parse(currentDateTimeStr())
        return Timestamp(date.time)
    }

    fun currentDateTimeStr(): String {
        val currentDate = LocalDateTime.now()
        return currentDate.format(thaiDateTimeFormatter(default_formatter_date_time))
    }

    fun currentDate() : Date {
        val simpleDateFormat = SimpleDateFormat(default_formatter_date)
        simpleDateFormat.timeZone = timeZone
        return simpleDateFormat.parse(simpleDateFormat.format(Date()))
    }

    fun currentDateStr() : String {
        val currentDate = LocalDateTime.now()
        return currentDate.format(thaiDateTimeFormatter(default_formatter_date))
    }

    private fun thaiDateTimeFormatter(format: String): DateTimeFormatter {
        return DateTimeFormatter.ofPattern(format)
    }
}