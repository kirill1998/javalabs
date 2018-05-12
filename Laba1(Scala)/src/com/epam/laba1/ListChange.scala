package com.epam.laba1

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

  object ListChange extends App {
    val ARRAYSIZE = 5

    def is_even(number:Int):Boolean = {number % 2 == 0}
    def ListChange_array(arr:ArrayBuffer[Int]):ArrayBuffer[Int] =
    {
      var op = ArrayBuffer[Int]()
      for(i <- 0 until arr.length){
        if (is_even(arr(i))) op += arr(i)/2
        else (op+=arr(i)+1)
      }
      op
    }
    @tailrec
    def ListChange_array_2(arr:ArrayBuffer[Int], index:Int, op2:ArrayBuffer[Int]):ArrayBuffer[Int] =
    {
      var op2temp = clone_array(op2)
      if (is_even(arr(index))) op2temp += (arr(index)/2)
      else(op2temp+=arr(index)+1)
      if (index >= arr.size - 1) return op2temp
      return ListChange_array_2(arr, index + 1, op2temp)
    }

    def clone_array(arr:ArrayBuffer[Int]):ArrayBuffer[Int] = {
      var out = ArrayBuffer[Int]()
      for(i <- 0 until arr.length){
        out+=arr(i)
      }
      out
    }

    var list = ArrayBuffer[Int]()
    for (_ <- 0 to ARRAYSIZE - 1) {
      list += scala.io.StdIn.readLine.toInt
    }

    var op2 = ArrayBuffer[Int]()
    var oop_list = ListChange_array(list)
    op2 = ListChange_array_2(list, 0, op2)

    println(oop_list.mkString(", "))
    println(op2.mkString(", "))

}
