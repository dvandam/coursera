package week2

object HigherOrderFunctions extends App {
  def id(x: Int): Int = x
  def cube(x: Int): Int = x * x * x
  def fact(x: Int): Int = if (x == 0) 1 else x * fact(x - 1)

//  def sum(f: Int => Int, a: Int, b: Int): Int =
//    if (a > b) 0
//    else f(a) + sum(f, a + 1, b)

  def sumInts(a: Int, b: Int) = sum(id)(a, b)
  def sumCubes(a: Int, b: Int) = sum(cube)(a, b)
  def sumFactorials(a: Int, b: Int) = sum(fact)(a, b)

  val myval = sumCubes(3, 5)

  def sum(f: Int => Int)(a: Int, b: Int): Int = mapReduce((x, y) => x + y, 0)(f)(a, b)
//  {  def loop(a: Int, acc: Int): Int = {
//      if (a > b) acc
//      else loop (a + 1, acc + f(a))
//    }
//    loop (a, 0)
//  }

  def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce((x, y) => x * y, 1)(f)(a, b)
//    if (a > b) 1
//    else f(a) * product(f)(a + 1, b)

  def prodfact(n: Int) = product(x => x)(1, n)

//  def generalized(g: (Int, Int) => Int)(f: Int => Int)(a: Int, b: Int): Int =
//    if g(a, b)
//    else f(a) * product(f)(a + 1, b)

  def mapReduce(combine: (Int, Int) => Int, zero: Int)(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) zero
    else combine(f(a), mapReduce(combine, zero)(f)(a + 1, b))
}
