package advent

import scala.io.Source

@main def DaySix() =
  val file = "inputs/stream.txt"
  val in = Source.fromFile(file).getLines.toList.apply(0).toList

  def receive(stream: List[Char]): Int =
    val acc = 4
    def loop(stream: List[Char], acc: Int): Int = stream match
      case Nil => acc
      case h1::h2::h3::h4::tail =>
        if List(h1,h2,h3,h4).distinct == List(h1,h2,h3,h4) then
          acc
        else
          loop(h2::h3::h4::tail, acc+1)
      case _ =>
        println("No packet marker detected!")
        -1
    loop(stream, acc)
  println(receive(in))


