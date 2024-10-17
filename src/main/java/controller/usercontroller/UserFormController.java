package controller.usercontroller;

import controller.EmployeeController;
import controller.OrderController;
import controller.ProductController;
import controller.SupplierController;
import controller.maincontroller.MainController;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import model.Order;
import model.OrderDetails;
import model.Product;
import model.Supplier;
import util.CreatePdf;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserFormController implements Initializable {

    private Product deleteproduct;
    private Supplier deletesupplier;
    private OrderDetails addproduct;
    private OrderDetails deleteitem;
    private Order deleteorder;

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
    private TextField o_u_email;

    @FXML
    private TextField o_email;

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
    private TableColumn o_total_price_col;

    @FXML
    private TableColumn o_date_col;

    @FXML
    private TextField discount;

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
        additem(1);
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
           if(ProductController.getInstance().AddProduct(
                    p_id.getText(),
                    p_name.getText(),
                    p_size.getText(),
                    p_supplier.getValue(),
                    p_qty.getText(),
                    p_price.getText(),
                    p_category.getValue())){

               setProductText();
               p_id.setText(ProductController.getInstance().GenerateId());
           }
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
        if(deleteorder!=null){
            UserController.getInstance().DeleteOrder(deleteorder);
            setOrdertable();
            new Alert(Alert.AlertType.INFORMATION,"Order Delete Successfully").showAndWait();
        }
        else{
            new Alert(Alert.AlertType.ERROR,"Select an Order to delete!").showAndWait();
        }
    }

    @FXML
    void DeleteProductOnAction(ActionEvent event) {
        if(deleteproduct!=null){
            ProductController.getInstance().DeleteProduct(deleteproduct);
            setProducttable();
        }
    }

    @FXML
    void DeleteSupplierOnAction(ActionEvent event) {
        if(deletesupplier!=null){
            SupplierController.getInstance().DeleteSupplier(deletesupplier);
            setSuppliertable();
        }
    }

    @FXML
    void DownloadEROnAction(ActionEvent event) {
        String text = EmployeeController.getInstance().GetReport();
        new CreatePdf().create(text,"EmployeeReport");
        new Alert(Alert.AlertType.INFORMATION,"EmployeeReport Downloaded!").showAndWait();
    }

    @FXML
    void DownloadPROnAction(ActionEvent event) {
        String text = ProductController.getInstance().GetReport();
        new CreatePdf().create(text,"ProductReport");
        new Alert(Alert.AlertType.INFORMATION,"ProductReport Downloaded!").showAndWait();
    }

    @FXML
    void DownloadSROnAction(ActionEvent event) {
        String text = SupplierController.getInstance().GetReport();
        new CreatePdf().create(text, "SupplierReport");
        new Alert(Alert.AlertType.INFORMATION,"ProductReport Downloaded!").showAndWait();
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

        setProducttable();
        setProductText();
        setUpdateProductText();
        setSuppliertext();
        setUpdateSuppliertext();
        setUpdateOrdertext();
        o_id.setText(OrderController.getInstance().GenerateId());
        additem(-1);
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
        setUpdateProductText();
        setSuppliertext();
        setUpdateSuppliertext();
        setOrdertext();
        setUpdateOrdertext();
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

        setProductText();
        setUpdateProductText();
        setUpdateSuppliertext();
        setOrdertext();
        setUpdateOrdertext();

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

        SetEmployeeChart();
        setProductText();
        setUpdateProductText();
        setSuppliertext();
        setUpdateSuppliertext();
        setOrdertext();
        setUpdateOrdertext();
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

        SetProductChart();
        setProductText();
        setUpdateProductText();
        setSuppliertext();
        setUpdateSuppliertext();
        setOrdertext();
        setUpdateOrdertext();
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

        SetSupplierChart();
        setProductText();
        setUpdateProductText();
        setSuppliertext();
        setUpdateSuppliertext();
        setOrdertext();
        setUpdateOrdertext();
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

        setOrdertable();
        setProducttable();
        setProductText();
        setUpdateProductText();
        setSuppliertext();
        setUpdateSuppliertext();
        setOrdertext();
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

        setCategory();
        setSupplier();
        setProduct();
        setProductText();
        setSuppliertext();
        setUpdateSuppliertext();
        setOrdertext();
        setUpdateOrdertext();
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
        setProductText();
        setUpdateProductText();
        setSuppliertext();
        setOrdertext();
        setUpdateOrdertext();
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

        setOrdertable();
        setProductText();
        setUpdateProductText();
        setSuppliertext();
        setUpdateSuppliertext();
        setOrdertext();
        setUpdateOrdertext();
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
        setProductText();
        setUpdateProductText();
        setSuppliertext();
        setUpdateSuppliertext();
        setOrdertext();
        setUpdateOrdertext();
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
        setProductText();
        setUpdateProductText();
        setSuppliertext();
        setUpdateSuppliertext();
        setOrdertext();
        setUpdateOrdertext();
    }

    @FXML
    void PlaceOrderOnAction(ActionEvent event) {
        if(o_paymenttype.getValue()==null){
            new Alert(Alert.AlertType.ERROR,"Select a Payment Method").showAndWait();
        }
        else{
            if(UserController.getInstance().PlaceOrder(new Order(
                            o_id.getText(),
                            o_name.getText(),
                            o_email.getText(),
                            o_paymenttype.getValue(),
                            Double.parseDouble(totalprice.getText()),
                            0,
                            UserController.getInstance().getDate(),
                            UserController.employee
                    ),cart.getItems()
            )){
                new Alert(Alert.AlertType.INFORMATION,"Order placed successfully").showAndWait();
                additem(-1);
                totalprice.setText(0+"");
                o_name.setText(null);
                o_paymenttype.setValue(null);
                o_email.setText(null);
                setProducttable();
                o_id.setText(OrderController.getInstance().GenerateId());
            }
            else{
                new Alert(Alert.AlertType.ERROR,"Order didn't placed successfully").showAndWait();
            }
        }
    }

    @FXML
    void RemoveItemOnAction(ActionEvent event) {
        removeItem();
    }

    @FXML
    void UpdateAddItemOnAction(ActionEvent event) {
        addupdateitem(1);
    }

    @FXML
    void UpdateOrderOnAction(ActionEvent event) {
        if(o_u_paymenttype.getValue()==null){
            new Alert(Alert.AlertType.ERROR,"Select a Payment Method").showAndWait();
        }
        else{
            UserController.getInstance().DeleteOrder(OrderController.getInstance().SearchOrder(o_u_id.getValue()));
            if(UserController.getInstance().PlaceOrder(new Order(
                            o_u_id.getValue(),
                            o_u_name.getText(),
                            o_u_email.getText(),
                            o_u_paymenttype.getValue(),
                            Double.parseDouble(u_totalprice.getText()),
                            0,
                            UserController.getInstance().getDate(),
                            UserController.employee
                    ),u_cart.getItems()
            )){
                new Alert(Alert.AlertType.INFORMATION,"Order updated successfully").showAndWait();
                additem(-1);
                u_totalprice.setText(0+"");
                o_u_name.setText(null);
                o_u_paymenttype.setValue(null);
                o_u_id.setValue(null);
                o_u_email.setText(null);
                setProducttable();
            }
            else{
                new Alert(Alert.AlertType.ERROR,"Order didn't updated successfully").showAndWait();
            }
        }
    }

    @FXML
    void UpdateProductOnAction(ActionEvent event) {
        if(p_supplier.getValue()==null) {
            new Alert(Alert.AlertType.ERROR,"Select a Supplier").showAndWait();
        }
        else if(p_category.getValue()==null){
            new Alert(Alert.AlertType.ERROR,"Select a Category").showAndWait();
        }
        else{
            if(ProductController.getInstance().UpdateProduct(
                    p_id.getText(),
                    p_name.getText(),
                    p_size.getText(),
                    p_supplier.getValue(),
                    p_qty.getText(),
                    p_price.getText(),
                    p_category.getValue())){

                setUpdateProductText();
                p_id.setText(ProductController.getInstance().GenerateId());
            }
        }

    }

    @FXML
    void UpdateRemoveItemOnAction(ActionEvent event) {
        removeupdateItem();
    }

    @FXML
    void UpdateSupplierOnAction(ActionEvent event) {
        if(s_u_id.getValue()!=null){
            SupplierController.getInstance().UpdateSupplier(
                    s_u_id.getValue(),
                    s_u_name.getText(),
                    s_u_company.getText(),
                    s_u_contact.getText()
            );
        setSuppliertext();
        }
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

        o_id_col.setCellValueFactory(new PropertyValueFactory<>("orid"));
        o_name_col.setCellValueFactory(new PropertyValueFactory<>("custname"));
        o_paymenttype_col.setCellValueFactory(new PropertyValueFactory<>("paymenttype"));
        o_total_price_col.setCellValueFactory(new PropertyValueFactory<>("total"));
        o_date_col.setCellValueFactory(new PropertyValueFactory<>("date"));

        s_id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        s_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        s_company_col.setCellValueFactory(new PropertyValueFactory<>("company"));
        s_contact_col.setCellValueFactory(new PropertyValueFactory<>("contact"));

        producttable.getSelectionModel().selectedItemProperty().addListener(((observableValue, o, t1) ->{
            if(t1!=null){
                deleteproduct = t1;
            }
        }));

        u_cart.getSelectionModel().selectedItemProperty().addListener(((observableValue, o, t1) ->{
            if(t1!=null){
                deleteitem = (OrderDetails)t1;
            }
        }));

        cart.getSelectionModel().selectedItemProperty().addListener(((observableValue, o, t1) ->{
            if(t1!=null){
                deleteitem = (OrderDetails)t1;
            }
        }));

        p_u_id.getSelectionModel().selectedItemProperty().addListener(((observableValue, o, t1) ->{
            if(t1!=null){
                setProductText(t1);
            }
        }));

        itemtable.getSelectionModel().selectedItemProperty().addListener(((observableValue, o, t1) ->{
            if(t1!=null){
                Product temp = (Product)t1;
                addproduct = new OrderDetails(temp.getId(),temp.getName(),o_id.getText(),temp.getQty(),temp.getPrice());
            }
        }));

        u_itemtable.getSelectionModel().selectedItemProperty().addListener(((observableValue, o, t1) ->{
            if(t1!=null){
                Product temp = (Product)t1;
                addproduct = new OrderDetails(temp.getId(),temp.getName(),o_id.getText(),temp.getQty(),temp.getPrice());
            }
        }));

        d_ordertable.getSelectionModel().selectedItemProperty().addListener(((observableValue, o, t1) ->{
            if(t1!=null){
                deleteorder = (Order) t1;
            }
        }));

        o_u_id.getSelectionModel().selectedItemProperty().addListener(((observableValue, o, t1) ->{
            if(t1!=null){
                setOrderDetails(t1);
            }
        }));

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
        setProducttable();
        setPaymentType();
        o_id.setText(OrderController.getInstance().GenerateId());

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
        p_supplier.setValue(null);
        p_category.setValue(null);
        p_name.setText(null);
        p_price.setText(null);
        p_qty.setText(null);
        p_size.setText(null);
    }

    private void setUpdateProductText(){
        p_u_id.setValue(null);
        p_u_supplier.setValue(null);
        p_u_category.setValue(null);
        p_u_name.setText(null);
        p_u_price.setText(null);
        p_u_qty.setText(null);
        p_u_size.setText(null);
    }

    private void setSuppliertext(String id){
        Supplier supplier = SupplierController.getInstance().SearchSupplier(id);
        s_u_name.setText(supplier.getName());
        s_u_company.setText(supplier.getCompany());
        s_u_contact.setText(supplier.getContact());
    }

    private void setSuppliertext(){
        s_name.setText(null);
        s_company.setText(null);
        s_contact.setText(null);
    }

    private void setUpdateSuppliertext(){
        s_u_id.setValue(null);
        s_u_name.setText(null);
        s_u_company.setText(null);
        s_u_contact.setText(null);
    }

    private void setOrdertext(){
        o_email.setText(null);
        o_paymenttype.setValue(null);
        o_name.setText(null);
        qty.setText(null);
        discount.setText(null);
        totalprice.setText(null);
    }

    private void setUpdateOrdertext(){
        o_u_email.setText(null);
        o_u_paymenttype.setValue(null);
        o_u_id.setValue(null);
        o_u_name.setText(null);
        u_qty.setText(null);
        u_discount.setText(null);
        u_totalprice.setText(null);
    }

    private void setPaymentType(){
        List<String> list = new ArrayList<>();
        list.add("Credit Card");
        list.add("Debit Card");
        list.add("Cash");
        o_paymenttype.setItems(FXCollections.observableArrayList(list));
        o_u_paymenttype.setItems(FXCollections.observableArrayList(list));
    }

    private void additem(int i){
        if(i == -1){
            cart.setItems(FXCollections.observableArrayList());
            cart.refresh();
            OrderController.getInstance().getCart(-1);
        }else {
            if (addproduct==null) {
                new Alert(Alert.AlertType.ERROR,"Select a Product to add").showAndWait();
            } else {
                List<OrderDetails> cartlist = OrderController.getInstance().getCart();
                if (qty.getText()==null||(qty.getText()).isEmpty() || qty.getText().equals("0") ){
                    new Alert(Alert.AlertType.ERROR, "Enter a qty").showAndWait();
                } else if (Integer.parseInt(qty.getText()) > addproduct.getQty()) {
                    new Alert(Alert.AlertType.ERROR, "Not enough qty").showAndWait();
                } else {
                    addproduct.setQty(Integer.parseInt(qty.getText()));
                    addproduct.setPrice(addproduct.getQty()*addproduct.getPrice());
                    addproduct.setDiscount(Integer.parseInt((discount.getText() == null ||discount.getText().isEmpty())?"0":discount.getText()));
                    cartlist.add(addproduct);
                    cart.setItems(FXCollections.observableArrayList(cartlist));
                    OrderController.getInstance().setTotal(addproduct.getPrice()-addproduct.getDiscount());
                    totalprice.setText(OrderController.getInstance().getTotal());
                    addproduct = null;
                    discount.setText(null);
                    qty.setText(null);
                }
            }
        }
    }

    private void addupdateitem(int i){
        if(i == -1){
            u_cart.setItems(FXCollections.observableArrayList());
            u_cart.refresh();
            OrderController.getInstance().getCart(-1);
        }else {
            if (addproduct==null) {
                new Alert(Alert.AlertType.ERROR,"Select a Product to add").showAndWait();
            } else {
                List<OrderDetails> cartlist = OrderController.getInstance().getCart();
                if (u_qty.getText()==null||(u_qty.getText()).isEmpty() || u_qty.getText().equals("0") ){
                    new Alert(Alert.AlertType.ERROR, "Enter a qty").showAndWait();
                } else if (Integer.parseInt(u_qty.getText()) > addproduct.getQty()) {
                    new Alert(Alert.AlertType.ERROR, "Not enough qty").showAndWait();
                } else {
                    addproduct.setQty(Integer.parseInt(u_qty.getText()));
                    addproduct.setPrice(addproduct.getQty()*addproduct.getPrice());
                    addproduct.setDiscount(Integer.parseInt((u_discount.getText() == null ||u_discount.getText().isEmpty())?"0":u_discount.getText()));
                    cartlist.add(addproduct);
                    u_cart.setItems(FXCollections.observableArrayList(cartlist));
                    OrderController.getInstance().setTotal(addproduct.getPrice()-addproduct.getDiscount());
                    u_totalprice.setText(OrderController.getInstance().getTotal());
                    addproduct = null;
                    u_discount.setText(null);
                    u_qty.setText(null);
                }
            }
        }
    }

    private void removeItem(){
        if(deleteitem==null){
            new Alert(Alert.AlertType.ERROR,"Select an Item to remove").showAndWait();
        }else {
            List<OrderDetails> cartlist = OrderController.getInstance().getCart();
            cartlist.remove(deleteitem);
            OrderController.getInstance().setTotal((deleteitem.getPrice()-deleteitem.getDiscount())*-1);
            totalprice.setText(OrderController.getInstance().getTotal());
            deleteitem =null;
            cart.setItems(FXCollections.observableArrayList(cartlist));
        }
    }

    private void removeupdateItem(){
        if(deleteitem==null){
            new Alert(Alert.AlertType.ERROR,"Select an Item to remove").showAndWait();
        }else {
            List<OrderDetails> cartlist = OrderController.getInstance().getCart();
            cartlist.remove(deleteitem);
            OrderController.getInstance().setTotal(deleteitem.getPrice()*-1);
            u_totalprice.setText(OrderController.getInstance().getTotal());
            deleteitem =null;
            u_cart.setItems(FXCollections.observableArrayList(cartlist));
        }
    }

    private void setOrdertable(){
        List<Order> list = FXCollections.observableArrayList(OrderController.getInstance().getOrder());
        List<String> idlist = new ArrayList<>();
        d_ordertable.setItems(FXCollections.observableArrayList(OrderController.getInstance().getOrder()));
        list.forEach(order -> {
            idlist.add(order.getOrid());
        });
        o_u_id.setItems(FXCollections.observableArrayList(idlist));
    }

    private void setOrderDetails(String id){
        Order order = OrderController.getInstance().SearchOrder(id);
        o_u_name.setText(order.getCustname());
        o_u_paymenttype.setValue(order.getPaymenttype());
        u_totalprice.setText(order.getTotal()+"");
        o_u_email.setText(order.getCustemail());
        u_cart.setItems(FXCollections.observableArrayList(OrderController.getInstance().getorderdetails(order.getOrid())));
    }

    private void SetProductChart(){
        productreportpiechart.getData().clear();
        double ladies = ProductController.getInstance().getData("Ladies");
        double gents = ProductController.getInstance().getData("Gents");
        double kids = ProductController.getInstance().getData("Kids");

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Ladies",ladies),
                new PieChart.Data("Gents",gents),
                new PieChart.Data("Kids",kids)
        );
        pieChartData.forEach(data -> {
            data.nameProperty().bind(
                    Bindings.concat(
                            data.getName()," amount: ",data.pieValueProperty()
                    )
            );
        });
        productreportpiechart.getData().addAll(pieChartData);
    }

    private void SetSupplierChart(){
        supplierpiechart.getData().clear();
        double ladies = ProductController.getInstance().getSupplierData("Ladies");
        double gents = ProductController.getInstance().getSupplierData("Gents");
        double kids = ProductController.getInstance().getSupplierData("Kids");

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Ladies",ladies),
                new PieChart.Data("Gents",gents),
                new PieChart.Data("Kids",kids)
        );
        pieChartData.forEach(data -> {
            data.nameProperty().bind(
                    Bindings.concat(
                            data.getName()," amount: ",data.pieValueProperty()
                    )
            );
        });
        supplierpiechart.getData().addAll(pieChartData);
    }

    private void SetEmployeeChart(){
        employeereportpiechart.getData().clear();

        List<PieChart.Data> list = EmployeeController.getInstance().getEmployeeData();

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(list);
        pieChartData.forEach(data -> {
            data.nameProperty().bind(
                    Bindings.concat(
                            data.getName()," amount: ",data.pieValueProperty()
                    )
            );
        });
        employeereportpiechart.getData().addAll(pieChartData);
    }

}