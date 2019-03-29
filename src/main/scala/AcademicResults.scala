
object AcademicResults extends App {

  val results = Map(
    "taro" -> Some(90),
    "jiro" -> None
  )

  val hoge = "hogehoge"

  sealed trait Result
  case class Point(point: Int) extends Result
  sealed trait Error extends Result
  case object StudentNotFound extends Error
  case object ResultNotFound extends Error

  def find(name: String): Result = {
    results.get(name) match {
      case Some(pointOpt) => pointOpt match {
        case Some(point) => Point(point)
        case None => ResultNotFound
      }
      case None => StudentNotFound
    }
  }

  def printResult() = {
    println(find("taro"))
    println(find("jiro"))
    println(find("saburo"))
  }
}
