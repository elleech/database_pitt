import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatDialog, MatPaginator, MatSort, MatDialogConfig } from '@angular/material';
import { DashboardService } from '../dashboard.service';
import { ProductcreateComponent } from './productcreate/productcreate.component';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  displayedColumns = ['id', 'productname', 'description', 'price'];
  dataSource: MatTableDataSource<any>;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;
  searchKey: any;


  constructor(private dashboardService: DashboardService, private dialog: MatDialog) { }

  ngOnInit() { 
    this.fetchData()
  }  

  fetchData() {
    this.dashboardService.getSaleProductList().subscribe(res => {
      let result:any = res
      this.dataSource = new MatTableDataSource(result);
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
    })
  }

  onCreate() {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = false; 
    dialogConfig.autoFocus = true;
    dialogConfig.width = "65%";
    const dialogRef = this.dialog.open(ProductcreateComponent, dialogConfig);
        dialogRef.afterClosed().subscribe(result => {
            if (result) {
                this.fetchData();
            }
        });
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
