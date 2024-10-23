import java.util.Scanner;

public class RoundRobin {
    public static void roundRobinScheduling(int[] processes, int[] burstTime, int quantum) {
        int n = processes.length;
        int[] remainingBurstTime = new int[n];
        int[] waitTime = new int[n];
        int totalWaitTime = 0, totalTurnAroundTime = 0, t = 0;
        
        for (int i = 0; i < n; i++) {
            remainingBurstTime[i] = burstTime[i];
        }
        
        while (true) {
            boolean done = true;
            
            for (int i = 0; i < n; i++) {
                if (remainingBurstTime[i] > 0) {
                    done = false;
                    
                    if (remainingBurstTime[i] > quantum) {
                        t += quantum;
                        remainingBurstTime[i] -= quantum;
                    } else {
                        t += remainingBurstTime[i];
                        waitTime[i] = t - burstTime[i];
                        remainingBurstTime[i] = 0;
                    }
                }
            }
            
            if (done) break;
        }
        
        System.out.println("Process\tBurst Time\tWaiting Time\tTurnaround Time");
        for (int i = 0; i < n; i++) {
            int turnAroundTime = burstTime[i] + waitTime[i];
            System.out.println(processes[i] + "\t\t" + burstTime[i] + "\t\t" + waitTime[i] + "\t\t" + turnAroundTime);
            totalWaitTime += waitTime[i];
            totalTurnAroundTime += turnAroundTime;
        }
        
        System.out.println("Average waiting time: " + (float) totalWaitTime / n);
        System.out.println("Average turnaround time: " + (float) totalTurnAroundTime / n);
    }
}
