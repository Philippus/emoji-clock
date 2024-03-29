package nl.gn0s1s.emojiclock

import java.time.{LocalDate, LocalDateTime}

object EmojiChineseZodiac {
  val chineseZodiacSigns =
    List("rat", "ox", "tiger", "rabbit", "dragon", "snake", "horse", "goat", "monkey", "rooster", "dog", "pig")

  val chineseZodiacMap: Map[((Int, Int, Int), (Int, Int, Int)), String] = Map(
    ((1924, 2, 5), (1925, 1, 23))  -> "rat",
    ((1925, 1, 24), (1926, 2, 12)) -> "ox",
    ((1926, 2, 13), (1927, 2, 1))  -> "tiger",
    ((1927, 2, 2), (1928, 1, 22))  -> "rabbit",
    ((1928, 1, 23), (1929, 2, 9))  -> "dragon",
    ((1929, 2, 10), (1930, 1, 29)) -> "snake",
    ((1930, 1, 30), (1931, 2, 16)) -> "horse",
    ((1931, 2, 17), (1932, 2, 5))  -> "goat",
    ((1932, 2, 6), (1933, 1, 25))  -> "monkey",
    ((1933, 1, 26), (1934, 2, 13)) -> "rooster",
    ((1934, 2, 14), (1935, 2, 3))  -> "dog",
    ((1935, 2, 4), (1936, 1, 23))  -> "pig",
    ((1936, 1, 24), (1937, 2, 10)) -> "rat",
    ((1937, 2, 11), (1938, 1, 30)) -> "ox",
    ((1938, 1, 31), (1939, 2, 18)) -> "tiger",
    ((1939, 2, 19), (1940, 2, 7))  -> "rabbit",
    ((1940, 2, 8), (1941, 1, 26))  -> "dragon",
    ((1941, 1, 27), (1942, 2, 14)) -> "snake",
    ((1942, 2, 15), (1943, 2, 4))  -> "horse",
    ((1943, 2, 5), (1944, 1, 24))  -> "goat",
    ((1944, 1, 25), (1945, 2, 12)) -> "monkey",
    ((1945, 2, 13), (1946, 2, 1))  -> "rooster",
    ((1946, 2, 2), (1947, 1, 21))  -> "dog",
    ((1947, 1, 22), (1948, 2, 9))  -> "pig",
    ((1948, 2, 10), (1949, 1, 28)) -> "rat",
    ((1949, 1, 29), (1950, 2, 16)) -> "ox",
    ((1950, 2, 17), (1951, 2, 5))  -> "tiger",
    ((1951, 2, 6), (1952, 1, 26))  -> "rabbit",
    ((1952, 1, 27), (1953, 2, 13)) -> "dragon",
    ((1953, 2, 14), (1954, 2, 2))  -> "snake",
    ((1954, 2, 3), (1955, 1, 23))  -> "horse",
    ((1955, 1, 24), (1956, 2, 11)) -> "goat",
    ((1956, 2, 12), (1957, 1, 30)) -> "monkey",
    ((1957, 1, 31), (1958, 2, 17)) -> "rooster",
    ((1958, 2, 18), (1959, 2, 7))  -> "dog",
    ((1959, 2, 8), (1960, 1, 27))  -> "pig",
    ((1960, 1, 28), (1961, 2, 14)) -> "rat",
    ((1961, 2, 15), (1962, 2, 4))  -> "ox",
    ((1962, 2, 5), (1963, 1, 24))  -> "tiger",
    ((1963, 1, 25), (1964, 2, 12)) -> "rabbit",
    ((1964, 2, 13), (1965, 2, 1))  -> "dragon",
    ((1965, 2, 2), (1966, 1, 20))  -> "snake",
    ((1966, 1, 21), (1967, 2, 8))  -> "horse",
    ((1967, 2, 9), (1968, 1, 29))  -> "goat",
    ((1968, 1, 30), (1969, 2, 16)) -> "monkey",
    ((1969, 2, 17), (1970, 2, 5))  -> "rooster",
    ((1970, 2, 6), (1971, 1, 26))  -> "dog",
    ((1971, 1, 27), (1972, 2, 14)) -> "pig",
    ((1972, 2, 15), (1973, 2, 2))  -> "rat",
    ((1973, 2, 3), (1974, 1, 22))  -> "ox",
    ((1974, 1, 23), (1975, 2, 10)) -> "tiger",
    ((1975, 2, 11), (1976, 1, 30)) -> "rabbit",
    ((1976, 1, 31), (1977, 2, 17)) -> "dragon",
    ((1977, 2, 18), (1978, 2, 6))  -> "snake",
    ((1978, 2, 7), (1979, 1, 27))  -> "horse",
    ((1979, 1, 28), (1980, 2, 15)) -> "goat",
    ((1980, 2, 16), (1981, 2, 4))  -> "monkey",
    ((1981, 2, 5), (1982, 1, 24))  -> "rooster",
    ((1982, 1, 25), (1983, 2, 12)) -> "dog",
    ((1983, 2, 13), (1984, 2, 1))  -> "pig",
    ((1984, 2, 2), (1985, 1, 21))  -> "rat",
    ((1985, 1, 22), (1986, 2, 8))  -> "ox",
    ((1986, 2, 9), (1987, 1, 28))  -> "tiger",
    ((1987, 1, 29), (1988, 2, 16)) -> "rabbit",
    ((1988, 2, 17), (1989, 2, 5))  -> "dragon",
    ((1989, 2, 6), (1990, 1, 26))  -> "snake",
    ((1990, 1, 27), (1991, 2, 14)) -> "horse",
    ((1991, 2, 15), (1992, 2, 3))  -> "goat",
    ((1992, 2, 4), (1993, 1, 22))  -> "monkey",
    ((1993, 1, 23), (1994, 2, 9))  -> "rooster",
    ((1994, 2, 10), (1995, 1, 30)) -> "dog",
    ((1995, 1, 31), (1996, 2, 18)) -> "pig",
    ((1996, 2, 19), (1997, 2, 6))  -> "rat",
    ((1997, 2, 7), (1998, 1, 27))  -> "ox",
    ((1998, 1, 28), (1999, 2, 15)) -> "tiger",
    ((1999, 2, 16), (2000, 2, 4))  -> "rabbit",
    ((2000, 2, 5), (2001, 1, 23))  -> "dragon",
    ((2001, 1, 24), (2002, 2, 11)) -> "snake",
    ((2002, 2, 12), (2003, 1, 31)) -> "horse",
    ((2003, 2, 1), (2004, 1, 21))  -> "goat",
    ((2004, 1, 22), (2005, 2, 8))  -> "monkey",
    ((2005, 2, 9), (2006, 1, 28))  -> "rooster",
    ((2006, 1, 29), (2007, 2, 17)) -> "dog",
    ((2007, 2, 18), (2008, 2, 6))  -> "pig",
    ((2008, 2, 7), (2009, 1, 25))  -> "rat",
    ((2009, 1, 26), (2010, 2, 13)) -> "ox",
    ((2010, 2, 14), (2011, 2, 2))  -> "tiger",
    ((2011, 2, 3), (2012, 1, 22))  -> "rabbit",
    ((2012, 1, 23), (2013, 2, 9))  -> "dragon",
    ((2013, 2, 10), (2014, 1, 30)) -> "snake",
    ((2014, 1, 31), (2015, 2, 18)) -> "horse",
    ((2015, 2, 19), (2016, 2, 7))  -> "goat",
    ((2016, 2, 8), (2017, 1, 27))  -> "monkey",
    ((2017, 1, 28), (2018, 2, 15)) -> "rooster",
    ((2018, 2, 16), (2019, 2, 4))  -> "dog",
    ((2019, 2, 5), (2020, 1, 24))  -> "pig",
    ((2020, 1, 25), (2021, 2, 11)) -> "rat",
    ((2021, 2, 12), (2022, 1, 31)) -> "ox",
    ((2022, 2, 1), (2023, 1, 21))  -> "tiger",
    ((2023, 1, 22), (2024, 2, 9))  -> "rabbit",
    ((2024, 2, 10), (2025, 1, 28)) -> "dragon",
    ((2025, 1, 29), (2026, 2, 16)) -> "snake",
    ((2026, 2, 17), (2027, 2, 5))  -> "horse",
    ((2027, 2, 6), (2028, 1, 25))  -> "goat",
    ((2028, 1, 26), (2029, 2, 12)) -> "monkey",
    ((2029, 2, 13), (2030, 2, 2))  -> "rooster",
    ((2030, 2, 3), (2031, 1, 22))  -> "dog",
    ((2031, 1, 23), (2032, 2, 10)) -> "pig",
    ((2032, 2, 11), (2033, 1, 30)) -> "rat",
    ((2033, 1, 31), (2034, 2, 18)) -> "ox",
    ((2034, 2, 19), (2035, 2, 7))  -> "tiger",
    ((2035, 2, 8), (2036, 1, 27))  -> "rabbit",
    ((2036, 1, 28), (2037, 2, 14)) -> "dragon",
    ((2037, 2, 15), (2038, 2, 3))  -> "snake",
    ((2038, 2, 4), (2039, 1, 23))  -> "horse",
    ((2039, 1, 24), (2040, 2, 11)) -> "goat",
    ((2040, 2, 12), (2041, 1, 31)) -> "monkey",
    ((2041, 2, 1), (2042, 1, 21))  -> "rooster",
    ((2042, 1, 22), (2043, 2, 9))  -> "dog",
    ((2043, 2, 10), (2044, 1, 29)) -> "pig"
  )

  def chineseZodiacSignShortCode(date: LocalDateTime): String = {
    val checkDate = date.toLocalDate
    chineseZodiacMap
      .find(x =>
        (!LocalDate.of(x._1._1._1, x._1._1._2, x._1._1._3).isAfter(checkDate)
          && !LocalDate.of(x._1._2._1, x._1._2._2, x._1._2._3).isBefore(checkDate))
      )
      .map(x => x._2)
      .getOrElse("")
  }

  def now(): String = chineseZodiacSignShortCode(LocalDateTime.now())
}
