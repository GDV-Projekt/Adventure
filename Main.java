package Main;
import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.nio.IntBuffer;

 
public class Main {
 
    // The window handle
    long window;
    
    private MyScene scene = new MyScene();
 //   private Camera c = new Camera();
    private int WIDTH = 800, HEIGHT = 600;
    boolean maus;
    double xPosMaus = 0,yPosMaus = 90;
    double dx=0,dy=0;
 
    public void run() {
        try {
            init();
            loop();
 
            glfwFreeCallbacks(window); // Resets all callbacks for the specified GLFW window to NULL
            						   // and frees all previously set callbacks.
            glfwDestroyWindow(window); // Destroys the specified window and its context.
        } finally {
            glfwTerminate(); // destroys all remaining windows, frees any allocated resources and sets the library to an uninitialized state.
            				 // Once this is called, you must again call glfwInit successfully before you will be able to use 
            				 // most GLFW functions.
            glfwSetErrorCallback(null).free(); // Frees the error callback
        }
    }
 
    
    private void init() {
        // Setup the Light
//        float light0_pos[] = {0.0f,0.5f,10.0f,0.0f};
//        float light1_amb[] = {1f,1f,1f,1.0f};
//        float light1_dif[] = {1.0f,1.0f,1.0f,1.0f};
//        float light1_spec[] = {1.0f,1.0f,1.0f,1.0f};
//           
//   		glLightfv(GL_LIGHT0, GL_POSITION, light0_pos);
//   		glLightfv(GL_LIGHT1, GL_AMBIENT, light1_amb);
//   		glLightfv(GL_LIGHT1, GL_DIFFUSE, light1_dif);
//   		glLightfv(GL_LIGHT1, GL_SPECULAR, light1_spec);
//   		
//   		glEnable(GL_LIGHTING);
//   		glEnable(GL_LIGHT0);
//   		glEnable(GL_LIGHT1);

    	
        GLFWErrorCallback.createPrint(System.err).set(); // Setup an error callback. The default implementation
		 												 // will print the error message in System.err.
 
        if ( !glfwInit() ) // Initialize GLFW. Most GLFW functions will not work before doing this.
            throw new IllegalStateException("Unable to initialize GLFW");
 
        // Configure our window
        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable
 
 
        // Create the window
        window = glfwCreateWindow(WIDTH, HEIGHT, "(R)ot, (G)rün, <- Links, -> Rechts", NULL, NULL);
        if ( window == NULL )
            throw new RuntimeException("Failed to create the GLFW window");
 
        // Setup a key callback. It will be called every time a key is pressed, repeated or released.
        glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
            if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
                glfwSetWindowShouldClose(window, true); // We will detect this in our rendering loop

            scene.keyboard(key, action);  // weitere Auswertung erfolgt in MyScene
        });
        // Setup a mouse position & key callback. It will be called when the mouse has entered the window, is moved or a button is pressed 
        glfwSetMouseButtonCallback(window, (window,button,action,mods) -> {
        	if(button == GLFW_MOUSE_BUTTON_1 && action == GLFW_PRESS) {
        		glfwSetCursorPos(window, WIDTH/2, HEIGHT/2);
        		maus = true;
        		glfwSetInputMode(window, GLFW_CURSOR, GLFW_CURSOR_HIDDEN);
        		glfwSetInputMode(window, GLFW_CURSOR, GLFW_CURSOR_DISABLED);
        	
        	}
        	if(button == GLFW_MOUSE_BUTTON_2 && action == GLFW_PRESS) {
        		maus = false;
        		glfwSetInputMode(window, GLFW_CURSOR, GLFW_CURSOR_NORMAL);
        	}
        });
        
        glfwSetCursorPosCallback(window, (window,xPos,yPos)->{
        	dx = xPos - WIDTH/2;
        	dy = yPos - HEIGHT/2;
        	xPosMaus += dx;
        	yPosMaus -= dy;
        	if(maus) {
        		scene.mouse(xPosMaus,yPosMaus); 	
//        		System.out.println("xPos: " +xPosMaus + "\t" + "yPos: " + yPosMaus + "\t" + "DX: " + dx + "  DY: " + dy);
        		glfwSetCursorPos(window, WIDTH/2, HEIGHT/2);
        	}
            
        });
        

        
    
        GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor()); // Get the resolution of the primary monitor
        // Center our window
        glfwSetWindowPos(
            window,
            (vidmode.width() - WIDTH) / 2,
            (vidmode.height() - HEIGHT) / 2
        );

        glfwMakeContextCurrent(window); // Makes the OpenGL context of the specified window current on the calling thread.

        glfwSwapInterval(1); // This function sets the swap interval for the current OpenGL, i.e. the number of screen updates
		 					 // to wait from the time glfwSwapBuffers was called before swapping the buffers and returning
 
        glfwShowWindow(window); // Makes the window visible
 
        GL.createCapabilities(); // Creates a new GLCapabilities instance for the OpenGL context that is current in the current thread
    }
    

	private void loop() {
        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
 
    	scene.initGLState();
 
        // Run the rendering loop until the user has attempted to close
        // the window or has pressed the ESCAPE key.
        while ( !glfwWindowShouldClose(window) ) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clears the color buffers and depth buffer
            
            scene.renderLoop();
 
            glfwSwapBuffers(window); // swaps the color buffers
 
            // Poll for window events. The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
            IntBuffer IntWindowWidth = BufferUtils.createIntBuffer(1);
            IntBuffer IntWindowHeight = BufferUtils.createIntBuffer(1);
            
            glfwGetWindowSize(window, IntWindowWidth, IntWindowHeight);
            if (windowSizeChanged(IntWindowWidth, IntWindowHeight))
    		{
            	glViewport(0, 0, WIDTH, HEIGHT);
    		}

            IntWindowWidth.clear();
            IntWindowHeight.clear();
        }
    }
    
	
    private boolean windowSizeChanged(IntBuffer w, IntBuffer h)
    {
    	if (WIDTH != w.get(0) || HEIGHT != h.get(0))
    	{
    		WIDTH = w.get(0);
    		HEIGHT = h.get(0);
    		return true;
    	}
    	return false;
    }
    
    
    public static void main(String[] args) {
        new Main().run();
    }
 
}