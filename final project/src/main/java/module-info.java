module com.example.finalproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;
    requires javafx.swing;
    requires thumbnailator;
    requires tensorflow;
    requires org.apache.commons.io;
    requires libtensorflow.jni;
    requires libtensorflow;


    opens com.example.finalproject to javafx.fxml;
    exports com.example.finalproject;
}