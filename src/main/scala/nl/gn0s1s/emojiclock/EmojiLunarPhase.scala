package nl.gn0s1s.emojiclock

import java.time.Duration
import java.time.LocalDateTime

object EmojiLunarPhase {
  private val synodicCycle = 29.530588853
  val phases = List(
    "new_moon", "waxing_crescent_moon", "first_quarter_moon", "waxing_gibbous_moon",
    "full_moon", "waning_gibbous_moon", "last_quarter_moon", "waning_crescent_moon")

  private val newMoons: List[(Int, Int, Int)] = List(
    (1900, 1, 1),
    (1910, 1, 11),
    (1920, 1, 21),
    (1930, 1, 29),
    (1940, 1, 9),
    (1950, 1, 18),
    (1960, 1, 28),
    (1970, 1, 7),
    (1980, 1, 17),
    (1990, 1, 26),
    (2000, 1, 6),
    (2010, 1, 15),
    (2017, 1, 28))

  private def dayInSynodicCycle(date: LocalDateTime) = {
    val nearestNewMoonBefore = newMoons.filter(x => LocalDateTime.of(x._1, x._2, x._3, 0, 0).isBefore(date)).minBy(x => Duration.between(LocalDateTime.of(x._1, x._2, x._3, 0, 0), date).toDays)
    val days = Duration.between(LocalDateTime.of(nearestNewMoonBefore._1, nearestNewMoonBefore._2, nearestNewMoonBefore._3, 0, 0), date).toDays
    days % synodicCycle
  }

  def moonPhaseShortCode(date: LocalDateTime): String = {
    val idx = ((1 + (dayInSynodicCycle(date) / synodicCycle * 8)) % 8).toInt

    phases(idx)
  }

  def now(): String = {
    val current = LocalDateTime.now()
    moonPhaseShortCode(current)
  }
}
