import { Component,Renderer2, ElementRef, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SalesOrderServiceService } from './sales-order.service';
import { setTimeout } from 'timers';


@Component({

selector: 'app-root',

templateUrl: './app.component.html',

styleUrls: ['./app.component.css']

})

export class AppComponent {

title = 'my-project';

name ='';

quality ='';

quantity = '';

price = '';

contacts: any = [ ];

salesorder;
editRowId: any;
isEditable=false;

@ViewChild('input1') input1: ElementRef;  


constructor(private http:HttpClient,private salesorde:SalesOrderServiceService,private renderer: Renderer2) {
  this.salesorder=salesorde;

 }

add(){
 this.contacts.push({name:this.name,quality:this.quality,quantity:this.quantity,price:this.price});
this.name='';
this.quality='';
this.quantity='';
this.price='';
console.log(this.contacts);
}

deleteFieldValue(index) {

this.contacts.splice(index, 1);

}


save(i,e){
    console.log('In Save Fun',e)
//   this.isEditable=!this.isEditable
     this.contacts[i] = e
     alert('Data Edited Successfully')
//    this.contacts.push({name:this.name,quality:this.quality,q

}
GenerateColor(){
    alert("style called");
    document.getElementById('editName').focus();
}
toggle(id){
    this.editRowId = id;
  //   setTimeout(() =>
  //   this.input1.nativeElement.focus(),0
  //   )
  //   setTimeout(() =>{
      // const element = this.renderer.selectRootElement('#input1');
      // element.focus()
  // },100)
   
  }
changeRowEdit(index){
    this.toggle(index)
}




}
