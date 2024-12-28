# Nama : Mufid Bahaudin Nugroho
# NIM : 22106050021

class Matrix:
    def __init__(self, rows, cols):
        self.rows = rows
        self.cols = cols
        self.matrix = [[0] * cols for _ in range(rows)]

    def set_element(self, row, col, value):
        self.matrix[row][col] = value

    def row_wise_traversal(self):
        print("Row-wise traversal:")
        for row in self.matrix:
            print(" ".join(map(str, row)))

    def column_wise_traversal(self):
        print("Column-wise traversal:")
        for col in range(self.cols):
            for row in range(self.rows):
                print(self.matrix[row][col], end=" ")
            print()

    def rotate_clockwise(self):
        print("Clockwise rotation:")
        rotated = [[0] * self.rows for _ in range(self.cols)]
        for i in range(self.rows):
            for j in range(self.cols):
                rotated[j][self.rows - 1 - i] = self.matrix[i][j]
        self.print_matrix(rotated, self.cols, self.rows)

    def transpose(self):
        print("Transpose matrix:")
        transposed = [[0] * self.rows for _ in range(self.cols)]
        for i in range(self.rows):
            for j in range(self.cols):
                transposed[j][i] = self.matrix[i][j]
        self.print_matrix(transposed, self.cols, self.rows)

    def print_matrix(self, mat, row_count, col_count):
        for row in mat:
            print(" ".join(map(str, row)))


def main():
    # Initialize a 3x3 matrix with some values
    matrix = Matrix(3, 3)
    values = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]

    for i in range(3):
        for j in range(3):
            matrix.set_element(i, j, values[i][j])

    while True:
        print("\nMENU:")
        print("1. Row-wise traversal")
        print("2. Column-wise traversal")
        print("3. Clock-wise rotate matrix")
        print("4. Transpose matrix")
        print("5. Quit")
        choice = int(input("Enter your choice: "))

        if choice == 1:
            matrix.row_wise_traversal()
        elif choice == 2:
            matrix.column_wise_traversal()
        elif choice == 3:
            matrix.rotate_clockwise()
        elif choice == 4:
            matrix.transpose()
        elif choice == 5:
            print("Keluar dari program")
            break
        else:
            print("Pilihan invalid, silakan coba lagi!")

if __name__ == "__main__":
    main()
