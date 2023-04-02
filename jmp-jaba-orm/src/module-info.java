module com.example.jmpjabaorm {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.commons.text;
    requires java.sql.rowset;
    requires junit;


    opens com.example.jmpjabaorm to javafx.fxml;
    exports com.example.jmpjabaorm;
}