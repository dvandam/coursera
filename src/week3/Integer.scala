package week3

class Integer (val value: Int) {
  def + (other: Integer) = new Integer(value + other.value)
  def - (other: Integer) = new Integer(value - other.value)
  def / (other: Integer) = new Integer(Math.round(value / other.value))
  def * (other: Integer) = new Integer(value * other.value)

  override def toString = value.toString
}

object Integer extends App {
  def apply(value: Int) = new Integer(value)

//  println(Integer(18) + Integer(6)  / Integer(3)  - Integer(6)  * Integer(2))
//  println(Integer(18).+(Integer(6))./(Integer(3)).-(Integer(6)).*(Integer(2)))

  println(18  + 6  / 3  - 6  * 2)
  println(18 .+(6)./(3).-(6).*(2))

}
