package EggsBaconSpam;

import java.io.*;

public class Breakfast{
    


    //Constructor
    public Breakfast(String inputFile) throws IOException{
        try{

            System.out.println("Being read");
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            
            String tokens[];
            String line;
            while((line = reader.readLine()) != null){
                //Will be the number of orders for the the day
                int k = Integer.parseInt(line);
                if(k == 0){//When the file is done reading
                    break;
                }
                System.out.println("Number of Orders: " + k);
                for(int i = 0; i < k; i++){
                    System.out.println(line = reader.readLine());
                }
                
            }

            reader.close();
        }catch(IOException e){
            System.err.println("No File found");
        }
    }

     
}
