/* 
 * Author: Paige Margaret Bartusiak
 * Assignment: 6.3c (project 5-3)
 * Date: October 11, 2018
 * 
 * ReadMe: This code takes and image (Flying.jpg) and returns its photographic negative.
 */


import images.APImage;
import images.Pixel;
import java.util.Scanner;

public class PhotographicNegative{
  public static void main (String[]args){
    Scanner reader = new Scanner(System.in);
    
    //opens image and then makes a copy (to preserve original image)
    APImage theOriginal = new APImage("flying.jpg");
    theOriginal.draw();
    APImage image = theOriginal.clone();
    
    //changes each pixel value to its negative
    for(Pixel p : image){
      int red = p.getRed();
      int green = p.getGreen();
      int blue = p.getBlue();
      
      p.setRed(255-red);
      p.setGreen(255-green);
      p.setBlue(255-blue);
    }
    
    //creates a wait, then returns new image
    System.out.println("Press enter to see the image in Photographic negative!");
    reader.nextLine();
    image.draw();
    
  }
}