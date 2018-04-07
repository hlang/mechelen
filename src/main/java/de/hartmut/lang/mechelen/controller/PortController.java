package de.hartmut.lang.mechelen.controller;

import de.hartmut.lang.mechelen.db.Port;
import de.hartmut.lang.mechelen.service.MachineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * hartmut on 07.04.18.
 */
@RestController
@RequestMapping("/portctrl")
public class PortController {
    private final static Logger LOG = LoggerFactory.getLogger(PortController.class);

    private final MachineService machineService;

    public PortController(MachineService machineService) {
        this.machineService = machineService;
    }

    @PostMapping("/{machineId}")
    ResponseEntity<Void> addPort(@PathVariable("machineId") Long machineId,
                                 @RequestBody Port port) {
        LOG.debug("addPort(): {}", port);

        machineService.addPort(machineId, port);
        return ResponseEntity.ok(null);
    }
}
