package com.ponchonog.census

import org.scalatest.{FunSuite, Matchers}

class CensusSpec extends FunSuite with Matchers {

  test("Pick a first name") {
    val firstName: String = Census.someFirstName
    println(firstName)

    firstName should not be 'empty
  }

  test("Pick a last name") {
    val lastName: String = Census.someLastName
    println(lastName)

    lastName should not be 'empty
  }

  test("Pick a company") {
    val company: String = Census.someCompany
    println(company)

    company should not be 'empty
  }

  test("Pick an email address") {
    val emailAddress: String = Census.someEmailAddress
    println(emailAddress)

    emailAddress should not be 'empty
    emailAddress should fullyMatch regex """\b[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}\b"""
  }
}
