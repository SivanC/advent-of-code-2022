package advent

import scala.io.Source

@main def DayTwo() = 
  // filename
  val file = "inputs/rps.txt"

  // values for playing each option, and for winning or drawing
  val r = 1
  val p = 2
  val s = 3
  val w = 6
  val d = 3

  var acc = 0
  for (line <- Source.fromFile(file).getLines) line match
    case "A X" => acc += s
    case "A Y" => acc += r + d
    case "A Z" => acc += p + w
    case "B X" => acc += r
    case "B Y" => acc += p + d
    case "B Z" => acc += s + w
    case "C X" => acc += p
    case "C Y" => acc += s + d
    case "C Z" => acc += r + w
  println(acc)
