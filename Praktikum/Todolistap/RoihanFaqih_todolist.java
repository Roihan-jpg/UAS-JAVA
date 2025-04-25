import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String taskName;
    boolean isCompleted;

    public Task(String taskName) {
        this.taskName = taskName;
        this.isCompleted = false;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return (isCompleted ? "[!] " : "[ ] ") + taskName;
    }
}

public class RoihanFaqih_todolist {
    private ArrayList<Task> todoList;

    public RoihanFaqih_todolist() {
        todoList = new ArrayList<>();
    }

    public void addTask(String task) {
        todoList.add(new Task(task));
        System.out.println("Task added successfully!");
    }

    public void removeTask(String task) {
        if (todoList.remove(task)) {
            System.out.println("Task removed successfully!");
        } else {
            System.out.println("Task not found!");
        }
    }

    public void removeTaskbyIndex(int index) {
        if (index >= 0 && index < todoList.size()) {
            todoList.remove(index);
            System.out.println("Task removed successfully!");
        } else {
            System.out.println("Invalid index!");
        }
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < todoList.size()) {
            todoList.get(index).markAsCompleted();
            System.out.println("Task marked as completed!");
        } else {
            System.out.println("Invalid index!");
        }
    }

    public void displayTasks() {
        if (todoList.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("To-Do List:");
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println((i + 1) + ". " + todoList.get(i));
            }
        }
    }

    public static void main(String[] args) {
        RoihanFaqih_todolist app = new RoihanFaqih_todolist();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nTo-Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task by Index");
            System.out.println("3. Remove Task By Task Name");
            System.out.println("4. Mark Task as Completed");
            System.out.println("5. Display Tasks");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task to add: ");
                    String taskToAdd = scanner.nextLine();
                    app.addTask(taskToAdd);
                    break;

                case 2:
                    System.out.print("Enter task to remove: ");
                    String taskToRemove = scanner.nextLine();
                    app.removeTask(taskToRemove);
                    break;

                case 3:
                    System.out.print("Enter task index to remove: ");
                    int indexToRemove = scanner.nextInt() - 1;
                    app.removeTaskbyIndex(indexToRemove);
                    break;

                case 4:
                    System.out.print("Enter task index to mark as completed: ");
                    int indexToComplete = scanner.nextInt() - 1;
                    app.markTaskAsCompleted(indexToComplete);
                    break;

                case 5:
                    app.displayTasks();
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting the application...");
                    break;
                

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
