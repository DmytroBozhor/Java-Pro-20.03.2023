package ua.ItHilell.homework8.OtherClasses;

public interface Participant {

    void run();

    void jump();

    static void decideMethod(Difficulty difficulty, Participant participant) {
        if (difficulty instanceof RunningTrack) {
            participant.run();
        } else {
            participant.jump();
        }
    }

}
