
object AcademicResults2 {

  val results = Map(
    "taro" -> Some(90),
    "jiro" -> None
  )

  sealed trait Result
  case class Point(point: Int) extends Result
  sealed trait Error extends Result
  case object StudentNotFound extends Error
  case object ResultNotFound extends Error

  def find(name: String): Result = {
    (for{
      pointOpt <- results.get(name).toRight(StudentNotFound)
      point <- results(name).toRight(ResultNotFound)
    } yield Point(point)).merge
  }

  def printResult() = {
    println(find("taro"))
    println(find("jiro"))
    println(find("saburo"))
  }
}
