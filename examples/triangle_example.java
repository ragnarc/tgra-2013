192.168.1.4ckage is.ru.tgra;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.utils.BufferUtils;

public class Boxes implements ApplicationListener {
    
    private FloatBuffer vertexBuffer;
    private float boxWidth = 50;
    private int x, y;
    private float rotate = 0;   
    private int tri_x, tri_y;
    
    private List<Box> boxes = new ArrayList<Box>();
    
    
    @Override
    public void create() {
        
        // Set initial position of the box.
        this.x = this.y = 10;
        this.tri_x = this.tri_y = 400;
        
        Gdx.gl11.glEnableClientState(GL11.GL_VERTEX_ARRAY);
        // Create vertex buffer for a box.
        this.initVertexBuffer();
        
        // Specify the location of data in the vertex buffer that we will draw when
        // we call the glDrawArrays function.
        Gdx.gl11.glVertexPointer(2, GL11.GL_FLOAT, 0, this.vertexBuffer);
        
        // Set the color that we want to clear the screen with.
        Gdx.gl11.glClearColor(0.3f, 0.3f, 0.3f, 1);
    }

    @Override
    public void dispose() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void render() {
        this.display();
        this.update();
    }
    
    private void update(){
        // Check if the mouse has been pressed.
        if(Gdx.input.justTouched()) {
            this.boxes.add(new Box(Gdx.input.getX()- (this.boxWidth/2.0f), (Gdx.graphics.getHeight() - Gdx.input.getY()) - (this.boxWidth/2.0f)));
        }
    }
    
    private void display() {
        this.rotate +=2;
        // On each render we clear the screen!
        Gdx.gl11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        Gdx.gl11.glColor4f(0.6f, 0.2f, 0.2f, 1f);
        Gdx.gl11.glMatrixMode(GL11.GL_MODELVIEW);
        Gdx.gl11.glLoadIdentity();
        
        Gdx.gl11.glColor4f(0.6f, 0.2f, 0.2f, 1f);
        
        for(Box b : this.boxes){
            Gdx.gl11.glPushMatrix();
            //Gdx.gl11.glScalef(30, 30, 40);
            Gdx.gl11.glTranslatef(b.x, b.y, 0);
            Gdx.gl11.glDrawArrays(GL11.GL_TRIANGLE_STRIP, 0, 3);
            Gdx.gl11.glPopMatrix(); 
        }
    
    }
    
    @Override
    public void resize(int width, int height) { 
        // Load the Project matrix. Next commands will be applied on that matrix.
        Gdx.gl11.glMatrixMode(GL11.GL_PROJECTION);
        Gdx.gl11.glLoadIdentity();
        
        // Set up a two-dimensional orthographic viewing region.
        Gdx.glu.gluOrtho2D(Gdx.gl11, 0, width, 0, height);
        
        // Set up affine transformation of x and y from world coordinates to window coordinates
        Gdx.gl11.glViewport(0, 0, width, height);
        
        // Set the Modelview matrix back.
        Gdx.gl11.glMatrixMode(GL11.GL_MODELVIEW_MATRIX);
    }

    @Override
    public void resume() {  
    }
    
    
    private void initVertexBuffer(){
        this.vertexBuffer = BufferUtils.newFloatBuffer(14);
    
        float[] box = new float[] {0,0, 0,boxWidth,  boxWidth,0,  boxWidth,boxWidth};
        float triangle[] = new float[] {0,0, 10,0, 10,10};
        
        for(int i=0; i< box.length; i++)
            this.vertexBuffer.put(box[i]);
        
        for(int i=0; i< triangle.length; i++)
            this.vertexBuffer.put(triangle[i]);

        this.vertexBuffer.rewind();
    }   
}

