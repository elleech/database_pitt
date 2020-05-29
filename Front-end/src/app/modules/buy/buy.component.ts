import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog, MatPaginator, MatTableDataSource, MatSort, MatDialogConfig } from '@angular/material';
import { DashboardService } from '../dashboard.service';
import { BuycreateComponent } from './buycreate/buycreate.component';

@Component({ 
  selector: 'app-buy',
  templateUrl: './buy.component.html',
  styleUrls: ['./buy.component.css']
})
export class BuyComponent implements OnInit {

  searchKey:string;
  displayedColumns = ['id', 'productName', 'quantity', 'totalPrice','payDate', 'customerName', 'salespersonName'];
  dataSource: MatTableDataSource<any>;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;


  constructor(private dashboardService: DashboardService, private dialog: MatDialog) { }

  ngOnInit() { 
    this.fetchData()
  } 

  fetchData() {
    this.dashboardService.getBuyList().subscribe(res => {
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
    const dialogRef = this.dialog.open(BuycreateComponent, dialogConfig);
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
