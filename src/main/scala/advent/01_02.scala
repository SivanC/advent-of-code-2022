package advent

import scala.io.Source

@main def Intro() = 
  val file = "inputs/calories.txt"
  val list = Source.fromFile(file).getLines.toList.map(s => s match
    case "" => 0
    case x  => x.toInt
  )
  def counter(l: List[Int]) =
    def loop(l: List[Int], max: List[Int], acc: Int): Int = l match
      case Nil => max.sum
      case head::tail => head match
        case 0 => 
          if (acc > max.min) loop(tail, max.updated(max.indexOf(max.min), acc), 0) 
          else loop(tail, max, 0)
        case x => loop(tail, max, acc + x)
    loop(l, List(0, 0, 0), 0)

  println(counter(list))
