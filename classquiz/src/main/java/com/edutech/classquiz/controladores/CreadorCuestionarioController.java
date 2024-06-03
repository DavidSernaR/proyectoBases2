package com.edutech.classquiz.controladores;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import com.edutech.classquiz.modelo.entidades.*;
import com.edutech.classquiz.servicios.interfaces.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;
import lombok.Setter;

import javax.swing.*;

@AllArgsConstructor
public class CreadorCuestionarioController {

    private final CursoInterface cursoInterface;

    private final TemaInterface temaInterface;

    private final EstadoInterface estadoInterface;

    private final TipospreguntaInterface tipospreguntaInterface;

    private final PreguntaInterface preguntaInterface;

    private final RespuestaInterface respuestaInterface;

    private final ExameneInterface exameneInterface;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCrear;

    @FXML
    private TextField txtPesoDos;

    @FXML
    private TextField txtPesoUno;

    @FXML
    private TextField txtPreguntaDos;

    @FXML
    private TextField txtPreguntaUno;

    @FXML
    private TextField txtRespuestaDos;

    @FXML
    private TextField txtRespuestaUno;

    @FXML
    private TextField txtTitulo;

    @Setter
    private Stage stage;

    @FXML
    void crearAction(ActionEvent event) throws IOException {
//        Curso curso = cursoInterface.getCursoById(1L);
//        Tema tema = temaInterface.getTemaById(1L);
//        Estado estado = estadoInterface.getEstadoById(1L);
//        Tipospregunta tipospregunta = tipospreguntaInterface.getTipospreguntaById(1L);

        Pregunta preguntaExamenUno = new Pregunta();
        String preguntaUno = txtPreguntaUno.getText();
        Double pesoUno = Double.valueOf(txtPesoUno.getText());
        preguntaExamenUno.setEnunciado(preguntaUno);
//        preguntaExamenUno.setIdtema(tema);
//        preguntaExamenUno.setIdestado(estado);
//        preguntaExamenUno.setIdtipopregunta(tipospregunta);
        preguntaExamenUno.setPeso(pesoUno);

        preguntaInterface.createPregunta(preguntaExamenUno);

        Pregunta preguntaExamenDos = new Pregunta();
        String preguntaDos = txtPreguntaDos.getText();
        Double pesoDos = Double.valueOf(txtPesoDos.getText());
        preguntaExamenDos.setEnunciado(preguntaDos);
//        preguntaExamenDos.setIdtema(tema);
//        preguntaExamenDos.setIdestado(estado);
//        preguntaExamenDos.setIdtipopregunta(tipospregunta);
        preguntaExamenDos.setPeso(pesoDos);

        preguntaInterface.createPregunta(preguntaExamenDos);

        Respuesta respuestaExamenUno = new Respuesta();
        String respuestaUno = txtRespuestaUno.getText();
        respuestaExamenUno.setOpcionrespuesta(respuestaUno);
        respuestaExamenUno.setCorrecta(respuestaUno);
        respuestaExamenUno.setIdpreguntas(preguntaExamenUno);

        respuestaInterface.createRespuesta(respuestaExamenUno);

        Respuesta respuestaExamenDos = new Respuesta();
        String respuestaDos = txtRespuestaDos.getText();
        respuestaExamenDos.setOpcionrespuesta(respuestaDos);
        respuestaExamenDos.setCorrecta(respuestaDos);
        respuestaExamenDos.setIdpreguntas(preguntaExamenDos);

        respuestaInterface.createRespuesta(respuestaExamenDos);

        Examene examene = new Examene();
        String tituloExamen = txtTitulo.getText();
        examene.setTitulo(tituloExamen);
//        LocalDate fechaActual = LocalDate.now();
//        examene.setFecha(fechaActual);
//        examene.setDuracionexamen(5L);
//        examene.setCantidadpreguntas(2L);
//        examene.setCalificacion(0.0);
//        examene.setIdcurso(curso);
//        examene.setCantidadpreguntasxestudiante(2L);
//        examene.setIdtema(tema);
//        LocalTime horaActual = LocalTime.now();
//        examene.setHorainicio(LocalDate.from(horaActual));
//        examene.setHorafin(LocalDate.from(horaActual));
//        examene.setNotaparaaprobar((long) 5.0);
//        examene.setEstado("Creado");
        List<Pregunta> preguntasExamen = new ArrayList<>();
        preguntasExamen.add(preguntaExamenUno);
        preguntasExamen.add(preguntaExamenDos);

        exameneInterface.createExamen(examene, preguntasExamen);

        var ventanaHome = new FXMLLoader(getClass().getResource("/Home.fxml"));
        var scene = new Scene(ventanaHome.load());
        Stage stage = new Stage();
        Image icon = new Image("/icon.png");
        stage.getIcons().add(icon);
        stage.setTitle("ClassQuizz");
        stage.setScene(scene);
        stage.setResizable(false);
        HomeController homeController = ventanaHome.getController();
        homeController.setStage(stage);
        stage.show();
        this.stage.close();
        JOptionPane.showMessageDialog(null, "Cuestionario creado correctamente");
    }

}
