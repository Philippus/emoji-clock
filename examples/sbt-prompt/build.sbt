import SbtPrompt.autoImport._

import com.lightbend.emoji.ShortCodes.Defaults._
import com.lightbend.emoji.ShortCodes.Implicits._
import com.scalapenos.sbt.prompt._

import nl.gn0s1s.emojiclock._

def emojiClock(): Promptlet = text(
  _ => {
    EmojiClock.now().emoji.toString
  },
  NoStyle
)

promptTheme := com.scalapenos.sbt.prompt.PromptThemes.DefaultTheme
  .copy(promptlets = emojiClock() +: com.scalapenos.sbt.prompt.PromptThemes.DefaultTheme.promptlets)
