package advent 

import scala.io.Source

@main def DayThree() = 
  val file = "inputs/rucksack.txt"

  val lines = Source.fromFile(file).getLines.toList
  def count(lines: List[String]): Int =
    val lower = ('a' to 'z').toList
    val upper = ('A' to 'Z').toList
    val key = lower++upper
    def loop(lines: List[String], acc: Int): Int = lines match
      case Nil => acc
      case h1::h2::h3::tail =>
        val badge = h1.intersect(h2.intersect(h3)).head
        val priority = key.indexOf(badge) + 1
        loop(tail, acc + priority)

    loop(lines, 0)

  println(count(lines))
