class Container[+T](n: T) {
  def put[E >: T](a: E): Container[E] = new Container[E](a)
  def get(): T = n
}
