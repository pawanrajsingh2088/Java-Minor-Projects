
import java.util.Scanner;

public class SchedulingMaster {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of processes: ");
        int n = sc.nextInt();
        
        int[] processes = new int[n];
        int[] burstTime = new int[n];
        int[] priority = new int[n];

        for (int i = 0; i < n; i++) {
            processes[i] = i + 1;
            System.out.println("Enter burst time for process " + (i + 1) + ": ");
            burstTime[i] = sc.nextInt();
            System.out.println("Enter priority for process " + (i + 1) + ": ");
            priority[i] = sc.nextInt();
        }

        System.out.println("Choose an option: ");
        System.out.println("1. Select a scheduling algorithm");
        System.out.println("2. Let the system suggest the best algorithm");

        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.println("Choose a scheduling algorithm:");
            System.out.println("1. FCFS");
            System.out.println("2. SJF");
            System.out.println("3. Round Robin");
            System.out.println("4. Priority Scheduling");
            int algoChoice = sc.nextInt();

            switch (algoChoice) {
                case 1:
                    FCFS.fcfsScheduling(processes, burstTime);
                    break;
                case 2:
                    SJF.sjfScheduling(processes, burstTime);
                    break;
                case 3:
                    System.out.println("Enter time quantum for Round Robin: ");
                    int quantum = sc.nextInt();
                    RoundRobin.roundRobinScheduling(processes, burstTime, quantum);
                    break;
                case 4:
                    PriorityScheduling.priorityScheduling(processes, burstTime, priority);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } else if (choice == 2) {
            // Basic suggestion logic: choose based on burst time variation
            int maxBurst = burstTime[0], minBurst = burstTime[0];
            for (int i = 1; i < n; i++) {
                if (burstTime[i] > maxBurst) maxBurst = burstTime[i];
                if (burstTime[i] < minBurst) minBurst = burstTime[i];
            }

            if (maxBurst - minBurst > 10) {
                System.out.println("System suggests: SJF Scheduling");
                SJF.sjfScheduling(processes, burstTime);
            } else {
                System.out.println("System suggests: FCFS Scheduling");
                FCFS.fcfsScheduling(processes, burstTime);
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }
    
}
