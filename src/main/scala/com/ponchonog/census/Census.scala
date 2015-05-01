package com.ponchonog.census

import com.ponchonog.census.ReferenceData.{companies, lastNames, girlsFirstNames, boysFirstNames}

import scala.util.Random

object Census {

  def someFirstName: String = oneOf(boysFirstNames ++ girlsFirstNames)

  def someLastName: String = oneOf(lastNames)

  def someCompany: String = oneOf(companies)

  def someEmailAddress(company: String = someCompany): String = {
    val cleanCompany = s"$company".replace(".com", "").replaceAll( """[^a-zA-Z0-9]""", "")

    s"$someFirstName.$someLastName@$cleanCompany.com"
      .replaceAll( """[^@.a-zA-Z0-9-]""", "")
      .toLowerCase
  }

  private def oneOf(values: Set[String]): String = Random.shuffle(values.toList).head
}
