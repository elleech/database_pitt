import { Component, OnInit, ViewChild, Inject } from '@angular/core';
import { MatTableDataSource, MatPaginator, MatSort, MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-spersondetail',
  templateUrl: './spersondetail.component.html',
  styleUrls: ['./spersondetail.component.css']
})
export class SpersondetailComponent implements OnInit {

  displayedColumns = ['productName', 'quantity', 'totalPrice', 'customerName', 'payDate'];
  dataSource: MatTableDataSource<any>;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;
  searchKey: any;
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
