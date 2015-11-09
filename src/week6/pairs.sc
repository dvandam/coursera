package week6

object pairs {
  val n=7

  def isPrime(i: Int): Boolean = (2 until i) forall (i % _ != 0)

  (1 until n) flatMap (i =>
    (1 until i) map (j => (i, j))) filter (pair =>
      isPrime(pair._1 + pair._2))

  for {
    i <- 1 until n
    j <- 1 until i
    if isPrime(i + j)
  } yield (i, j)

  def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
    (for ((x, y) <- xs zip ys) yield x * y).sum
}
