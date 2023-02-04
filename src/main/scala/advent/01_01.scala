package advent

import scala.io.Source

@main def Intro() = 
  val file = "inputs/calories.txt"
  val list = Source.fromFile(file).getLines.toList.map(s => s match
    case "" => 0
    case x  => x.toInt
  )
  def counter(l: List[Int]) =
    def loop(l: List[Int], max: Int, acc: Int): Int = l match
      case Nil => max
      case head::tail => head match
        case 0 => if (acc > max) loop(tail, acc, 0) else loop(tail, max, 0)
        case x => loop(tail, max, acc + x)
    loop(l, 0, 0)

  println(counter(list))
