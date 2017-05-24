package repository;/**
 * Created by camelia on 11/29/2016.
 */

import domain.Student;
import domain.validators.StudentValidator;
import domain.validators.ValidatorException;
import javafx.application.Application;
import javafx.stage.Stage;

public class TestXML extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        StudentXMLStAXRepository repo=
                new StudentXMLStAXRepository(new StudentValidator(), "./src/data/testXML.xml");
        repo.findAll().forEach(System.out::println);
        try {
            repo.save(new Student("52","andu","dan","djhsjdhsj@"));
        } catch (ValidatorException e) {
            e.printStackTrace();
        }


    }
}
