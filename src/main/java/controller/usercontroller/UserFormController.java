package controller.usercontroller;

import controller.ProductController;
import controller.SupplierController;
import controller.maincontroller.MainController;
import entity.ProductEntity;
import entity.SupplierEntity;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Product;
import model.Supplier;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserFormController implements Initializable {

    private Product deleteproduct;
    private Supplier deletesupplier;

    @FXML
    private AnchorPane addorderform;

    @FXML
    private AnchorPane addproductform;

    @FXML
    private AnchorPane addsupplierform;

    @FXML
    private TableView cart;

    @FXML
    private TableColumn cart_item_id_col;

    @FXML
    private TableColumn cart_item_name_col;

    @FXML
    private TableColumn cart_item_qty_col;

    @FXML
    private AnchorPane deleteorderform;

    @FXML
    private AnchorPane deleteproductform;

    @FXML
    private AnchorPane deletesupplierform;

    @FXML
    private AnchorPane employeereportform;

    @FXML
    private PieChart employeereportpiechart;

    @FXML
    private TableColumn item_category_col;

    @FXML
    private TableColumn item_id_col;

    @FXML
    private TableColumn item_name_col;

    @FXML
    private TableColumn item_price_col;

    @FXML
    private TableColumn item_size_col;

    @FXML
    private TableColumn item_qty_col;

    @FXML
    private TableView itemtable;

    @FXML
    private TextField o_id;

    @FXML
    private TableColumn o_id_col;

    @FXML
    private TextField o_name;

    @FXML
    private TableColumn o_name_col;

    @FXML
    private ComboBox<String> o_paymenttype;

    @FXML
    private TableColumn o_paymenttype_col;

    @FXML
    private TableColumn o_total_price;

    @FXML
    private ComboBox<String> o_u_id;

    @FXML
    private TextField o_u_name;

    @FXML
    private ComboBox<String> o_u_paymenttype;

    @FXML
    private ComboBox<String> p_category;

    @FXML
    private TableColumn p_category_col;

    @FXML
    private TextField p_id;

    @FXML
    private TableColumn p_id_col;

    @FXML
    private TextField p_name;

    @FXML
    private TableColumn p_name_col;

    @FXML
    private TextField p_price;

    @FXML
    private TableColumn p_price_col;

    @FXML
    private TextField p_qty;

    @FXML
    private TableColumn p_qty_col;

    @FXML
    private TextField p_size;

    @FXML
    private TableColumn p_size_col;

    @FXML
    private ComboBox<String> p_supplier;

    @FXML
    private TableColumn p_supplier_col;

    @FXML
    private ComboBox<String> p_u_category;

    @FXML
    private ComboBox<String> p_u_id;

    @FXML
    private TextField p_u_name;

    @FXML
    private TextField p_u_price;

    @FXML
    private TextField p_u_qty;

    @FXML
    private TextField p_u_size;

    @FXML
    private ComboBox<String> p_u_supplier;

    @FXML
    private AnchorPane productreportform;

    @FXML
    private PieChart productreportpiechart;

    @FXML
    private TableView<Product> producttable ;

    @FXML
    private TextField qty;

    @FXML
    private TextField s_company;

    @FXML
    private TableColumn s_company_col;

    @FXML
    private TextField s_contact;

    @FXML
    private TableColumn s_contact_col;

    @FXML
    private TextField s_id;

    @FXML
    private TableColumn s_id_col;

    @FXML
    private TextField s_name;

    @FXML
    private TableColumn s_name_col;

    @FXML
    private TextField s_u_company;

    @FXML
    private TextField s_u_contact;

    @FXML
    private ComboBox<String> s_u_id;

    @FXML
    private TextField s_u_name;

    @FXML
    private PieChart supplierpiechart;

    @FXML
    private AnchorPane supplierreportform;

    @FXML
    private TableView<Supplier> suppliertable;

    @FXML
    private TableView d_ordertable;

    @FXML
    private Label totalprice;

    @FXML
    private TableView u_cart;

    @FXML
    private TableColumn u_cart_item_id_col;

    @FXML
    private TableColumn u_cart_item_name_col;

    @FXML
    private TableColumn u_cart_item_qty_col;

    @FXML
    private TextField u_discount;

    @FXML
    private TableColumn u_item_category_col;

    @FXML
    private TableColumn u_item_id_col;

    @FXML
    private TableColumn u_item_name_col;

    @FXML
    private TableColumn u_item_price_col;

    @FXML
    private TableColumn u_item_size_col;

    @FXML
    private TableColumn u_item_qty_col;

    @FXML
    private TableView u_itemtable;

    @FXML
    private TextField u_qty;

    @FXML
    private Label u_totalprice;

    @FXML
    private AnchorPane updateorderform;

    @FXML
    private AnchorPane updateproductform;

    @FXML
    private AnchorPane updatesupplierform;

    @FXML
    void AddItemOnAction(ActionEvent event) {

    }

    @FXML
    void AddProductOnAction(ActionEvent event) {
        if(p_supplier.getValue()==null) {
            new Alert(Alert.AlertType.ERROR,"Select a Supplier").showAndWait();
        }
        else if(p_category.getValue()==null){
            new Alert(Alert.AlertType.ERROR,"Select a Category").showAndWait();
        }
        else{
            ProductController.getInstance().AddProduct(
                    p_id.getText(),
                    p_name.getText(),
                    p_size.getText(),
                    p_supplier.getValue(),
                    Integer.parseInt(p_qty.getText()),
                    Double.parseDouble(p_price.getText()),
                    p_category.getValue()
            );
            setProductText();
            p_id.setText(ProductController.getInstance().GenerateId());
        }
    }

    @FXML
    void AddSupplierOnAction(ActionEvent event) {
        SupplierController.getInstance().AddSupplier(
                s_id.getText(),
                s_name.getText(),
                s_company.getText(),
                s_contact.getText()
        );
        setSuppliertext();
        s_id.setText(SupplierController.getInstance().GenerateId());
    }

    @FXML
    void BackOnAction(ActionEvent event) throws IOException {
        Stage stage = MainController.stage;
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../view/main_form.fxml"))));
        stage.setFullScreen(false);
    }

    @FXML
    void DeleteOrderOnAction(ActionEvent event) {

    }

    @FXML
    void DeleteProductOnAction(ActionEvent event) {
        ProductController.getInstance().DeleteProduct(deleteproduct);
        setProducttable();
    }

    @FXML
    void DeleteSupplierOnAction(ActionEvent event) {
        SupplierController.getInstance().DeleteSupplier(deletesupplier);
        setSuppliertable();
    }

    @FXML
    void DownloadEROnAction(ActionEvent event) {

    }

    @FXML
    void DownloadPROnAction(ActionEvent event) {

    }

    @FXML
    void DownloadSROnAction(ActionEvent event) {

    }

    @FXML
    void NavAddOrderOnAction(ActionEvent event) {
        addorderform.setVisible(true);
        addproductform.setVisible(false);
        addsupplierform.setVisible(false);
        deleteorderform.setVisible(false);
        deleteproductform.setVisible(false);
        deletesupplierform.setVisible(false);
        updateorderform.setVisible(false);
        updateproductform.setVisible(false);
        updatesupplierform.setVisible(false);
        employeereportform.setVisible(false);
        productreportform.setVisible(false);
        supplierreportform.setVisible(false);
    }

    @FXML
    void NavAddProductOnAction(ActionEvent event) {
        addorderform.setVisible(false);
        addproductform.setVisible(true);
        addsupplierform.setVisible(false);
        deleteorderform.setVisible(false);
        deleteproductform.setVisible(false);
        deletesupplierform.setVisible(false);
        updateorderform.setVisible(false);
        updateproductform.setVisible(false);
        updatesupplierform.setVisible(false);
        employeereportform.setVisible(false);
        productreportform.setVisible(false);
        supplierreportform.setVisible(false);

        setSupplier();
    }

    @FXML
    void NavAddSupplierOnAction(ActionEvent event) {
        addorderform.setVisible(false);
        addproductform.setVisible(false);
        addsupplierform.setVisible(true);
        deleteorderform.setVisible(false);
        deleteproductform.setVisible(false);
        deletesupplierform.setVisible(false);
        updateorderform.setVisible(false);
        updateproductform.setVisible(false);
        updatesupplierform.setVisible(false);
        employeereportform.setVisible(false);
        productreportform.setVisible(false);
        supplierreportform.setVisible(false);

    }

    @FXML
    void NavEmployeeReportOnAction(ActionEvent event) {
        addorderform.setVisible(false);
        addproductform.setVisible(false);
        addsupplierform.setVisible(false);
        deleteorderform.setVisible(false);
        deleteproductform.setVisible(false);
        deletesupplierform.setVisible(false);
        updateorderform.setVisible(false);
        updateproductform.setVisible(false);
        updatesupplierform.setVisible(false);
        employeereportform.setVisible(true);
        productreportform.setVisible(false);
        supplierreportform.setVisible(false);
    }

    @FXML
    void NavProductReportOnAction(ActionEvent event) {
        addorderform.setVisible(false);
        addproductform.setVisible(false);
        addsupplierform.setVisible(false);
        deleteorderform.setVisible(false);
        deleteproductform.setVisible(false);
        deletesupplierform.setVisible(false);
        updateorderform.setVisible(false);
        updateproductform.setVisible(false);
        updatesupplierform.setVisible(false);
        employeereportform.setVisible(false);
        productreportform.setVisible(true);
        supplierreportform.setVisible(false);
    }

    @FXML
    void NavSupplierReportOnAction(ActionEvent event) {
        addorderform.setVisible(false);
        addproductform.setVisible(false);
        addsupplierform.setVisible(false);
        deleteorderform.setVisible(false);
        deleteproductform.setVisible(false);
        deletesupplierform.setVisible(false);
        updateorderform.setVisible(false);
        updateproductform.setVisible(false);
        updatesupplierform.setVisible(false);
        employeereportform.setVisible(false);
        productreportform.setVisible(false);
        supplierreportform.setVisible(true);
    }

    @FXML
    void NavUpdateOrderOnAction(ActionEvent event) {
        addorderform.setVisible(false);
        addproductform.setVisible(false);
        addsupplierform.setVisible(false);
        deleteorderform.setVisible(false);
        deleteproductform.setVisible(false);
        deletesupplierform.setVisible(false);
        updateorderform.setVisible(true);
        updateproductform.setVisible(false);
        updatesupplierform.setVisible(false);
        employeereportform.setVisible(false);
        productreportform.setVisible(false);
        supplierreportform.setVisible(false);
    }

    @FXML
    void NavUpdateProductOnAction(ActionEvent event) {
        addorderform.setVisible(false);
        addproductform.setVisible(false);
        addsupplierform.setVisible(false);
        deleteorderform.setVisible(false);
        deleteproductform.setVisible(false);
        deletesupplierform.setVisible(false);
        updateorderform.setVisible(false);
        updateproductform.setVisible(true);
        updatesupplierform.setVisible(false);
        employeereportform.setVisible(false);
        productreportform.setVisible(false);
        supplierreportform.setVisible(false);

        setSupplier();
        setProduct();
    }

    @FXML
    void NavUpdateSupplierOnAction(ActionEvent event) {
        addorderform.setVisible(false);
        addproductform.setVisible(false);
        addsupplierform.setVisible(false);
        deleteorderform.setVisible(false);
        deleteproductform.setVisible(false);
        deletesupplierform.setVisible(false);
        updateorderform.setVisible(false);
        updateproductform.setVisible(false);
        updatesupplierform.setVisible(true);
        employeereportform.setVisible(false);
        productreportform.setVisible(false);
        supplierreportform.setVisible(false);

        setSupplier();
    }

    @FXML
    void NavViewOrderOnAction(ActionEvent event) {
        addorderform.setVisible(false);
        addproductform.setVisible(false);
        addsupplierform.setVisible(false);
        deleteorderform.setVisible(true);
        deleteproductform.setVisible(false);
        deletesupplierform.setVisible(false);
        updateorderform.setVisible(false);
        updateproductform.setVisible(false);
        updatesupplierform.setVisible(false);
        employeereportform.setVisible(false);
        productreportform.setVisible(false);
        supplierreportform.setVisible(false);
    }

    @FXML
    void NavViewProductOnAction(ActionEvent event) {
        addorderform.setVisible(false);
        addproductform.setVisible(false);
        addsupplierform.setVisible(false);
        deleteorderform.setVisible(false);
        deleteproductform.setVisible(true);
        deletesupplierform.setVisible(false);
        updateorderform.setVisible(false);
        updateproductform.setVisible(false);
        updatesupplierform.setVisible(false);
        employeereportform.setVisible(false);
        productreportform.setVisible(false);
        supplierreportform.setVisible(false);

        setProducttable();
    }

    @FXML
    void NavViewSupplierOnAction(ActionEvent event) {
        addorderform.setVisible(false);
        addproductform.setVisible(false);
        addsupplierform.setVisible(false);
        deleteorderform.setVisible(false);
        deleteproductform.setVisible(false);
        deletesupplierform.setVisible(true);
        updateorderform.setVisible(false);
        updateproductform.setVisible(false);
        updatesupplierform.setVisible(false);
        employeereportform.setVisible(false);
        productreportform.setVisible(false);
        supplierreportform.setVisible(false);

        setSuppliertable();
    }

    @FXML
    void PlaceOrderOnAction(ActionEvent event) {

    }

    @FXML
    void RemoveItemOnAction(ActionEvent event) {

    }

    @FXML
    void UpdateAddItemOnAction(ActionEvent event) {

    }

    @FXML
    void UpdateOrderOnAction(ActionEvent event) {

    }

    @FXML
    void UpdateProductOnAction(ActionEvent event) {
        ProductController.getInstance().UpdateProduct(
                p_u_id.getValue().toString(),
                p_u_name.getText(),
                p_u_size.getText(),
                p_u_supplier.getValue().toString(),
                Integer.parseInt(p_u_qty.getText()),
                Double.parseDouble(p_u_price.getText()),
                p_u_category.getValue().toString()
        );
        setProductText();
    }

    @FXML
    void UpdateRemoveItemOnAction(ActionEvent event) {

    }

    @FXML
    void UpdateSupplierOnAction(ActionEvent event) {
        SupplierController.getInstance().UpdateSupplier(
                s_u_id.getValue().toString(),
                s_u_name.getText(),
                s_u_company.getText(),
                s_u_contact.getText()
        );
        setSuppliertext();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addorderform.setVisible(true);
        addproductform.setVisible(false);
        addsupplierform.setVisible(false);
        deleteorderform.setVisible(false);
        deleteproductform.setVisible(false);
        deletesupplierform.setVisible(false);
        updateorderform.setVisible(false);
        updateproductform.setVisible(false);
        updatesupplierform.setVisible(false);
        employeereportform.setVisible(false);
        productreportform.setVisible(false);
        supplierreportform.setVisible(false);

        p_id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        p_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        p_size_col.setCellValueFactory(new PropertyValueFactory<>("size"));
        p_supplier_col.setCellValueFactory(new PropertyValueFactory<>("supplier"));
        p_qty_col.setCellValueFactory(new PropertyValueFactory<>("qty"));
        p_price_col.setCellValueFactory(new PropertyValueFactory<>("price"));
        p_category_col.setCellValueFactory(new PropertyValueFactory<>("category"));

        item_id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        item_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        item_size_col.setCellValueFactory(new PropertyValueFactory<>("size"));
        item_qty_col.setCellValueFactory(new PropertyValueFactory<>("qty"));
        item_price_col.setCellValueFactory(new PropertyValueFactory<>("price"));
        item_category_col.setCellValueFactory(new PropertyValueFactory<>("category"));

        u_item_id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        u_item_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        u_item_size_col.setCellValueFactory(new PropertyValueFactory<>("size"));
        u_item_qty_col.setCellValueFactory(new PropertyValueFactory<>("qty"));
        u_item_price_col.setCellValueFactory(new PropertyValueFactory<>("price"));
        u_item_category_col.setCellValueFactory(new PropertyValueFactory<>("category"));

        cart_item_id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        cart_item_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        cart_item_qty_col.setCellValueFactory(new PropertyValueFactory<>("qty"));

        u_cart_item_id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        u_cart_item_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        u_cart_item_qty_col.setCellValueFactory(new PropertyValueFactory<>("qty"));


        producttable.getSelectionModel().selectedItemProperty().addListener(((observableValue, o, t1) ->{
            if(t1!=null){
                deleteproduct = t1;
            }
        }));

        p_u_id.getSelectionModel().selectedItemProperty().addListener(((observableValue, o, t1) ->{
            if(t1!=null){
                setProductText(t1);
            }
        }));

        s_id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        s_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        s_company_col.setCellValueFactory(new PropertyValueFactory<>("company"));
        s_contact_col.setCellValueFactory(new PropertyValueFactory<>("contact"));

        suppliertable.getSelectionModel().selectedItemProperty().addListener(((observableValue, o, t1) ->{
            if(t1!=null){
                deletesupplier = t1;
            }
        }));

        s_u_id.getSelectionModel().selectedItemProperty().addListener(((observableValue, o, t1) ->{
            if(t1!=null){
                 setSuppliertext(t1);
            }
        }));

        p_id.setText(ProductController.getInstance().GenerateId());
        s_id.setText(SupplierController.getInstance().GenerateId());

        setCategory();
    }

    private void setCategory(){
        List<String> categorylist = new ArrayList<>();
        categorylist.add("Gents");
        categorylist.add("Ladies");
        categorylist.add("Kids");
        p_category.setItems(FXCollections.observableArrayList(categorylist));
        p_u_category.setItems(FXCollections.observableArrayList(categorylist));
    }

    private void setSupplier(){
        List<String> supplierlist = new ArrayList<>();
        List<Supplier> supplierentitylist = SupplierController.getInstance().getSupplier();
        for (int i = 0; i <supplierentitylist.size(); i++){
            supplierlist.add((supplierentitylist.get(i)).getId());
        }
        p_supplier.setItems(FXCollections.observableArrayList(supplierlist));
        p_u_supplier.setItems(FXCollections.observableArrayList(supplierlist));
        s_u_id.setItems(FXCollections.observableArrayList(supplierlist));
    }

    private void setProduct(){
        List<String> productlist = new ArrayList<>();
        List<Product> productentitylist = ProductController.getInstance().getProduct();
        for (int i = 0; i <productentitylist.size(); i++){
            productlist.add((productentitylist.get(i)).getId());
        }
        p_u_id.setItems(FXCollections.observableArrayList(productlist));
    }

    private void setProducttable(){
        producttable.setItems(FXCollections.observableArrayList(ProductController.getInstance().getProduct()));
        itemtable.setItems(FXCollections.observableArrayList(ProductController.getInstance().getProduct()));
        u_itemtable.setItems(FXCollections.observableArrayList(ProductController.getInstance().getProduct()));
    }

    private void setSuppliertable(){
        suppliertable.setItems(FXCollections.observableArrayList(SupplierController.getInstance().getSupplier()));
    }

    private void setProductText(String id){
        Product product =  ProductController.getInstance().SearchProduct(id);
        p_u_category.setValue(product.getCategory());
        p_u_supplier.setValue(product.getSupplier());
        p_u_name.setText(product.getName());
        p_u_price.setText(product.getPrice()+"");
        p_u_qty.setText(product.getQty()+"");
        p_u_size.setText(product.getSize());
    }

    private void setProductText(){
        p_u_id.setValue(null);
        p_u_supplier.setValue(null);
        p_u_category.setValue(null);
        p_u_name.setText(null);
        p_u_price.setText(null);
        p_u_qty.setText(null);
        p_u_size.setText(null);
        p_supplier.setValue(null);
        p_category.setValue(null);
        p_name.setText(null);
        p_price.setText(null);
        p_qty.setText(null);
        p_size.setText(null);
    }

    private void setSuppliertext(String id){
        Supplier supplier = SupplierController.getInstance().SearchSupplier(id);
        s_u_name.setText(supplier.getName());
        s_u_company.setText(supplier.getCompany());
        s_u_contact.setText(supplier.getContact());
    }

    private void setSuppliertext(){
        s_u_id.setValue(null);
        s_u_name.setText(null);
        s_u_company.setText(null);
        s_u_contact.setText(null);
        s_name.setText(null);
        s_company.setText(null);
        s_contact.setText(null);
    }

}