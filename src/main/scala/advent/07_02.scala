package advent

import scala.io.Source

@main def DaySeven() =
  val file = "inputs/directories.txt"
  val lines = Source.fromFile(file).getLines.toList

  def compute(lines: List[String]): Int =
    val path = List[Int]()
    val past = List[Int]()
    def loop(lines: List[String],path: List[Int],past: List[Int]): Int=lines match
      case Nil => 
        // outermost directory is last in path
        (path.concat(past)).filter(path.last-_<=40000000).min
      case head::tail => head match
        case s"$$ cd $dir" => dir match
          // move top dir from path to past
          case ".." => loop(tail, path.drop(1), path.head::past) 
          // add new dir to path
          case _    => loop(tail, 0::path, past)
        // dont do anything on ls or dir
        case "$ ls" => loop(tail, path, past)
        case s"dir $dirname" => loop(tail, path, past)
        // on file, add size to all dirs in path
        case s"$size $filename" => loop(tail, path.map(_ + size.toInt), past)
        // default
        case line => println("unknown line pattern " + line); -1
    loop(lines, path, past)
  println(compute(lines))
