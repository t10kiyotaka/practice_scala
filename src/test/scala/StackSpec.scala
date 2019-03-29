import org.scalatest.{DiagrammedAssertions, FlatSpec}

class StackSpec extends FlatSpec with DiagrammedAssertions {

  "Stack" should "LIFO" in {
    val stack = Stack()
    val stackPushed1 = stack.push(1)
    val stackPushed2 = stack.push(2)
    val (poped2, stackPoped2) = stackPushed2.pop
    val (poped1, stackPoped1) = stackPushed1.pop

    assert(poped2 === 2)
    assert(poped1 === 1)
  }

  "isEmpty" should "Return empty correctly" in {
    val stack = Stack()
    assert(stack.isEmpty === true)
    val stackPushed1 = stack.push(1)
    assert(stackPushed1.isEmpty === false)
    val (_, stackPoped1) = stackPushed1.pop
    assert(stackPoped1.isEmpty === true)
  }

  "empty stack" should "throw error when pop" in {
    intercept[IllegalArgumentException] {
      Stack().pop
    }
  }
}
