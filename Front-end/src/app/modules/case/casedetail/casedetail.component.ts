import { Component, OnInit, Inject, ViewChild } from '@angular/core';
import { MatTableDataSource, MatPaginator, MAT_DIALOG_DATA, MatSort } from '@angular/material';

@Component({
  selector: 'app-casedetail',
  templateUrl: './casedetail.component.html',
  styleUrls: ['./casedetail.component.css']
})
export class CasedetailComponent implements OnInit {

  displayedColumns = ['time', 'comment', 'cases_id', 'casesSummary'];
  dataSource: MatTableDataSource<any>;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;
  constructor(@Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit() {
    this.fetchData()
  } 

  fetchData() {
    console.log(this.data.casecomment)
    this.dataSource = new MatTableDataSource(this.data.casecomment);
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }
 
}
 