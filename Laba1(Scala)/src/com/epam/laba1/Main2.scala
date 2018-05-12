package com.epam.laba1

import scala.annotation.tailrec
import scala.math.abs

object Main2 {
  def main(args: Array[String]): Unit = {
    val myVector = Vector(10, 21, 2, 23, 3)
    val result1 = execution(myVector)
    println(result1)
    val result2 = recExecution(myVector)
    println(result2)
}

  //////////четные числа /2 , нечетные +1 /////////////////
  def execution(v1: Vector[Int]): Vector[Int] = {
    def internal(a: Int): Int = {
      if (a % 2 == 0) a / 2
      else a + 1
    }
    for (elem <- v1) yield internal(elem)
  }

  def recExecution(v1: Vector[Int]): Vector[Int] = {
    def internal(a: Int): Int = {
      if (a % 2 == 0) a / 2
      else a + 1
    }
    @tailrec
    def tailrec(v1: Vector[Int], acc: Vector[Int]): Vector[Int] = {
      if (v1.isEmpty) acc
      else tailrec(v1.drop(1), acc :+ internal(v1.head))
    }
    tailrec(v1, Vector())
  }


}