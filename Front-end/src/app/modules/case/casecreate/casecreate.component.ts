import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { DashboardService } from '../../dashboard.service';
import { MatDialogRef, MatSnackBar } from '@angular/material';


export class Casebody {
  summary: string;
  description: string;
  status: string;
}

@Component({
  selector: 'app-casecreate',
  templateUrl: './casecreate.component.html',
  styleUrls: ['./casecreate.component.css']
})
export class CasecreateComponent implements OnInit {

  constructor(private dashboardService: DashboardService, public dialogRef: MatDialogRef<CasecreateComponent>, public snackBar: MatSnackBar) { }

  caseForm: FormGroup = new FormGroup({
    buyId: new FormControl('', [Validators.required, Validators.pattern("^[0-9]*$")]),
    employeeId: new FormControl('', [Validators.required, Validators.pattern("^[0-9]*$")]),
    summary: new FormControl('', Validators.required),
    description: new FormControl('', Validators.required),
    status: new FormControl('', Validators.required),
  });

  ngOnInit() {
  }

  addCase() {
    if (this.caseForm.value.status == "open" || this.caseForm.value.status == "Open") {
      this.caseForm.value.status = "Open"
    } else {
      this.caseForm.value.status = "Close"
    }
    let caseBody: Casebody = {
      summary: this.caseForm.value.summary,
      description: this.caseForm.value.description,
      status: this.caseForm.value.status
    }
    this.dashboardService.createCases(this.caseForm.value.buyId, this.caseForm.value.employeeId, caseBody).subscribe(
      data => {
        setTimeout(() => {
          this.snackBar.dismiss()
        }, 2000);
        this.dialogRef.close("check");
        this.snackBar.open('::Submited successfully')
      },
      error => {
        setTimeout(() => {
          this.snackBar.dismiss()
        }, 2000);
        this.snackBar.open('::Something goes wrong')
      }
    );
  }

}
