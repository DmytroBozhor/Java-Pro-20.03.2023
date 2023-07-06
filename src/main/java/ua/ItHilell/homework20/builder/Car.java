package ua.ItHilell.homework20.builder;

public class Car {

    private String wheel;
    private String engine;
    private String seat;
    private String model;
    private String color;

    public Car(String wheel, String engine, String seat, String model, String color) {
        this.wheel = wheel;
        this.engine = engine;
        this.seat = seat;
        this.model = model;
        this.color = color;
    }

    public static class Builder {

        private String wheel;
        private String engine;
        private String seat;
        private String model;
        private String color;

        public Builder setWheel(String wheel) {
            this.wheel = wheel;
            return this;
        }

        public Builder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public Builder setSeat(String seat) {
            this.seat = seat;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Car build() {
            return new Car(wheel, engine, seat, model, color);
        }
    }
}
