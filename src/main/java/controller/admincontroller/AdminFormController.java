package controller.admincontroller;


import controller.ProductController;
import controller.SupplierController;
import controller.maincontroller.MainController;
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

public class AdminFormController implements Initializable {

    private Product deleteproduct;
    private Supplier deletesupplier;

    @FXML
    private AnchorPane addemployeeform;

    @FXML
    private AnchorPane addproductform;

    @FXML
    private AnchorPane addsupplierform;

    @FXML
    private AnchorPane deleteemployeeform;

    @FXML
    private AnchorPane deleteproductform;

    @FXML
    private AnchorPane deletesupplierform;

    @FXML
    private TextField e_address;

    @FXML
    private TableColumn e_address_col;

    @FXML
    private TextField e_contact;

    @FXML
    private TableColumn e_contact_col;

    @FXML
    private TextField e_email;

    @FXML
    private TableColumn e_email_col;

    @FXML
    private TextField e_id;

    @FXML
    private TableColumn e_id_col;

    @FXML
    private TextField e_name;

    @FXML
    private TableColumn e_name_col;

    @FXML
    private TextField e_password;

    @FXML
    private TextField e_re_password;

    @FXML
    private TextField e_u_address;

    @FXML
    private TextField e_u_contact;

    @FXML
    private TextField e_u_email;

    @FXML
    private ComboBox<?> e_u_id;

    @FXML
    private TextField e_u_name;

    @FXML
    private TextField e_u_password;

    @FXML
    private TextField e_u_re_password;

    @FXML
    private AnchorPane employeereportform;

    @FXML
    private AnchorPane salesreportform;

    @FXML
    private PieChart employeereportpiechart;

    @FXML
    private TableView employeetable;

    @FXML
    private ComboBox p_category;

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
    private TableColumn p_priice_col;

    @FXML
    private TextField p_qty;

    @FXML
    private TableColumn p_qty_col;

    @FXML
    private TextField p_size;

    @FXML
    private TableColumn p_size_col;

    @FXML
    private ComboBox p_supplier;

    @FXML
    private TableColumn p_supplier_col;

    @FXML
    private ComboBox p_u_category;

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
    private ComboBox p_u_supplier;

    @FXML
    private AnchorPane productreportform;

    @FXML
    private PieChart productreportpiechart;

    @FXML
    private TableView<Product> producttable;

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
    private PieChart salesreportchart;

    @FXML
    private ComboBox salesreporttype;

    @FXML
    private PieChart supplierpiechart;

    @FXML
    private AnchorPane supplierreportform;

    @FXML
    private TableView<Supplier> suppliertable;

    @FXML
    private AnchorPane updateemployeeform;

    @FXML
    private AnchorPane updateproductform;

    @FXML
    private AnchorPane updatesupplierform;

    @FXML
    void AddEmployeeOnAction(ActionEvent event) {

    }

    @FXML
    void AddProductOnAction(ActionEvent event) {
        setProductText();
    }

    @FXML
    void AddSupplierOnAction(ActionEvent event) {
        setSuppliertext();
    }

    @FXML
    void BackOnAction(ActionEvent event) throws IOException {
        Stage stage = MainController.stage;
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../view/main_form.fxml"))));
        stage.setFullScreen(false);
    }

    @FXML
    void DeleteEmployeeOnAction(ActionEvent event) {

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
    void DownloadSsROnAction(ActionEvent event) {

    }

    @FXML
    void NavAddEmployeeOnAction(ActionEvent event) {
        addemployeeform.setVisible(true);
        addproductform.setVisible(false);
        addsupplierform.setVisible(false);
        updateemployeeform.setVisible(false);
        updateproductform.setVisible(false);
        updatesupplierform.setVisible(false);
        deleteemployeeform.setVisible(false);
        deleteproductform.setVisible(false);
        deletesupplierform.setVisible(false);
        employeereportform.setVisible(false);
        productreportform.setVisible(false);
        supplierreportform.setVisible(false);
        salesreportform.setVisible(false);
    }

    @FXML
    void NavAddProductOnAction(ActionEvent event) {
        addemployeeform.setVisible(false);
        addproductform.setVisible(true);
        addsupplierform.setVisible(false);
        updateemployeeform.setVisible(false);
        updateproductform.setVisible(false);
        updatesupplierform.setVisible(false);
        deleteemployeeform.setVisible(false);
        deleteproductform.setVisible(false);
        deletesupplierform.setVisible(false);
        employeereportform.setVisible(false);
        productreportform.setVisible(false);
        supplierreportform.setVisible(false);
        salesreportform.setVisible(false);

        setCategory();
        setSupplier();
    }

    @FXML
    void NavAddSupplierOnAction(ActionEvent event) {
        addemployeeform.setVisible(false);
        addproductform.setVisible(false);
        addsupplierform.setVisible(true);
        updateemployeeform.setVisible(false);
        updateproductform.setVisible(false);
        updatesupplierform.setVisible(false);
        deleteemployeeform.setVisible(false);
        deleteproductform.setVisible(false);
        deletesupplierform.setVisible(false);
        employeereportform.setVisible(false);
        productreportform.setVisible(false);
        supplierreportform.setVisible(false);
        salesreportform.setVisible(false);
    }

    @FXML
    void NavEmployeeReportOnAction(ActionEvent event) {
        addemployeeform.setVisible(false);
        addproductform.setVisible(false);
        addsupplierform.setVisible(false);
        updateemployeeform.setVisible(false);
        updateproductform.setVisible(false);
        updatesupplierform.setVisible(false);
        deleteemployeeform.setVisible(false);
        deleteproductform.setVisible(false);
        deletesupplierform.setVisible(false);
        employeereportform.setVisible(true);
        productreportform.setVisible(false);
        supplierreportform.setVisible(false);
        salesreportform.setVisible(false);
    }

    @FXML
    void NavProductReportOnAction(ActionEvent event) {
        addemployeeform.setVisible(false);
        addproductform.setVisible(false);
        addsupplierform.setVisible(false);
        updateemployeeform.setVisible(false);
        updateproductform.setVisible(false);
        updatesupplierform.setVisible(false);
        deleteemployeeform.setVisible(false);
        deleteproductform.setVisible(false);
        deletesupplierform.setVisible(false);
        employeereportform.setVisible(false);
        productreportform.setVisible(true);
        supplierreportform.setVisible(false);
        salesreportform.setVisible(false);
    }

    @FXML
    void NavSalesReportOnAction(ActionEvent event) {
        addemployeeform.setVisible(false);
        addproductform.setVisible(false);
        addsupplierform.setVisible(false);
        updateemployeeform.setVisible(false);
        updateproductform.setVisible(false);
        updatesupplierform.setVisible(false);
        deleteemployeeform.setVisible(false);
        deleteproductform.setVisible(false);
        deletesupplierform.setVisible(false);
        employeereportform.setVisible(false);
        productreportform.setVisible(false);
        supplierreportform.setVisible(false);
        salesreportform.setVisible(true);
    }

    @FXML
    void NavSupplierReportOnAction(ActionEvent event) {
        addemployeeform.setVisible(false);
        addproductform.setVisible(false);
        addsupplierform.setVisible(false);
        updateemployeeform.setVisible(false);
        updateproductform.setVisible(false);
        updatesupplierform.setVisible(false);
        deleteemployeeform.setVisible(false);
        deleteproductform.setVisible(false);
        deletesupplierform.setVisible(false);
        employeereportform.setVisible(false);
        productreportform.setVisible(false);
        supplierreportform.setVisible(true);
        salesreportform.setVisible(false);
    }

    @FXML
    void NavUpdateEmployeeOnAction(ActionEvent event) {
        addemployeeform.setVisible(false);
        addproductform.setVisible(false);
        addsupplierform.setVisible(false);
        updateemployeeform.setVisible(true);
        updateproductform.setVisible(false);
        updatesupplierform.setVisible(false);
        deleteemployeeform.setVisible(false);
        deleteproductform.setVisible(false);
        deletesupplierform.setVisible(false);
        employeereportform.setVisible(false);
        productreportform.setVisible(false);
        supplierreportform.setVisible(false);
        salesreportform.setVisible(false);
    }

    @FXML
    void NavUpdateProductOnAction(ActionEvent event) {
        addemployeeform.setVisible(false);
        addproductform.setVisible(false);
        addsupplierform.setVisible(false);
        updateemployeeform.setVisible(false);
        updateproductform.setVisible(true);
        updatesupplierform.setVisible(false);
        deleteemployeeform.setVisible(false);
        deleteproductform.setVisible(false);
        deletesupplierform.setVisible(false);
        employeereportform.setVisible(false);
        productreportform.setVisible(false);
        supplierreportform.setVisible(false);
        salesreportform.setVisible(false);

        setCategory();
        setSupplier();
        setProduct();
    }

    @FXML
    void NavUpdateSupplierOnAction(ActionEvent event) {
        addemployeeform.setVisible(false);
        addproductform.setVisible(false);
        addsupplierform.setVisible(false);
        updateemployeeform.setVisible(false);
        updateproductform.setVisible(false);
        updatesupplierform.setVisible(true);
        deleteemployeeform.setVisible(false);
        deleteproductform.setVisible(false);
        deletesupplierform.setVisible(false);
        employeereportform.setVisible(false);
        productreportform.setVisible(false);
        supplierreportform.setVisible(false);
        salesreportform.setVisible(false);

        setSupplier();
    }

    @FXML
    void NavViewEmployeeOnAction(ActionEvent event) {
        addemployeeform.setVisible(false);
        addproductform.setVisible(false);
        addsupplierform.setVisible(false);
        updateemployeeform.setVisible(false);
        updateproductform.setVisible(false);
        updatesupplierform.setVisible(false);
        deleteemployeeform.setVisible(true);
        deleteproductform.setVisible(false);
        deletesupplierform.setVisible(false);
        employeereportform.setVisible(false);
        productreportform.setVisible(false);
        supplierreportform.setVisible(false);
        salesreportform.setVisible(false);


    }

    @FXML
    void NavViewProductOnAction(ActionEvent event) {
        addemployeeform.setVisible(false);
        addproductform.setVisible(false);
        addsupplierform.setVisible(false);
        updateemployeeform.setVisible(false);
        updateproductform.setVisible(false);
        updatesupplierform.setVisible(false);
        deleteemployeeform.setVisible(false);
        deleteproductform.setVisible(true);
        deletesupplierform.setVisible(false);
        employeereportform.setVisible(false);
        productreportform.setVisible(false);
        supplierreportform.setVisible(false);
        salesreportform.setVisible(false);

        setProducttable();
    }

    @FXML
    void NavViewSupplierOnAction(ActionEvent event) {
        addemployeeform.setVisible(false);
        addproductform.setVisible(false);
        addsupplierform.setVisible(false);
        updateemployeeform.setVisible(false);
        updateproductform.setVisible(false);
        updatesupplierform.setVisible(false);
        deleteemployeeform.setVisible(false);
        deleteproductform.setVisible(false);
        deletesupplierform.setVisible(true);
        employeereportform.setVisible(false);
        productreportform.setVisible(false);
        supplierreportform.setVisible(false);
        salesreportform.setVisible(false);

        setSuppliertable();
    }

    @FXML
    void UpdateEmployeeOnAction(ActionEvent event) {

    }

    @FXML
    void UpdateProductOnAction(ActionEvent event) {

    }

    @FXML
    void UpdateSupplierOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addemployeeform.setVisible(true);
        addproductform.setVisible(false);
        addsupplierform.setVisible(false);
        updateemployeeform.setVisible(false);
        updateproductform.setVisible(false);
        updatesupplierform.setVisible(false);
        deleteemployeeform.setVisible(false);
        deleteproductform.setVisible(false);
        deletesupplierform.setVisible(false);
        employeereportform.setVisible(false);
        productreportform.setVisible(false);
        supplierreportform.setVisible(false);
        salesreportform.setVisible(false);

        p_id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        p_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        p_size_col.setCellValueFactory(new PropertyValueFactory<>("size"));
        p_supplier_col.setCellValueFactory(new PropertyValueFactory<>("supplier"));
        p_qty_col.setCellValueFactory(new PropertyValueFactory<>("qty"));
        p_category_col.setCellValueFactory(new PropertyValueFactory<>("category"));



        s_id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        s_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        s_company_col.setCellValueFactory(new PropertyValueFactory<>("company"));
        s_contact_col.setCellValueFactory(new PropertyValueFactory<>("contact"));

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
