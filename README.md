# Emoji-clock

[![Build Status](https://travis-ci.org/Philippus/emoji-clock.svg?branch=master)](https://travis-ci.org/Philippus/emoji-clock)
[![codecov](https://codecov.io/gh/Philippus/emoji-clock/branch/master/graph/badge.svg)](https://codecov.io/gh/Philippus/emoji-clock)
![Current Version](https://img.shields.io/badge/version-0.3.1-brightgreen.svg?style=flat "0.3.1")
[![License](https://img.shields.io/badge/license-MIT-blue.svg?style=flat "MIT")](LICENSE.md)

Emoji-clock can, when given a date-time, generate the applicable emoji short code for:
- clock faces
- lunar phases
- (tropical) zodiac signs
- chinese zodiac signs

To view the emoji itself you will need an emoji library such as [Lightbend Emoji](https://github.com/typesafehub/lightbend-emoji).

## Installation

Emoji-clock is published for Scala 2.12 and 2.13. To start using it add the following to your `build.sbt`:

```
resolvers += Resolver.bintrayRepo("gn0s1s", "releases")

libraryDependencies += "nl.gn0s1s" %% "emoji-clock" % "0.3.1"
```

## Example usage

Follow the Lightbend Emoji [installation instructions](https://github.com/typesafehub/lightbend-emoji#installation) also for these examples:

```scala
import nl.gn0s1s.emojiclock.EmojiClock
import com.lightbend.emoji.ShortCodes.Defaults._
import com.lightbend.emoji.ShortCodes.Implicits._

EmojiClock.clockFaceShortCode(java.time.LocalDateTime.of(2018, 1, 31, 1, 50))
// res0: String = clock2
EmojiClock.clockFaceShortCode(java.time.LocalDateTime.of(2018, 1, 31, 1, 50)).emoji
// res1: com.lightbend.emoji.Emoji = 🕑

EmojiClock.now() // at 16:44
// res2: String = clock430
EmojiClock.now().emoji
// res3: com.lightbend.emoji.Emoji = 🕟
```

```scala
import nl.gn0s1s.emojiclock.EmojiLunarPhase
import com.lightbend.emoji.ShortCodes.Defaults._
import com.lightbend.emoji.ShortCodes.Implicits._

EmojiLunarPhase.lunarPhaseShortCode(java.time.LocalDateTime.of(2018, 1, 31, 0, 0))
// res0: String = full_moon
EmojiLunarPhase.lunarPhaseShortCode(java.time.LocalDateTime.of(2017, 12, 10, 0, 0)).emoji
// res1: com.lightbend.emoji.Emoji = 🌗

EmojiLunarPhase.now() // at 1st December 2017
// res2: String = full_moon
EmojiLunarPhase.now().emoji
// res3: com.lightbend.emoji.Emoji = 🌕
```

```scala
import nl.gn0s1s.emojiclock.EmojiZodiacSign
import com.lightbend.emoji.ShortCodes.Defaults._
import com.lightbend.emoji.ShortCodes.Implicits._

EmojiZodiacSign.zodiacSignShortCode(java.time.LocalDateTime.of(2018, 1, 31, 0, 0))
// res0: String = aquarius
EmojiZodiacSign.zodiacSignShortCode(java.time.LocalDateTime.of(2017, 5, 5, 0, 0)).emoji
// res1: com.lightbend.emoji.Emoji = ♉

EmojiZodiacSign.now() // at 2nd December 2017
// res2: String = sagittarius
EmojiZodiacSign.now().emoji
// res3: com.lightbend.emoji.Emoji = ♐
```

```scala
import nl.gn0s1s.emojiclock.EmojiChineseZodiac
import com.lightbend.emoji.ShortCodes.Defaults._
import com.lightbend.emoji.ShortCodes.Implicits._

EmojiChineseZodiac.chineseZodiacSignShortCode(java.time.LocalDateTime.of(2018, 1, 31, 0, 0))
// res0: String = rooster
EmojiChineseZodiac.chineseZodiacSignShortCode(java.time.LocalDateTime.of(2015, 5, 5, 0, 0)).emoji
// res1: com.lightbend.emoji.Emoji = 🐐

EmojiChineseZodiac.now() // at 1st January 2019
// res2: String = dog
EmojiChineseZodiac.now().emoji
// res3: com.lightbend.emoji.Emoji = 🐶
```

## Links
- Emo R package that does something similar for R - https://github.com/hadley/emo
- Rust crate that does something similar for the cli - https://github.com/softprops/emoji-clock
- Lunar phase - https://en.wikipedia.org/wiki/Lunar_phase
- Sidereal and tropical astrology - https://en.wikipedia.org/wiki/Sidereal_and_tropical_astrology
- Chinese zodiac - https://en.wikipedia.org/wiki/Chinese_zodiac

## License
The code is available under the [MIT license](LICENSE.md).
