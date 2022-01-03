import sun.invoke.empty.Empty

import scala.collection.mutable.ListBuffer

object main {
  def main(args: Array[String]): Unit = {
    val list: List[String] = List("Poniedzialek", "Wtorek", "Sroda", "Czwartek", "Piatek", "Sobota", "Niedziela")
    //zad1
    println("Zad1")
    println(toStringFor(list))
    println(onlyP(list))
    println(toStringWhile(list))

    //zad2
    println("Zad2")
    println(toStringReq(list, 0, ""))
    println(toStringReqFromEnd(list, list.length - 1, ""))

    //zad3
    println("Zad3")
    println(toStringReqOgon(list, 0, ""))

    //zad4
    println("Zad4")
    println(list.foldLeft("") { (a, m) => a + "," + m })
    println(list.foldRight("") { (a, m) => a + "," + m })
    println(list.foldLeft("") { (a, m) =>
      if (m.startsWith("P")) {
        a + "," + m
      } else {
        a
      }
    })

    //zad5
    println("Zad5")
    val ceny: Map[String, Double] = Map("mleko" -> 100.0, "platki" -> 50.0)
    var newCeny = ceny.map((b) => (b._1, obnizka(b._2)))
    println(newCeny.toString())

    //zad6
    println("Zad6")
    println(krotka("bmw", 10, false))

    //zad7
    println("Zad7")
    val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
    println("show(capitals.get( \"Japan\")) : " + show(capitals.get("Japan")))
    println("show(capitals.get( \"India\")) : " + show(capitals.get("India")))

    //zad8
    println("Zad8")
    val numberList = List(1, 0, 2, 4, 5, 6, 19, 0, 20)
    val clearList = del0(numberList, new ListBuffer[Int](), 0)
    println(clearList.toString())

    //zad9
    println("Zad8")
    val plus = plusOne(numberList)
    println(plus)

    //zad10
    val numberMinus = List(-1.4, 0, -2.5, -4.4, -5.3, -6.5, -11.3, 0, -20.2)
    println(filterList(numberMinus))

  }

  def filterList(list: List[Double]): List[Double] = {
    list.filter((a)=> (-5.0)<=a&&a<=(12.0)).map(a => a.abs)
  }

  def plusOne(list: List[Int]): List[Int] = {
    list.map((a) => a + 1)
  }

  def del0(list: List[Int], clearList: ListBuffer[Int], counter: Int): List[Int] = {
    if (list.length - 1 == counter) {
      clearList.toList
    } else {
      if (list(counter) != 0) {
        del0(list, clearList += list(counter), counter + 1)
      } else {
        del0(list, clearList, counter + 1)
      }
    }
  }


  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "nie ma"
  }

  def krotka[A, B, C](t: Tuple3[A, B, C]): String = {
    t._1 + " " + t._2 + " " + t._3
  }

  def obnizka(a: Double): Double = {
    a - a * 0.1
  }

  def toStringReqOgon(list: List[String], counter: Int, string: String, empty: String = ""): String = {
    if (list.isEmpty) {
      empty
    }
    if (counter <= list.length - 1) {
      val result = string + list(counter) + ","
      toStringReq(list, counter + 1, result)
    } else {
      string
    }
  }

  def toStringReq(list: List[String], counter: Int, string: String): String = {
    if (counter <= list.length - 1) {
      val result = string + list(counter) + ","
      toStringReq(list, counter + 1, result)
    } else {
      string
    }
  }

  def toStringReqFromEnd(list: List[String], counter: Int, string: String): String = {
    if (counter != 0) {
      val result = string + list(counter) + ","
      toStringReqFromEnd(list, counter - 1, result)
    } else {
      string + list.head
    }
  }

  def toStringFor(list: List[String]): String = {
    var result: String = ""
    for (day <- list) {
      result += day + ","
    }
    return result
  }

  def onlyP(list: List[String]): String = {
    var result: String = ""

    for (day <- list) {
      if (day.startsWith("P")) {
        result += day + ","
      }
    }

    return result
  }

  def toStringWhile(list: List[String]): String = {
    var result: String = ""
    var counter: Int = 0
    while (counter <= list.length - 1) {
      result += list(counter) + ","
      counter += 1
    }
    return result
  }
}
