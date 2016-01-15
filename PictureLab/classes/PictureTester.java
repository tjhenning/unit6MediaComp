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
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
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
    source.explore();
    source.cropAndCopy(50,400,10,530,1,1,.75,collage);
    source.rotate(50,350,10,520,350,100,-30,collage);
    source.rotateAndSize(50,350,10,520,200,30,40,1.333,collage);
    collage.limitPallete(1,200,1,300,50);
    collage.explore();
  }
  
//   //LookWhatIFound dump
//   public void rotate(int startSourceRow, double width, int startSourceCol, double height,int startDestRow, int startDestCol, double rotation)
//   {
//     Pixel[][] pixels = this.getPixels2D();   
//     
// //     int width=100;//(int)((width1*Math.cos(rotation))+(height1*Math.sin(rotation)));
// //     int height=100;//(int)((width1*Math.cos(rotation))+(height1*Math.sin(rotation)));    
// //     boolean[][] pixel=new boolean[width][height];
//      for (int i=0; i<width;i++)
//      {
//        for (int j=0; j<height;j++)
//        { 
//          double i2=i-width/2;//Remove Width For Similar Effect
//          double j2=j-height/2;
//          double dist=Math.sqrt(i2*i2+j2*j2);
//          double nrot1=rotation+Math.toDegrees(Math.atan(j2/i2));
//          int nrot=(int)nrot1;
//          pixels[startDestRow+(int)(Math.cos(nrot)*dist)][startDestCol+(int)(Math.sin(nrot)*dist)].setColor(pixels[startSourceRow+i][startSourceCol+j].getColor());
// 
//        }
//      }    
//  }
}