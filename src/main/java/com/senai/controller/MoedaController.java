package com.senai.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class MoedaController {

    @FXML
    private Label resultadoMoeda;

    @FXML
    private ComboBox<String> num2Combo;

    @FXML
    private TextField num1Text;

    @FXML
    private void initialize() {
            List<String> listaConversoes = new ArrayList<>();

        listaConversoes.add("BRL -> USD");
        listaConversoes.add("USD -> BRL");
        listaConversoes.add("BRL -> EUR");
        listaConversoes.add("EUR -> BRL");

        num2Combo.setItems(FXCollections.observableArrayList(listaConversoes));
    }

    @FXML
    private void calcularMoeda() {

        double valor = Double.parseDouble(num1Text.getText());
        double resultado = 0;

        String moeda = num2Combo.getValue();

        switch (moeda) {

            case "BRL -> USD":
                resultado = valor / 5.03;
                break;

            case "USD -> BRL":
                resultado = valor * 5.03;
                break;

            case "BRL -> EUR":
                resultado = valor / 5.85;
                break;

            case "EUR -> BRL":
                resultado = valor * 5.85;
                break;
        }

        resultadoMoeda.setText(String.format("O valor é %.2f", resultado));
    }
}