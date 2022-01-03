
object main {
  def main(args: Array[String]): Unit = {
    var no = new No
    var yes = new Yes[String]("Suppeeeeerr")
    println(yes.isInstanceOf[Maybe[_]])
    println(no.isInstanceOf[Maybe[_]])
  }
}

trait Maybe[A] {}

class Container[A](private val zawartosc: A) {

  def getContent(): A = {
    zawartosc
  }

  def applyFunction[R](funkcja: A => R): R = {
    funkcja(zawartosc)
  }
}

class No extends Maybe[Nothing] {
  def applyFunction[A, R](funkcja: A => R): No = {
    new No()
  }

  def getOrElse[A](parametr: A) = {
    parametr
  }
}

class Yes[A](var zawartosc: A) extends Maybe[A] {
  def applyFunction[R](f: A => R): R = {
    f(zawartosc)
  }

  def getOrElse(param: A): A = {
    zawartosc
  }
}