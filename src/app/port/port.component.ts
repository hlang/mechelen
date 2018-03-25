import {Component, Input, OnInit} from '@angular/core';
import {PortInfo} from "../machine.service";

@Component({
    selector: 'app-port',
    templateUrl: './port.component.html',
    styleUrls: ['./port.component.css']
})
export class PortComponent implements OnInit {
    @Input() portInfo: PortInfo;

    constructor() {
    }

    ngOnInit() {
    }

}
