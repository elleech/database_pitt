import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Customer } from './dashboard/customercreate/Customer';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json', observe: 'response' })
};
@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  private rootUrl = "http://localhost:8080/api/";
  constructor(private http: HttpClient) {
  }

  getCustomerList() {
    return this.http.get(this.rootUrl + "customer");
  }  

  createCustomer(customer: Customer) {
    return this.http.post<Customer>(this.rootUrl + "customer", customer, httpOptions);
  }

  editCustomer(newcustomer) {
    return this.http.post(this.rootUrl + "customer", newcustomer, httpOptions);
  }

  getSalePersonList() {
    return this.http.get(this.rootUrl + "salesperson");
  }

  createSales(sales) {
    return this.http.post(this.rootUrl + "salesperson", sales, httpOptions);
  }

  getSaleProductList() {
    return this.http.get(this.rootUrl + "product");
  }

  createProduct(product) {
    return this.http.post(this.rootUrl + "product", product, httpOptions);
  }

  getBuyList() {
    return this.http.get(this.rootUrl + "buy");
  }

  //@PostMapping("{customerId}/{productId}/{salespersonId}/buy")
  createBuy(customerId, productId, salespersonId, body) {
    return this.http.post(this.rootUrl + customerId + "/" + productId + "/" + salespersonId + "/buy", body, httpOptions);
  }

  getCasesList() {
    return this.http.get(this.rootUrl + "cases");
  }
  // @PostMapping("/{buyId}/{employeeId}/cases") 
  createCases(buyId, employeeId, body) {
    return this.http.post(this.rootUrl + buyId + "/" + employeeId + "/cases", body, httpOptions);
  }

  editCase(productId, employeeId, body) {
    return this.http.post(this.rootUrl + productId + "/" + employeeId + "/cases", body, httpOptions);
  }

  getEmployeeList() {
    return this.http.get(this.rootUrl + "employee");
  }

  createEmployee(employee) {
    return this.http.post(this.rootUrl + "employee", employee, httpOptions);
  }

  getCaesCommentList() {
    return this.http.get(this.rootUrl + "casecomment");
  }

  //@PostMapping("/{casesId}/casecomment")
  createCaseComment(casesId, body) {
    return this.http.post(this.rootUrl + casesId + "/casecomment", body, httpOptions);
  }

  getResolutionList() {
    return this.http.get(this.rootUrl + "resolution");
  }

  // @PostMapping("/{productId}/resolution")
  createResolution(productId, body) {
    return this.http.post(this.rootUrl + productId + "/resolution", body, httpOptions);
  }

}
