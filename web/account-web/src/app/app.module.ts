import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AccountLoginComponent } from './account-login/account-login.component';

@NgModule({
  declarations: [
    AppComponent,
    AccountLoginComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent, AccountLoginComponent]
})
export class AppModule { }
