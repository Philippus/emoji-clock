package nl.gn0s1s.emojiclock

import java.time.LocalDateTime

import com.lightbend.emoji.ShortCodes
import com.lightbend.emoji.ShortCodes.Defaults._
import com.lightbend.emoji.ShortCodes.Implicits._
import org.scalacheck.Properties
import org.scalacheck.Prop.forAll

import Generators._

object EmojiClockSpec extends Properties("EmojiClock") {
  val clockFacesShortCodes = ShortCodes.current.shortCodes.filter(_.startsWith("clock"))

  property("generates a valid clock face for the current date-time") = {
    println(EmojiClock.now().emoji)
    clockFacesShortCodes.contains(EmojiClock.now())
  }

  property("generates valid clock faces") = forAll {
    (dateTime: LocalDateTime) =>
      clockFacesShortCodes.contains(EmojiClock.clockFaceShortCode(dateTime))
  }

  property("rounds to the nearest clock face") = {
    def twelveHourClock(hour: Int) = if (hour % 12 == 0) 12 else hour % 12

    val correctHour = forAll {
      dateTime: LocalDateTime =>
        val (h, m) = (dateTime.getHour, dateTime.getMinute)
        EmojiClock.clockFaceShortCode(dateTime) match {
          case x if x.stripSuffix("30").equals("clock" + twelveHourClock(h + 1)) => m > 44
          case x if x.stripSuffix("30").equals("clock" + twelveHourClock(h)) => m <= 44
        }
    }

    val correctMinute = forAll {
      dateTime: LocalDateTime =>
        val m = dateTime.getMinute
        EmojiClock.clockFaceShortCode(dateTime) match {
          case x if x.endsWith("30") => m > 14 && m <= 44
          case _ => m <= 14 || m > 44
        }
    }

    correctHour && correctMinute
  }

  property("generates all clock faces") = forAll {
    dateTime: LocalDateTime =>
      var generatedClockShortCodes = Set[String]()
      for (h <- 1 to 12) {
        generatedClockShortCodes += EmojiClock.clockFaceShortCode(dateTime.withHour(h).withMinute(0))
      }
      for (h <- 1 to 12) {
        generatedClockShortCodes += EmojiClock.clockFaceShortCode(dateTime.withHour(h).withMinute(30))
      }
      generatedClockShortCodes.equals(clockFacesShortCodes)
  }
}
