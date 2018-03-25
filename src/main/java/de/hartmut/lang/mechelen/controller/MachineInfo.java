package de.hartmut.lang.mechelen.controller;

import org.springframework.hateoas.ResourceSupport;

/**
 * hartmut on 24.03.18.
 */
public class MachineInfo extends ResourceSupport {
    private Long machineId;
    private String name;
    private String ipAddress;
    private String description;

    public Long getMachineId() {
        return machineId;
    }

    public void setMachineId(Long machineId) {
        this.machineId = machineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
