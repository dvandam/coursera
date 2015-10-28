package week4
//
//trait Expr {
//  def isNumber: Boolean
//  def isSum: Boolean
//  def numValue: Int
//  def leftOp: Expr
//  def rightOp: Expr
//}
//
//class Number(n: Int) extends Expr {
//  def isNumber = true
//  def isSum = false
//  def numValue = n
//  def leftOp = throw new Error("Number.leftOp")
//  def rightOp = throw new Error("Number.rightOp")
//}
//
//class Sum(e1: Expr, e2: Expr) extends Expr {
//  def isNumber = false
//  def isSum = true
//  def numValue = throw new Error("Sum.numValue")
//  def leftOp = e1
//  def rightOp = e2
//}
