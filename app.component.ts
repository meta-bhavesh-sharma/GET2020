import { Component } from '@angular/core';
import { NONE_TYPE } from '@angular/compiler';
import { element } from 'protractor';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title:"ANugular";
  display1="none";
  display2="none";
  display3="none";
display="";
newElement:any="";
progressElement:any="";
  taskTitle : any="";
 taskDescription : any="";
 taskStatus : any="";
 creationDate : any="";
 completionDate : any="";
 priority : any="";
 newtasksList = [{
   "title":null,
   "description":null,
   "creationDate":null,
   "completionDate":null,
   "priority":null,
   "updateBtn":null,
   "deleteBtn":null,
   "display":null,
   "color":null }];
 progresstasksList = [{
  "title":null,
  "description":null,
  "creationDate":null,
  "completionDate":null,
  "priority":null,
  "updateBtn":null,
  "deleteBtn":null, 
  "display":null,
  "color":null
}];
 completetasksList = [{
  "title":null,
   "description":null,
   "creationDate":null,
   "completionDate":null,
   "priority":null,
   "updateBtn":null,
   "deleteBtn":null,
   "display":null,
   "color":null
}];
delete(element)
{
  element.display="none";

}
  addTask() {
  this.taskTitle = document.getElementById("title");
  this.taskDescription = document.getElementById("description");
  this.taskStatus = document.getElementById("status");
  this.completionDate = document.getElementById("completionDate");
  this.creationDate = document.getElementById("creationDate");
  this.priority = document.getElementById("priority");
  if( this.taskStatus.value == "New"){
    if(this.newtasksList.length>=1)
    {
    if(this.newtasksList[0].title==null)
    {
      this.newtasksList.pop();
    }
  }
  if(this.priority.value=="High")
  {
    
    this.newtasksList.push({title:this.taskTitle.value,description:this.taskDescription.value,creationDate:this.creationDate.value,completionDate:this.completionDate.value,priority:this.priority.value,updateBtn:"Update",deleteBtn:"delete", display:"block",color:"success" });

  }
  else   if(this.priority.value=="Medium")
  {
    this.newtasksList.push({title:this.taskTitle.value,description:this.taskDescription.value,creationDate:this.creationDate.value,completionDate:this.completionDate.value,priority:this.priority.value,updateBtn:"Update",deleteBtn:"delete", display:"block",color:"danger" });

  }
  else   if(this.priority.value=="Low")
  {
    this.newtasksList.push({title:this.taskTitle.value,description:this.taskDescription.value,creationDate:this.creationDate.value,completionDate:this.completionDate.value,priority:this.priority.value,updateBtn:"Update",deleteBtn:"delete", display:"block",color:"dark" });

  }    this.display1 = "inline";
    
  }
  else if ( this.taskStatus.value == "Completed"){
    if(this.completetasksList.length>=1)
    {
    if(this.completetasksList[0].title==null)
    {
      this.completetasksList.pop();
    }
  }
  if(this.priority.value=="High")
  {
    this.completetasksList.push({title:this.taskTitle.value,description:this.taskDescription.value,creationDate:this.creationDate.value,completionDate:this.completionDate.value,priority:this.priority.value,updateBtn:"Update",deleteBtn:"delete", display:"block",color:"success" });

  }
  else   if(this.priority.value=="Medium")
  {
    this.completetasksList.push({title:this.taskTitle.value,description:this.taskDescription.value,creationDate:this.creationDate.value,completionDate:this.completionDate.value,priority:this.priority.value,updateBtn:"Update",deleteBtn:"delete", display:"block",color:"danger" });

  }
  else   if(this.priority.value=="Low")
  {
    this.completetasksList.push({title:this.taskTitle.value,description:this.taskDescription.value,creationDate:this.creationDate.value,completionDate:this.completionDate.value,priority:this.priority.value,updateBtn:"Update",deleteBtn:"delete", display:"block",color:"dark" });

  }

    this.display2 = "inline";
    
  }
  else {
    if(this.progresstasksList.length>=1)
    {
    if(this.progresstasksList[0].title==null)
    {
      this.progresstasksList.pop();
    }
  }
  if(this.priority.value=="High")
  {
    this.progresstasksList.push({title:this.taskTitle.value,description:this.taskDescription.value,creationDate:this.creationDate.value,completionDate:this.completionDate.value,priority:this.priority.value,updateBtn:"Update",deleteBtn:"delete", display:"block",color:"success" });

  }
  else   if(this.priority.value=="Medium")
  {
    this.progresstasksList.push({title:this.taskTitle.value,description:this.taskDescription.value,creationDate:this.creationDate.value,completionDate:this.completionDate.value,priority:this.priority.value,updateBtn:"Update",deleteBtn:"delete", display:"block",color:"danger" });

  }
  else   if(this.priority.value=="Low")
  {
    this.progresstasksList.push({title:this.taskTitle.value,description:this.taskDescription.value,creationDate:this.creationDate.value,completionDate:this.completionDate.value,priority:this.priority.value,updateBtn:"Update",deleteBtn:"delete", display:"block",color:"dark" });

  }    this.display3 = "inline";
  }
  var item=  <HTMLFormElement>document.getElementById("addTaskForm");
  item.reset();
}

ChangeToCompleted(element){
  if(this.completetasksList.length>=1)
    {
  if(this.completetasksList[0].title==null)
    {
      this.completetasksList.pop();
    }
  }
  this.completetasksList.push(element);
  let index= this.progresstasksList.indexOf(element);
  this.progresstasksList.splice(index,1);
  this.display2 = "inline";

}
ChangeToProgress(element)
{
  if(this.progresstasksList.length>=1)
    {
  if(this.progresstasksList[0].title==null)
    {
      this.progresstasksList.pop();
    }
  }
  this.progresstasksList.push(element);
  let index=this.newtasksList.indexOf(element);
   this.newtasksList.splice(index,1);
   this.display3 = "inline";

}
updateNew(element)
{
document.getElementById("updateNewTitle").setAttribute("value",element.title);
document.getElementById("updateNewDescription").setAttribute("value",element.description);
document.getElementById("updateNewStartDate").setAttribute("value",element.creationDate);
document.getElementById("updateNewEndDate").setAttribute("value",element.completionDate);
document.getElementById("updateNewPriority").setAttribute("value",element.priority);
document.getElementById("updateNewDescription").innerHTML=element.description;
this.newElement=element;
}
updateNewTask()
{
let index=this.newtasksList.indexOf(this.newElement);
this.newtasksList.splice(index,1);
this.taskTitle = document.getElementById("updateNewTitle");
this.taskDescription = document.getElementById("updateNewDescription");
this.creationDate = document.getElementById("updateNewStartDate");
this.completionDate = document.getElementById("updateNewEndDate");
this.priority = document.getElementById("updateNewPriority");
if(this.priority.value=="High")
{
  this.newtasksList.unshift({title:this.taskTitle.value,description:this.taskDescription.value,creationDate:this.creationDate.value,completionDate:this.completionDate.value,priority:this.priority.value,updateBtn:"Update",deleteBtn:"delete", display:"block",color:"success" });

}
else   if(this.priority.value=="Medium")
{
  this.newtasksList.unshift({title:this.taskTitle.value,description:this.taskDescription.value,creationDate:this.creationDate.value,completionDate:this.completionDate.value,priority:this.priority.value,updateBtn:"Update",deleteBtn:"delete", display:"block",color:"danger" });

}
else   if(this.priority.value=="Low")
{
  this.newtasksList.unshift({title:this.taskTitle.value,description:this.taskDescription.value,creationDate:this.creationDate.value,completionDate:this.completionDate.value,priority:this.priority.value,updateBtn:"Update",deleteBtn:"delete", display:"block",color:"dark" });

}   
}

updateProgressTask()
{
let index=this.progresstasksList.indexOf(this.progressElement);
this.progresstasksList.splice(index,1);
this.taskTitle = document.getElementById("updateProgressTitle");
this.taskDescription = document.getElementById("updateProgressDescription");
this.creationDate = document.getElementById("updateProgressStartDate");
this.completionDate = document.getElementById("updateProgressEndDate");
this.priority = document.getElementById("updateProgressPriority");
if(this.priority.value=="High")
{
  this.progresstasksList.unshift({title:this.taskTitle.value,description:this.taskDescription.value,creationDate:this.creationDate.value,completionDate:this.completionDate.value,priority:this.priority.value,updateBtn:"Update",deleteBtn:"delete", display:"block",color:"success" });

}
else   if(this.priority.value=="Medium")
{
  this.progresstasksList.unshift({title:this.taskTitle.value,description:this.taskDescription.value,creationDate:this.creationDate.value,completionDate:this.completionDate.value,priority:this.priority.value,updateBtn:"Update",deleteBtn:"delete", display:"block",color:"danger" });

}
else   if(this.priority.value=="Low")
{
  this.progresstasksList.unshift({title:this.taskTitle.value,description:this.taskDescription.value,creationDate:this.creationDate.value,completionDate:this.completionDate.value,priority:this.priority.value,updateBtn:"Update",deleteBtn:"delete", display:"block",color:"dark" });

}   
}
updateProgress(element)
{
  document.getElementById("updateProgressTitle").setAttribute("value",element.title);
  document.getElementById("updateProgressDescription").setAttribute("value",element.description);
  document.getElementById("updateProgressStartDate").setAttribute("value",element.creationDate);
  document.getElementById("updateProgressEndDate").setAttribute("value",element.completionDate);
  document.getElementById("updateProgressPriority").setAttribute("value",element.priority);
  document.getElementById("updateProgressDescription").innerHTML=element.description;
  this.progressElement=element;

}
}
