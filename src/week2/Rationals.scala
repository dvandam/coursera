package week2

import scala.annotation.tailrec

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be nonzero")

  def this(x: Int) = this(x, 1)

  @tailrec
  private def gcd(a: Int, b: Int): Int = if (b ==0) a else gcd(b, a % b)
  private val gcd:Int = gcd(x, y)
  val numer = x / gcd
  val denom = y / gcd

  def + (that: Rational) =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def unary_- = new Rational(-numer, denom)

  def - (that: Rational) = this + -that

  def < (that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (that < this) this else that

  override def toString = numer + "/" + denom
}

object Rational {

}

object Rationals extends App {
  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  println(x - y - z)
  println(-x)
  println(new Rational(6, 8))

  println(new Rational(3, 4) max new Rational(1, 2))
  println(new Rational(1, 2) max new Rational(3, 4))
}
