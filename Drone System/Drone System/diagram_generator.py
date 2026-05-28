import graphviz

# ==============================
# 1. SYSTEM ARCHITECTURE
# ==============================
g1 = graphviz.Digraph()

g1.node('L1', 'Laptop 1\n(Drones + ZooKeeper)')
g1.node('L2', 'Laptop 2\n(Hadoop HDFS)')

g1.edge('L1', 'L2', label='Send Logs')

g1.render('system_architecture', format='png', cleanup=True)


# ==============================
# 2. MUTUAL EXCLUSION
# ==============================
g2 = graphviz.Digraph()

g2.node('D1', 'Drone 1 (Running)')
g2.node('D2', 'Drone 2 (Waiting)')
g2.node('D3', 'Drone 3 (Waiting)')
g2.node('CS', 'Critical Section')

g2.edge('D1', 'CS')
g2.edge('D2', 'CS', label='Wait')
g2.edge('D3', 'CS', label='Wait')

g2.render('mutual_exclusion', format='png', cleanup=True)


# ==============================
# 3. DEADLOCK
# ==============================
g3 = graphviz.Digraph()

g3.node('D1', 'Drone 1')
g3.node('D2', 'Drone 2')
g3.node('Z1', 'Zone 1')
g3.node('Z2', 'Zone 2')

g3.edge('D1', 'Z1', label='holds')
g3.edge('Z1', 'D2', label='wait')
g3.edge('D2', 'Z2', label='holds')
g3.edge('Z2', 'D1', label='wait')

g3.render('deadlock', format='png', cleanup=True)


# ==============================
# 4. HDFS STORAGE
# ==============================
g4 = graphviz.Digraph()

g4.node('Client', 'Laptop 1\n(Drone System)')
g4.node('NN', 'NameNode')
g4.node('DN', 'DataNode')

g4.edge('Client', 'NN', label='Request')
g4.edge('NN', 'DN', label='Store Log')
g4.edge('DN', 'Client', label='Success')

g4.render('hdfs_architecture', format='png', cleanup=True)


print("All diagrams generated successfully!")