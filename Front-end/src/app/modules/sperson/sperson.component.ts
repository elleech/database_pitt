import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatPaginator, MatSort, MatDialog, MatDialogConfig } from '@angular/material';
import { DashboardService } from '../dashboard.service';
import { SpersondetailComponent } from './spersondetail/spersondetail.component';
import { SpersoncreateComponent } from './spersoncreate/spersoncreate.component';

@Component({
  selector: 'app-sperson',
  templateUrl: './sperson.component.html',
  styleUrls: ['./sperson.component.css']
})
export class SpersonComponent implements OnInit {
 
  displayedColumns = ['id', 'lastname', 'email', 'address','phone','jobtitle', 'action'];
  dataSource: MatTableDataSource<any>;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;
  searchKey: string;


  constructor(private dashboardService: DashboardService, private dialog: MatDialog) { }

  ngOnInit() { 
    this.fetchData()
  }    
  
  fetchData() {
    this.dashboardService.getSalePersonList().subscribe(res => {
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
    const dialogRef = this.dialog.open(SpersoncreateComponent, dialogConfig);
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
    this.dialog.open(SpersondetailComponent, dialogConfig);
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
