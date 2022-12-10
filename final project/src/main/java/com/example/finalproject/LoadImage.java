package com.example.finalproject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import net.coobird.thumbnailator.Thumbnails;

public class LoadImage implements transferGraph{

    //encapsulate rgbArray
    private static float[][] rgbArray;
    /*
    public BufferedImage getScaledImage() throws IOException {
        Thumbnails.of("src/main/original.png").size(28,28).toFile("src/main/transformed.png");
        Image srcImg = ImageIO.read(new File("src/main/transformed.png"));
        scaledImg = new BufferedImage(28, 28, BufferedImage.TYPE_BYTE_GRAY);
        Graphics graphics = scaledImg.getGraphics();
        graphics.drawImage(srcImg, 0, 0, null);
        graphics.dispose();
        ImageIO.write(scaledImg, "PNG", new File("src/main/transformedgray.png"));
        return scaledImg;
    }

    public float[][] convertImageToArray() {
        Raster graphic = scaledImg.getData();
        //Get the image's width and height
        int width = scaledImg.getWidth();
        int height = scaledImg.getHeight();
        //Get the image's pixels for each point
        int[] pixels = new int[width * height];
        pixels = graphic.getPixels(0, 0, width, height, pixels);
        //Check if image is blank
        boolean valid = false;
        for (int pixel : pixels) {
            if (pixel != 255) {
                valid = true;
                break;
            }
        }
        if (!valid) {
            return null;
        }
        /* Convert the int array to a float array and make each pixel's value is between 0 and 1,
        while 0 is pure white and 1 is pure black
        float[] temp = new float[width * height];
        for(int i = 0; i < pixels.length; i++) {
            temp[i] = (255-pixels[i])*1.0f/255.0f;
        }
        rgbArray = new float[1][width*height]; //Convert float array to 2-dimensional float array
        for(int i = 0; i < width*height; i++) {
            rgbArray[0][i] = temp[i];
            System.out.print(rgbArray[0][i]);
        }
        return rgbArray;
    }*/
//get rgbArray and transfer it to Predict
    public float[][] getRgbArray() throws IOException {
        rgbArray=this.transfer();
        System.out.println(rgbArray);
        return rgbArray;
    }
}
