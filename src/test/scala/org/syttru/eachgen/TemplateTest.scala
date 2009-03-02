package org.syttru.eachgen

import org.junit._
import Assert._

@Test
class TemplateTest {
  @Test
  def testGenerate = {
    var tpl = new Template("insert into tbl values({1}, '{2}', {3});")
    assertEquals(
        "insert into tbl values(1, 'apple', 300);", 
        tpl generate List("1", "apple", "300"))
    assertEquals(
        "insert into tbl values(2, 'orange', 250);",
        tpl generate List("2", "orange", "250"))
    assertEquals(
        "insert into tbl values(3, 'greep', {3});",
        tpl generate List("3", "greep"))

    tpl = new Template("{1}, {2}, {3}, {1}, {2}, {3}")
    assertEquals(
        "1, apple, 300, 1, apple, 300", 
        tpl generate List("1", "apple", "300"))
  }
}
