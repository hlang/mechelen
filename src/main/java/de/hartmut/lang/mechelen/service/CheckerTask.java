package de.hartmut.lang.mechelen.service;

import de.hartmut.lang.mechelen.db.Port;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.Socket;
import java.util.function.Supplier;

/**
 * hartmut on 07.04.18.
 */
public class CheckerTask implements Supplier<Port> {
    private final static Logger LOG = LoggerFactory.getLogger(CheckerTask.class);

    private final String ipAddress;
    private final Port port;

    public CheckerTask(String ipAddress, Port port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }

    @Override
    public Port get() {
        boolean reachable = checkPort();
        port.setReachable(reachable);
        return port;
    }

    private boolean checkPort() {
        try {
            Socket ServerSok = new Socket(ipAddress, port.getPortNum());
            ServerSok.close();
            LOG.debug("checkPort: {}, {} -> true", ipAddress, port.getPortNum());
            return true;
        } catch (Exception e) {
            LOG.debug("checkPort: {}, {} -> false", ipAddress, port.getPortNum());
            return false;
        }
    }
}
