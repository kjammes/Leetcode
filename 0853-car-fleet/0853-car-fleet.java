class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        PosSpeed[] cars = new PosSpeed[len];

        for (int i = 0; i < len; i++) {
            cars[i] = new PosSpeed(position[i], speed[i], target);
        }
        Arrays.sort(cars, (a, b) -> Double.compare(b.pos, a.pos));

        int res = 0;
        double currTime = -1;
        for (int i = 0; i < len; i++) {
            PosSpeed car = cars[i];
            double time = car.timeToTarget;
            if (time > currTime) {
                currTime = time;
                res++;
            }
        }

        return res;
    }
}

class PosSpeed {
    double pos;
    double speed;
    double timeToTarget;

    PosSpeed(int pos, int s, int target) {
        this.pos = (double) pos;
        this.speed = (double) s;
        timeToTarget = (target - this.pos) / this.speed;
    }

}
