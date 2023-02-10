package advent

import scala.io.Source

@main def DaySeven() =
  val file = "inputs/directories.txt"
  val lines = Source.fromFile(file).getLines.toList

  def compute(lines: List[String]): Int =
    val path = List[Int]()
    val acc = 0
    def loop(lines: List[String], path: List[Int], acc: Int): Int = lines match
      // add all unpopped small directories to acc at the end
      case Nil => 
        if path.filter(_<100000).length == 0 then acc
        else acc + path.filter(_<100000).reduce(_+_)
      // split line by spaces
      case head::tail => head match
        // push new element if new dir, else pop one and add to acc if small
        case s"$$ cd $dir" => dir match
          case ".." => 
            if (path.head < 100000) then loop(tail, path.drop(1), acc + path.head)
            else loop(tail, path.drop(1), acc)
          case _    => loop(tail, 0::path, acc)
        // dont do anything on ls or dir
        case "$ ls" => loop(tail, path, acc)
        case s"dir $dirname" => loop(tail, path, acc)
        // on file, add size to all directories
        case s"$size $filename" => loop(tail, path.map(_ + size.toInt), acc)
        // default
        case line => println("unknown line pattern " + line); -1
    loop(lines, path, acc)
  println(compute(lines))
