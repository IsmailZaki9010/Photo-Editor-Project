import java.util.Scanner;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * Write a description of class GROUP here.
 *
 * @author Ismail Zaki
 * @version 11/27/2018
 */
public class GROUP
{
    public static Scanner kb = new Scanner(System.in);
    
    public static BufferedImage image;
    public static int i;
 
    public static String imagename;
    public static String newimagename;
    
    public static void main (String [] args) throws Exception
    {
        System.out.println("What file would you like to open?");
        String imagename = kb.nextLine();
        System.out.println("What would you like to rename this file");
        newimagename = kb.nextLine();
        try{
            File input = new File("images/"+imagename+".jpg");    
            image = ImageIO.read(input);
        for(i = 0; i < 1; i++){
            System.out.println("Which option would you like to perform?");
            System.out.println("1 - Vertical Mirror Reflection");
            System.out.println("2 - Horizontal Mirror Reflection");
            System.out.println("3 - Image Crop");
            System.out.println("4 - ");
            System.out.println("5 _ ");
            System.out.println("6 - ");
            System.out.println("7 - ");
            System.out.println("8 - ");
            System.out.println("9 - save file");
            int userchoice = kb.nextInt();
            switch(userchoice)
            {
                case 1:
                mirrorVertical();
                finishedoption();
                break;
                case 2:
                mirrorHorizontal();
                finishedoption();
                break;
                case 3:
                imageCrop();
                finishedoption();
                break;
                case 4:
                finishedoption();
                break;
                case 5:
                finishedoption();
                break;
                case 6:
                finishedoption();
                break;
                case 7:
                finishedoption();
                break;
                case 8:
                finishedoption();
                break;
                case 9:
                File output = new File("images/" + newimagename + " .jpg");
                ImageIO.write(image, "jpg", output);
                break;
                default:
                System.out.println("Sorry, wrong choice, please choose again.");
                i = i - 1;
                break;
            
            }
        }
        }
        catch (Exception e)
        {
            System.out.println("Oops: " + e);
        }
    }
    
    public static void finishedoption()
    {
        System.out.println("Are you finished?");
        System.out.println("1 - yes");
        System.out.println("2 - no");
        for(int o =0; o<1; o++){
            int choice = kb.nextInt();
            if(choice == 1){
            try{
               File output = new File("images/" + newimagename + " .jpg");
               ImageIO.write(image, "jpg", output);
            }
            catch (Exception e)
            {
                System.out.println("Oops: " + e);
            }
            }
            else if(choice == 2)
            {
                i = i - 1;
            }
            else
            {
                o = o - 1;
            }
        }
    }
     //
     //
     //
     //
     //
     //
     //
     //
    public static void mirrorOption()
    {
        System.out.println("Enter which way you want to mirror your image -\n2 1.) Vertically -\n3 2.) Horizontally");
        int option = kb.nextInt();
        switch(option)
        {
            case 1:
            mirrorVertical();
            break;
            case 2: 
            mirrorHorizontal();
            break;
        }
    }
    public static void mirrorVertical()
        //ismail        //Takes image input and reflects a mirror image across the midpoint of the width. 
    {
      //This takes the dimensions of the image.
      int width = image.getWidth();
      int height = image.getHeight();
           
      BufferedImage newimg = new BufferedImage(width, height, image.getType());
      //This will read every individual pixel of the image.
      for(int y = 0; y < height; y++)
      {
          for(int x = 0; x < width; x++)
          { 
           int nx = x < width / 2 ? x : width - 1 - x;
           newimg.setRGB(x, y, image.getRGB(nx, y));
          }
      }
      image = newimg;
    }
    
    public static void mirrorHorizontal()
    {   //ismail
        //Takes image input and reflects a mirror image across the midpoint of the height. 
        
          //This takes the dimensions of the image.
          int width = image.getWidth();
          int height = image.getHeight();
               
          BufferedImage newimg = new BufferedImage(width, height, image.getType());
          //This will read every individual pixel of the image.
          for(int x = 0; x < width; x++)
          {
              for(int y = 0; y < height; y++)
              { 
               int ny = y < height / 2 ? y : height - 1 - y;
               newimg.setRGB(x, y, image.getRGB(x, ny));
              }
          }
          image = newimg;
    }
    
    public static void imageCrop()
        //ismail
        //Decreases image dimensions by a scale factor
    {
        //Takes image dimensions.  
        int width = image.getWidth();
        int height = image.getHeight();
        
        System.out.println("Image Width: " + width);
        System.out.println("Image Height: " + height);
        System.out.print("By what scale factor do you want top resize your image"); 
        
        int scFactor = kb.nextInt();
        width = width/ scFactor;
        height = height/ scFactor;
        System.out.println("New Image width: " + width);
        System.out.println("New Image Height: " + height);
        //Reduce image dimensions by scale factor
        BufferedImage nimg = new BufferedImage(width, height, image.getType());
        
        //This reads every individual pixel
        for(int x = 0; x < width; x++)
        {   
            for(int y = 0; y < height; y++)
            {
             Color c = new Color(image.getRGB(x,y));
             nimg.setRGB(x, y, image.getRGB(x, y));
            }
        }
        image = nimg;
    }
    }
      
    
