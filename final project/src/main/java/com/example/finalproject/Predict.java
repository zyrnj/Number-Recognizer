package com.example.finalproject;

import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.apache.commons.io.IOUtils;

import static java.nio.file.Files.readAllBytes;

//inherit the predictNumber interface
public class Predict implements predictNumber{
    //encapsulate the predict result
    private int result;
    //singleton design pattern, we only instantiate one predict object at one time
    private static Predict instance = new Predict();
    private Predict(){
    }
    public static Predict getInstance(){
        return instance;
    }
    public int getPredictRes(LoadImage loadImage) throws IOException {
        result=this.getResult(loadImage);
        return result;
    }

    /*   public Predict() throws IOException {
        LoadImage l=new LoadImage();;
        rgbArray = l.getRgbArray();
    }

    public int getResult() throws IOException {

        //Load the model which has been trained before
        byte[] graphDef = readAllBytes(Paths.get("src/main/trainedModel.pb"));
        Graph graph = new Graph();
        graph.importGraphDef(graphDef);

        //Create a session to handle input and output of the model
        Session session = new Session(graph);

        //Get the 2-dimensional float array of the target image
        //Check if image is blank
        if (rgbArray == null) {
            return -1;
        }
        //Create input and get the result out of the model
        Tensor inputTarget = Tensor.create(rgbArray);
        List<Tensor<?>> out = session.runner().feed("input_x", inputTarget).fetch("final_result").run();

        /*The result out is a list of possibilities for each number from 0 to 9,
          and the number which has the highest possibility is the recognized result.
        for (Tensor tensor : out) {
            float[][] matrix = new float[1][10];
            tensor.copyTo(matrix);
            float max = 0f;
            for (int i = 0; i < matrix[0].length; i++) {
                if(max < matrix[0][i]) {
                    max = matrix[0][i];
                    result = i;
                }
            }
        }
        return result;
    }
*/

}
