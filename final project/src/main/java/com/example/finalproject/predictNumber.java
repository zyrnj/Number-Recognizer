package com.example.finalproject;

import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.Files.readAllBytes;

public interface predictNumber {
    default int getResult(LoadImage loadImage) throws IOException {
        int result=0;
        float[][] rgbArray=loadImage.getRgbArray();
        //Load the model which has been trained in python
        byte[] graphDef = readAllBytes(Paths.get("src/main/trainedModel.pb"));
        Graph graph = new Graph();
        graph.importGraphDef(graphDef);

        //Use Tensorflow API to run the model
        Session session = new Session(graph);

        //Check if image is blank
        if (rgbArray == null) {
            return -1;
        }
        //Create input and get the result out of the model
        Tensor inputTarget = Tensor.create(rgbArray);
        List<Tensor<?>> out = session.runner().feed("input_x", inputTarget).fetch("final_result").run();

        //The result is a list of possibilities from 0 to 9, and we choose the largest
        //Here is how to use the output in Tensorflow1, Tensorflow2 has changed a lot and with few tutorial
        //Tenosorflow is not suitable to Java, and we come across bug using it on MAC air. But it runs well on windows.
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
}
