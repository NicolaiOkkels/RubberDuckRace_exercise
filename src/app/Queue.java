package app;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
    private List<T> queue = new ArrayList<>();

    public void addToQueue(T obj){
            queue.add(obj);
    }

    public void removeFromQueue(){
        queue.remove(0);
    }

    public List<T> getQueue() {
        return queue;
    }

    public T peek(){
        return queue.get(0);
    }

    public int size(){
        return queue.size();
    }

    public T getDuck(){
        T obj;
        if(queue.size()>0){
            obj = peek();
            removeFromQueue();
            return obj;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Queue{" +
                "queue=" + queue +
                '}';
    }
}
