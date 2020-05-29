import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { DashboardService } from '../../dashboard.service';
import { MatDialogRef, MatSnackBar } from '@angular/material';


export class CaseCommentbody{
  comment:string;
}
@Component({
  selector: 'app-carecommentcreate',
  templateUrl: './carecommentcreate.component.html',
  styleUrls: ['./carecommentcreate.component.css']
})
export class CarecommentcreateComponent implements OnInit {

  constructor(private dashboardService: DashboardService, public dialogRef: MatDialogRef<CarecommentcreateComponent>, public snackBar: MatSnackBar) { }

  caseCommentForm: FormGroup = new FormGroup({
    caseId: new FormControl('', [Validators.required, Validators.pattern("^[0-9]*$")]),
    comment: new FormControl('', Validators.required),
  });

  ngOnInit() {
  }

  addCaseComment() {
    console.log(this.caseCommentForm.value);
    let caseCommentBody: CaseCommentbody ={
      comment : this.caseCommentForm.value.comment,
    }
    this.dashboardService.createCaseComment(this.caseCommentForm.value.caseId, caseCommentBody).subscribe(
      data => {
        setTimeout(() => {
          this.snackBar.dismiss()
        }, 2000);
        this.dialogRef.close("check");
        this.snackBar.open('::Submited successfully')
      },
      error => {
        this.snackBar.open('::Something goes wrong')
      }
    );
  }

} 
