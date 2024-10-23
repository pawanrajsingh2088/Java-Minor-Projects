import java.util.Scanner;

public class PriorityScheduling {
    public static void priorityScheduling(int[] processes, int[] burstTime, int[] priority) {
        int n = processes.length;
        int[] waitTime = new int[n];
        int[] turnAroundTime = new int[n];
        int totalWaitTime = 0, totalTurnAroundTime = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (priority[i] > priority[j]) {
                    int temp = burstTime[i];
                    burstTime[i] = burstTime[j];
                    burstTime[j] = temp;
                    
                    temp = priority[i];
                    priority[i] = priority[j];
                    priority[j] = temp;
                }
            }
        }
        
        waitTime[0] = 0;
        for (int i = 1; i < n; i++) {
            waitTime[i] = burstTime[i - 1] + waitTime[i - 1];
        }
        
        for (int i = 0; i < n; i++) {
            turnAroundTime[i] = burstTime[i] + waitTime[i];
            totalWaitTime += waitTime[i];
            totalTurnAroundTime += turnAroundTime[i];
        }
        
        System.out.println("Process\tBurst Time\tPriority\tWaiting Time\tTurnaround Time");
        for (int i = 0; i < n; i++) {
            System.out.println(processes[i] + "\t\t" + burstTime[i] + "\t\t" + priority[i] + "\t\t" + waitTime[i] + "\t\t" + turnAroundTime[i]);
        }
        
        System.out.println("Average waiting time: " + (float) totalWaitTime / n);
        System.out.println("Average turnaround time: " + (float) totalTurnAroundTime / n);
    }
}
