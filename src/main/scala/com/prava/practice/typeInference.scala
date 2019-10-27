package com.prava.practice

object typeInference {

  def id[T] (x: T) = x

  val x: List[Int] = id(List(1, 2, 3))

  // Types are now preserved. Scala compiler infers the type parameter
  // for us.
}