import {Component, Input, OnInit} from '@angular/core';
import {MachineInfo, MachineService, PortInfo} from "../machine.service";

@Component({
    selector: 'app-machine',
    templateUrl: './machine.component.html',
    styleUrls: ['./machine.component.css']
})
export class MachineComponent implements OnInit {

    @Input() machineInfo: MachineInfo;
    portInfos: PortInfo[] = [];

    constructor(private machineService: MachineService) {
    }

    ngOnInit() {
        this.machineService.getPorts(this.machineInfo.id)
            .subscribe(data => this.portInfos = data);
    }

}
