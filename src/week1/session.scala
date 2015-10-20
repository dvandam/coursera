package week1

import scala.annotation.tailrec

object session extends App {
  def abs(x: Double) = if (x < 0) -x else x

  def sqrt(x: Double) = {
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double): Boolean =
      abs(guess * guess - x) / x < 0.001

    def improve(guess: Double): Double =
      (guess + x / guess) / 2

    sqrtIter(1.0)
  }

  @tailrec
  def gcd(a: Int, b: Int): Int =
    if (b ==0) a else gcd(b, a % b)

  println(gcd (14, 21))

  def factorial(n: Int): Int = {
    @tailrec
    def innerFactorial(accumulator: Int, n: Int): Int = {
      require(n >= 0)
      if (n <= 1) return accumulator
      else innerFactorial(accumulator * n, n - 1)
    }
    innerFactorial(1, n)
//    if (n == 0) 1 else n * factorial(n - 1)
  }

  println(factorial(5))
  println(factorial(1))
  println(factorial(0))

  println(sqrt(2))
  println(sqrt(4))
  println(sqrt(9))
  println(sqrt(0.001))
  println(sqrt(0.1e-20))
  println(sqrt(1.0e20))
  println(sqrt(1.0e50))
  println("klaar")
}
