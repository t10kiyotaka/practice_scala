import scala.annotation.tailrec

object Main {

  @tailrec
  def series(n: Int, acc: Int): Int = {
    if(n == 0){
      acc
    } else {
      series(n - 1, acc + n)
    }
  }

  @tailrec
  def fanc(n: Int, acc: Int): Int = if(n <= 1) acc else fanc(n - 1, acc * n)

  def twice(f: Int => Int): Int => Int = {
//    x => f(f(x))
    f.compose(f)
  }


}
