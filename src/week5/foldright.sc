def mapFun[T, U](xs: List[T], f: T=> U): List[U] =
  (xs foldRight List[U]())(f(_) :: _)

mapFun(List[Int](1, 2, 3), (x: Int) => 3 * x)

def lengthFun[T](xs: List[T]): Int =
  (xs foldRight 0)((x,y) => 1 + y)

lengthFun(List(1,2,3,4))
