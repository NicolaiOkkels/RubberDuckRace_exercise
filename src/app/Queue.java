package app;

import java.util.ArrayList;
import java.util.List;

public class Queue {
    private List<Duck> queue = new ArrayList<>();

    public boolean addToQueue(Duck duck, int maxElementInQueue){
        if(queue.size()<maxElementInQueue){
            queue.add(duck);
            return true;
        } else{
            return false;
        }
    }

    public void removeFromQueue(){
        queue.remove(0);
    }

    public List<Duck> getQueue() {
        return queue;
    }

    public Duck peek(){
        return queue.get(0);
    }

    public int size(){
        return queue.size();
    }

    public Duck getDuck(){
        Duck duck;
        if(queue.size()>0){
            duck = peek();
            removeFromQueue();
            return duck;
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
