package nl.gn0s1s.emojiclock

import java.time.{ LocalDateTime, ZoneOffset }

import com.lightbend.emoji.ShortCodes.Defaults._
import com.lightbend.emoji.ShortCodes.Implicits._
import org.scalacheck.{ Gen, Properties }
import org.scalacheck.Prop.forAll

object EmojiChineseZodiacSpec extends Properties("EmojiChineseZodiac") {
  property("generates a valid chinese zodiac sign for the current date-time") = {
    println(EmojiChineseZodiac.now().emoji)
    EmojiChineseZodiac.chineseZodiacSigns.contains(EmojiChineseZodiac.now())
  }

  val fromEpoch = LocalDateTime.of(1924, 2, 5, 0, 0).toEpochSecond(ZoneOffset.UTC)
  val toEpoch = LocalDateTime.of(2044, 1, 29, 0, 0).toEpochSecond(ZoneOffset.UTC)
  val genDateBetween = Gen.choose[Long](fromEpoch, toEpoch).map(x => LocalDateTime.ofEpochSecond(x, 0, ZoneOffset.UTC))

  property("generates a valid chinese zodiac sign for any day from 192400205 to 20440129") = forAll(genDateBetween) {
    dateTime =>
      EmojiChineseZodiac.chineseZodiacSigns.contains(EmojiChineseZodiac.chineseZodiacSignShortCode(dateTime))
  }
}
