import $ivy.`com.goyeau::mill-scalafix:0.2.4`
import com.goyeau.mill.scalafix.ScalafixModule
import mill._, scalalib._, scalafmt._

object versions {
  val scala = "2.13.6"
  val scalaTest = "3.2.9"
  object mill {
    val organizeImports = "0.5.0"
  }
}

trait Scala extends ScalaModule with ScalafmtModule with ScalafixModule {
  def scalaVersion = versions.scala
  def scalacOptions = super.scalacOptions() ++ Seq(
    "-language:postfixOps",
    "-deprecation",
    "-Wunused:imports",
  )
  def scalafixIvyDeps = Agg(ivy"com.github.liancheng::organize-imports:${versions.mill.organizeImports}")
}
