//package myTest;
//
//import akka.actor.ActorRef;
//import akka.actor.ActorSystem;
//import com.jme3.app.SimpleApplication;
//import com.jme3.asset.plugins.ZipLocator;
//import com.jme3.material.Material;
//import com.jme3.material.RenderState.BlendMode;
//import com.jme3.math.ColorRGBA;
//import com.jme3.math.Vector3f;
//import com.jme3.renderer.queue.RenderQueue.Bucket;
//import com.jme3.scene.Geometry;
//import com.jme3.scene.Node;
//import com.jme3.scene.shape.Box;
//import com.jme3.texture.Texture;
//
///**
// * This is the Main Class of your Game. You should only do initialization here.
// * Move your Logic into AppStates or Controls
// *
// * @author normenhansen
// */
//public class First2D extends SimpleApplication {
//	public static boolean isRunning = true;
//
//	public static Texture anim1;
//	public static Texture anim2;
//	public static Texture anim3;
//
//	public static Box backgroundBox = new Box(100,100,0);
//	static Geometry background = new Geometry("background", backgroundBox);
//	public static Material backgroundMat;
//
//	public static MyThread goAnim = new MyThread();
//
//	static Box firstRect = new Box(1,1,0);
//	static Geometry blue = new Geometry("Box", firstRect);
//	public static Material mat1;
//
//	public static Node pivot2 = new Node("pivot2");
//	public static float rotationX = 0;
//
//    public static void main(String[] args) {
//        First2D app = new First2D();
//
//        app.start();
//
//    }
//
//    @Override
//    public void simpleInitApp() {
//    	assetManager.registerLocator("assets.zip", ZipLocator.class);
//    	flyCam.setEnabled(false);
//    	ActorSystem system = ActorSystem.create("testSystem");
//
//        ActorRef firstRef = system.actorOf(PrintMyActorRefActor.props(), "first-actor");
//        anim1 = assetManager.loadTexture("firstAnim1.png");
//        anim2 = assetManager.loadTexture("firstAnim2.png");
//        anim3 = assetManager.loadTexture("firstAnim3.png");
//
//
//    	background.setLocalTranslation(new Vector3f(0,0,0));
//    	backgroundMat = new Material(assetManager,
//                "Common/MatDefs/Misc/Unshaded.j3md");
//        backgroundMat.setColor("Color", ColorRGBA.White);
//        background.setMaterial(backgroundMat);
//
//        Node pivot1 = new Node("pivot");
//        pivot1.attachChild(background);
//
//        rootNode.attachChild(pivot1);
//
//
//        blue.setLocalTranslation(new Vector3f(0,0,3));
//        mat1 = new Material(assetManager,
//                "Common/MatDefs/Misc/Unshaded.j3md");
//        mat1.setTexture("ColorMap",
//                assetManager.loadTexture("firstAnim1.png"));
//        mat1.getAdditionalRenderState().setBlendMode(BlendMode.Alpha);
//        blue.setQueueBucket(Bucket.Transparent);
//        blue.setMaterial(mat1);
//
//        Node pivot2 = new Node("pivot");
//        pivot2.attachChild(blue);
//
//        rootNode.attachChild(pivot2);
//
//        firstRef.tell("startAnim", ActorRef.noSender());
//
//    }
//
//
//
//
//
//    @Override
//    public void simpleUpdate(float tpf) {
//    	//pivot2.rotate(0.002f,0f,0f);
//    }
//
//
//}
//
