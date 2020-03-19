import { Component } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

 display = "none";
 taskTitle : any;
 taskDescription : any;
 taskStatus : any="";
 creationDate : any="";
 completionDate : any="";
 priority : any="";
 newtasksList = [{
   "title":null,
   "description":null,
   "viewButton":null,
   "updateBtn":null
   
 }];
 progresstasksList = [{
  "title":null,
  "description":null,
  "viewButton":null,
  "updateBtn":null

}];
 completetasksList = [{
  "title":null,
  "description":null,
  "viewButton":null,
  "updateBtn":null

}];

  getTask() {
  this.taskTitle = document.getElementById("title");
  this.taskDescription = document.getElementById("description");
  this.taskStatus = document.getElementById("status");
  this.completionDate = document.getElementById("compDate");
  this.creationDate = document.getElementById("creDate");
  this.priority = document.getElementById("priority");
  this.taskStatus = document.getElementById("status");
  if( this.taskStatus.value == "NEW"){
    this.newtasksList.push({title:this.taskTitle.value,description:this.taskDescription.value, viewButton:"View Task",updateBtn:"Update"});
    this.display = "inline";
    
  }
  else if ( this.taskStatus.value == "PROGRESS"){
    this.progresstasksList.push({title:this.taskTitle.value,description:this.taskDescription.value,viewButton:"View Task",updateBtn:"Update"});
    this.display = "inline";
    
  }
  else {
    this.completetasksList.push({title:this.taskTitle.value,description:this.taskDescription.value,viewButton:"View Task",updateBtn:"Update"});
    this.display = "inline";
    

  }
}
  // this.taskDescription = des.value;
  // this.taskStatus = status.value;
  // this.creationDate = creDate.value;
  // this.completionDate = comDate.value;
  // this.priority = prt.value;


  

}








