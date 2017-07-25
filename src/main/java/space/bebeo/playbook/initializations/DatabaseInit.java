package space.bebeo.playbook.initializations;


import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
@NoArgsConstructor
public class DatabaseInit {

    @PostConstruct
    private void init() {
        log.info("========== Initializing database information ==========");
    }

    private void argumentation() {
        log.info("asssss");
    }

}
