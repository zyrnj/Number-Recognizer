package com.example.finalproject;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

public interface transferGraph {

    default float[][] transfer() throws IOException {
        //use thumnails to zoom in raw photo
        Thumbnails.of("src/main/original.png").size(28,28).toFile("src/main/transformed.png");
        //use BufferedImage to create grey photo
        BufferedImage srcImg = ImageIO.read(new File("src/main/transformed.png"));
        BufferedImage scaledImg = new BufferedImage(28, 28, BufferedImage.TYPE_BYTE_GRAY);
        Graphics graphics = scaledImg.getGraphics();
        graphics.drawImage(srcImg, 0, 0, null);
        graphics.dispose();
        //ImageIO.write(scaledImg, "PNG", new File("src/main/transformedgray.png"));
        for(int i= 0 ; i < 28 ; i++){
            for(int j = 0 ; j < 28; j++){
                int rgb = srcImg.getRGB(i, j);
                scaledImg.setRGB(i, j, rgb);
            }
        }
        //get gray picture of  size 28*28
        Raster graphic = scaledImg.getData();

        //Get the pixels for each point in 28*28 photo
        int[] pixels = new int[28 * 28];
        pixels = graphic.getPixels(0, 0, 28, 28, pixels);
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
        // Pixels' value is between 0 and 255, we transfer it from 0 to 1 to suit the model
        //0 is white and 1 is black
        float[] temp = new float[28 * 28];
        for(int i = 0; i < pixels.length; i++) {
            temp[i] = (255-pixels[i])*1.0f/255.0f;
        }
        float[][] rgbArray = new float[1][28*28];
        //Convert float array to 2-dimensional float array
        for(int i = 0; i < 28*28; i++) {
            rgbArray[0][i] = temp[i];
            System.out.print(rgbArray[0][i]);
        }
        return rgbArray;
    }
}
