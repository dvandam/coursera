// Peano numbers
package week4

abstract class Nat {
  def isZero: Boolean
  def prededecessor: Nat
  def successor: Nat = new Succ(this)
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}

class Succ(n: Nat) extends Nat {
  val isZero = false
  def prededecessor = n
  def + (that: Nat) = new Succ(n + that)
  def - (that: Nat) = if (that.isZero) n else n - that.prededecessor
}

object Zero extends Nat {
  val isZero = true
  def prededecessor = throw new Error("0.predecessor")
  def + (that: Nat) = that
  def - (that: Nat) = if (that.isZero) this else throw new Error("negative number")
}
