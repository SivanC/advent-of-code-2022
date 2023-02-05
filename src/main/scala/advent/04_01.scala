package advent

import scala.io.Source

@main def DayFour() = 
  val file = "inputs/cleanup.txt"
  val lines = Source.fromFile(file).getLines.toList
  def counter(lines: List[String]): Int = 
    val acc = 0
    def loop(lines: List[String], acc: Int): Int = lines match
      case Nil        => acc
      case head::tail => head match
        case s"$min1-$max1,$min2-$max2" =>
          if ((min1.toInt <= min2.toInt && max1.toInt >= max2.toInt) ||
              (min2.toInt <= min1.toInt && max2.toInt >= max1.toInt))
            loop(tail, acc + 1)
          else
            loop(tail, acc)
        case _        => -1
    loop(lines, acc)
  println(counter(lines))

