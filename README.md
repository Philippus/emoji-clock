Emoji-clock
===========

[![Build Status](https://travis-ci.org/Philippus/emoji-clock.svg?branch=master)](https://travis-ci.org/Philippus/emoji-clock)
[![codecov](https://codecov.io/gh/Philippus/emoji-clock/branch/master/graph/badge.svg)](https://codecov.io/gh/Philippus/emoji-clock)
![Current Version](https://img.shields.io/badge/version-0.1.2-brightgreen.svg?style=flat "0.1.2")
[![License](https://img.shields.io/badge/license-MIT-blue.svg?style=flat "MIT")](LICENSE.md)

Emoji-clock generates the nearest emoji clock face short code for a given time.

To view the emoji itself you will need an emoji library such as [Lightbend Emoji](https://github.com/typesafehub/lightbend-emoji).

## Installation

Add the following to your `build.sbt`:

```
resolvers += Resolver.bintrayRepo("gn0s1s", "releases")

libraryDependencies += "nl.gn0s1s" %% "emoji-clock" % "0.1.2"
```

## Example usage

Follow the Lightbend Emoji [installation instructions](https://github.com/typesafehub/lightbend-emoji#installation) also for this example:

```scala
import nl.gn0s1s.emojiclock.EmojiClock
import com.lightbend.emoji.ShortCodes.Defaults._
import com.lightbend.emoji.ShortCodes.Implicits._

EmojiClock.clockFaceShortCode(1, 50)
// res0: String = clock2
EmojiClock.clockFaceShortCode(1, 50).emoji
// res1: com.lightbend.emoji.Emoji = 🕑

EmojiClock.now() // at 16:44
// res2: String = clock430
EmojiClock.now().emoji
// res3: com.lightbend.emoji.Emoji = 🕟
```

## License
The code is available under the [MIT license](LICENSE.md).
