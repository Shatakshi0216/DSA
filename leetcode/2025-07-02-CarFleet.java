import java.util.*;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // Step 1: Create [position, time] pairs
        List<double[]> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double time = (double)(target - position[i]) / speed[i];
            pairs.add(new double[] { position[i], time });
        }

        // Step 2: Sort cars by position in descending order
        pairs.sort((a, b) -> Double.compare(b[0], a[0]));

        // Step 3: Count fleets using just lastTime (no need for full stack)
        int fleets = 0;
        double lastTime = 0.0;

        for (double[] car : pairs) {
            double currentTime = car[1];

            if (currentTime > lastTime) {
                fleets++;               // New fleet starts
                lastTime = currentTime; // Update last fleet time
            }
            // else: current car joins an existing fleet
        }

        return fleets;
    }
}
