#!/bin/bash
if [ $# -ne 4 ]
then
	echo "ERROR: project name, version, and scalaVersion must be supplied." >&2
	echo "USAGE: param1 -> project name, param2 -> project version, param3 -> scalaVersion, param4 -> sbt version"
	exit 1
fi

mkdir {app,conf,project,public,test,tutorial,docs,logs,gatling,target,scripts,modules}
mkdir -p app/{assets,controllers,views,https,router}
touch {build.sbt,LICENSE}
touch app/controllers/{MainController.scala,MessageController.scala}
touch app/views/index.scala.html
touch conf/{application.conf,routes,secure.conf,generated.keystore,disabledAlgorithms.properties}
touch project/{build.properties,plugins.sbt}
touch logs/{application.log,metrics.log}
echo 'project.uuid='$(uuidgen) > ./project/build.properties
echo 'sbt.version='$4 >> ./project/build.properties

echo 'name := "'$1'"

version := "'$2'"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies ++= Seq(
  jdbc,
  javaCore,
  filters
)

scalaVersion := "'$3'"' > build.sbt

echo 'addSbtPlugin("com.typesafe.play" %% "sbt-plugin" % "latest.integration")' > ./project/plugins.sbt
touch .gitignore
