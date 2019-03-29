
object Test {
  def solution(n: Int): Int = n
  solution(1)

  def decimalToBinary(deciNum: Int): String = deciNum.toBinaryString

  def hoge(s: String) = s.split("1")

  def binaryToDescimal(biNum: String) = Integer.parseInt(biNum,2)

  def fuga(n: Int) = {
    val arr = n.toBinaryString.split("1")
    val validatedArr = arr.last match {
      case "" => arr
      case _ => arr.reverse.tail
    }
    validatedArr.map(_.size).max
  }
}