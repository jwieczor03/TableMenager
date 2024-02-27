module com.jwieczor.tablemenager {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.jwieczor.tablemenager to javafx.fxml;
    exports com.jwieczor.tablemenager;
}