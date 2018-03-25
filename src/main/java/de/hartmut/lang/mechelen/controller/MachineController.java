package de.hartmut.lang.mechelen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * hartmut on 24.03.18.
 */
@RestController
@RequestMapping("/machines")
public class MachineController {
    private final static Logger LOG = LoggerFactory.getLogger(MachineController.class);

    @GetMapping
    public ResponseEntity<MachineList> machines() {
        List<MachineInfo> machines = LongStream.range(1L, 10L)
            .mapToObj(this::createMachine)
            .collect(Collectors.toList());
        MachineList machineList = new MachineList();
        machineList.setMachineInfos(machines);
        Link selfRel = linkTo(MachineController.class)
            .withSelfRel();
        machineList.add(selfRel);

        return ResponseEntity.ok(machineList);
    }

    @GetMapping("/{machineId}")
    public ResponseEntity<MachineInfo> machine(@PathVariable("machineId") Long machineId) {
        MachineInfo machine = createMachine(machineId);
        return ResponseEntity.ok(machine);
    }

    @GetMapping("/{machineId}/ports")
    public ResponseEntity<PortList> ports(@PathVariable("machineId") Long machineId) {

        List<PortInfo> ports = LongStream.range(1L, 10L)
            .mapToObj(this::createPort)
            .collect(Collectors.toList());

        PortList portList = new PortList();
        portList.setPortInfos(ports);
        portList.add(linkTo(methodOn(MachineController.class).ports(machineId)).withSelfRel());
        return ResponseEntity.ok(portList);
    }

    private MachineInfo createMachine(Long id) {
        MachineInfo machineInfo = new MachineInfo();
        machineInfo.setMachineId(id);
        machineInfo.setName("Name#" + id);
        machineInfo.setDescription("Description: " + id);
        machineInfo.add(linkTo(methodOn(MachineController.class).machine(id)).withSelfRel());
        machineInfo.add(linkTo(methodOn(MachineController.class).ports(id))
            .withRel("ports"));
        return machineInfo;
    }

    private PortInfo createPort(Long id) {
        PortInfo portInfo = new PortInfo();
        portInfo.setPortId(id);
        portInfo.setPortNum(9000 + id.intValue());
        portInfo.setDescription("Port#" + id);
        portInfo.setReachable(true);
        return portInfo;
    }
}
