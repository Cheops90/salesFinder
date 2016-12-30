package implementation.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.testng.TestNG;
import org.testng.collections.Lists;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    // Schedule for the top of every hour of every day.
    // ToDo Move Cron value in properties file.
    @Scheduled(cron = "0 0 * * * *")
    public void reportCurrentTime() {
        log.info("The time is now {}, run tests!", dateFormat.format(new Date()));

        // Run tests.
        TestNG testNG = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add("src/ui_tests/java/com/example/suite/simpleSuite.xml");
        testNG.setTestSuites(suites);
        testNG.run();
    }

}
