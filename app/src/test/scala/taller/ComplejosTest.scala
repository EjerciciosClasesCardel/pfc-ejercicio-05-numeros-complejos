package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ComplejosTest extends AnyFunSuite {
  val q1 = new Complejos(1.0,2.0)
  val q2 = new Complejos(4.0,3.0)
  val q3 = new Complejos(3.0,6.0)

  test("Representación numeros"){
    assert(q1.toString == "1.0 + 2.0i")
    assert(q2.toString == "4.0 + 3.0i")
    assert(q3.toString == "3.0 + 6.0i")
  }

  test("Suma numeros") {
    assert((q1 + q2).toString == "5.0 + 5.0i")
    assert((q2 + q3).toString == "7.0 + 9.0i")
  }

  test("Resta numeros") {
    assert((q1 - q2).toString == "-3.0 - 1.0i")
    assert((q2 - q3).toString == "1.0 - 3.0i")
  }

  test("Multiplicación números") {
    assert((q1 * q2).toString == "-2.0 + 11.0i")
    assert((q2 * q3).toString == "-6.0 + 33.0i")
  }

  test("División números") {
    assert((q1 / q2).toString == "0.4 + 0.2i")
    assert((q2 / q3).toString == "0.667 - 0.333i")
  }
}
