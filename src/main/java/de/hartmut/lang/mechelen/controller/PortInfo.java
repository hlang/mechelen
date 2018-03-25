package de.hartmut.lang.mechelen.controller;

import org.springframework.hateoas.ResourceSupport;

/**
 * hartmut on 24.03.18.
 */
public class PortInfo extends ResourceSupport {
    private Long portId;
    private Integer portNum;
    private String description;
    private Boolean reachable;

    public Long getPortId() {
        return portId;
    }

    public void setPortId(Long portId) {
        this.portId = portId;
    }

    public Integer getPortNum() {
        return portNum;
    }

    public void setPortNum(Integer portNum) {
        this.portNum = portNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getReachable() {
        return reachable;
    }

    public void setReachable(Boolean reachable) {
        this.reachable = reachable;
    }
}
