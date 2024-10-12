package controller.usercontroller;

import controller.maincontroller.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserFormController implements Initializable {

    @FXML
    private AnchorPane addorderform;

    @FXML
    private AnchorPane addproductform;

    @FXML
    private AnchorPane addsupplierform;

    @FXML
    private TableView<?> cart;

    @FXML
    private TableColumn<?, ?> cart_item_id_col;

    @FXML
    private TableColumn<?, ?> cart_item_name_col;

    @FXML
    private TableColumn<?, ?> cart_item_qty_col;

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
    private TableColumn<?, ?> item_category_col;

    @FXML
    private TableColumn<?, ?> item_id_col;

    @FXML
    private TableColumn<?, ?> item_name_col;

    @FXML
    private TableColumn<?, ?> item_price_col;

    @FXML
    private TableColumn<?, ?> item_qty_col;

    @FXML
    private TableView<?> itemtable;

    @FXML
    private TextField o_id;

    @FXML
    private TableColumn<?, ?> o_id_col;

    @FXML
    private TextField o_name;

    @FXML
    private TableColumn<?, ?> o_name_col;

    @FXML
    private ComboBox<?> o_paymenttype;

    @FXML
    private TableColumn<?, ?> o_paymenttype_col;

    @FXML
    private TableColumn<?, ?> o_total_price;

    @FXML
    private ComboBox<?> o_u_id;

    @FXML
    private TextField o_u_name;

    @FXML
    private ComboBox<?> o_u_paymenttype;

    @FXML
    private ComboBox<?> p_category;

    @FXML
    private TableColumn<?, ?> p_category_col;

    @FXML
    private TextField p_id;

    @FXML
    private TableColumn<?, ?> p_id_col;

    @FXML
    private TextField p_name;

    @FXML
    private TableColumn<?, ?> p_name_col;

    @FXML
    private TextField p_price;

    @FXML
    private TableColumn<?, ?> p_priice_col;

    @FXML
    private TextField p_qty;

    @FXML
    private TableColumn<?, ?> p_qty_col;

    @FXML
    private TextField p_size;

    @FXML
    private TableColumn<?, ?> p_size_col;

    @FXML
    private ComboBox<?> p_supplier;

    @FXML
    private TableColumn<?, ?> p_supplier_col;

    @FXML
    private ComboBox<?> p_u_category;

    @FXML
    private ComboBox<?> p_u_id;

    @FXML
    private TextField p_u_name;

    @FXML
    private TextField p_u_price;

    @FXML
    private TextField p_u_qty;

    @FXML
    private TextField p_u_size;

    @FXML
    private ComboBox<?> p_u_supplier;

    @FXML
    private AnchorPane productreportform;

    @FXML
    private PieChart productreportpiechart;

    @FXML
    private TableView<?> producttable;

    @FXML
    private TextField qty;

    @FXML
    private TextField s_company;

    @FXML
    private TableColumn<?, ?> s_company_col;

    @FXML
    private TextField s_contact;

    @FXML
    private TableColumn<?, ?> s_contact_col;

    @FXML
    private TextField s_id;

    @FXML
    private TableColumn<?, ?> s_id_col;

    @FXML
    private TextField s_name;

    @FXML
    private TableColumn<?, ?> s_name_col;

    @FXML
    private TextField s_u_company;

    @FXML
    private TextField s_u_contact;

    @FXML
    private ComboBox<?> s_u_id;

    @FXML
    private TextField s_u_name;

    @FXML
    private PieChart supplierpiechart;

    @FXML
    private AnchorPane supplierreportform;

    @FXML
    private TableView<?> suppliertable;

    @FXML
    private TableView<?> suppliertable1;

    @FXML
    private Label totalprice;

    @FXML
    private TableView<?> u_cart;

    @FXML
    private TableColumn<?, ?> u_cart_item_id_col;

    @FXML
    private TableColumn<?, ?> u_cart_item_name_col;

    @FXML
    private TableColumn<?, ?> u_cart_item_qty_col;

    @FXML
    private TextField u_discount;

    @FXML
    private TableColumn<?, ?> u_item_category_col;

    @FXML
    private TableColumn<?, ?> u_item_id_col;

    @FXML
    private TableColumn<?, ?> u_item_name_col;

    @FXML
    private TableColumn<?, ?> u_item_price_col;

    @FXML
    private TableColumn<?, ?> u_item_qty_col;

    @FXML
    private TableView<?> u_itemtable;

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

    }

    @FXML
    void AddSupplierOnAction(ActionEvent event) {

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

    }

    @FXML
    void DeleteSupplierOnAction(ActionEvent event) {

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

    }

    @FXML
    void UpdateItemOnAction(ActionEvent event) {

    }

    @FXML
    void UpdateSupplierOnAction(ActionEvent event) {

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
    }
}