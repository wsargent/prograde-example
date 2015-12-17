name := """prograde-example"""

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

// https://github.com/pro-grade/pro-grade
libraryDependencies += "net.sourceforge.pro-grade" % "pro-grade" % "1.1.1"

// Require fork to avoid the SBT security manager
fork := true

// Once prograde has been generated, use the security policy defined.
// REMINDER: You will have to run "reload" if you change these settings with a running SBT.
javaOptions in (run) ++= Seq("-Djava.security.manager=net.sourceforge.prograde.sm.ProGradeJSM",
                             "-Djava.security.policy==strict.policy")

// Run the app initially with the policy file generator (with ALL USE CASES)
javaOptions in (Test) ++= Seq("-Djava.security.manager=net.sourceforge.prograde.sm.PolicyFileGeneratorJSM",
                              "-Djava.security.policy==/dev/null",
                              "-Dprograde.generated.policy=prograde.policy")
