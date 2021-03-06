package is.ru.tgra;

import java.nio.FloatBuffer;

import org.lwjgl.opengl.GL11;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.utils.BufferUtils;

public class BoxWorld implements ApplicationListener {
    // Vertex buffer.
    private FloatBuffer vertexBuffer = null;
    private int boxWidth = 20;
    private int box_x, box_y;
    
    
    @Override
    public void create() {
        System.out.println("Created!");
        
        this.box_x = this.box_y = 10;
        
        this.vertexBuffer = BufferUtils.newFloatBuffer(8);
        
        float[] box = new float[] {0,0, 0,boxWidth,  boxWidth,0,  boxWidth,boxWidth};
        this.vertexBuffer.put(box);
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
        Gdx.gl11.glTranslatef(this.box_x, this.box_y, 0);
        Gdx.gl11.glDrawArrays(GL11.GL_TRIANGLE_STRIP, 0, 4);
        Gdx.gl11.glPopMatrix(); 
    }
    
    private void update(){
        if(Gdx.input.isKeyPressed(Keys.RIGHT)){
            this.box_x += 2;
        }
        if(Gdx.input.isKeyPressed(Keys.LEFT)){
            this.box_x -= 2;
        }
        if(Gdx.input.isKeyPressed(Keys.UP)){
            this.box_y += 2;
        }
        if(Gdx.input.isKeyPressed(Keys.DOWN)){
            this.box_y -= 2;
        }
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
        Gdx.glu.gluOrtho2D(Gdx.gl11, 0, width, 0, height);

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

