import { Component, OnInit, Inject, ViewChild } from '@angular/core';
import { MatTableDataSource, MAT_DIALOG_DATA, MatPaginator, MatSort } from '@angular/material';

@Component({
  selector: 'app-employeedetail',
  templateUrl: './employeedetail.component.html',
  styleUrls: ['./employeedetail.component.css']
})
export class EmployeedetailComponent implements OnInit {

  displayedColumns = ['id', 'productName', 'casecommentTime', 'caseComment', 'casesSummary'];
  dataSource: MatTableDataSource<any>;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;
  searchKey: any;
  constructor(@Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit() {
    this.fetchData()
  }

  fetchData() {
    //append to outer array
    for (var key in this.data.cases) {
      for (var anotherKey in this.data.cases[key].casecomment) {
        this.data.cases[key]['casecommentTime'] = this.data.cases[key].casecomment[anotherKey].time;
        this.data.cases[key]['caseComment'] = this.data.cases[key].casecomment[anotherKey].comment;
        this.data.cases[key]['casesSummary'] = this.data.cases[key].casecomment[anotherKey].casesSummary;
      }
      
      console.log(this.data.cases)
    } 
    this.dataSource = new MatTableDataSource(this.data.cases);
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  onSearchClear(){
    this.searchKey ="";
    this.applyFliter();
  } 

  applyFliter(){
    this.dataSource.filter = this.searchKey.trim().toLowerCase();
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
}
