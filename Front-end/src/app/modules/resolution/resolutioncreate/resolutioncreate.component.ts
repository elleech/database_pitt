import { Component, OnInit } from '@angular/core';
import { MatSnackBar, MatDialogRef } from '@angular/material';
import { DashboardService } from '../../dashboard.service';
import { FormGroup, Validators, FormControl } from '@angular/forms';


export class Resolutionbody{
  name:string;
  description:string;
  step:string;
}
@Component({
  selector: 'app-resolutioncreate',
  templateUrl: './resolutioncreate.component.html',
  styleUrls: ['./resolutioncreate.component.css']
})
export class ResolutioncreateComponent implements OnInit {

  constructor(private dashboardService: DashboardService, public dialogRef: MatDialogRef<ResolutioncreateComponent>, public snackBar: MatSnackBar) { }

  resolutionForm: FormGroup = new FormGroup({
    productId: new FormControl('', [Validators.required, Validators.pattern("^[0-9]*$")]),
    name: new FormControl('', Validators.required),
    description: new FormControl('', Validators.required),
    step: new FormControl('', Validators.required),
  });

  ngOnInit() {
  }

  addResolution() { 
    console.log(this.resolutionForm.value);
    let resolutionbody: Resolutionbody ={
      name : this.resolutionForm.value.name,
      description : this.resolutionForm.value.description,
      step : this.resolutionForm.value.step,
    }
    this.dashboardService.createResolution(this.resolutionForm.value.productId, resolutionbody).subscribe(
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
 