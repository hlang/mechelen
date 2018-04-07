package de.hartmut.lang.mechelen.service;

import de.hartmut.lang.mechelen.db.Machine;
import de.hartmut.lang.mechelen.db.MachineRepository;
import de.hartmut.lang.mechelen.db.Port;
import de.hartmut.lang.mechelen.db.PortRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * hartmut on 07.04.18.
 */
@Service
public class MachineService {
    private final static Logger LOG = LoggerFactory.getLogger(MachineService.class);

    private final PortRepository portRepository;
    private final MachineRepository machineRepository;

    public MachineService(PortRepository portRepository, MachineRepository machineRepository) {
        this.portRepository = portRepository;
        this.machineRepository = machineRepository;
    }

    public void addPort(Long machineId, Port port) {
        LOG.debug("addPort(): machineId={}, {}", machineId, port);
        Optional<Machine> machineOpt = machineRepository.findById(machineId);
        if (machineOpt.isPresent()) {
            Machine machine = machineOpt.get();
            machine.addPort(port);
            machineRepository.save(machine);
            portRepository.save(port);
        }
    }
}
