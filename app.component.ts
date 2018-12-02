import { Component } from '@angular/core';


@Component({

selector: 'app-root',

templateUrl: './app.component.html',

styleUrls: ['./app.component.css']

})

export class AppComponent {

title = 'my-project';

name ='Gautham';

quality ='20';

quantity = '200';

price = '100';

contacts: any = [ ];

add(){
 this.contacts.push({name:this.name,quality:this.quality,quantity:this.quantity,price:this.price});

this.name ='Gautham';

this.quality='20';

this.quantity='200';

this.price='100';


}

deleteFieldValue(index) {

this.contacts.splice(index, 1);

}

}

