package fr.wildcodeschool.quetes.chrono;

public class Startup {

    public static void main(String... args) throws InterruptedException {

        boolean maximise = false;

        if ( args.length >= 1) {
            maximise = Boolean.parseBoolean(args[0]);
        }

        long totalRunTime = 0;

        if ( args.length >= 2) {
            try {
                totalRunTime = Long.parseLong(args[1]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        TimeProvider tp = new JavaTimeProvider(totalRunTime);
        new Chrono(tp).roll(maximise);
    }
}
