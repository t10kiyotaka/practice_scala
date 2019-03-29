case class Pair[A, B](a: A, b: B)

object Hoge {
  def isSorted[E](sortedSeq: Seq[E])(isOrdered: (E, E) => Boolean): Boolean = {
    def isSortedRecursive(i: Int): Boolean = {
      if(i == sortedSeq.length - 1) true
      else if(!isOrdered(sortedSeq(i), sortedSeq(i + 1))) false
      else isSortedRecursive(i + 1)
    }
    if(sortedSeq.length == 0) true else isSortedRecursive(0)
  }

  def forexp() = {
    val v1: Option[Int] = Some(2)
    val v2: Option[Int] = Some(3)
    val v3: Option[Int] = Some(5)
    val v4: Option[Int] = Some(7)
    val v5: Option[Int] = Some(11)
    val r = for{
      i1 <- v1
      i2 <- v2
      i3 <- v3
      i4 <- v4
      i5 <- v5
    } yield i1 * i2 * i3 * i4 * i5
    r
  }

  def forexp2(int: Int) = {
    val f1: Option[Int => Int] = Some((x) => x * 2)
    val f2: Option[Int => Int] = Some((x) => x + 10)
    val f3: Option[Int => Int] = Some((x) => x / 3)
    var r = for {
      i1 <- f1
      i2 <- f2
      i3 <- f3
    } yield i3(i2(i1(int)))
    r
  }

}
