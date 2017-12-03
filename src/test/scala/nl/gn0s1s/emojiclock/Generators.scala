package nl.gn0s1s.emojiclock

import java.time.{ LocalDateTime, ZoneOffset }

import org.scalacheck.{ Arbitrary, Gen }

object Generators {
  def genDateTime: Gen[LocalDateTime] = {
    val start = LocalDateTime.of(1900, 1, 1, 0, 0, 0).toEpochSecond(ZoneOffset.UTC)
    val end = LocalDateTime.of(2100, 1, 1, 0, 0, 0).toEpochSecond(ZoneOffset.UTC)
    Gen.choose(start, end).map(x ⇒ LocalDateTime.ofEpochSecond(x, 0, ZoneOffset.UTC))
  }

  implicit val arbitraryDateTime: Arbitrary[LocalDateTime] = Arbitrary(genDateTime)
}
