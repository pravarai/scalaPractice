package com.prava.practice

object Application extends App {
  import com.prava.practice
  println("Hello World")
  parametricPolymorphism
}

object forComprehension {
  val nameList = List("John", "Ruby", "Todd")
  val upperCaseNames = for (user <- nameList) yield user.toUpperCase()
  upperCaseNames.foreach(println)
}

object forComprehension2 {
  def foo(x: Int, y: Int) = {
    for (i <- 0 until x;
         j <- 0 until x if i + j == y) yield (i, j)
  }

  foo(10, 10) foreach {
    case (i, j) =>
      println(s"($i, $j)")
  }
}


object monadForComprehension {

  val fruits = List("Apple", "Banana", "Pear")
  val resFruits = fruits.flatMap(_.toUpperCase())
  println(resFruits)

  val fruit = "Apple"

  // def map[A, B](ma: Box[A])(f: A => B): Box[B]
  // f: A => B
  // convert each character to it's uppercase
  val res3 = fruit.map(_.toUpper)
  println(res3)


  //def flatMap[A, B](ma: Box[A])(f: A => Box[B]): Box[B]
  // f: A => Box[B]
  // convert each character to Box [B] or String
  val res4 = fruit.flatMap(c => c.toUpper + ".")
  // A=> Container[B] where Container[B] is a String

  println(res4)

  // def map[A, B](ma: Box[A])(f: A => B): Box[B]
  val strings = Seq("1", "2", "foo", "4", "bar")
  println(strings.map(toInt))

  def toInt(s: String): Option[Int] = {
    try {
      Some(Integer.parseInt(s.trim))
    } catch {
      case e: Exception => None
    }
  }

  //def flatMap[A, B](ma: Box[A])(f: A => Box[B]): Box[B]
  println(strings.flatMap(toInt))

}

object obj {
  val a = Some(2)
  val b = Some(3)

  val res = a.flatMap { num1 =>
    b.map { num2 =>
      num2 + num1
    }
  }

  val res2 = a.map(_ + 3)

  val res3 = a.map(_.toString)

  println(res)
  println(res2)
  println(res3)


  val seq = Seq(1, 3, 5, "Hello")

  println(seq.map(_.toString)) //Res: List(1, 3, 5, Hello)
  println(seq.flatMap(_.toString)) //Res: List(1, 3, 5, H, e, l, l, o)

  val res4 = for {
    num <- a
    num2 <- b
  } yield num + num2

  println(res4)
}

//dummy changes



