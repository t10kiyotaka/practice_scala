import org.scalatest.{DiagrammedAssertions, FlatSpec}
import NumberFormatter._

class NumberFormatterSpec extends FlatSpec with DiagrammedAssertions {
  it should "format" in {
    assert(format(1) === "1")
    assert(format(1000) === "1,000")
    assert(format(-1) === "-1")
    assert(format(0) === "0")
    assert(format(1000000) === "1,000,000")
    assert(format(-1000000) === "-1,000,000")
    assert(format(100) === "100")
    assert(format(-100) === "-100")
  }
}
