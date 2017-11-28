package com.icolor.StudySpringBoot.schedules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 2017/11/24.
 */
@Component
public class ScheduledTasks {

        private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

        private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

        @Scheduled(fixedDelay = 5000)
        public void reportCurrentTime() {
            log.info("The time is now {}", dateFormat.format(new Date()));
        }

}
