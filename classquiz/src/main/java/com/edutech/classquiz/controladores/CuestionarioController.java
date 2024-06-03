package com.edutech.classquiz.controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.edutech.classquiz.modelo.entidades.Examene;
import com.edutech.classquiz.modelo.entidades.Pregunta;
import com.edutech.classquiz.servicios.interfaces.ExameneInterface;
import com.edutech.classquiz.servicios.interfaces.PreguntaInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CuestionarioController {

    private final ExameneInterface exameneInterface;

    private final PreguntaInterface preguntaInterface;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnEnviar;

    @FXML
    private Label linPreguntaDos;

    @FXML
    private Label linPreguntaUno;

    @FXML
    private Label linTitulo;

    @FXML
    private TextField txtRespuestaDos;

    @FXML
    private TextField txtRespuestaUno;

    private Stage stage;

    private Long cuestionarioId;

    private Long estudianteId;

    @FXML
    void enviarAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        Pregunta[] arrayPregunta = new Pregunta[2];
        int n = 0;
        Examene examene = exameneInterface.getExamenById(cuestionarioId);
        linTitulo.setText(examene.getTitulo());
        for (Pregunta pregunta : preguntaInterface.getPreguntasByExamenId(cuestionarioId)) {
            arrayPregunta[n] = pregunta;
            n++;
        }
        linPreguntaUno.setText(arrayPregunta[0].getEnunciado());
        linPreguntaDos.setText(arrayPregunta[1].getEnunciado());
    }

    public void setStage(Stage stage, Long cuestionarioId, Long estudianteId) {
        this.stage = stage;
        this.cuestionarioId = cuestionarioId;
        this.estudianteId = estudianteId;
    }

}
