/* 
 * Author: Paige Margaret Bartusiak
 * Assignment: 6.3b (project 5-5)
 * Date: October 11, 2018
 * 
 * ReadMe: This code takes user input to change the RGB values of each pixel of a picture, making a color filter!
 */

import images.APImage;
import images.Pixel;
import java.util.Scanner;

public class ColorFilter{
  public static void main(String [] args){
     Scanner reader = new Scanner(System.in);
     
     //inputs to select image file, display image, and create a copy to make changes of
     System.out.println("Enter an image file name: ");
     String fileName = reader.nextLine();
     
     APImage theOriginal = new APImage(fileName);
     theOriginal.draw();
     
     APImage image = theOriginal.clone();   
     
  
     //inputs for color change of RGB
     System.out.println("Enter the change in red: ");
     int rChange = reader.nextInt();
    
     System.out.println("Enter the change in green: ");
     int gChange = reader.nextInt();
     
     System.out.println("Enter the change in blue: ");
     int bChange = reader.nextInt();
     
     
    //loops to change each pixel value.
     for(Pixel p : image){
       int red = p.getRed();
       int green = p.getGreen();
       int blue = p.getBlue();
       
       int sumRed = red + rChange;
       int sumGreen = green + gChange;
       int sumBlue = blue + bChange;
       
       //checks that values are in RGB range
       if (sumRed > 250)
         p.setRed(250);
       else if (sumRed < 0)
         p.setRed(0);
       else
         p.setRed(sumRed);
       
       if (sumGreen > 250)
         p.setGreen(250);
       else if (sumGreen < 0)
         p.setGreen(0);
       else
         p.setGreen(sumGreen);
       
       
       if (sumBlue > 250)
         p.setBlue(250);
       else if (sumBlue < 0)
         p.setBlue(0);
       else
         p.setBlue(sumBlue);
       
     }
      
      reader.nextLine(); //gets rid of built up "strings" from last inputs
      
      //creates wait and output final image with filter!
      System.out.println("Press Enter to see filtered image!");
      reader.nextLine();
      image.draw();
      
  }
}