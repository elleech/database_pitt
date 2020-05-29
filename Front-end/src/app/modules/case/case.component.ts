import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatDialog, MatSort, MatPaginator, MatDialogConfig } from '@angular/material';
import { DashboardService } from '../dashboard.service';
import { CasedetailComponent } from './casedetail/casedetail.component';
import { CasecreateComponent } from './casecreate/casecreate.component';
import { CaseeditComponent } from './caseedit/caseedit.component';

@Component({
  selector: 'app-case',
  templateUrl: './case.component.html',
  styleUrls: ['./case.component.css']
})
export class CaseComponent implements OnInit {

  searchKey: string;
  displayedColumns = ['id', 'productName', 'employeeName', 'customerName', 'customerCompany', 'summary', 'description', 'status', 'action'];
  dataSource: MatTableDataSource<any>;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;


  constructor(private dashboardService: DashboardService, private dialog: MatDialog) { }

  ngOnInit() {
    this.fetchData()
  }

  fetchData() {
    this.dashboardService.getCasesList().subscribe(res => {
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
    const dialogRef = this.dialog.open(CasecreateComponent, dialogConfig);
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
    this.dialog.open(CasedetailComponent, dialogConfig);
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

  onEdit(row: any) {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = false;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "65%";
    dialogConfig.data = row
    const dialogRef = this.dialog.open(CaseeditComponent, dialogConfig);
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.fetchData();
      }
    });
  }

}
