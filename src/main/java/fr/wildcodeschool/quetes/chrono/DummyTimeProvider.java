package fr.wildcodeschool.quetes.chrono;

import java.util.Date;

public class DummyTimeProvider implements TimeProvider {

    private long totalRunTime;
    private long startTime;
    private boolean started;


    public DummyTimeProvider(long totalRunTime) {

        this.totalRunTime = totalRunTime * 1000;
    }

    @Override
    public void startStop() {
        // nothing

        if (isStarted()){
            // Arrête le chrono
            started = false;
            totalRunTime += new Date().getTime() - startTime ;
        }
        else{
            // lance le chrono
            started = true;
            startTime =  new Date().getTime();
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
            compteur += new Date().getTime() - startTime ;
        }
        return compteur / 1000;
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
