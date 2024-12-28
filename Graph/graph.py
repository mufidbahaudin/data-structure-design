# Nama : Mufid Bahaudin Nugroho
# NIM : 22106050021
from collections import deque, defaultdict

class Graph:
    def __init__(self, num_vertices):
        self.num_vertices = num_vertices
        self.adj_list = defaultdict(list)
    
    def add_edge(self, u, v):
        self.adj_list[u].append(v)
        self.adj_list[v].append(u)  # For undirected graph
    
    def transpose(self):
        transposed_graph = Graph(self.num_vertices)
        for u in self.adj_list:
            for v in self.adj_list[u]:
                transposed_graph.adj_list[v].append(u)
        return transposed_graph
    
    def bfs(self, start):
        visited = [False] * self.num_vertices
        queue = deque([start])
        visited[start] = True
        
        while queue:
            u = queue.popleft()
            print(u, end=' ')
            
            for v in self.adj_list[u]:
                if not visited[v]:
                    visited[v] = True
                    queue.append(v)
        print()
    
    def dfs_util(self, v, visited):
        visited[v] = True
        print(v, end=' ')
        
        for u in self.adj_list[v]:
            if not visited[u]:
                self.dfs_util(u, visited)
    
    def dfs(self, start):
        visited = [False] * self.num_vertices
        self.dfs_util(start, visited)
        print()
    
    def print_adj_list(self):
        for i in range(self.num_vertices):
            print(f"{i} -> {' '.join(map(str, self.adj_list[i]))}")

def create_adjacency_list(edges, num_vertices):
    graph = Graph(num_vertices)
    for u, v in edges:
        graph.add_edge(u, v)
    return graph

if __name__ == "__main__":
    num_vertices = 6
    edges = [(1, 0), (2, 0), (3, 0), (4, 2), (5, 3)]
    
    graph = create_adjacency_list(edges, num_vertices)

    while True:
        print("MENU:")
        print("1. Transpose graph")
        print("2. BFS graph")
        print("3. DFS graph")
        print("4. Quit")
        choice = int(input("Enter your choice: "))

        if choice == 1:
            transposed_graph = graph.transpose()
            print("Transposed Graph Adjacency List:")
            transposed_graph.print_adj_list()
        elif choice == 2:
            start_vertex = int(input("Enter start vertex for BFS: "))
            print(f"BFS traversal starting from vertex {start_vertex}:")
            graph.bfs(start_vertex)
        elif choice == 3:
            start_vertex = int(input("Enter start vertex for DFS: "))
            print(f"DFS traversal starting from vertex {start_vertex}:")
            graph.dfs(start_vertex)
        elif choice == 4:
            print("Keluar dari program")
            break
        else:
            print("Pilihan invalid, silakan coba lagi")
