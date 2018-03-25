package de.hartmut.lang.mechelen.controller;

import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * hartmut on 24.03.18.
 */
public class PortList extends ResourceSupport {
    private List<PortInfo> portInfos;

    public List<PortInfo> getPortInfos() {
        return portInfos;
    }

    public void setPortInfos(List<PortInfo> portInfos) {
        this.portInfos = portInfos;
    }
}
