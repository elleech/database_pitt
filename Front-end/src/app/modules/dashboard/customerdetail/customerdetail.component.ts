import { Component, OnInit, Inject, ViewChild } from '@angular/core';
import { MAT_DIALOG_DATA, MatPaginator, MatSort, MatTableDataSource } from '@angular/material';

@Component({
  selector: 'app-customerdetail',
  templateUrl: './customerdetail.component.html',
  styleUrls: ['./customerdetail.component.css']
})
export class CustomerdetailComponent implements OnInit {

  displayedColumns = ['productName', 'quantity', 'totalPrice', 'salespersonName', 'payDate'];
  dataSource: MatTableDataSource<any>;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;
  constructor(@Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit() {
    this.fetchData()
  }

  fetchData() {
    console.log(this.data.buy)
    this.dataSource = new MatTableDataSource(this.data.buy);
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

}
