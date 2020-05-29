import { Component, OnInit, Inject } from '@angular/core';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef, MatSnackBar } from '@angular/material';
import { DashboardService } from '../../dashboard.service';

export class Casebody {
  id: string;
  summary: string;
  description: string;
  status: string;
}
@Component({
  selector: 'app-caseedit',
  templateUrl: './caseedit.component.html',
  styleUrls: ['./caseedit.component.css']
})
export class CaseeditComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: any, private dashboardService: DashboardService, public dialogRef: MatDialogRef<CaseeditComponent>, public snackBar: MatSnackBar, ) { }


  editCaseForm: FormGroup = new FormGroup({
    id: new FormControl('', Validators.required),
    productId: new FormControl('', [Validators.required, Validators.pattern("^[0-9]*$")]),
    employeeId: new FormControl('', [Validators.required, Validators.pattern("^[0-9]*$")]),
    summary: new FormControl('', Validators.required),
    description: new FormControl('', Validators.required),
    status: new FormControl('', Validators.required)
  });

  ngOnInit() {
    this.fetchData()
  }

  fetchData() {
    this.editCaseForm.setValue({
      id: this.data.id,
      productId: this.data.product_id,
      employeeId: this.data.employee_id,
      summary: this.data.summary,
      description: this.data.description,
      status: this.data.status,
    })
  }

  editCase() {
    if (this.editCaseForm.value.status == "open" || this.editCaseForm.value.status == "Open") {
      this.editCaseForm.value.status = "Open"
    } else {
      this.editCaseForm.value.status = "Close"
    }
    let caseBody: Casebody = {
      id: this.editCaseForm.value.id,
      summary: this.editCaseForm.value.summary,
      description: this.editCaseForm.value.description,
      status: this.editCaseForm.value.status
    }
    this.dashboardService.editCase(this.editCaseForm.value.productId, this.editCaseForm.value.productId, caseBody).subscribe(
      data => {
        setTimeout(() => {
          this.snackBar.dismiss()
        }, 2000);
        this.snackBar.open('::Submited successfully')
        this.dialogRef.close("check");
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
