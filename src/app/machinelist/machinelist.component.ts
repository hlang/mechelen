import {Component, OnInit} from '@angular/core';
import {MachineInfo, MachineService} from "../machine.service";

@Component({
    selector: 'app-machinelist',
    templateUrl: './machinelist.component.html',
    styleUrls: ['./machinelist.component.css']
})
export class MachinelistComponent implements OnInit {
    machines: MachineInfo[] = [];

    constructor(private machineService: MachineService) {
    }

    ngOnInit() {
        this.machineService.getMachines()
            .subscribe(data => {
                this.machines = data;
            })
    }

}
