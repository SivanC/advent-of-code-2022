package advent

import scala.io.Source
import scala.collection.mutable.Stack
import scala.language.postfixOps

@main def DayFive() = 
  val file = "inputs/crates.txt"
  val lines = Source.fromFile(file).getLines.toList
  val moves = lines.drop(10)

  // 9 crates with input terribly formatted in file
  // and yes this way is also dumb
  val crates = List(List('R','G','H','Q','S','B','T','N') reverse,
               List('H','S','F','D','P','Z','J') reverse,
               List('Z','H','V') reverse,
               List('M','Z','J','F','G','H') reverse,
               List('T','Z','C','D','L','M','S','R') reverse,
               List('M','T','W','V','H','Z','J') reverse,
               List('T','F','P','L','Z') reverse,
               List('Q','V','W','S') reverse,
               List('W','H','L','M','T','D','N','C') reverse)

  def moveCrates(lines: List[String], crates: List[List[Char]]): String =
    def loop(lines: List[String], crates: List[List[Char]]): List[List[Char]] =
      lines match
        case Nil => crates
        case head::tail => head match
          case s"move $n from $source to $dest" =>
            val new_source = crates.apply(source.toInt - 1).drop(n.toInt)
            val new_dest = crates.apply(source.toInt - 1).take(n.toInt).concat(crates apply(dest.toInt - 1))
            val new_crates = crates updated(source.toInt - 1, new_source) updated(dest.toInt - 1, new_dest)
            loop(tail, new_crates)
    val result = loop(lines, crates)
    (for i <- 0 to 8 yield result.apply(i).head).mkString

  println(moveCrates(moves, crates))

