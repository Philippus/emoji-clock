package nl.gn0s1s.emojiclock

import java.time.LocalDateTime

object EmojiClock {
  val clockFaces = List(
    "clock1",
    "clock2",
    "clock3",
    "clock4",
    "clock5",
    "clock6",
    "clock7",
    "clock8",
    "clock9",
    "clock10",
    "clock11",
    "clock12",
    "clock130",
    "clock230",
    "clock330",
    "clock430",
    "clock530",
    "clock630",
    "clock730",
    "clock830",
    "clock930",
    "clock1030",
    "clock1130",
    "clock1230"
  )

  def clockFaceShortCode(dateTime: LocalDateTime): String = {
    def twelveHourClock(hour: Int) = if (hour % 12 == 0) 12 else hour % 12

    dateTime.getMinute match {
      case x if x <= 14 => s"clock${twelveHourClock(dateTime.getHour)}"
      case x if x <= 44 => s"clock${twelveHourClock(dateTime.getHour)}30"
      case _            => s"clock${twelveHourClock(dateTime.getHour + 1)}"
    }
  }

  def now(): String = clockFaceShortCode(LocalDateTime.now())
}
