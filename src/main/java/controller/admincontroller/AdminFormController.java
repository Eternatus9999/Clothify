package controller.admincontroller;


import controller.EmployeeController;
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
import model.Employee;
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
    private Employee deleteemployee;

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
    private ComboBox<String> e_u_id;

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
    private ComboBox<String> salesreporttype;

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
        EmployeeController.getInstance().AddEmployee(e_name.getText(),e_email.getText(),e_address.getText(),e_password.getText(),e_re_password.getText(),e_contact.getText());
        setEmployeetext();
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
    void DeleteEmployeeOnAction(ActionEvent event) {
        if(deleteemployee!=null){
            EmployeeController.getInstance().DeleteEmployee(deleteemployee);
            setEmployeetable();
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

        SetProductChart();
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

        SetSupplierChart();
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

        setEmployee();
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

        setEmployeetable();
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
        EmployeeController.getInstance().UpdateEmployee(e_u_name.getText(),e_u_email.getText(),e_u_address.getText(),e_u_password.getText(),e_u_re_password.getText(),e_u_contact.getText());
        setEmployeetext();
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

                setProductText();
                p_id.setText(ProductController.getInstance().GenerateId());
            }
        }
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

        e_id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        e_address_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        e_contact_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        e_email_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        e_name_col.setCellValueFactory(new PropertyValueFactory<>("id"));

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

        employeetable.getSelectionModel().selectedItemProperty().addListener(((observableValue, o, t1) ->{
            if(t1!=null){
                deleteemployee = (Employee) t1;
            }
        }));

        s_u_id.getSelectionModel().selectedItemProperty().addListener(((observableValue, o, t1) ->{
            if(t1!=null){
                setSuppliertext(t1);
            }
        }));

        e_u_id.getSelectionModel().selectedItemProperty().addListener(((observableValue, o, t1) ->{
            if(t1!=null){
                setEmployeetext(t1);
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

    private void setEmployee(){
        List<String> employeelist = new ArrayList<>();
        List<Employee> employeeentitylist = EmployeeController.getInstance().GetEmployee();
        for (int i = 0; i <employeeentitylist.size(); i++){
            employeelist.add((employeeentitylist.get(i)).getId());
        }
        e_u_id.setItems(FXCollections.observableArrayList(employeelist));

    }

    private void setProducttable(){
        producttable.setItems(FXCollections.observableArrayList(ProductController.getInstance().getProduct()));
    }

    private void setEmployeetable(){
        employeetable.setItems(FXCollections.observableArrayList(EmployeeController.getInstance().GetEmployee()));
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

    private void setEmployeetext(String id){
        Employee employee = EmployeeController.getInstance().SearchEmployee(id);
        e_u_name.setText(employee.getName());
        e_u_address.setText(employee.getAddress());
        e_u_contact.setText(employee.getPhone());
        e_u_email.setText(employee.getEmail());
    }

    private void setEmployeetext(){
        e_u_name.setText(null);
        e_u_address.setText(null);
        e_u_contact.setText(null);
        e_u_email.setText(null);
        e_u_password.setText(null);
        e_u_re_password.setText(null);
        e_name.setText(null);
        e_address.setText(null);
        e_contact.setText(null);
        e_email.setText(null);
        e_password.setText(null);
        e_re_password.setText(null);
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

    }

}
