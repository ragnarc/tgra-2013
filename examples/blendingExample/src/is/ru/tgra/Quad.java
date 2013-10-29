package is.ru.tgra;

import java.nio.FloatBuffer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL11;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.BufferUtils;

public class Quad {
	
	FloatBuffer vertexBuffer;
	FloatBuffer texCoordBuffer;
	Texture tex;
	
	
	public Quad(String tex){	
		this.vertexBuffer = BufferUtils.newFloatBuffer(12);
		this.vertexBuffer.put(new float[] {
	            -1.0f, -1.0f, 0.0f,  // 0. left-bottom
	            1.0f, -1.0f, 0.0f,  // 1. right-bottom
	            -1.0f, 1.0f, 0.0f,  // 2. left-top
	            1.0f, 1.0f, 0.0f   // 3. right-top
		});
		this.vertexBuffer.rewind();
		
		texCoordBuffer = BufferUtils.newFloatBuffer(8);
		texCoordBuffer.put(new float[] {0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f});
		texCoordBuffer.rewind();
		
		this.tex = new Texture(Gdx.files.internal(tex));
	}
	
	public void draw(){
		Gdx.gl11.glVertexPointer(3, GL11.GL_FLOAT, 0, vertexBuffer);
		Gdx.gl11.glEnable(GL11.GL_TEXTURE_2D);
		Gdx.gl11.glEnableClientState(GL11.GL_TEXTURE_COORD_ARRAY);
		
		tex.bind();  //Gdx.gl11.glBindTexture(GL11.GL_TEXTURE_2D, textureID);

		Gdx.gl11.glTexCoordPointer(2, GL11.GL_FLOAT, 0, texCoordBuffer);
		
		
		Gdx.gl11.glNormal3f(0.0f, 0.0f, -1.0f);
		Gdx.gl11.glDrawArrays(GL11.GL_TRIANGLE_STRIP, 0, 4);
		
		Gdx.gl11.glDisable(GL11.GL_TEXTURE_2D);
		Gdx.gl11.glDisableClientState(GL11.GL_TEXTURE_COORD_ARRAY);
		
		
		
	}
}
