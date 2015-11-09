package week5

object Map extends App {
  def squareListFun(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil
    case y :: ys => y * y :: squareListFun(ys)
  }

  def squareListMap(xs: List[Int]): List[Int] = xs map (x => x * x)

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (first, rest) = xs span (y => y == x)
      first :: pack(rest)
  }

  def encode[T](xs: List[T]): List[(T, Int)] =
    pack(xs) map (ys => (ys.head, ys.length))

  def mapFun[T, U](xs: List[T], f: T=> U): List[U] =
    (xs foldRight List[U]())(f(_) :: _)

  mapFun(List(1, 2, 3), x => 3 * x)
}
