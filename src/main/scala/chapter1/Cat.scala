package chapter1

import cats.{
  Eq,
  Show
}
import cats.syntax.eq._
import cats.instances.int._
import cats.instances.string._

case class Cat(name: String, age: Int, color: String) {

  override def toString = s"${name} is a ${age} year-old ${color} cat"

}

object Cat {

  implicit val printableCat = new Printable[Cat] {
    def format(a: Cat): String = s"${a.name} is a ${a.age} year-old ${a.color} cat"
  }

  // implicit val catShow = Show.show((a: Cat) => s"${a.name} is a ${a.age} year-old ${a.color} cat")

  implicit val catShow = Show.fromToString[Cat]

  implicit val catEq = Eq.instance[Cat] { (a, b) => (a.name === b.name) && (a.age === b.age) && (a.color === b.color) }

}
