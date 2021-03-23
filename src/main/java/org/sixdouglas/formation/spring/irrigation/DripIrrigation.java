package org.sixdouglas.formation.spring.irrigation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.stereotype.Component;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Component
public class DripIrrigation {
    private static Logger LOGGER = LoggerFactory.getLogger(DripIrrigation.class);

    public Flux<Drop> followDrops() {
        return Flux.fromIterable(this.getListOfDrops()).timeout(Duration.ofMillis(20));
    }

    private List<Drop> getListOfDrops() {
        Drop drop = Drop.builder()
                .dropperId(1)
                .greenHouseId(1)
                .rowId(1)
                .instant(Instant.now())
                .broken(false)
                .build();

        Drop drop2 = Drop.builder()
                .dropperId(2)
                .greenHouseId(2)
                .rowId(2)
                .instant(Instant.now())
                .broken(false)
                .build();

        Drop drop3 = Drop.builder()
                .dropperId(2)
                .greenHouseId(2)
                .rowId(2)
                .instant(Instant.now())
                .broken(false)
                .build();

        Drop drop4 = Drop.builder()
                .dropperId(2)
                .greenHouseId(2)
                .rowId(2)
                .instant(Instant.now())
                .broken(false)
                .build();

        Drop drop5 = Drop.builder()
                .dropperId(2)
                .greenHouseId(2)
                .rowId(2)
                .instant(Instant.now())
                .broken(false)
                .build();

        List<Drop> l_drops = new ArrayList<>();
        l_drops.add(drop);
        l_drops.add(drop2);
        l_drops.add(drop3);
        l_drops.add(drop4);
        l_drops.add(drop5);

        return l_drops;
    }
}
