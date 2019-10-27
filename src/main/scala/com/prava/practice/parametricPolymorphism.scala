package com.prava.practice

object parametricPolymorphism {

  def drop1[A](l: List[A]) = l.tail

  println(drop1(List(1,2,4)))

  implicit class ListOps[A](val l: List[A]) extends AnyVal {
    def drop1: List[A] = l match {
      case head :: tail => tail
      case Nil => Nil
    }
  }

  println(List(1, 2, 4).drop1)

  //there is actually already a default drop method
  println(List(1, 2, 4) drop 1)
}