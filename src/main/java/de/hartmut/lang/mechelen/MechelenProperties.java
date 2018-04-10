package de.hartmut.lang.mechelen;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * hartmut on 07.04.18.
 */
@Component
@ConfigurationProperties(prefix = "mechelen")
public class MechelenProperties {
    private Long checkDelay = 60L;

    public Long getCheckDelay() {
        return checkDelay;
    }

    public void setCheckDelay(Long checkDelay) {
        this.checkDelay = checkDelay;
    }
}
