package com.edutech.classquiz.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.edutech.classquiz.modelo.entidades.AsignacionesEstudiante;
import com.edutech.classquiz.modelo.entidades.AsignacionesPregunta;
import com.edutech.classquiz.modelo.entidades.Docente;
import com.edutech.classquiz.servicios.interfaces.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;


@Component
public class HomeController {

    @Autowired
    private ExameneInterface exameneInterface;

    @Autowired
    private EstudianteInterface estudianteInterface;

    @Autowired
    private DocenteInterface docenteInterface;

    @Autowired
    private AsignacionesEstudianteInterface asignacionesEstudianteInterface;

    @Autowired
    private AsignacionesPreguntaInterface asignacionesPreguntaInterface;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCrearCuestionario;

    @FXML
    private Button btnRealizarCuestionario;

    @FXML
    private ComboBox<Long> cboCuestionario;

    @FXML
    private ComboBox<Long> cboEstudiante;

    @FXML
    private TextField txtCorreo;

    @FXML
    private PasswordField txtPassword;

    @Setter
    private Stage stage;

    @FXML
    void crearCuestionarioAction(ActionEvent event) throws IOException {
        String correo = txtCorreo.getText();
        String password = txtPassword.getText();
        Docente docente = docenteInterface.authenticateDocente(correo, password);
        if (docente != null) {
            var ventanaCreadorCuestionario = new FXMLLoader(getClass().getResource("/CreadorCuestionario.fxml"));
            var scene = new Scene(ventanaCreadorCuestionario.load());
            Stage stage = new Stage();
            Image icon = new Image("/icon.png");
            stage.getIcons().add(icon);
            stage.setTitle("ClassQuizz");
            stage.setScene(scene);
            stage.setResizable(false);
            CreadorCuestionarioController creadorCuestionarioController = ventanaCreadorCuestionario.getController();
            creadorCuestionarioController.setStage(stage);
            stage.show();
            this.stage.close();
            JOptionPane.showMessageDialog(null, "Docente ingreso correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Docente no encontrado. Vuelva a intentarlo",
                    "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
    }

    @FXML
    void cuestionarioAction(ActionEvent event) {
        Long cuestionario = Long.valueOf(cboCuestionario.getSelectionModel().getSelectedItem().toString());
    }

    @FXML
    void estudianteAction(ActionEvent event) {
        Long estudiante = Long.valueOf(cboEstudiante.getSelectionModel().getSelectedItem().toString());
    }

    @FXML
    void realizarCuestionarioAction(ActionEvent event) throws IOException {
        Long cuestionarioId = Long.valueOf(cboCuestionario.getSelectionModel().getSelectedItem().toString());
        Long estudianteId = Long.valueOf(cboEstudiante.getSelectionModel().getSelectedItem().toString());
        AsignacionesEstudiante asignacionesEstudiante = asignacionesEstudianteInterface.createAsignacion(estudianteId, cuestionarioId);
        AsignacionesPregunta asignacionesPregunta = asignacionesPreguntaInterface.createAsignacion(asignacionesEstudiante.getId(), cuestionarioId);
        if (asignacionesEstudiante != null && asignacionesPregunta != null) {
            var ventanaCuestionario = new FXMLLoader(getClass().getResource("/Cuestionario.fxml"));
            var scene = new Scene(ventanaCuestionario.load());
            Stage stage = new Stage();
            Image icon = new Image("/icon.png");
            stage.getIcons().add(icon);
            stage.setTitle("ClassQuizz");
            stage.setScene(scene);
            stage.setResizable(false);
            CuestionarioController cuestionarioController = ventanaCuestionario.getController();
            cuestionarioController.setStage(stage, cuestionarioId, estudianteId);
            stage.show();
            this.stage.close();
        } else {
            JOptionPane.showMessageDialog(null, "Error al ingresar al cuestionario",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    void initialize() {
//        ObservableList<Long> examenes = FXCollections.observableArrayList(exameneInterface.getListExamenId());
//        cboCuestionario.setItems(examenes);
//        ObservableList<Long> estudiantes = FXCollections.observableArrayList(estudianteInterface.getListEstudianteId());
//        cboEstudiante.setItems(estudiantes);
    }

}
