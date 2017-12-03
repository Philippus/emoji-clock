package nl.gn0s1s.emojiclock

import java.time.LocalDateTime

import com.lightbend.emoji.ShortCodes
import com.lightbend.emoji.ShortCodes.Defaults._
import com.lightbend.emoji.ShortCodes.Implicits._
import org.scalacheck.Properties
import org.scalacheck.Prop.forAll

import Generators._

object EmojiLunarPhaseSpec extends Properties("EmojiLunarPhase") {
  property("generates a valid moon phase for the current date-time") = {
    println(EmojiLunarPhase.now().emoji)
    EmojiLunarPhase.phases.contains(EmojiLunarPhase.now())
  }

  property("generate valid moon phase for a certain day") = forAll {
    dateTime: LocalDateTime =>
      val lunarPhasesShortCodes = ShortCodes.current.shortCodes.filter(_.endsWith("_moon")).filterNot(_ == "crescent_moon")
      lunarPhasesShortCodes.contains(EmojiLunarPhase.moonPhaseShortCode(dateTime))
  }

  property("pass all moon phases in a synodic cycle") = forAll {
    (dateTime: LocalDateTime) =>
      var passedLunarPhases = scala.collection.mutable.Set.empty[String]
      for (i <- 1 to 30) {
        val passedLunarPhase = EmojiLunarPhase.moonPhaseShortCode(dateTime.plusDays(i))
        passedLunarPhases += passedLunarPhase
      }
      passedLunarPhases == EmojiLunarPhase.phases.toSet
  }

  property("one year contains twelve or thirteen full moons") = forAll {
    (dateTime: LocalDateTime) =>
      var fullMoons = 0
      for (i <- 1 to 366) {
        val prevLunarPhase = EmojiLunarPhase.moonPhaseShortCode(dateTime.plusDays(i - 1))
        val passedLunarPhase = EmojiLunarPhase.moonPhaseShortCode(dateTime.plusDays(i))
        if (passedLunarPhase == "full_moon" && ((prevLunarPhase != passedLunarPhase) || i == 1)) {
          fullMoons += 1
        }
      }
      fullMoons == 12 || fullMoons == 13
  }
}
