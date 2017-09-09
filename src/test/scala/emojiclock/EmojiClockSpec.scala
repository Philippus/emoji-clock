package emojiclock

import com.lightbend.emoji.ShortCodes
import com.lightbend.emoji.ShortCodes.Defaults._
import com.lightbend.emoji.ShortCodes.Implicits._
import org.scalacheck.{ Gen, Properties }
import org.scalacheck.Prop.forAll

object EmojiClockSpec extends Properties("EmojiClock") {
  val genMinute = Gen.choose[Int](0, 59)
  val genHour = Gen.choose[Int](0, 23)
  val clockFacesShortCodes = ShortCodes.current.shortCodes.filter(_.startsWith("clock"))

  property("generates a valid clock face for the current date-time") = {
    val current = java.time.LocalDateTime.now()
    println(EmojiClock.now().emoji)
    clockFacesShortCodes.contains(EmojiClock.clockFaceShortCode(current.getHour, current.getMinute))
  }

  property("generates valid clock faces") = forAll(genHour, genMinute) {
    (h, m) =>
      clockFacesShortCodes.contains(EmojiClock.clockFaceShortCode(h, m))
  }

  property("rounds to the nearest clock face") = {
    def twelveHourClock(hour: Int) = if (hour % 12 == 0) 12 else hour % 12

    val correctHour = forAll(genHour, genMinute) {
      (h, m) =>
        EmojiClock.clockFaceShortCode(h, m) match {
          case x if x.stripSuffix("30").equals("clock" + twelveHourClock(h + 1)) => m > 44
          case x if x.stripSuffix("30").equals("clock" + twelveHourClock(h)) => m <= 44
        }
    }

    val correctMinute = forAll(genHour, genMinute) {
      (h, m) =>
        EmojiClock.clockFaceShortCode(h, m) match {
          case x if x.endsWith("30") => m > 14 && m <= 44
          case _ => m <= 14 || m > 44
        }
    }

    correctHour && correctMinute
  }

  property("generates all clock faces") = {
    var generatedClockShortCodes = Set[String]()
    for (h <- 1 to 12) {
      print(EmojiClock.clockFaceShortCode(h, 0).emoji)
      generatedClockShortCodes += EmojiClock.clockFaceShortCode(h, 0)
    }
    println
    for (h <- 1 to 12) {
      print(EmojiClock.clockFaceShortCode(h, 30).emoji)
      generatedClockShortCodes += EmojiClock.clockFaceShortCode(h, 30)
    }
    println
    generatedClockShortCodes.equals(clockFacesShortCodes)
  }
}
