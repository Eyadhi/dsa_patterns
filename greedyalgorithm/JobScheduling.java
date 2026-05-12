package techniques.greedyalgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Job {
    int id;
    int deadline;
    int profit;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobScheduling {

    public static List<Job> scheduleJobs(List<Job> jobs) {
        // Sort the jobs in descending order of profits
        Collections.sort(jobs, Comparator.comparingInt(j -> j.profit));
        Collections.reverse(jobs);

        int maxDeadline = getMaxDeadline(jobs);
        boolean[] slots = new boolean[maxDeadline + 1];
        List<Job> scheduledJobs = new ArrayList<>();

        // Iterate through the sorted jobs
        for (Job job : jobs) {
            // Find a slot for the current job, starting from its deadline
            for (int i = job.deadline; i > 0; i--) {
                // If a slot is available, schedule the job and mark the slot as occupied
                if (!slots[i]) {
                    slots[i] = true;
                    scheduledJobs.add(job);
                    break;
                }
            }
        }

        return scheduledJobs;
    }

    private static int getMaxDeadline(List<Job> jobs) {
        int maxDeadline = Integer.MIN_VALUE;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }
        return maxDeadline;
    }

    public static void main(String[] args) {
        // Create a list of jobs with their respective deadlines and profits
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job(1, 4, 20));
        jobs.add(new Job(2, 1, 10));
        jobs.add(new Job(3, 1, 40));
        jobs.add(new Job(4, 2, 30));

        // Schedule the jobs
        List<Job> scheduledJobs = scheduleJobs(jobs);

        // Print the scheduled jobs
        System.out.println("Scheduled Jobs:");
        for (Job job : scheduledJobs) {
            System.out.println("Job " + job.id + " with profit " + job.profit);
        }
    }
}
