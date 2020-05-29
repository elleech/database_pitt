import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatPaginator, MatSort, MatDialog, MatDialogConfig } from '@angular/material';
import { DashboardService } from '../dashboard.service';
import { CarecommentcreateComponent } from './carecommentcreate/carecommentcreate.component';

@Component({
  selector: 'app-casecomment',
  templateUrl: './casecomment.component.html',
  styleUrls: ['./casecomment.component.css']
})
export class CasecommentComponent implements OnInit {

  searchKey:string;
  displayedColumns = ['id', 'time', 'comment', 'cases_id','casesSummary'];
  dataSource: MatTableDataSource<any>;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;


  constructor(private dashboardService: DashboardService, private dialog: MatDialog) { }

  ngOnInit() { 
    this.fetchData() 
  }   
 
  fetchData() {
    this.dashboardService.getCaesCommentList().subscribe(res => {
      console.log(res);
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
    const dialogRef = this.dialog.open(CarecommentcreateComponent, dialogConfig);
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
