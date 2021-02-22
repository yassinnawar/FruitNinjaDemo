package Tools;

    public class StopWatch {

        private final long startTime;

        public StopWatch() {

            startTime = System.currentTimeMillis();
        }



        public double getElapsedTimeSeconds() { return (System.currentTimeMillis() - startTime) / 1000.0; }

    }






