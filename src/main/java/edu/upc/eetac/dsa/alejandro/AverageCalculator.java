package edu.upc.eetac.dsa.alejandro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Alex on 24/9/15.
 */
public class AverageCalculator {
    public static final double average (String file) throws FileParsingException, BigNumberException{
        double counter=0d;
        double sum =0d;
        BufferedReader reader =null;
        try{
            reader = new BufferedReader(new FileReader(file));
            String line =null;
            while ((line=reader.readLine()) != null){
                try{
                 int number = Integer.parseInt(line);
                    if (number >= 1000)
                        throw new BigNumberException ("Number greater than 1000 at line " +(int) (++counter));
                    sum+=number;
                    counter++;
                }
                catch (NumberFormatException e){
                    throw new FileParsingException(e.getMessage());
                }
            }
        }catch (java.io.IOException e){
            throw new FileParsingException(e.getMessage());
        }finally{
            try {
                reader.close();
            }catch (IOException e){
                System.out.println("Warniiing!: Can't close file.");
            }
        }
        return sum/counter;
    }
}
