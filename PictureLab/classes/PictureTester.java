/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture(500,500);
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("sandwich.jpg");
    swan.sepia();
    swan.explore();
  }  
  public static void testNegate()
  {
    Picture swan = new Picture("beach.jpg");
    swan.negate();
    swan.explore();
  }
  public static void testGrayscale()
  {
    Picture swan = new Picture("beach.jpg");
    swan.betterGrayscale();
    swan.explore();
  }
  public static void testMirror()
  {
    Picture swan = new Picture("beach.jpg");
    swan.mirror();
    swan.explore();
  }
  public static void testMirrorDiagonal()
  {
    Picture swan = new Picture("beach.jpg");
    swan.mirrorDiagonal();
    swan.explore();
  }
  public static void testMirrorArms()
  {
    Picture swan = new Picture("snowman.jpg");
    swan.mirrorArms();
    swan.explore();
  }
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {    
    Picture collage=new Picture(700,700);
    Picture source=new Picture("sandwich.jpg");
    Picture edit=new Picture("sandwich.jpg");    
    
    ////source.rotate(50,350,10,520,-50,200,45,edit2);
    ////edit2.cropAndCopy(1,480,1,530,0,430,.5,collage);    
    source.rotateAndSize(50,350,10,520,-60,485,36,(double)5/8,collage);
        
    collage.limitPallete(1,300,300,700,85);
            
    source.blur(50,400,10,530,50,10,5,edit);    
    edit.cropAndCopy(50,400,10,530,20,-10,.8,collage);
    edit=new Picture("sandwich.jpg");
    edit.mirrorDiagonal();
    edit.grayscale();
    edit.rotate(50,350,10,520,80,300,30,collage);
    edit=new Picture("sandwich.jpg");
    edit.negative();
    edit.rotateAndSize(50,350,10,520,200,30,40,(double)4/3,collage);
    source.splash(50,350,10,520,600,600,2,collage);
    collage.explore();
    collage.write("CollageHenning.jpg");
  }
  
}