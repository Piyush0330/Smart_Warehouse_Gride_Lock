
class GridItem {
    String itemId;
    String itemName;
    int quantity;

   
    GridItem(String itemId, String itemName, int quantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    
    void display() {
        System.out.println(itemId + " - " + itemName + " - Qty: " + quantity);
    }
}


class Warehouse {
    GridItem[][] grid;
    int rows, cols;

    
    Warehouse(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new GridItem[rows][cols];
    }

    
    void addItem(int row, int col, GridItem item) {
        grid[row][col] = item;
    }

    void searchItem(String id) {
        boolean found = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] != null && grid[i][j].itemId.equals(id)) {
                    System.out.println("Item Found at Row: " + i + ", Column: " + j);
                    grid[i][j].display();
                    found = true;
                    return;
                }
            }
        }

        if (!found) {
            System.out.println("Item not found in warehouse");
        }
    }

   
    void displayGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != null) {
                    System.out.print("[" + grid[i][j].itemId + "] ");
                } else {
                    System.out.print("[Empty] ");
                }
            }
            System.out.println();
        }
    }
}


public class Main {
    public static void main(String[] args) {

        
        Warehouse warehouse = new Warehouse(3, 3);

       
        warehouse.addItem(0, 0, new GridItem("I101", "Laptop", 10));
        warehouse.addItem(1, 2, new GridItem("I102", "Phone", 25));
        warehouse.addItem(2, 1, new GridItem("I103", "Tablet", 15));

       
        System.out.println("Warehouse Grid:");
        warehouse.displayGrid();

        
        System.out.println("\nSearching for I102:");
        warehouse.searchItem("I102");

        System.out.println("\nSearching for I999:");
        warehouse.searchItem("I999");
    }
}
