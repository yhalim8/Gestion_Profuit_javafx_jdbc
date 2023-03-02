package ma.enset.presentation.controller;

import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.Dao.CategorieDaoImpl;
import ma.enset.Dao.ProductDaoImpl;
import ma.enset.Dao.entities.Categorie;
import ma.enset.Dao.entities.Product;
import ma.enset.Service.Catalogueservice;


import java.net.URL;
import java.util.ResourceBundle;

public class ProductController implements Initializable {
    @FXML private TextField textnom ;
    @FXML private TextField ref;
    @FXML private TextField textprix;
    @FXML private ComboBox<Categorie> categorieComboBox;
    @FXML private TableView<Product> tableView;
    @FXML private TextField textFind;
    @FXML private TableColumn<Long,Product> columnId ;
    @FXML private TableColumn<String,Product> columnNom ;
    @FXML private TableColumn<String,Product> columnRef ;
    @FXML private TableColumn<Float,Product> columnPrix ;
    @FXML private TableColumn<Categorie,Product> columnCat ;

    private Catalogueservice catalogueservice;
    Product selectedProduct = new Product();
    ObservableList<Product> data= FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tableView.setItems(data);
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        columnRef.setCellValueFactory(new PropertyValueFactory<>("reference"));
        columnPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        columnCat.setCellValueFactory(new PropertyValueFactory<>("categorie"));

        catalogueservice=new Catalogueservice(new ProductDaoImpl(),new CategorieDaoImpl());
        categorieComboBox.getItems().addAll(catalogueservice.getAllCat());
        //expression lambda
        textFind.textProperty().addListener(((observable, oldValue, newValue) -> {
            data.clear();
            data.addAll(catalogueservice.searchProductByQuery(newValue));
        }));
        loadData();
    }
    private  void loadData(){
        data.clear();
        data.addAll(catalogueservice.getAll());
    }
public void addPr(){
    Categorie c1 = categorieComboBox.getSelectionModel().getSelectedItem();
    Product p = new Product();
    p.setNom(textnom.getText());
    p.setReference(ref.getText());
    p.setPrix(Float.parseFloat(textprix.getText()));
    p.setCategorie(c1);
    catalogueservice.addProduct(p);
    loadData();

}
    public void removeproduct(){
        //int i = listprod.getSelectionModel().getSelectedIndex();
        Product p = tableView.getSelectionModel().getSelectedItem();
        catalogueservice.deleteProduct(p);
        loadData();
    }
    public void editProduct(){
        selectedProduct=tableView.getSelectionModel().getSelectedItem();
        textnom.setText(selectedProduct.getNom());
        ref.setText(selectedProduct.getReference());
        textprix.setText(String.valueOf(selectedProduct.getPrix()));
        /*categorieComboBox.setSelectionModel(new SingleSelectionModel<Categorie>() {
            @Override
            protected Categorie getModelItem(int index) {
                return selectedProduct.getCategorie();
            }

            @Override
            protected int getItemCount() {
                return 4;
            }
        });*/
    }
    public void updateProduct() {
        selectedProduct.setNom(textnom.getText());
        selectedProduct.setReference(ref.getText());
        selectedProduct.setPrix(Float.parseFloat(textprix.getText()));
        selectedProduct.setCategorie(categorieComboBox.getSelectionModel().getSelectedItem());
        catalogueservice.updateProduct(selectedProduct);
        loadData();
    }
}
