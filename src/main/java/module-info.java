module com.jwieczor.tablemenager {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.jwieczor.tablemenager to javafx.fxml;
    exports com.jwieczor.tablemenager;
}