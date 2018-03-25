import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {NgModule} from '@angular/core';
import {HttpClientModule} from "@angular/common/http";
import {CardModule} from 'primeng/card';
import {PanelModule} from 'primeng/panel';

import {AppComponent} from './app.component';
import {MachinelistComponent} from './machinelist/machinelist.component';
import {MachineComponent} from './machine/machine.component';
import {PortComponent} from './port/port.component';
import {MachineService} from "./machine.service";


@NgModule({
    declarations: [
        AppComponent,
        MachinelistComponent,
        MachineComponent,
        PortComponent
    ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        HttpClientModule,
        CardModule,
        PanelModule
    ],
    providers: [MachineService],
    bootstrap: [AppComponent]
})
export class AppModule {
}
