# Tutorial for building evironment of Rest with Playframework

##1.Install sbt and add it to PATH

http://grosdim.blogspot.ca/2013/01/quick-sbt-tutorial.html

##2.Add sbteclipse plugin to sbt

https://github.com/typesafehub/sbteclipse

  * Add addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "4.0.0") to
PROJECT_DIR/project/plugins.sbt
 
  * In build.sbt, add following statements
  
  // Compile the project before generating Eclipse files,so that generated .scala or .class files for views and routes are present

  EclipseKeys.preTasks := Seq(compile in Compile) 

  * In the project directory, execute
  D:\play_workspace\order-api-rest-java-playframework> sbt eclipse
 http://stackoverflow.com/questions/31511143/play-framework-executioncontext-cannot-be-resolved-when-trying-to-map-a-promis

##3.Install scala eclipse and import the project by importing from existing project

##4.Running
D:\play_workspace\order-api-rest-java-playframework> activator "eclipse with-source=true"
playRun

##5.Debugging
https://www.playframework.com/documentation/2.5.x/PlayConsole

In project directory, execute command
activator -jvm-debug #debug_port "run #running_port"
for example,
D:\play_workspace\order-api-rest-java-playframework> activator -jvm-debug 9999 "run 8080"

http://stackoverflow.com/questions/8205067/how-do-i-change-the-default-port-9000-that-play-uses-when-i-execute-the-run
