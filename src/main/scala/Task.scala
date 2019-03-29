import scala.util.Try

object Task {
  def createString(size: Int): Try[String] = {
    Try {
      require(size >= 0, "sizeはゼロ以上である必要があります")
      (for(i <- 0 to size) yield "a").mkString
    }
  }

  def benchmark(f: => Unit) = {
    val begin = System.currentTimeMillis()
    f
    val end = System.currentTimeMillis()
    val formatter = java.text.NumberFormat.getNumberInstance()
    println(s"time: ${formatter.format(end - begin)}ミリ秒")
  }

  def benchmarkNano(f: => Unit) = {
    val begin = System.nanoTime()
    f
    val end = System.nanoTime()
    val formatter = java.text.NumberFormat.getNumberInstance()
    println(s"time: ${formatter.format(end - begin)} ナノ秒")
  }

  def reverse[T](list: List[T]): List[T] = list.foldLeft(Nil: List[T])((a, b) => b :: a)

  def myMap[T, U](list: List[T])(f: T => U): List[U] = {
    list.foldLeft(Nil: List[U])((x, y) => f(y) :: x).reverse
  }

  def myFilter[T](list: List[T])(f: T => Boolean): List[T] = {
    list.foldLeft(Nil: List[T]){(x, y) =>
      if(f(y)) { y :: x } else x
    }.reverse
  }

  def myFlatten(list: List[_]): List[Any] = list match {
    case Nil => Nil
    case (x: List[_])::xs => myFlatten(x) ++ myFlatten(xs)
    case x::xs => x::myFlatten(xs)
  }

  def mySplit[A](n: Int, list: List[A]): (List[A], List[A]) = {
    def splitRec(index: Int, take: List[A], lest: List[A]): (List[A], List[A]) =
      (index, lest) match {
        case (_, Nil)  => (take.reverse, Nil)
        case (0, list) => (take.reverse, lest)
        case(i, x::xs) => splitRec(i - 1, x::take, xs)
      }
    splitRec(n, Nil, list)
  }

  val tribs: Stream[Int] = {
    0 #:: 0 #:: 1 #:: tribs.zip(tribs.tail).zip(tribs.tail.tail).map { n => n._1._1 + n._1._2 + n._2 }
  }

  implicit class Twice(val src: String) {
    def twice: String = src * 2
  }

}

object Taps {
  implicit class Tap[T](self: T){
    def tap[U](block: T => U): T = {
      block(self) // 値は捨てる
      self
    }
  }

  def main(args: Array[String]): Unit = {
    "Hello, World".tap{s => println(s)}.reverse.tap{s => println(s)}
  }
}
