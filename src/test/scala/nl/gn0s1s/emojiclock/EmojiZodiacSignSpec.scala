package nl.gn0s1s.emojiclock

import java.time.{LocalDateTime, ZoneOffset}

import com.lightbend.emoji.ShortCodes.Defaults._
import com.lightbend.emoji.ShortCodes.Implicits._
import org.scalacheck.{Gen, Properties}
import org.scalacheck.Prop.forAll

object EmojiZodiacSignSpec extends Properties("EmojiZodiacSign") {
  property("generates a zodiac sign for the current date-time") = {
    println(EmojiZodiacSign.now().emoji)
    EmojiZodiacSign.zodiacSigns.contains(EmojiZodiacSign.now())
  }

  val fromEpoch = LocalDateTime.of(1924, 2, 5, 0, 0).toEpochSecond(ZoneOffset.UTC)
  val toEpoch = LocalDateTime.of(2044, 1, 29, 0, 0).toEpochSecond(ZoneOffset.UTC)
  val genDateBetween = Gen.choose[Long](fromEpoch, toEpoch).map(x => LocalDateTime.ofEpochSecond(x, 0, ZoneOffset.UTC))

  property("generates a zodiac sign for any day from 192400205 to 20440129") = forAll(genDateBetween) { dateTime =>
    EmojiZodiacSign.zodiacSigns.contains(EmojiZodiacSign.zodiacSignShortCode(dateTime))
  }
}
