package advent 

import scala.io.Source

@main def DayThree() = 
  val file = "inputs/rucksack.txt"

  val lower = ('a' to 'z').toList
  val upper = ('A' to 'Z').toList
  val key = lower++upper

  var acc = 0
  for (line <- Source.fromFile(file).getLines)
    val first = line.take(line.length / 2)
    val second = line.drop(line.length / 2)
    val shared = first.find(x => second contains x).get
    val priority = key.indexOf(shared) + 1
    acc += priority

  println(acc)
