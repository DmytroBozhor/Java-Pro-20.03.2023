package ua.ItHilell.homework8.OtherClasses;

public class Main {

    public static void main(String[] args) {

        Participant[] participants = {new Person(), new Cat(), new Robot()};
        Difficulty[] difficulties = {new RunningTrack(), new Wall()};

        for (int i = 0; i < participants.length; i++) {
            for (int j = 0; j < difficulties.length; j++) {
                Participant.decideMethod(difficulties[j], participants[i]);
            }
        }

    }
}
