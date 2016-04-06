import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

public class DisplayExample {
		
	public static void main(String [] arg) {
		initDisplay();
		initGL();
		gameLoop();
		cleanUp();
	}

	private static void gameLoop() {
		while(!Display.isCloseRequested()) {
			glClear(GL_COLOR_BUFFER_BIT);

			glBegin(GL_QUADS);
			glEnd();

			Display.update();
		}
	}

	private static void cleanUp() {
		Display.destroy();
	}

	private static void initGL() {
		//switch to projection matrix
		glMatrixMode(GL_PROJECTION);
		//clear matrix
		glLoadIdentity();
		//making a square
		//
		glOrtho(0,Display.getWidth,0,Display.getHeight(),-1,1);

		//switch back to the model view matrix
		glMatrixMode(GL_MODELVIEW);

		//set color to clear screen to
		glClearColor(0,0,0,1);

		//disable depth test cause we aren't doing 3d
		glDisable(GL_DEPTH_TEST);
	}

	private static void initDisplay() {
		try {
			Display.setDisplayMode(new DisplayMode(600,480));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
x
	}
}
