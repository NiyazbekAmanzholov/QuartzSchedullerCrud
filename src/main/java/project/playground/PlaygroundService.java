package project.playground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.info.TimerInfo;
import project.jobs.HelloNiyazJob;
import project.jobs.HelloWorldJob;
import project.timerservice.SchedulerService;

import java.util.List;

@Service
public class PlaygroundService {
    private final SchedulerService scheduler;

    @Autowired
    public PlaygroundService(final SchedulerService scheduler) {
        this.scheduler = scheduler;
    }

    public void runHelloWorldJob() {
        final TimerInfo info = new TimerInfo();
        info.setTotalFireCount(5);
        info.setRemainingFireCount(info.getTotalFireCount());
        info.setRepeatIntervalMs(5000);
        info.setInitialOffsetMs(1000);
        info.setCallbackData("My callback data");

//        final TimerInfo infoNiyaz = new TimerInfo();
//        infoNiyaz.setTotalFireCount(2);
//        infoNiyaz.setRemainingFireCount(infoNiyaz.getTotalFireCount());
//        infoNiyaz.setRepeatIntervalMs(6000);
//        infoNiyaz.setInitialOffsetMs(1000);
//        infoNiyaz.setCallbackData("Niyaz callback data");
//
//        scheduler.schedule(HelloNiyazJob.class, infoNiyaz);

        scheduler.schedule(HelloWorldJob.class, info);
    }

    public Boolean deleteTimer(final String timerId) {
        return scheduler.deleteTimer(timerId);
    }

    public List<TimerInfo> getAllRunningTimers() {
        return scheduler.getAllRunningTimers();
    }

    public TimerInfo getRunningTimer(final String timerId) {
        return scheduler.getRunningTimer(timerId);
    }
}