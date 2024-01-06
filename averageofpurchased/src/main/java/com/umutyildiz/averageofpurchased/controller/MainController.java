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
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

public class MainController {

    /*@FXML
    Button button1;

    @FXML
    private void handle(ActionEvent event){
        button1.setText("UMMUUUUUT");
    }*/

    @FXML
    Button categoryButton;

    @FXML
    ChoiceBox<String> categoryList;

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

            if (!this.categoryList.getItems().isEmpty()) {
                this.categoryList.getItems().clear();
            }

            for (CategoryDto category : categoryList) {
                this.categoryList.getItems().add(category.getName());
            }
        } catch (Exception e) {
            System.out.println("MC0001 ".concat(e.toString()));
        }

    }

    public void getStocks() {
        Task<String> task = new Task<>() {
            @Override
            protected String call(){

                getStockList();
                return "success";
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }

    private void getStockList() {
        String choosenCategoryName = categoryList.getValue();
        Type type = new TypeToken<ArrayList<StockDto>>() {
        }.getType();

        if (choosenCategoryName.isEmpty()){
            return;
        }

        try {
            HttpResponse<JsonNode> apiResponse = makeRestCallGet(EndpointDefinition.SERVER_IP_PORT.
                    concat(EndpointDefinition.STOCK).
                    concat(choosenCategoryName));

            ArrayList<StockDto> stockList = gson.fromJson(apiResponse.getBody().toString(), type);

            for (StockDto stockDto : stockList){
                System.out.println("anaaaaa: " + stockDto);//buradaki stockları tabloya sırasıyla yaz
            }


        } catch (Exception e) {
            System.out.println("MC0002 ".concat(Arrays.toString(e.getStackTrace())));
        }
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
