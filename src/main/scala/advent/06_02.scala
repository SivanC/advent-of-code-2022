package advent

import scala.io.Source

@main def DaySix() =
  val file = "inputs/stream.txt"
  val in = Source.fromFile(file).getLines.toList.apply(0).toList

  def receive(stream: List[Char]): Int =
    val acc = 14
    def loop(stream: List[Char], acc: Int): Int = stream match
      case Nil => acc
      case head::tail =>
        if (head::tail.take(13)).distinct.length == 14 then
          acc
        else
          loop(tail, acc + 1)
    loop(stream, acc)
  println(receive(in))


