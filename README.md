Emoji-clock
===========

[![Build Status](https://travis-ci.org/Philippus/emoji-clock.svg?branch=master)](https://travis-ci.org/Philippus/emoji-clock)
[![codecov](https://codecov.io/gh/Philippus/emoji-clock/branch/master/graph/badge.svg)](https://codecov.io/gh/Philippus/emoji-clock)
[![License](https://img.shields.io/badge/license-MIT-blue.svg?style=flat "MIT")](LICENSE.md)

Emoji-clock generates the nearest emoji clock face shortcode for a given time, you will need an emoji library
such as [Lightbend Emoji](https://github.com/typesafehub/lightbend-emoji) to view the emoji itself

## Installation

## Usage

```scala
import emojiclock.EmojiClock
import com.lightbend.emoji.ShortCodes.Defaults._
import com.lightbend.emoji.ShortCodes.Implicits._

EmojiClock.now().emoji // 16:44
//res0: com.lightbend.emoji.Emoji = 🕟

EmojiClock.clockFaceShortCode(1, 50).emoji
//res1: com.lightbend.emoji.Emoji = 🕑
```

## License
The code is available under the [MIT license](LICENSE.md).
