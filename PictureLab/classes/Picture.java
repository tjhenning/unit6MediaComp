import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  public void negate()
  {
      Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
          pixelObj.setRed(255-pixelObj.getRed());
          pixelObj.setBlue(255-pixelObj.getBlue());
          pixelObj.setGreen(255-pixelObj.getGreen());
        }
    }        
  }
  public void mirror()
  {
      Pixel[][] pixels = this.getPixels2D();
    for (int i=pixels[0].length/2; i<pixels[0].length;i++)
    {
      for (int j=0; j<pixels.length;j++)
      {
          pixels[j][i].setRed(pixels[j][pixels[0].length-i].getRed());
          pixels[j][i].setBlue(pixels[j][pixels[0].length-i].getBlue());
          pixels[j][i].setGreen(pixels[j][pixels[0].length-i].getGreen());
        }
    }        
  }
  public void mirrorArms()
  {
      Pixel[][] pixels = this.getPixels2D();
    for (int i=238; i<pixels.length;i++)
    {
      for (int j=158; j<pixels[0].length;j++)
      {
          pixels[i][j].setRed(pixels[210-(238-210)][pixels[0].length-i].getRed());
          ///pixels[j][i].setBlue(pixels[j][pixels[0].length-i].getBlue());
          //pixels[j][i].setGreen(pixels[j][pixels[0].length-i].getGreen());
      }
    }        
  }
  public void mirrorDiagonal()
  {
      Pixel[][] pixels = this.getPixels2D();
    for (int i=0; i<pixels.length;i++)
    {
      for (int j=0; j<pixels[0].length;j++)
      {
          if (i>j)
          {
              pixels[i][j].setRed(pixels[j][i].getRed());
              pixels[i][j].setBlue(pixels[j][i].getBlue());
              pixels[i][j].setGreen(pixels[j][i].getGreen());
              
            }
        }
    }        
  }

  public void grayscale()
  {
      Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
          int avg=pixelObj.getRed();
          avg+=pixelObj.getBlue();
          avg+=pixelObj.getGreen();
          avg/=3;
          pixelObj.setBlue(avg);
          pixelObj.setGreen(avg);
          pixelObj.setRed(avg);
        }
    }        
  }
  
  public void betterGrayscale()
  {
      Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
          int red=pixelObj.getRed();
          int blue =pixelObj.getBlue();
          int green=pixelObj.getGreen();
          int avg=0;
          if (red>=blue&red>=green)
          {
              avg+=red;
            }
          else if (blue>=red&&blue>=green)
          {
              avg+=blue;
          }
          else if (green>blue&&green>red)
          {
              avg+=green;
          }
          if (red<=blue&red<=green)
          {
              avg+=red;
          }
          else if (blue<=red&&blue<=green)
          {
              avg+=blue;
          }
          else if (green<blue&&green<red)
          {
              avg+=green;
          }
          avg /=2;
          
          pixelObj.setBlue(avg);
          pixelObj.setGreen(avg);
          pixelObj.setRed(avg);
        }
    }        
  }
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
          pixelObj.setRed(pixelObj.getRed()*2);
          if (pixelObj.getRed()>=50)
          {
              pixelObj.setRed(pixelObj.getRed()+25);
            }
            else{
                // pixelObj.setRed(0);
                }
          if (pixelObj.getBlue()>=25)
          {
              pixelObj.setBlue(pixelObj.getBlue()-25);
            }
            else{
                 pixelObj.setBlue(0);
                }
                if (pixelObj.getGreen()>=50)
          {
              pixelObj.setGreen(pixelObj.getBlue()-50);
            }
            else{
                 pixelObj.setGreen(0);
                }
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    //beach.cropAndCopy(80,120,180,230,1,1,.75);
    beach.rotate(400,50,300,50,100,100,45);
    beach.explore();
  }
  
  public void rotate(int startSourceRow, double width, int startSourceCol, double height,int startDestRow, int startDestCol, double rotation)
  {
    Pixel[][] pixels = this.getPixels2D();   
    
//     int width=100;//(int)((width1*Math.cos(rotation))+(height1*Math.sin(rotation)));
//     int height=100;//(int)((width1*Math.cos(rotation))+(height1*Math.sin(rotation)));    
//     boolean[][] pixel=new boolean[width][height];
     for (int i=0; i<width;i++)
     {
       for (int j=0; j<height;j++)
       { 
         int i2=i-(int)width/2;
         int j2=j-(int)height/2;
         double dist=Math.sqrt(i2*i2+j2*j2);
         double nrot1=rotation+Math.toDegrees(Math.atan(j2/i2));
         int nrot=(int)nrot1;
         pixels[startDestRow+(int)(Math.cos(nrot)*dist)][startDestCol+(int)(Math.sin(nrot)*dist)].setColor(pixels[startSourceRow+i][startSourceCol+j].getColor());

       }
     }    
  }
  public  int[] findTrue(boolean[][] pixels,int num)
  {
     int counter=0;
    //int[] arr={1,1};
      for (int i=0; i<pixels.length;i++)
    {
      for (int j=0; j<pixels[0].length;j++)
      {    
          //System.out.println(counter+" "+num);
          
          if (pixels[i][j])
          {
              counter++;
          }   
          if (counter>=num)
          {              
              System.out.println(counter);
              int[] arr={i,j};
              return arr;
              
          }
          if (false){
          System.out.println(j+" "+pixels[0].length);}
      }
    }
    System.out.println(counter);
    return null;
      
  }
  //((int)((double)Math.sin(rotation)*i))((int)((double)Math.cos(rotation)*
  public void cropAndCopy(int startSourceRow, int endSourceRow, int startSourceCol, int endSourceCol,int startDestRow, int startDestCol, double multiplier)
  {
    Pixel[][] pixels = this.getPixels2D();    
    for (int i=0; i<endSourceRow-startSourceRow;i++)
    {
      for (int j=0; j<endSourceCol-startSourceCol;j++)
      {          
          bigPixel((int)(i*multiplier)+startDestRow,(int)(j*multiplier)+startDestCol,multiplier,pixels[i+startSourceRow][j+startSourceCol],pixels);
      }
    }    
  }
  public void bigPixel(int row, int col, double mult, Pixel pixel,Pixel[][] pixels)
  {      
      //size+=.999;
      //int mult=(int)size;      
      //Pixel[][] pixels = this.getPixels2D();
      for (int i=0; i<mult;i++)
      {
          for (int j=0; j<mult;j++)
          {                                       
              pixels[row+i][col+j].setRed(pixel.getRed());
              pixels[row+i][col+j].setBlue(pixel.getBlue());
              pixels[row+i][col+j].setGreen(pixel.getGreen());
          }
      } 
    }
} // this } is the end of class Picture, put all new methods before this
