package de.hartmut.lang.mechelen.controller;

import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * hartmut on 24.03.18.
 */
public class MachineList extends ResourceSupport {
    private List<MachineInfo> machineInfos;

    public List<MachineInfo> getMachineInfos() {
        return machineInfos;
    }

    public void setMachineInfos(List<MachineInfo> machineInfos) {
        this.machineInfos = machineInfos;
    }
}
