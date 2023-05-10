package ua.ItHilell.homework10;

public class ValueCalculator {

    int arraySize = 1000000;
    int halfOfArraySize = arraySize / 2;

    public double[] numbers = new double[arraySize];

    public void method() throws InterruptedException {
        long start = System.currentTimeMillis();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }

        double[] firstHalfOfArray = new double[halfOfArraySize];
        double[] secondHalfOfArray = new double[halfOfArraySize];

        System.arraycopy(numbers, 0, firstHalfOfArray, 0, halfOfArraySize);

        System.arraycopy(numbers, halfOfArraySize, secondHalfOfArray, 0, halfOfArraySize);

        MyThread thread = new MyThread();
        thread.setHalfNumbers(firstHalfOfArray);

        MyThread thread2 = new MyThread();
        thread2.setHalfNumbers(secondHalfOfArray);

        thread.start();
        thread2.start();

        thread.join();
        thread2.join();

        System.arraycopy(firstHalfOfArray, 0, numbers, 0, halfOfArraySize);

        System.arraycopy(secondHalfOfArray, 0, numbers, halfOfArraySize, halfOfArraySize);

        long finish = System.currentTimeMillis();

        System.out.println("Spent time: " + (finish - start) + "ms.");

    }

    class MyThread extends Thread {

        private double[] halfNumbers;

        @Override
        public void run() {
            for (int i = 0; i < halfNumbers.length; i++) {
                halfNumbers[i] = (float) (halfNumbers[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }

        public void setHalfNumbers(double[] halfNumbers) {
            this.halfNumbers = halfNumbers;
        }
    }

}
