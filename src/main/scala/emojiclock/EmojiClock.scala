package emojiclock

object EmojiClock {
  def clockFaceShortCode(hour: Int, minute: Int): String = {
    def twelveHourClock(hour: Int) = if (hour % 12 == 0) 12 else hour % 12

    minute match {
      case x if x <= 14 => s"clock${twelveHourClock(hour)}"
      case x if x <= 44 => s"clock${twelveHourClock(hour)}30"
      case _ => s"clock${twelveHourClock(hour + 1)}"
    }
  }

  def now(): String = {
    val current = java.time.LocalDateTime.now()
    clockFaceShortCode(current.getHour, current.getMinute)
  }
}
