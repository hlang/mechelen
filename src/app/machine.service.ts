import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/map";

export interface MachineInfo {
    id: number;
    name: string;
    description: string;
}

export interface PortInfo {
    id: number;
    portNum: string;
    description: string;
    reachable: boolean;
}

@Injectable()
export class MachineService {
    machineInfos: MachineInfo[];

    constructor(private http: HttpClient) {
    }

    getMachines(): Observable<MachineInfo[]> {
        return this.http.get("/machines")
            .map(data => {
                return data['_embedded']['machines'];
            });

    }

    getPorts(machineId: number): Observable<PortInfo[]> {
        return this.http.get("/machines/" + machineId + "/ports")
            .map(data => {
                return data['_embedded']['ports'];
            });

    }

}
