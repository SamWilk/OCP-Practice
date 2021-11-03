package EggsBaconSpam;

import java.io.*;
import java.util.*;

public class Breakfast{

    //Constructor
    public Breakfast(String inputFile) throws IOException{

        try{

            System.out.println("Being read");
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            
            String line;
            while((line = reader.readLine()) != null){
                //Will be the number of orders for the the day
                int k = Integer.parseInt(line);
                if(k == 0){//When the file is done reading
                    break;
                }
                //System.out.println("Number of Orders: " + k);
                for(int i = 0; i < k; i++){
                    //System.out.println(line = reader.readLine());
                    line = reader.readLine();
                    setQueues(line);
                }
                
            }

            reader.close();
        }catch(IOException e){
            System.err.println("No File found");
        }
        

    }

    //Gobals
    //List<Queue<String>> Items = new ArrayList<Queue<String>>();//Is a simple linked list of Queues
    PriorityQueue<String> Items = new PriorityQueue<String>();//Prior queue will sort strings lexio
    PriorityQueue<PriorityQueue<String>> OrderList = new PriorityQueue<PriorityQueue<String>>();
    TreeSet<String> Names = new TreeSet<String>();//Acts as red-black tree

    //Creates the priority queue so that the items that have been ordered
    //are sorted leziographically
    private void setQueues(String values){
        String[] tokens;
        tokens = values.split(" ");

        String name = tokens[0];
        Names.add(name);//Adds to the tree of names
        int strLen = tokens.length - 1;
        for(int i = 1; i <= strLen; i++){
            if(Items.contains(tokens[i]) == false){
                Items.add(tokens[i]);
                OrderList.add(Items);//For this to work I need to make a new Queue each time
            }
        }


    }

    public void displayItems(){
        int size = Items.size() - 1;
        for(int i = 0; i <= size; i++){
            System.out.println("Item: " + Items.poll());
        }
        int k = Names.size();
        for(int i = 0; i <= k - 1; i++){
            System.out.println("Names: " + Names.pollLast());
        }
    }
     
}
