# Drone Fleet Airspace Coordination System

## Project Overview
The Drone Fleet Airspace Coordination System is a distributed systems project designed to simulate safe coordination between multiple drones operating in shared airspace. The system demonstrates important distributed system concepts such as:

- Distributed Mutual Exclusion
- Distributed Deadlock Detection
- Distributed Coordination using Apache ZooKeeper
- Distributed Log Storage using Hadoop HDFS

The project ensures that only one drone can access a critical airspace zone at a time, preventing collisions and unsafe operations. It also simulates deadlock situations where drones wait indefinitely for each other’s resources.

This project was implemented using Java, Apache ZooKeeper, and Apache Hadoop HDFS in a real distributed environment using multiple laptops. :contentReference[oaicite:0]{index=0}

---

# Abstract
The project demonstrates the application of distributed system concepts to manage shared airspace among multiple drones. Apache ZooKeeper is used for synchronization and distributed mutual exclusion, while Hadoop HDFS is used for distributed storage of execution logs.

The system:
- Prevents multiple drones from entering the same zone simultaneously
- Detects circular wait deadlock conditions
- Stores execution logs in distributed storage
- Simulates real-world distributed coordination systems

The project provides practical implementation of distributed systems beyond theoretical concepts. :contentReference[oaicite:1]{index=1}

---

# Objectives

The major objectives of this project are:

- Ensure only one drone accesses a critical zone at a time
- Implement distributed mutual exclusion
- Simulate and detect deadlocks
- Store execution logs using Hadoop HDFS
- Demonstrate coordination among distributed nodes
- Build a scalable distributed drone coordination system
- Integrate distributed coordination and distributed storage together

:contentReference[oaicite:2]{index=2}

---

# Real-World Scenario

Modern drone systems require safe coordination while operating in shared airspace. Multiple drones may attempt to access the same restricted area simultaneously, creating unsafe conditions.

This project simulates:
- Drone delivery systems
- Airspace traffic coordination
- Shared landing zones
- Multi-agent coordination systems

The system ensures safe resource sharing using distributed locks and deadlock handling mechanisms. :contentReference[oaicite:3]{index=3}

---

# Distributed System Concepts Used

## 1. Distributed Mutual Exclusion
Ensures only one drone can enter a shared airspace zone at a time.

### Implemented Using:
- Apache ZooKeeper distributed locks
- Sequential znodes
- Lock acquisition and release mechanisms

### Result:
- Prevents collisions
- Ensures synchronization
- Maintains consistency

:contentReference[oaicite:4]{index=4}

---

## 2. Distributed Deadlock Detection

Deadlock occurs when:
- Drone 1 holds Zone 1 and waits for Zone 2
- Drone 2 holds Zone 2 and waits for Zone 1

This creates a circular wait condition.

### Features:
- Simulates resource dependency
- Detects circular waiting
- Generates deadlock detection logs

:contentReference[oaicite:5]{index=5}

---

# Hadoop Product Used

## Hadoop Distributed File System (HDFS)

HDFS is used for:
- Distributed storage of drone logs
- Reliable data storage
- Fault-tolerant storage management

### Logs Stored:
- Drone entry logs
- Waiting state logs
- Deadlock detection logs
- Execution activities

### Commands Used:
```bash
hdfs dfs -mkdir /drone
hdfs dfs -put drone_log.txt /drone
hdfs dfs -cat /drone/drone_log.txt
```

:contentReference[oaicite:6]{index=6}

---

# Technologies Used

| Technology | Purpose |
|---|---|
| Java | Core implementation |
| Apache ZooKeeper | Distributed coordination |
| Apache Hadoop HDFS | Distributed storage |
| VS Code | Development |
| Command Prompt | Execution |
| Windows | Platform |

:contentReference[oaicite:7]{index=7}

---

# System Architecture

The system contains two main components:

## Laptop 1
- Runs Apache ZooKeeper
- Handles coordination
- Executes Drone 1
- Manages distributed locks

## Laptop 2
- Runs Hadoop HDFS
- Executes Drone 2 and Drone 3
- Stores logs in distributed storage

### Workflow:
1. Drones request zone access
2. ZooKeeper grants lock
3. Mutual exclusion enforced
4. Deadlock scenarios simulated
5. Logs generated
6. Logs stored in HDFS

The architecture separates:
- Coordination
- Storage

which reflects real-world distributed systems. :contentReference[oaicite:8]{index=8}

---

# Modules Implemented

## 1. Drone Simulation Module

### Files:
- Drone.java
- DeadlockDrone.java

### Functions:
- Simulates drone behavior
- Requests resource access
- Generates logs

:contentReference[oaicite:9]{index=9}

---

## 2. Lock Manager Module

### File:
- LockManager.java

### Functions:
- Mutual exclusion
- Lock acquisition
- Lock release
- ZooKeeper coordination

:contentReference[oaicite:10]{index=10}

---

## 3. Deadlock Detection Module

### File:
- DeadlockDrone.java

### Functions:
- Circular wait simulation
- Deadlock detection
- Resource dependency tracking

:contentReference[oaicite:11]{index=11}

---

## 4. ZooKeeper Connector

### File:
- ZooKeeperConnector.java

### Functions:
- Connect drones to ZooKeeper server
- Handle distributed coordination

:contentReference[oaicite:12]{index=12}

---

## 5. Hadoop HDFS Integration

### Functions:
- Store logs
- Retrieve logs
- Distributed storage management

:contentReference[oaicite:13]{index=13}

---

# Execution Flow

1. ZooKeeper server starts
2. Hadoop HDFS starts
3. Drones execute
4. Drones request locks
5. Mutual exclusion enforced
6. Deadlock simulated
7. Logs generated
8. Logs uploaded to HDFS
9. Logs retrieved from HDFS

:contentReference[oaicite:14]{index=14}

---

# Output Achieved

## Results Observed

### Mutual Exclusion
- Only one drone enters critical section

### Waiting Mechanism
- Other drones wait until lock release

### Deadlock Detection
- Circular wait successfully identified

### HDFS Storage
- Logs stored and retrieved correctly

:contentReference[oaicite:15]{index=15}

---

# Advantages

- Safe drone coordination
- Prevents airspace collisions
- Scalable distributed architecture
- Reliable distributed storage
- Real-time synchronization
- Deadlock simulation and analysis
- Fault-tolerant storage using HDFS

---

# Future Enhancements

Future improvements include:
- Multi-node distributed deployment
- Automated deadlock prevention
- Real-time monitoring dashboard
- Cloud-based storage
- Enhanced fault tolerance
- Security and authentication
- AI-based drone coordination

:contentReference[oaicite:16]{index=16}

---

# Conclusion

The project successfully demonstrates:
- Distributed coordination
- Mutual exclusion
- Deadlock detection
- Distributed storage

The integration of ZooKeeper and Hadoop HDFS creates a complete distributed system capable of handling real-world resource coordination scenarios.

The system is scalable, reliable, and provides practical implementation experience in distributed systems. :contentReference[oaicite:17]{index=17}

---

# GitHub Repository

Repository Link:

:contentReference[oaicite:18]{index=18}

---

# Authors

- M.V. Likith Kumar
- D. Kavya
- N. Bhavya Sri

School of Computer Science and Engineering

:contentReference[oaicite:19]{index=19}
