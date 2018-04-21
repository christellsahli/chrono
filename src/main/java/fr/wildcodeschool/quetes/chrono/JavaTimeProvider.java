package fr.wildcodeschool.quetes.chrono;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class JavaTimeProvider implements TimeProvider {

    private long totalRunTime;
    private boolean started;
    private LocalDateTime startTime;

    public JavaTimeProvider() {
    }

    public JavaTimeProvider(long totalRunTime) {

        this.totalRunTime = totalRunTime;
    }

    @Override
    public void startStop() {
        // nothing

        if (isStarted()){
            // Arrête le chrono
            started = false;
            totalRunTime += startTime.until(LocalDateTime.now(), ChronoUnit.SECONDS);
        }
        else{
            // lance le chrono
            started = true;
            startTime =  LocalDateTime.now();
        }

    }

    @Override
    public void reset() {
        // nothing
        totalRunTime = 0;
        started = false;
    }

    @Override
    public boolean isStarted() {
        return started;
    }

    @Override
    public long getSecondsTotalRuntime() {
        long compteur = totalRunTime;
        if (isStarted()){
            compteur += startTime.until(LocalDateTime.now(), ChronoUnit.SECONDS);
        }
        return compteur;
    }

    @Override
    public long getHoursRuntime() {
        return getSecondsTotalRuntime() / 3600;
    }

    @Override
    public long getMinutesRuntime() {
        return  (getSecondsTotalRuntime() - getHoursRuntime() * 3600) / 60;
    }

    @Override
    public long getSecondsRuntime() {
        return (getSecondsTotalRuntime() - getHoursRuntime() * 3600 - getMinutesRuntime() * 60);
    }

}
