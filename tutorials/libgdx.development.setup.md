# Setting up development environment with libGDX in Eclipse
This document describes how to set up development environment with LibGDX and Eclipse. If you have never heard of LibGDX before - then the authors describe it as follows.
>Libgdx is a cross-platform game development library written in Java, with some JNI >code for performance hungry sections. It abstracts away the differences between >writting desktop, Android, iOS and HTML5 games based on standards like OpenGL ES/>WebGL. Applications can be prototyped and developed entirely on the desktop, then >only 6 lines of code are needed to run your app on Android or HTML5.

That is - a library that allows you to write graphic applications on desktop and mobile devices such as phones and handheld devices (android tables anyone?)

If you write a Desktop application using LibGDX (like you will be doing in this course) then it is relatively easy to port it for an Android device as well. We encourage students to experiment with their applications on their devices and hand in both Desktop and mobile solutions (rock points are involved).

So what are we waiting for, let us get busy.


## Installing Eclipse
If you don´t have Eclipse installed on your machine aim your favorite browser to [Eclipse download](http://www.eclipse.org/downloads/) and fetch the latest version of Eclipse Standard and install it on your machine. There are distribution available for Windows, Linux and OS X. Note, before you install Eclipse be sure that you have Java installed on your machine. You can check if Java JDK is installed by opening up a terminal (or cmd.exe) and run `javac`. You should see something like the following listing.

    ➜  ~  javac -version
    javac 1.6.0_51
    
If not head over to [java.com](http://java.com) and download the latest Java release for you operating system.

## Download the LibGDX libraries
Before launching Eclipse. Let's download the latest version of the LibGDX libraries. Aim your browser to [LibGDX download page](http://libgdx.badlogicgames.com/download.html) and fetch the latest release build of the library. Unzip the archive to some good location on your hard drive (~/libgdx or c:/libgdx) where you will be reusing the library throughout the this course.


## Create a project
Fire up Eclipse and create a new Project and name it what ever you like (lab1 might be good name if you want to keep track of what you have doing in the lab and increment the number throughout each lab class).

Before we write some code we need to add the LibGDX dependencies to our newly created project. Right click your project and select _"Properties -> Java Build Path -> Libraries"_. Then click on "Add External JARs…". Browse to the folder where you extracted LibGDX and add the following jars to your project.

- gdx.jar
- gdx-natives.jar
- gdx-backend-lwjgl.jar
- gdx-backend-lwjgl-natives.jar

Then press ok.

Next create a package for your application. Names like "is.ru.tgra" is good for this course, or what ever naming convention you like for Java packages.

## Let´s add some classes
Now this might not be the best way to structure a given graphics program but this structure is nice one to start with. When start getting more familiar with the LibGDX library and you are getting familiar with the myriad of graphics jargon that will flood over you for the next week - then you might want to structure your application differently. Until then, let´s do it this way.

### Create an application listener

The first class the we create implements an interface from LibGDX that is called ApplicationListener and can be found under the `com.badlogic.gdx`. Lets name our class Boxes and the the scheleton of it should be similar to the following code listing.

	package is.ru.tgra;
	
	import com.badlogic.gdx.ApplicationListener;
	
	public class Boxes implements ApplicationListener {
		@Override
		public void create() {
			// TODO Auto-generated method stub
		}
	
		@Override
		public void dispose() {
			// TODO Auto-generated method stub
		}
	
		@Override
		public void pause() {
			// TODO Auto-generated method stub
		}
	
		@Override
		public void render() {
			// TODO Auto-generated method stub
		}
	
		@Override
		public void resize(int arg0, int arg1) {
			// TODO Auto-generated method stub	
		}
	
		@Override
		public void resume() {
			// TODO Auto-generated method stub	
		}
	}
	
Please don't write all these function. When you state that your class implements `ApplicationListener` Eclipse can extract the functions that you need to implement from the interface specification.

Now the authors of LibGDX describes this interface as follows.

> An ApplicationListener is called when the Application is created, resumed, rendering, paused or destroyed. All methods are called in a thread that has the OpenGL context current. You can thus safely create and manipulate graphics resources.
> 
> The ApplicationListener interface follows the standard Android activity life-cycle and is emulated on the desktop accordingly.

This means that when we create our Application a thread is created that calls these "event" functions and we can call OpenGL functions from them to do our graphics routines. Let us briefly discuss when this "magic" thread calls the functions in our class.

**create**: This function is called when our application is created. This function is only called once and here we can initialize resources and enable, or set, flags to the graphics pipeline (you will hear a great deal of flood from Kári about the OpenGL pipeline throughout this course).

**dispose**: This function is called when we close our application. Here we can release resources if needed.

**pause**: This function is called when application is paused on handheld device. Here you can save application state and stop rendering.

**resize**: This function is called when the application is resized. When running on desktop this function is called when the window is resized. Here it is good to think about scaling and windows viewports (you will here a great deal about window and viewports in this course).

**resume**: This function is called when the application is resumed on a handheld device. Here it is good to reload the application state and start rendering.

Now let´s create the application that uses our Application listener. This will be part of our main function of our application. Create a new class that is called `DesktopRunner` and write a similar code as follows within your main function.

	package is.ru.tgra;
	
	import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

	public class DesktopRunner {
		public static void main(String[] args) {
			new LwjglApplication(new Boxes(), "nice", 800, 600, false);
		}
	}

Now try to run your the main function. If everything went well you should see an empty window filled with nothingness. 

Now you can head on to work on the first lab assignment!

Happy coding.


This document was written by Hlynur Sigurþórsson (hlysig) for the course T-511-TGRA fall 2013.





