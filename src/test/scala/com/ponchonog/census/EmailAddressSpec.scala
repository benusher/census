package com.ponchonog.census

import org.scalatest.{FunSuite, Matchers}

class EmailAddressSpec extends FunSuite with Matchers {

  test("Pick an email address") {
    val emailAddress: String = Census.someEmailAddress
    println(emailAddress)

    emailAddress should not be 'empty
    emailAddress should lookLikeAnEmailAddress
  }

  test("Specify the company") {
    val company = "Acme Limited"
    val emailAddress: String = Census.someEmailAddressFor(company)
    println(emailAddress)

    emailAddress should not be 'empty
    emailAddress should lookLikeAnEmailAddress
    emailAddress should include("""@acmelimited""")
  }

  private def lookLikeAnEmailAddress = fullyMatch regex """\b[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}\b"""
}
