# Setting up OpenGL developer environment on Windows

## Introduction
This document describes setting up OpenGL development environment on Windows, Linux and OS X for the course _T-511-TGRA_. 

In all three major desktop platforms (Linux, MacOS X, and Windows), OpenGL more or less comes with the system. However, you will need to ensure that you have downloaded and installed a recent driver for your graphics hardware from Nvidia, ATI, etc. Note that Visual Studio and Xcode might install some of the files that are mentioned below - so if you have these applications installed then you are in good hands. We assume that Windows students are using Visual Studio in this course. If you are using other then Windows I personally would choose VIM and Makefiles.


##Windows
##OpenGL
Like stated above, your operating system should include all files for OpenGL but it does not hurt to verify that to be sure. Use the find functionality in Windows and search for the following files and verify that they are present before you continue.

OpenGL runtime libraries should be stored at,

    C:\Windows\System32\{opengl,glu}32.dll 

on 32-bit version of Windows, or

    C:\Windows\SysWOW64\{opengl,glu}32.dll on 64-bit Windows.

on 64-bit version of Windows.

Header files should be stored at,

    C:\Program Files\Microsoft SDKs\Windows\vX.XX\Include\gl\{GL,GLU}.h 
    
on 32-bit version of Windows and,

    C:\Program Files(x86)\Microsoft SDKs\Windows\vX.XX\Include\gl\{GL,GLU}.h
    
on 64-bit version of Windows.

Linker library should be stored at.

    C:\Program Files\Microsoft SDKs\Windows\vX.XX\Lib\OpenGL32.Lib 

on 32-bit version of Windows, and

    C:\Program Files(x86)\Microsoft SDKs\Windows\vX.XX\Lib\OpenGL32.Lib 

on 64-bit version of Windows.

##Glut
Next we look at GLUT. GLUT provides a platform-independent interface to window management, menus, and input devices in a simple and elegant manner. Using GLUT comes at the price of some flexibility.

Note that you might already have GLUT ready on your machine, so please check if you have the following files.

Runtime library:

    C:\Program Files\Microsoft Visual Studio *\VC\bin\glut32.dll

Header file:
    
    C:\Program Files\Microsoft Visual Studio *\VC\include\GL\glut.h

Linker library:
    
    C:\Program Files\Microsoft Visual Studio *\VC\lib\glut32.lib


If not, you can download free version of the GLUT library, FreeGLUT, online [here]([http://files.transmissionzero.co.uk/software/development/GLUT/freeglut-MSVC.zip] "FreeGLUT homepage"). Extract the content of the archive somewhere on your computer, such as c:\freeglut. It would be wise to copy the freeglut.dll file into c:\windows.

Now we are ready to rock hard!

## Create Visual Studio project and write a simple OpenGL application to test our environment.
For Windows we use Visual Studio. For other environments, such as Code::Blocks Google is your friend.

Open up your ridiculously expensive Visual Studio and create a new empty C++ project. Go to project settings (right click your newly created project and select properties). Select "Configuration Properties -> General" and add the path to the glut.h to _Additional Include Directories_. Then select "Configuration Properties ->Linker" and add the path to glut32.lib or to freeglut.lib. The same configuration applies to both GLUT and FreeGlut.

Now the project configuration should be done. Now add a simple cpp file to your project and write the following code.

	#include <GL/glut.h>
	
	int main(int argc, char* argv[])  {
		glutInit(&argc, argv);
		glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGBA);
		
		glutInitWindowSize(800, 600);
		glutInitWindowPosition(100, 100);
		glutCreateWindow("My TGRA window!");
		
		glutMainLoop();
		return 0;
	}

If everything was ok then you should see a new Window when you run the application.


## OpenGL Linux
If you are using Ubuntu or other commercial Linux distribution you should have OpenGL installed (where it comes with X) but you might be missing Glut.
 
You can install Glut as follows.

    sudo apt-get install freeglut3
    sudo apt-get install freeglut3-dev
 
After install, you should see the header file
glut.h in /usr/include/GL/glut.h
 
Take the example project above and place it into a .cpp file. To compile, open up a terminal and write

	g++ -lglut filename.cpp

Note that you might have to add additional include paths using -I and library paths using -L. 
 
 
## OpenGL OSX
All that you need for start writing OpenGL application on mac is to install Xcode.

The directives are different on OSX then on Linux and windows. On OSX you use

	<GLUT/glut.h>

and to link to libOpenGL and libGlut compile your application as follows.

	gcc -o hello filename.cpp -framework Carbon -framework OpenGL -framework GLUT


# Now you should be ready
When you run the application you should see an empty Window. That means that you are ready to head on to the first lab assignment!

Happy coding!


_This document was written by Hlynur Sigurþórsson (hlysig) for the course T-511-TGRA fall 2013._

