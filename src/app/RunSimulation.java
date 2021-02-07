package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RunSimulation {

    private Random random = new Random();

    //n is equals to number of time steps
    public void run(int n) {
        List<Queue> startingQueue = populateStartingQueues(n);
        Duck duck;

        for (int i = 1; 1 <= (n - i) * (n - i); i++) {

            List<Queue> emptyQueuesTemp = createEmptyQueues(n - i); //create empty queues with the number of queues depending on current time step
            for (int j = 0; j < (n - i) * (n - i); j++) {

                boolean isFetched = false; //Checks if a duck is fetched from the starting queue
                boolean isAddedToNewQueue = false; //Checks if a duck is added to a new queue

                while (!isFetched) {
                    int randomTemp = randomNumber(i, n) + 1; //Queue number to get foremost duck
                    duck = startingQueue.get(randomTemp).getDuck(); //Get duck by using peek and removing it from starting queue

                    if (duck != null) {
                        while (!isAddedToNewQueue) {
                            int randomTemp2 = randomNumber(i, n); //Queue number to add duck to

                            if (emptyQueuesTemp.get(randomTemp2).size() < n - i) { //checks if queue number is full
                                emptyQueuesTemp.get(randomTemp2).addToQueue(duck); //add duck to next time step queues if not full
                                isAddedToNewQueue = true;
                            }
                        }
                        isFetched = true;
                    } else {
                        isFetched = false;
                    }
                }
            }

            startingQueue.clear(); //remove all duck that didnt make it to next time step
            startingQueue.addAll(emptyQueuesTemp); //Add all ducks that made it to next time step to starting queue

            //Display winner then Queue size is 1
            if (startingQueue.size() == 1) {
                displayWinner(emptyQueuesTemp.get(0).getQueue().get(0));
            }

        }
    }

    //populate starting queues
    public List populateStartingQueues(int n) {
        List<Queue> tempQueue = createEmptyQueues(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tempQueue.get(i).addToQueue(new Duck());
            }
        }
        return tempQueue;
    }


    //create a list of empty queues
    public List createEmptyQueues(int numberOfQueues) {
        List<Queue> queues = new ArrayList<>();
        for (int i = 0; i < numberOfQueues; i++) {
            Queue queue = new Queue();
            queues.add(queue);
        }
        return queues;
    }

    //Gets a random number in each time step
    public int randomNumber(int i, int n) {
        return random.nextInt(n - i);
    }

    public void displayWinner(Duck duck) {
        System.out.println("-----------------------------");
        System.out.println("-- WINNER " + duck);
        System.out.println("-----------------------------");
    }


}
