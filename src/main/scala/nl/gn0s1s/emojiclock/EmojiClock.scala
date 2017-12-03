package nl.gn0s1s.emojiclock

import java.time.LocalDateTime

object EmojiClock {
  def clockFaceShortCode(dateTime: LocalDateTime): String = {
    def twelveHourClock(hour: Int) = if (hour % 12 == 0) 12 else hour % 12

    dateTime.getMinute match {
      case x if x <= 14 => s"clock${twelveHourClock(dateTime.getHour)}"
      case x if x <= 44 => s"clock${twelveHourClock(dateTime.getHour)}30"
      case _ => s"clock${twelveHourClock(dateTime.getHour + 1)}"
    }
  }

  def now(): String = clockFaceShortCode(LocalDateTime.now())
}
