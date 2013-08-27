package is.ru.tgra;

import java.nio.FloatBuffer;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL11;
import com.badlogic.gdx.utils.BufferUtils;

public class ZoomyWorld implements ApplicationListener {
    // angle for rotation.
    private int angle = 0;
    private int x,y =10;
    private float colr = 0;
    private int zoom_position_x, zoom_position_y =0;
    float zoom_width, zoom_height =50;
    
    
    @Override
    public void create() {
        Gdx.gl11.glEnableClientState(GL11.GL_VERTEX_ARRAY);
        FloatBuffer vertexBuffer = BufferUtils.newFloatBuffer(8);
        vertexBuffer.put(new float[] {-0.5f,-0.5f, -0.5f,0.5f, 0.5f,-0.5f, 0.5f,0.5f});
        vertexBuffer.rewind();
        Gdx.gl11.glVertexPointer(2, GL11.GL_FLOAT, 0, vertexBuffer);
    }

    
    void display() {    
        Gdx.gl11.glClearColor(0.3f, 0.3f, 0.3f, 1.0f);
        Gdx.gl11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        Gdx.gl11.glColor4f(0, 1, 0, 1.0f);
        Gdx.gl11.glViewport(0, 0, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight());
        Gdx.gl11.glMatrixMode(GL11.GL_MODELVIEW);
        Gdx.gl11.glLoadIdentity();
        Gdx.glu.gluOrtho2D(Gdx.gl10, 0, Gdx.graphics.getWidth() / 2, 0, Gdx.graphics.getHeight());
        drawScene();
        
        Gdx.gl11.glColor4f(1, 1, 0, 1.0f);
        Gdx.gl11.glViewport(Gdx.graphics.getWidth() / 2, 0, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight());
        Gdx.gl11.glMatrixMode(GL11.GL_MODELVIEW);
        
        Gdx.gl11.glLoadIdentity();

        Gdx.glu.gluOrtho2D(Gdx.gl10, 
                 zoom_position_x - zoom_width / 2,
                 zoom_position_x + zoom_width / 2,
                 zoom_position_y - zoom_height / 2,
                 zoom_position_y + zoom_height / 2);
        // rotate the coordinate system!
        //Gdx.gl11.glScalef(-1f, 1f, 1f);
        //Gdx.glu.gluOrtho2D(Gdx.gl10, 0, Gdx.graphics.getWidth() / 2, 0, Gdx.graphics.getHeight());
        drawScene();

    }
    
    void drawScene(){
        Gdx.gl11.glPushMatrix();
        Gdx.gl11.glColor4f(this.colr, this.colr, this.colr, 1.0f);
        Gdx.gl11.glTranslatef(this.x, this.y, 0);
        Gdx.gl11.glRotatef(angle, 0, 0, 1);
        Gdx.gl11.glScalef(100, 100, 1.0f);
        Gdx.gl11.glDrawArrays(GL11.GL_TRIANGLE_STRIP, 0, 4);
        Gdx.gl11.glPopMatrix();
        
        Gdx.gl11.glPushMatrix();
        Gdx.gl11.glColor4f(1.0f, 1.0f, this.colr, 1.0f);
        Gdx.gl11.glTranslatef(60, 29, 0);
        Gdx.gl11.glRotatef(-angle, 0, 0, 1);
        Gdx.gl11.glScalef(20, 100, 1.0f);
        Gdx.gl11.glDrawArrays(GL11.GL_TRIANGLE_STRIP, 0, 4);
        Gdx.gl11.glPopMatrix();
    }
    
    
    void update() {
        //zoom_width = (Gdx.graphics.getWidth() / 8) + (float) (Math.sin(angle * 3.1415f / 180.0f) * (Gdx.graphics.getWidth() / 16));
        //zoom_height = (Gdx.graphics.getHeight() / 4) + (float) (Math.sin(angle * 3.1415f / 180.0f) * (Gdx.graphics.getHeight() / 8));

        this.angle += 1;
        if(this.colr > 1.0)
            this.colr = 0;
        this.colr += 0.01;
        
        
        
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            this.x -= 5.0f;
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            this.x += 5.0f;
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
            this.y -= 5.0f;
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
            this.y += 5.0f;

        if(Gdx.input.isKeyPressed(Input.Keys.O)){
            this.zoom_width+=10;
            this.zoom_height+=10;
        }
        
        if(Gdx.input.isKeyPressed(Input.Keys.P)){
            this.zoom_width-=10;
            this.zoom_height-=10;
        }
        
        
        
        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            this.zoom_position_x = Gdx.input.getX();
            this.zoom_position_y = Gdx.graphics.getHeight() - Gdx.input.getY();
        }
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

    @Override
    public void resize(int arg0, int arg1) {
    }

    @Override
    public void resume() {      
    }
}

