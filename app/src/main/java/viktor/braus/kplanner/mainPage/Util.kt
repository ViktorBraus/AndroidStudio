package viktor.braus.kplanner.mainPage


import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import timber.log.Timber
import viktor.braus.kplanner.R
import viktor.braus.kplanner.entity.Plans
import java.text.SimpleDateFormat

/**
 * These functions create a formatted string that can be set in a TextView.
 */

/**
 * Returns a string representing the numeric quality rating.
 */

/**
 * Take the Long milliseconds returned by the system and stored in Room,
 * and convert it to a nicely formatted string for display.
 *
 * EEEE - Display the long letter version of the weekday
 * MMM - Display the letter abbreviation of the nmotny
 * dd-yyyy - day in month and full year numerically
 * HH:mm - Hours and minutes in 24hr format
 */
@SuppressLint("SimpleDateFormat")
fun convertLongToDateString(systemTime: Long): String {
    return SimpleDateFormat("EEEE MMM-dd-yyyy' Time: 'HH:mm")
            .format(systemTime).toString()
}

/**
 * Takes a list of SleepNights and converts and formats it into one string for display.
 *
 * For display in a TextView, we have to supply one string, and styles are per TextView, not
 * applicable per word. So, we build a formatted string using HTML. This is handy, but we will
 * learn a better way of displaying this data in a future lesson.
 *
 * @param   plans - List of all Plans in the database.
 * @param   resources - Resources object for all the resources defined for our app.
 *
 * @return  Spanned - An interface for text that has formatting attached to it.
 *           See: https://developer.android.com/reference/android/text/Spanned
 */

fun MondayFormat(plans: List<Plans>, resources: Resources): Spanned {
    val sb = StringBuilder()
    sb.apply{
        plans.forEach {
            if (it.EventDay == "Понеділок")
            {
                append(resources.getString(R.string.start_time))
                append("\t${(it.EventName)}<br>")
                append(resources.getString(R.string.end_time))
                if(it.Time != "Інтервал") {
                    append("\t${(it.Time)}<br>")
                }
                else
                {   append("\t${(it.Time)}<br>")
                    append("Початок: \t${(it.StartTime)}<br>")
                    append("Кінець: \t${(it.EndTime)}<br>")
                }
            }
        }
    }
    return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
}
fun MondayFormatDay(plans: List<Plans>):Spanned {
    val sb = StringBuilder()
    sb.apply {
        plans.forEach {
            if (it.EventDay == "Понеділок") {
                append("<b>Назва Події</b>")
                append("\t${(it.EventName)}<br>")
                append("<b>Час Події</b>")
                if (it.Time != "Інтервал") {
                    append("\t${(it.Time)}<br>")
                } else {
                    append("\t${(it.Time)}<br>")
                    append("Початок: \t${(it.StartTime)}<br>")
                    append("Кінець: \t${(it.EndTime)}<br>")
                }
            }
        }
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    }
}
fun TuesdayFormat(plans: List<Plans>, resources: Resources): Spanned {
        val sb = StringBuilder()
        sb.apply {
            plans.forEach {
                if (it.EventDay == "Вівторок") {
                    append(resources.getString(R.string.start_time))
                    append("\t${(it.EventName)}<br>")
                    append(resources.getString(R.string.end_time))
                    if (it.Time != "Інтервал") {
                        append("\t${(it.Time)}<br>")
                    } else {
                        append("\t${(it.Time)}<br>")
                        append("Початок: \t${(it.StartTime)}<br>")
                        append("Кінець: \t${(it.EndTime)}<br>")
                    }
                }
            }
        }
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    }

    fun WednesdayFormat(plans: List<Plans>, resources: Resources): Spanned {
        val sb = StringBuilder()
        sb.apply {
            plans.forEach {
                if (it.EventDay == "Середа") {
                    append(resources.getString(R.string.start_time))
                    append("\t${(it.EventName)}<br>")
                    append(resources.getString(R.string.end_time))
                    if (it.Time != "Інтервал") {
                        append("\t${(it.Time)}<br>")
                    } else {
                        append("\t${(it.Time)}<br>")
                        append("Початок: \t${(it.StartTime)}<br>")
                        append("Кінець: \t${(it.EndTime)}<br>")
                    }
                }
            }
        }
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    }
    fun ThursdayFormat(plans: List<Plans>, resources: Resources): Spanned {
        val sb = StringBuilder()
        sb.apply {
            plans.forEach {
                if (it.EventDay == "Четвер") {
                    append(resources.getString(R.string.start_time))
                    append("\t${(it.EventName)}<br>")
                    append(resources.getString(R.string.end_time))
                    if (it.Time != "Інтервал") {
                        append("\t${(it.Time)}<br>")
                    } else {
                        append("\t${(it.Time)}<br>")
                        append("Початок: \t${(it.StartTime)}<br>")
                        append("Кінець: \t${(it.EndTime)}<br>")
                    }
                }
            }
        }
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    }

    fun FridayFormat(plans: List<Plans>, resources: Resources): Spanned {
        val sb = StringBuilder()
        sb.apply {
            plans.forEach {
                if (it.EventDay == "П'ятниця") {
                    append(resources.getString(R.string.start_time))
                    append("\t${(it.EventName)}<br>")
                    append(resources.getString(R.string.end_time))
                    if (it.Time != "Інтервал") {
                        append("\t${(it.Time)}<br>")
                    } else {
                        append("\t${(it.Time)}<br>")
                        append("Початок: \t${(it.StartTime)}<br>")
                        append("Кінець: \t${(it.EndTime)}<br>")
                    }
                }
            }
        }
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    }

    fun SaturdayFormat(plans: List<Plans>, resources: Resources): Spanned {
        val sb = StringBuilder()
        sb.apply {
            plans.forEach {
                if (it.EventDay == "Субота") {
                    append(resources.getString(R.string.start_time))
                    append("\t${(it.EventName)}<br>")
                    append(resources.getString(R.string.end_time))
                    if (it.Time != "Інтервал") {
                        append("\t${(it.Time)}<br>")
                    } else {
                        append("\t${(it.Time)}<br>")
                        append("Початок: \t${(it.StartTime)}<br>")
                        append("Кінець: \t${(it.EndTime)}<br>")
                    }
                }
            }
        }
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    }

    fun SundayFormat(plans: List<Plans>, resources: Resources): Spanned {
        val sb = StringBuilder()
        sb.apply {
            plans.forEach {
                if (it.EventDay == "Неділя") {
                    append(resources.getString(R.string.start_time))
                    append("\t${(it.EventName)}<br>")
                    append(resources.getString(R.string.end_time))
                    if (it.Time != "Інтервал") {
                        append("\t${(it.Time)}<br>")
                    } else {
                        append("\t${(it.Time)}<br>")
                        append("Початок: \t${(it.StartTime)}<br>")
                        append("Кінець: \t${(it.EndTime)}<br>")
                    }
                }
            }
        }
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    }