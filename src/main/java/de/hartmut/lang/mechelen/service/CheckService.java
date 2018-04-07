package de.hartmut.lang.mechelen.service;

import de.hartmut.lang.mechelen.db.Machine;
import de.hartmut.lang.mechelen.db.MachineRepository;
import de.hartmut.lang.mechelen.db.Port;
import de.hartmut.lang.mechelen.db.PortRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.concurrent.*;

/**
 * hartmut on 07.04.18.
 */
@Service
public class CheckService implements Runnable {
    private final static Logger LOG = LoggerFactory.getLogger(CheckService.class);

    private final MachineRepository machineRepository;
    private final PortRepository portRepository;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    public CheckService(MachineRepository machineRepository, PortRepository portRepository) {
        this.machineRepository = machineRepository;
        this.portRepository = portRepository;
    }

    @PostConstruct
    public void init() {
        scheduler.scheduleAtFixedRate(this, 5, 30, TimeUnit.SECONDS);
    }

    @Override
    public void run() {
        LOG.debug("run()");
        try {
            Iterable<Machine> machines = machineRepository.findAll();
            for (Machine machine : machines) {
                if (!StringUtils.isEmpty(machine.getIpAddress())) {
                    String ipAddress = machine.getIpAddress();
                    for (Port port : machine.getPorts()) {
                        if (port.getPortNum() != null) {
                            Integer portNum = port.getPortNum();
                            LOG.debug("check: ip={}, port={}", ipAddress, portNum);
                            CompletableFuture.supplyAsync(new CheckerTask(ipAddress, port), executor)
                                .thenAccept(p ->
                                {
                                    LOG.debug("check(): {}", p.getReachable());
                                    portRepository.save(p);
                                });

                        }
                    }
                }
            }
        } catch (Exception ex) {
            LOG.warn("run() failed!", ex);
        }
    }
}
