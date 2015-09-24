package edu.upc.eetac.dsa.alejandro;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        if (args.length!=1){
            System.out.println("System needs the path with the numbers file.");
            System.exit(-1);
        }
        try{
            double average = AverageCalculator.average(args[0]);
            System.out.println("Average: "+average);
        }catch (FileParsingException e){
            e.printStackTrace();
        }catch (BigNumberException e){
            e.printStackTrace();
        }
    }
}
