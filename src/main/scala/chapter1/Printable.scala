package chapter1

trait Printable[A] {

  def format(a: A): String

}

object PrintableInstances {

  implicit val printableString = new Printable[String] {
    override def format(a: String): String = a
  }

  implicit val printableInt = new Printable[Int] {
    override def format(a: Int): String = a.toString
  }

}


object Printable {

  def format[A : Printable](a: A): String = implicitly[Printable[A]].format(a)

  def print[A : Printable](a: A): Unit = println(format(a))

}

object PrintableSyntax {

  implicit class PrintableOps[A : Printable](a: A) {

    def format: String = implicitly[Printable[A]].format(a)

    def print(): Unit = println(implicitly[Printable[A]].format(a))

  }

}
