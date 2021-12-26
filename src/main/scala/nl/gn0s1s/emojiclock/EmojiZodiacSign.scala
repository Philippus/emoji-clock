package nl.gn0s1s.emojiclock

import java.time.{LocalDate, LocalDateTime}

object EmojiZodiacSign {
  val zodiacSigns = List(
    "aries",
    "taurus",
    "gemini",
    "cancer",
    "leo",
    "virgo",
    "libra",
    "scorpius",
    "sagittarius",
    "capricorn",
    "aquarius",
    "pisces"
  )

  def zodiacSignShortCode(date: LocalDateTime): String = {
    val year: Int = date.getYear
    val zodiacSignMap: Map[((Int, Int, Int), (Int, Int, Int)), String] = Map(
      ((year - 1, 12, 22), (year, 1, 19)) -> "capricorn",
      ((year, 1, 20), (year, 2, 18)) -> "aquarius",
      ((year, 2, 19), (year, 3, 20)) -> "pisces",
      ((year, 3, 21), (year, 4, 19)) -> "aries",
      ((year, 4, 20), (year, 5, 20)) -> "taurus",
      ((year, 5, 21), (year, 6, 20)) -> "gemini",
      ((year, 6, 21), (year, 7, 22)) -> "cancer",
      ((year, 7, 23), (year, 8, 22)) -> "leo",
      ((year, 8, 23), (year, 9, 22)) -> "virgo",
      ((year, 9, 23), (year, 10, 22)) -> "libra",
      ((year, 10, 23), (year, 11, 21)) -> "scorpius",
      ((year, 11, 22), (year, 12, 21)) -> "sagittarius",
      ((year, 12, 22), (year + 1, 1, 19)) -> "capricorn"
    )

    val checkDate = date.toLocalDate
    zodiacSignMap
      .find(x =>
        (!LocalDate.of(x._1._1._1, x._1._1._2, x._1._1._3).isAfter(checkDate)
          && !LocalDate.of(x._1._2._1, x._1._2._2, x._1._2._3).isBefore(checkDate))
      )
      .map(x => x._2)
      .getOrElse("")
  }

  def now(): String = zodiacSignShortCode(LocalDateTime.now())
}
