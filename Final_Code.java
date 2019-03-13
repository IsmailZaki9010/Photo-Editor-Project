
import java.util.Scanner;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
/**
 * Write a description of class GROUP here.
 *
 * @author Jeffrey Chen
 * @version 11/27/2018
 */
public class Final_Code
{
    public static Scanner kb = new Scanner(System.in);
    public static int i;
    public static String imagename;
    public static String newimagename;
    public static BufferedImage image;
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
        System.out.println("1 - I Hate A Color");
        System.out.println("2 - Random Minimizer");
        System.out.println("3 - Vertical Mirror");
        System.out.println("4 - Horizontal Mirror");
        System.out.println("5 _ Image Crop");
        System.out.println("6 - UserColorSelection");
        System.out.println("7 -NewSizeAndColor ");
        System.out.println("8 - Vignette");
        System.out.println("9 - RotateAndColor");
        System.out.println("10 - save file");
        int userchoice = kb.nextInt();
        switch(userchoice)
        {
            case 1: IHateAColor();
            finishedoption();
            break;
            case 2: RandomResize();
            finishedoption();
            break;
            case 3:
            mirrorVertical();
            finishedoption();
            break;
            case 4:
            mirrorHorizontal();
            finishedoption();
            break;
            case 5:
            imageCrop();
            finishedoption();
            break;
            case 6:
            UserColorSelection();
            finishedoption();
            break;
            case 7:
            NewSizeAndColor();
            finishedoption();
            break;
            case 8:
            vignette();
            finishedoption();
            break;
            case 9:
            rotateandcolor();
            finishedoption();
            case 10:
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
  
    public static void john()
    {
        System.out.println("You called john");
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

    
    
 //-----------------------------------------------------------------------------------------------------------------------------
 //photo editing methods
 //-----------------------------------------------------------------------------------------------------------------------------   
    
    
//JeffreyChen
    public static void IHateAColor()//Made by Jeffrey Chen
    { 
    //asks user what color they hate, scans for pixels with high values for that color, and sets that color to 0 for those pixels
        int width = image.getWidth();
        int height = image.getHeight(); 

    //asks user what color they hate    
        System.out.println("What color do you hate?");
        System.out.println("1 - red");
        System.out.println("2 - green");
        System.out.println("3 - blue");
            int hatedcolor = kb.nextInt();
    
    //for loops go through every pixel in the image    
    for (int x=0;x<width;x++)
        {
            for(int y=0;y<height;y++)
            {
            //gets the RGB values for each pixel
                Color c = new Color(image.getRGB(x,y));                              
               int green = c.getGreen();
               int blue = c.getBlue();
               int red = c.getRed();
            
            //checks if hated color's value > average of other colors in pixel. 
            //If it is, then hated color's value is reduced to zero for that pixel
           
            switch(hatedcolor)
            {
            
                case 1 :     
            if (red>((blue+green)/2))
               {Color newcolor = new Color(0,green,blue);
               image.setRGB(x,y,newcolor.getRGB());
            }
            break;
                case 2 :
            if (green>((blue+green)/2))
               {Color newcolor = new Color(red,0,blue);
               image.setRGB(x,y,newcolor.getRGB());
            }    
            break;
                case 3 :
            if (blue>((red+green)/2))
               {Color newcolor = new Color(red,green,0);
               image.setRGB(x,y,newcolor.getRGB());
            }
            break;    
                default: 
            System.out.println("sum ting wen wong");
            break;
            }
            
        }        
    }
}
public static void RandomResize()//made by Jeffrey Chen
{
 //crops the image to a random size
    int width = image.getWidth();
    int height = image.getHeight();
 
 //generates random values for width and height
    int randomwidth = (int)(width*Math.random());
    int randomheight = (int)(height*Math.random());
 
 //creates new blank image with the generated width and height
     BufferedImage newImage=new BufferedImage(randomwidth,randomheight,BufferedImage.TYPE_INT_RGB);
 
 
 //replaces the blank pixels with RGB values from the original image in the same position
 for (int x=0; x<randomwidth; x++)
 {
     for (int y=0; y<randomheight; y++)
     {
         Color c = new Color(image.getRGB(x,y));                              
               int green = c.getGreen();
               int blue = c.getBlue();
               int red = c.getRed();
               
         Color newcolor = new Color(red,green,blue);
         newImage.setRGB(x,y,newcolor.getRGB());
        }
    }
 image=newImage;
}

//------------------------------------------------------------------------------------------------------------------------------

//Ismail Zaki
public static void mirrorVertical()
        //Takes image input and reflects a mirror image across the midpoint of the width. //Ismail Zaki
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
      //Takes image input and reflects a mirror image across the midpoint of the height. //Ismail Zaki
   {
        
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
        //Decreases image dimensions by a scale factor //Ismail Zaki
    {
        //Takes image dimensions.  
        int width = image.getWidth();
        int height = image.getHeight();
        
        System.out.println("Image Width: " + width);
        System.out.println("Image Height: " + height);
        System.out.print("By how much do you want top resize your image"); 
        
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
    
//------------------------------------------------------------------------------------------------------------------------------    
//Duston Hartland 
   
public static void UserColorSelection()//Duston Hartland
    {
    try 
    {
    File input = new File ("images/imagename.jpg"); 
    BufferedImage image = ImageIO.read(input);
    
    int width = image.getWidth();
    int height = image.getHeight(); 
    // Im prompting the user to enter their desired values for RGB and adding them to the images existing RGB values
    System.out.println("please enter the value you wish to have for red(between 0 and 255).");
    int UserRed = kb.nextInt(); 
    
    System.out.println("please enter the value you wish to have for green(between 0 and 255).");
    int UserGreen = kb.nextInt();
    
    System.out.println("please enter the value you wish to have for blue(between 0 and 255).");
    int UserBlue = kb.nextInt();
    
    System.out.println("The image is " + width + "x " + height + ".");
    
    for (int x = 0; x < width; x++)
    {
        for (int y = 0; y < height; y++)
        {
        Color c = new Color(image.getRGB(x,y));        
        
        int red = c.getRed();
        int green = c.getGreen();
        int blue = c.getBlue();
        int redValue = (red + UserRed); 
        int greenValue = (green + UserGreen);
        int blueValue = (blue + UserBlue);
        //this is to ensure there will not be an error when the values exceed the max of 255
        if (redValue > 255)
        {
            redValue = 255;
        }
        
         if (greenValue > 255)
        {
            greenValue = 255;
        }
        
         if (blueValue > 255)
        {
            blueValue = 255;
        }
        
        Color newColor = new Color(redValue, greenValue, blueValue);
        
        image.setRGB(x, y, newColor.getRGB());
        }
    }
    
    }
    catch(Exception e)
    {
        System.out.println("Ooops: " + e);
    }
    }
//Duston Hartland
  public static void NewSizeAndColor()
    {
    try 
    {
    File input = new File ("images/imagename.jpg"); 
    BufferedImage image = ImageIO.read(input);
    
    int width = image.getWidth();
    int height = image.getHeight();         
//this is the amount that im going to crop
    int a = 100;
    int b = 100;
    BufferedImage newImage=new BufferedImage((width - a * 2),(height - b * 2),BufferedImage.TYPE_INT_RGB); 
 //replaces the blank pixels with RGB values from the original image in the same position
 for (int x=a; x < width - a; x++)
 {
     for (int y = b; y < height - b; y++)
     {
         Color c = new Color(image.getRGB(x,y));  
         //these are the color calues that are going to be used in the editor 
         int red = c.getRed();
         int green = c.getGreen();
         int blue = c.getBlue();
         int redValue = 200;
         
         int d = width/2;
         //im delcairing color outside of my if/else statement to prevent any errors
         Color newColor;
         //I used an if statement to set what color is one half.
         if(x < d)
         {
              newColor = new Color(redValue, green, blue);
         }
         else 
         {
             newColor = new Color(red, green, blue);
         }
         
         newImage.setRGB(x - a,y - b,newColor.getRGB());
        }
}   
}

    catch(Exception e)
    {
        System.out.println("Ooops: " + e);
    }
}
    
    
//------------------------------------------------------------------------------------------------------------------------------
//Jeremy Rine

public static int shade;
    public static void vignette()//Jeremy Rine
    {
        try
        {
            File input = new File("images/"+ imagename +".jpg");
            int width = image.getWidth();
            int height = image.getHeight();
            
            for(int y =0; y<1; y++){
            System.out.println("how much of a vignette would you like to apply? please provide a positive integer, the closer to 1 the darker, 0 is not applicable.");
            shade = kb.nextInt();
            if (shade < 1){
                y = y - 1;
            }
            }
            
            
            for (int x = 0; x < width; x++)
            {
                for (int y = 0;  y < height; y++)
                {
                    Color c = new Color(image.getRGB(x, y));
                    
                    int red = c.getRed();
                    int green = c.getGreen();
                    int blue = c.getBlue();
                    
                    int middle = width/2;
                    int middletall = height/2;
                    
                    int shader = Math.abs(middle - x);
                    int shadertall = Math.abs(middletall - y);
                    
                    int xvalueshadered = red - ((shader + shadertall)/shade);
                    int xvalueshadeblue = blue - ((shader + shadertall)/shade);
                    int xvalueshadegreen = green - ((shader + shadertall)/shade);
                    
                    if (xvalueshadered >= 0){
                        red = xvalueshadered;
                    }
                    else
                    {
                        red = 0;
                    }
                    if (xvalueshadeblue >= 0){
                        blue = xvalueshadeblue;
                    }
                    else
                    {
                        blue = 0;
                    }
                    if (xvalueshadegreen >= 0){
                        green = xvalueshadegreen;
                    }
                    else
                    {
                        green = 0;
                    }
                    
                    
                    Color newcolor = new Color(red, green, blue);
                    
                    image.setRGB(x, y, newcolor.getRGB());
                }
            }
            
            File output = new File("images/Juneau_gs1 .jpg");
            ImageIO.write(image, "jpg", output);
        }
        catch (Exception e)
        {
            System.out.println("Oops: " + e);
        }
    }    
public static BufferedImage shrunkimage;
    public static Color c = new Color(0, 0, 0);
    public static Color newcolor = new Color(0, 0, 0);
    public static void rotateandcolor()// jeremy Rine is meant to rotate and add a tint
    {
        try
        {
            int width = image.getWidth();
            int height = image.getHeight();
            System.out.println(width + " + " + height);
            shrunkimage = new BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB); 
            // these loops take the original image's pixels and assigns them to their correlating positions on the new image
            for (int i = 0; i < (width -1); i++)
            {
                for (int y = 0; y < (height -1); y++)
                {
                    Color c = new Color(image.getRGB(i, y));
                    
                    int red = c.getRed();
                    int green = c.getGreen();
                    int blue = c.getBlue();
                    
                    shrunkimage.setRGB(y, i, image.getRGB(i, y));
                }
            } 

            File output = new File("images/" + newimagename + " .jpg");
            ImageIO.write(shrunkimage, "jpg", output);
        }
        catch (Exception e)
        {
            System.out.println("Oops: " + e);
        }
        image=shrunkimage;
    }

    }

