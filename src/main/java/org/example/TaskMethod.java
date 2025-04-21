package org.example;
import java.util.*;

public class TaskMethod {

    private Queue<Task> taskQueue;

    public TaskMethod() {
        taskQueue = new LinkedList<>();
//        taskInitialize();
    }

    public void taskInitialize() {
        taskQueue.add(new Task("Clean dishes", 3));
        taskQueue.add(new Task("Do laundry", 2));
        taskQueue.add(new Task("Walk the dog", 1));
        taskQueue.add(new Task("Pay bills", 2));
    }

    public void addTaskToQueue(Task task) {
        if (task == null) {
            throw new IllegalArgumentException();
        }
        taskQueue.add(task);
    }

    public Task processNextTaskFromQueue() {
        return taskQueue.poll();
    }

    public Task peekAtNextTaskInQueue() {
       return taskQueue.peek();
    }

    public int getTaskQueueSize() {
        return taskQueue.size();
    }

    public List<Task> getTasksWithPriority(int priority) {

        List<Task> priorityTasks = new ArrayList<>();

        for (Task currentTask : taskQueue) {
            if (currentTask.getPriority() == priority) {
                priorityTasks.add(currentTask);
            }
        }
        return priorityTasks;
    }

    public void moveTaskToBack(int numberOfPositions) {

        if (numberOfPositions <= 0 || numberOfPositions >= getTaskQueueSize()) {
            throw new IllegalArgumentException();
        }

        Task targetTask = processNextTaskFromQueue();

        List<Task> queueList = new ArrayList<>(taskQueue);
        queueList.add(numberOfPositions - 1, targetTask);

        taskQueue.clear();
        taskQueue.addAll(queueList);

    }

    public static void main( String[] args )
    {
//        TaskMethod test = new TaskMethod();
//        Task testTask = new Task("Garbage", 3);
//
//        test.addTaskToQueue(testTask);
//
//        test.taskQueue.forEach((task ->  {
//            System.out.println(task.getDescription());
//        }));
//
//        System.out.println(test.getTaskQueueSize());


    }
}
