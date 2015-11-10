package week3

import java.util.NoSuchElementException

trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  def prepend[U >: T](elem: U): List[U] = new Cons(elem, this)
}

object List {
  def apply[T](): List[T] = Nil
  def apply[T](x: T): List[T] = new Cons(x, Nil)
  def apply[T](x: T, y: T): List[T] = new Cons(x, new Cons(y, Nil))
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

object Nil extends List[Nothing] {
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

object test {
  val x: List[String] = Nil
//  def f(xs: List[NonEmpty], x: Empty)  = xs prepend x
}

object nth extends App {
  def singleton[T](elem: T) = new Cons[T](elem, Nil)

  singleton[Int](1)
  singleton[Boolean](true)

  // compiler can infer the types
  singleton(1)
  singleton(true)

  def nth[T](n: Int, xs: List[T]): T =
    if (xs.isEmpty) throw new IndexOutOfBoundsException
    else if (n == 0) xs.head
    else nth(n - 1, xs.tail)

  val list = new Cons(1, new Cons(2, new Cons(3, Nil)))
  println(nth(2, list))
  println(nth(0, list))
}
