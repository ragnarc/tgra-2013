package is.ru.tgra;

import java.nio.FloatBuffer;

import org.lwjgl.opengl.GL11;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.utils.BufferUtils;

public class Sine implements ApplicationListener {
    // Vertex buffer.
    private FloatBuffer vertexBuffer = null;    
    private float screen_x, screen_y;
    private int number_of_points = 0;
    
    private float[] create_points(float lower, float higher, float step){   
        float A,B,C,D;
    
        A = this.screen_x / (higher-lower);
        B = 0;
        C = this.screen_y / 2.0f;
        D = C;
        
        int buffer_size = (int)  (Math.ceil((higher-lower)/step)*2) + 2;
        
        float[] buffer = new float[buffer_size];
        int curr_index = 0;
        for(float x = lower; x<higher; x+=step){
            buffer[curr_index] = x;
            buffer[curr_index+1] = (float) Math.sin(x);
            // Using scaling and translation
            //buffer[curr_index] = A*x + B;
            //buffer[curr_index+1] = C * ((float) Math.sin(x)) + D;
            curr_index +=2;
        }
        return buffer;
    }
    
    @Override
    public void create() {

        this.screen_x = Gdx.graphics.getWidth();
        this.screen_y = Gdx.graphics.getHeight();

        float[] f = this.create_points(0f, 10f, 0.005f);
        this.number_of_points = f.length / 2;
        this.vertexBuffer = BufferUtils.newFloatBuffer(f.length);       
        this.vertexBuffer.put(f);
        this.vertexBuffer.rewind();
        
        Gdx.gl11.glVertexPointer(2, GL11.GL_FLOAT, 0, this.vertexBuffer);
        
        // Enable vertex array.
        Gdx.gl11.glEnableClientState(GL11.GL_VERTEX_ARRAY);
        
        // Select clear color for the screen.
        Gdx.gl11.glClearColor(.3f, .3f, .3f, 1f);
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
    }
    
    private void display(){
        Gdx.gl11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        Gdx.gl11.glMatrixMode(GL11.GL_MODELVIEW);
        Gdx.gl11.glLoadIdentity();
        Gdx.gl11.glColor4f(1f, 1f, 1f, 1f);
        
        Gdx.gl11.glPushMatrix();
        //Gdx.gl11.glTranslatef(this.box_x, this.box_y, 0);
        Gdx.gl11.glDrawArrays(GL11.GL_POINTS, 0, this.number_of_points);
        Gdx.gl11.glPopMatrix(); 
    }
    
    private void update() {
    }
    
    @Override
    public void render() {
        this.display();
        this.update();
    }

    @Override
    public void resize(int width, int height) {
        // Load the Project matrix. Next commands will be applied on that matrix.
        Gdx.gl11.glMatrixMode(GL11.GL_PROJECTION);
        Gdx.gl11.glLoadIdentity();

        // Set up a two-dimensional orthographic viewing region.
        Gdx.glu.gluOrtho2D(Gdx.gl11, 0, 10, -1, 1);
        
        //Gdx.glu.gluOrtho2D(Gdx.gl11, 0, this.screen_x, 0, this.screen_y);

        // Set up affine transformation of x and y from world coordinates to window coordinates
        Gdx.gl11.glViewport(0, 0, width, height);

        // Set the Modelview matrix back.
        Gdx.gl11.glMatrixMode(GL11.GL_MODELVIEW_MATRIX);    
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
    }
}

