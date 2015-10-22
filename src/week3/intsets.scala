package week3

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

object Empty extends IntSet {
  def contains(x: Int):Boolean = false

  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)

  override def toString = "."

  def union(other: IntSet): IntSet = other
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def this(elem: Int) = this(elem, Empty, Empty)
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this

  override def toString = "{" + left + "-" + elem + "-" + right + "}"

  def union(other: IntSet): IntSet =
    ((left union right) union other) incl elem
}

object intsets extends App{
  val t1 = new NonEmpty(3)
  val t2 = t1 incl 4 incl 2 incl 6 incl 4 incl 10 incl 8
  println(t2)
}
