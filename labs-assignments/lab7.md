# Lab class 7
This document contains instructions for lab class 7 for the course T-511-TGRA. Today's lab class is two folded. First, we cover two problems on the white board then we then continue working on the First 3D application where we look at cameras, lights and some cool shapes.

## Math problems
The first problem we calculate the light for a given point on the screen and in the second problem we will calculate the projection matrix when we call the function gluPerspective.
# Problem 1 - Problem 7 from final exam 2008
A single light is in the light model in an OpenGL program. It has the ambient values (0.0, 0.0, 0.0), diffuse values (0.3, 0.6, 0.2), specular values (0.7, 0.7, 0.7) and position (-1.0, 7.0, 5.0).There is also a global ambient factor of (0.4, 0.4, 0.4) in the light model.A camera is positioned in (5.0, 7.0, 7.0) and looks towards P.P has the color values: ambient (0.1, 0.3, 0.2), diffuse (0.3, 0.4, 0.6) and specular (0.9, 0.9, 0.9). It has the position (3.0, 7.0, 2.0) and a normal (0.0, 0.0, 1.0).What will be the blue color value for P on the screen ?
# Problem 2 - Projection
Let us assume that we have the following code
    
    Gdx.gl11.glMatrixMode(GL11.GL_PROJECTION);
    Gdx.gl11.glLoadIdentity();	gluPerspective(100, 1.333333f, 1.0f, 30.0f)
How will the Projection matrix look like when these lines of code have been executed.
## Programming
We will continue on implementing the camera and some shapes from last lab class (lab assignment 6).