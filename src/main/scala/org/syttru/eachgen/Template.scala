package org.syttru.eachgen

/**
 * テンプレートは{1},{2},...{n}という置換文字列を含む文字列
 */
class Generator(val template:String) {

  /** データを受け取って文字列を生成する */
  def generate(data:List[String]) = _generate(data, template, 1)

  def _generate(data:List[String], tpl:String, idx:Int):String = data match {
    case x::xs => _generate(xs, tpl, idx+1).replace("{" + idx + "}", x)
    case Nil   => tpl
  }
}
