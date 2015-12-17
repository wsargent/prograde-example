package com.example

object Hello {
  def main(args: Array[String]): Unit = {
    val runtime = Runtime.getRuntime
    val cwd = System.getProperty("user.dir")
    val process = runtime.exec(s"$cwd/testscript.sh") // pick something harmless
    println("Process executed without security manager interference!")
  }
}
