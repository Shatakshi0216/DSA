// Class to represent a task with its remaining frequency and next valid execution time
class Task {
    int fre;       // remaining frequency (how many times it still needs to be executed)
    int exeTime;   // time after which this task can be scheduled again

    Task(int f, int et) {
        fre = f;
        exeTime = et;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count the frequency of each task
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Max heap based on task frequency (higher frequency comes first)
        PriorityQueue<Task> maxHeap = new PriorityQueue<>((a, b) -> b.fre - a.fre);
        for (char ch : map.keySet()) {
            int fre = map.get(ch);
            maxHeap.offer(new Task(fre, 0)); // initially no cooldown time needed
        }

        // Step 3: Queue to hold tasks in their cooldown period
        Queue<Task> queue = new LinkedList<>();

        int time = 0; // Tracks the total time required

        // Step 4: Simulate time step-by-step
        while (!queue.isEmpty() || !maxHeap.isEmpty()) {
            time++; // Move forward in time

            // Check if any task's cooldown has finished — move it back to maxHeap
            if (!queue.isEmpty() && queue.peek().exeTime == time) {
                maxHeap.offer(queue.poll());
            }

            // If there’s a task available to execute, pick the most frequent one
            if (!maxHeap.isEmpty()) {
                Task task = maxHeap.poll(); // take the task with max remaining frequency
                task.fre--; // one instance of the task is completed

                // If task still needs to run, put it into cooldown queue
                if (task.fre > 0) {
                    task.exeTime = time + n + 1; // it can be run again after 'n' idle slots
                    queue.offer(task); // put in cooldown
                }
            }
            // else, if no task to run from heap, it’s idle time (but time is already incremented)
        }

        // Return the total time taken
        return time;
    }
}
