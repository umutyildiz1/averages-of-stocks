package com.umutyildiz.averageofpurchased.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.umutyildiz.averageofpurchased.dto.CategoryDto;
import com.umutyildiz.averageofpurchased.dto.StockDto;
import com.umutyildiz.averageofpurchased.utility.EndpointDefinition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

public class MainController {

    @FXML
    Button categoryButton;

    @FXML
    ChoiceBox<String> categoryBox;

    @FXML
    TableView<StockDto> stockTable;

    @FXML
    TableColumn<StockDto, String> nameColumn;
    @FXML
    TableColumn<StockDto, String> quantityColumn;
    @FXML
    TableColumn<StockDto, String> averagePriceColumn;

    private final Gson gson = new Gson();

    public void getCategories() {
        Task<String> task = new Task<>() {
            @Override
            protected String call() {

                getCategoryList();
                return "success";
            }
        };
        Thread thread = new Thread(task);
        thread.start();

    }

    private void getCategoryList() {
        try {
            HttpResponse<JsonNode> apiResponse = makeRestCallGet(EndpointDefinition.SERVER_IP_PORT.concat(EndpointDefinition.CATEGORY));

            Type type = new TypeToken<ArrayList<CategoryDto>>() {
            }.getType();
            ArrayList<CategoryDto> categoryList = gson.fromJson(apiResponse.getBody().toString(), type);

            if (!categoryBox.getItems().isEmpty()) {
                categoryBox.getItems().clear();
            }

            for (CategoryDto category : categoryList) {
                categoryBox.getItems().add(category.getName());
            }
        } catch (Exception e) {
            System.out.println("MC0001 ".concat(e.toString()));
        }

    }

    public void getStocks() {
        Task<String> task = new Task<>() {
            @Override
            protected String call() {

                getStockList();
                return "success";
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }

    private void getStockList() {
        String choosenCategoryName = categoryBox.getValue();
        Type type = new TypeToken<ArrayList<StockDto>>() {
        }.getType();

        if (choosenCategoryName.isEmpty()) {
            return;
        }

        try {
            HttpResponse<JsonNode> apiResponse = makeRestCallGet(EndpointDefinition.SERVER_IP_PORT.
                    concat(EndpointDefinition.STOCK).
                    concat(choosenCategoryName));

            ArrayList<StockDto> stockList = apiResponse.getBody().toString()
                    .equals("{}") ? new ArrayList<>() : gson.fromJson(apiResponse.getBody().toString(), type);


            fillStockTable(FXCollections.observableList(stockList));


        } catch (Exception e) {
            System.out.println("MC0002 ".concat(Arrays.toString(e.getCause().toString().toCharArray())));
        }
    }

    private void fillStockTable(ObservableList<StockDto> stockList) {
        nameColumn.setCellValueFactory(cell -> cell.getValue().getNameProperty());
        quantityColumn.setCellValueFactory(cell -> cell.getValue().getQuantityProperty());
        averagePriceColumn.setCellValueFactory(cell -> cell.getValue().getAveragePriceProperty());

        stockTable.setItems(stockList);
    }

    private HttpResponse<JsonNode> makeRestCallGet(String endpoint) throws UnirestException {
        return Unirest.get(endpoint)
                .asJson();
    }

    /*private HttpResponse<JsonNode> makeRestCallGetWithRouteParams(String endpoint, HashMap<String,?> paramMap) throws UnirestException {
        GetRequest getRequest = new GetRequest(HttpMethod.GET, endpoint);
        getRequest.
        for(Map.Entry<String,?> entry : paramMap.entrySet()){
            getRequest.routeParam(entry.getKey(), entry.getValue())
        }


        return Unirest.get(endpoint)
                .asJson();

        return
    }*/

    private HttpResponse<JsonNode> makeRestCallPost(String endpoint) throws UnirestException {
        return Unirest.post(endpoint)
                .asJson();
    }
}
