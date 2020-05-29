import { Component, OnInit, ViewChild } from '@angular/core';
import { DashboardService } from '../dashboard.service';
import { MatTableDataSource, MatPaginator, MatSort, MatDialogConfig, MatDialog, MatTableModule } from '@angular/material';
import { CustomerdetailComponent } from './customerdetail/customerdetail.component';
import { CustomercreateComponent } from './customercreate/customercreate.component';
import { CustomereditComponent } from './customeredit/customeredit.component';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  displayedColumns = ['id', 'lastname', 'email', 'address', 'phone', 'company','grossannualincome', 'action'];
  dataSource: MatTableDataSource<any>;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;
  searchKey: any;


  constructor(private dashboardService: DashboardService, private dialog: MatDialog) { }

  ngOnInit() {
    this.fetchData()
  }

  fetchData() {
    this.dashboardService.getCustomerList().subscribe(res => {
      let result: any = res
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
    const dialogRef = this.dialog.open(CustomercreateComponent, dialogConfig);
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.fetchData();
      }
    });
  }


  onDetail(row: any) {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = false;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "65%";
    dialogConfig.data = row
    this.dialog.open(CustomerdetailComponent, dialogConfig);
  }

  onEdit(row: any) {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = false;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "65%";
    dialogConfig.data = row
    const dialogRef = this.dialog.open(CustomereditComponent, dialogConfig);
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.fetchData();
      }
    });
  }

  onSearchClear() {
    this.searchKey = "";
    this.applyFliter();
  }

  applyFliter() {
    this.dataSource.filter = this.searchKey.trim().toLowerCase();
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

} 
