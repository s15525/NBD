
object main {
  def main(args: Array[String]): Unit = {
    //zad1
    println("zad1")
    println(identyfikacja("Poniedzialek"))
    println(identyfikacja("Sobota"))
    println(identyfikacja("bmw"))

    //zad2
    println("zad2")
    var kontoBankowe = new KontoBankowe(1)
    println(kontoBankowe.getStanKonta())
    kontoBankowe.wyplata(11)
    println(kontoBankowe.getStanKonta())
    kontoBankowe.wplata(100)
    println(kontoBankowe.getStanKonta())
    var kontoBankowe1 = new KontoBankowe()
    println(kontoBankowe1.getStanKonta())

    //zad3
    println("zad3")
    var osoba = new Osoba("Bartek", "Nos")
    var osoba1 = new Osoba("Wlodek", "Koc")
    var osoba2 = new Osoba("Sara", "Kosiara")
    var osoba3 = new Osoba("Lukasz", "Tolpa")
    println(powitanie(osoba))
    println(powitanie(osoba1))
    println(powitanie(osoba2))
    println(powitanie(osoba3))

    //zad4
    println("zad4")
    println(trzyrazytosamo(4,funkcja))

    //zad5
    println("zad5")
    var student = new Osoba2("Lukasz","Marciniak",30.0) with Student
    println(student.podatek)
    var pracownik = new Osoba2("Lukasz","Marciniak",30.0) with Pracownik{
      override var pensja: Double = 400
    };
    println(pracownik.podatek)
    var nauczyciel = new Osoba2("Lukasz","Marciniak",30.0) with Nauczyciel{
      override var pensja: Double = 320
    };
    println(nauczyciel.podatek)

    var student4 = new Osoba2("Lukasz","Marciniak",30.0) with Student with Pracownik{
      override var pensja: Double = 320
      override def podatek:Double=super[Pracownik].podatek;//Pomoc ze stacka
    };
    println(student4.podatek)
    var student5 = new Osoba2("Lukasz","Marciniak",30.0) with Pracownik with Student {
      override var pensja: Double = 320
      override def podatek:Double=super[Student].podatek;//Pomoc ze stacka
    };
    println(student5.podatek)
  }

  trait Pracownik{
    var pensja : Double
    def getPensja:Double = {
      pensja
    }
    def setPensja(value:Double):Unit={
      pensja=value
    }
    def podatek:Double = pensja*0.2;
  }
  trait Student{
    def podatek:Double = 0.0;
  }
  trait Nauczyciel extends Pracownik {
    override def podatek:Double = pensja*0.1;
  }

  def funkcja(liczba: Int): Int = {
    liczba+4+2+4
  }

  def trzyrazytosamo(liczba: Int, funkcja: Int => Int): Int = {
    funkcja(funkcja(funkcja(liczba)))
  }

  def identyfikacja(string: String): String = {
    string match {
      case "Poniedzialek" => "Praca"
      case "Wtorek" => "Praca"
      case "Sroda" => "Praca"
      case "Czwartek" => "Praca"
      case "Piątek" => "Praca"
      case "Sobota" => "Weekend"
      case "Niedziela" => "Weekend"
      case _ => "Nie ma takiego dnia"
    }
  }

  def powitanie(osoba: Osoba): String = {
    osoba.getImie() + " " + osoba.getNazwisko() match {
      case "Bartek Nos" => "Witaj Bartek"
      case "Wlodek Koc" => "Witaj eminencjo"
      case "Sara Kosiara" => "Elko"
      case _ => "Witaj Gosciu"
    }
  }
}

class KontoBankowe(private var stanKonta: Int) {

  def this() {
    this(0)
  }

  def wplata(ile: Int): Unit = {
    stanKonta = stanKonta + ile
  }

  def wyplata(ile: Int): Unit = {
    stanKonta = stanKonta - ile
  }

  def getStanKonta(): String = {
    stanKonta.toString
  }
}

class Osoba(private var imie: String, private var nazwisko: String) {

  def getImie(): String = {
    imie
  }

  def getNazwisko(): String = {
    nazwisko
  }
}

class Osoba2(imie: String,  nazwisko: String, podatek: Double){
}