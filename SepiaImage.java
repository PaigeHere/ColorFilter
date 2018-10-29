/* 
 * Author: Paige Margaret Bartusiak
 * Assignment: 6.3d (project 5-4)
 * Date: October 11, 2018
 * 
 * ReadMe: This code takes an image and returns it in a sepia filter.
 */

import images.APImage;
import images.Pixel;
import java.util.Scanner;

public class SepiaImage{

   public static void main(String[]args){
     Scanner reader = new Scanner(System.in);
     
      //creates and outputs image
      APImage image = new APImage("flying.jpg");
      image.draw();
      
      
      //converts image to grayscale
      APImage aCopy = image.clone();
      for (Pixel p: aCopy){
         int red = p.getRed();
         int green = p.getGreen();
         int blue = p.getBlue();
         int average = (red + green + blue) / 3;
         p.setRed(average);
         p.setGreen(average);
         p.setBlue(average);               
      }
      
      
     //takes grayscale image and changes to sepia form
     for (Pixel p : aCopy){
       int red = p.getRed();
       int blue = p.getBlue();
      if(red < 63){
        red = (int)(red * 1.1);
        blue = (int)(blue * 0.9);
      }else if (red < 192){
         red = (int)(red * 1.15);
        blue = (int)(blue * 0.85);
      }else{
        red = Math.min((int)(red *1.08), 255);
        blue = (int)(blue * 0.93);
      }
      
      p.setRed(red);
      p.setBlue(blue);  
     }
     
     //creates wait and then returns sepia image
     System.out.println("Press enter to see the sepia image!");
     reader.nextLine();
     aCopy.draw();
      
   }
}
      