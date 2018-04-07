package de.hartmut.lang.mechelen.db;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * hartmut on 27.03.18.
 */
@Entity
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String ipAddress;
    private String description;

    @OneToMany(mappedBy = "machine", fetch = FetchType.EAGER)
    private List<Port> ports;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Port> getPorts() {
        return ports;
    }

    public void setPorts(List<Port> ports) {
        this.ports = ports;
    }

    public void addPort(Port port) {
        if (ports == null) {
            ports = new ArrayList<>();
        }
        ports.add(port);
        port.setMachine(this);
    }
}
