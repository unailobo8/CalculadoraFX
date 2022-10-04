package com.example.calculadora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class HelloController {
    @FXML
    private Button button0;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Button buttonC;
    @FXML
    private Button buttonDel;
    @FXML
    private Button buttonDiv;
    @FXML
    private Button buttonMult;
    @FXML
    private Button buttonRes;
    @FXML
    private Button buttonSum;
    @FXML
    private Button buttonAns;
    @FXML
    private Button buttonComa;
    @FXML
    private Button buttonTrans;
    @FXML
    private TextField textfieldResult;

    private boolean operationOn = true;
    private double lastOperation = 0;

    public void cleanScreen() {
        textfieldResult.setText("");
        operationOn = true;
    }

    public void deleteValue() {
        if (!(textfieldResult.getText().length() == 0)) {
            textfieldResult.setText(textfieldResult.getText().substring(0, textfieldResult.getText().length() - 1));
        }
    }

    public void getLastResult() {
        if (!(lastOperation == 0)) {
            textfieldResult.setText(textfieldResult.getText() + lastOperation);
        }
    }

    public void addValue(javafx.event.ActionEvent actionEvent) {
        textfieldResult.setText(textfieldResult.getText() + ((Button) actionEvent.getSource()).getText());
        operationOn = true;
    }

    public void addOperation(javafx.event.ActionEvent actionEvent) {
        if (operationOn) {
            textfieldResult.setText(textfieldResult.getText() + ((Button) actionEvent.getSource()).getText());
            operationOn = false;
        }
    }

    public void makeOperation() {
        String operationS = textfieldResult.getText();

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        try {
            Object operation = engine.eval(textfieldResult.getText().replaceAll("x", "*"));
            textfieldResult.setText("" + operation);
            lastOperation = Double.parseDouble(textfieldResult.getText());
        } catch (ScriptException e) {
            textfieldResult.setText("");
        }
    }

}