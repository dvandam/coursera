package week2

import scala.annotation.tailrec

class Rational(x: Int, y: Int) {
  @tailrec
  private def gcd(a: Int, b: Int): Int = if (b ==0) a else gcd(b, a % b)
  private val gcd:Int = gcd(x, y)
  val numer = x / gcd
  val denom = y / gcd

  def + (that: Rational) = add(that)
  def add(that: Rational) =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def unary_- = neg
  def neg = new Rational(-numer, denom)

  def - (that: Rational) = sub(that)
  def sub(that: Rational) = add(that.neg)

  def less(that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (that.less(this)) this else that

  override def toString = numer + "/" + denom
}


object Rationals extends App {
  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  println(x.sub(y).sub(z))
  println(x - y - z)
  println(-x)
  println(new Rational(6, 8))

  println(new Rational(3, 4).max(new Rational(1, 2)))
  println(new Rational(1, 2).max(new Rational(3, 4)))
}
