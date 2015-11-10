package week4

trait Expr {
  def eval: Int = this match {
    case Number(n) => n
    case Sum(e1, e2) => e1.eval + e2.eval
    case Prod(e1, e2) => e1.eval * e2.eval
  }
  def show: String = this match {
    case Number(n) => n.toString
    case Sum(e1, e2) => e1.show + " + " + e2.show
    case Prod(e1:Sum, e2:Sum) => "(" + e1.show + ") * (" + e2.show + ")"
    case Prod(e1, e2:Sum) => e1.show + " * (" + e2.show + ")"
    case Prod(e1:Sum, e2) => "(" + e1.show + ") * " + e2.show
    case Prod(e1, e2) => e1.show + " * " + e2.show
    case Var(x) => x
  }
}

object expr extends App {
  println(Sum(Number(4), Number(40)).show)
  println(Sum(Number(4), Number(40)).eval)
  println(Sum(Prod(Number(2), Var("x")), Var("y")).show)
  println(Prod(Sum(Number(2), Var("x")), Var("y")).show)
}

case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Prod(e1: Expr, e2: Expr) extends Expr
case class Var(x: String) extends Expr
