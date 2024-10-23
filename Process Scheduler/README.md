
# Process Scheduling Algorithms in Java

This project provides Java implementations of four essential CPU process scheduling algorithms:

- **FCFS (First-Come, First-Served)**
- **SJF (Shortest Job First)**
- **Round Robin**
- **Priority Scheduling**

## Overview

These scheduling algorithms are used in operating systems to determine the order in which processes are executed by the CPU. The project also includes a **master program** that allows users to either:

1. Choose a specific scheduling algorithm to apply, or
2. Let the system suggest the best scheduling algorithm based on the inputted process details.

## Files

| Filename               | Description                          |
|------------------------|--------------------------------------|
| FCFS.java              | First-Come, First-Served scheduling  |
| SJF.java               | Shortest Job First scheduling        |
| RoundRobin.java        | Round Robin scheduling               |
| PriorityScheduling.java| Priority Queue scheduling            |
| SchedulingMaster.java  | Main program to select/suggest algorithm |

## Usage

1. **Compile all files**: Ensure all the files are compiled before running.
2. **Run the master program**: 
   - To run the master program, execute `SchedulingMaster.java`:
     ```
     javac SchedulingMaster.java
     java SchedulingMaster
     ```

3. **Input Details**: 
   - You will be asked to enter the number of processes, burst time, and priority for each process.
   - Based on your choice, either select a scheduling algorithm manually or let the system recommend one.

## Where It Can Be Used

These scheduling algorithms are essential in operating systems to efficiently manage process execution and CPU time allocation. They are used in:

- **Operating Systems**: For managing CPU scheduling.
- **Embedded Systems**: To manage tasks on microcontrollers.
- **Real-Time Systems**: To prioritize critical tasks in real-time environments.

Each algorithm offers different advantages depending on the workload, making this project a useful reference for understanding and applying scheduling techniques.


