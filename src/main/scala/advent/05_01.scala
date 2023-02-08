package advent

import scala.io.Source
import scala.collection.mutable.Stack

@main def DayFive() = 
  val file = "inputs/crates.txt"
  val lines = Source.fromFile(file).getLines.toList
  val moves = lines.drop(10)

  // 9 crates with input terribly formatted in file
  // and yes this way is also dumb
  val crates = List(Stack[Char](),Stack[Char](),Stack[Char](),
                    Stack[Char](),Stack[Char](),Stack[Char](),
                    Stack[Char](),Stack[Char](),Stack[Char]())
  for (l1 <- List('R','G','H','Q','S','B','T','N')) crates.apply(0).push(l1)
  for (l2 <- List('H','S','F','D','P','Z','J')) crates.apply(1).push(l2)
  for (l3 <- List('Z','H','V')) crates.apply(2).push(l3)
  for (l4 <- List('M','Z','J','F','G','H')) crates.apply(3).push(l4)
  for (l5 <- List('T','Z','C','D','L','M','S','R')) crates.apply(4).push(l5)
  for (l6 <- List('M','T','W','V','H','Z','J')) crates.apply(5).push(l6)
  for (l7 <- List('T','F','P','L','Z')) crates.apply(6).push(l7)
  for (l8 <- List('Q','V','W','S')) crates.apply(7).push(l8)
  for (l9 <- List('W','H','L','M','T','D','N','C')) crates.apply(8).push(l9)

  def moveCrates(lines: List[String], crates: List[Stack[Char]]): String =
    def loop(lines: List[String], crates: List[Stack[Char]]): List[Stack[Char]] =
      lines match
        case Nil => crates
        case head::tail => head match
          case s"move $n from $source to $dest" =>
            for i <- 0 to n.toInt - 1 do
              val crate = crates.apply(source.toInt - 1).pop
              crates.apply(dest.toInt - 1).push(crate)
            loop(tail, crates)
    val result = loop(lines, crates)
    val str = new StringBuilder()
    (for i <- 0 to 8 yield result.apply(i).top).addString(str).mkString

  println(moveCrates(moves, crates))

