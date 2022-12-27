import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Ex2_1{
    // delete all files in fileNames array
    public static void deleteFiles(String[] fileNames){
        for(int i = 0; i < fileNames.length; i++){
            File file = new File(fileNames[i]);
            file.delete();
        }
    }
    /**
     * Creates n text files with random numbers in each file, returns the file names in an array
     * @param n - number of files to create
     * @param seed - seed for random number generator
     * @param bound - upper bound for random number generator
     * @return fileNames
     */
    public static String[] createTextFiles(int n, int seed, int bound){
        String[] fileNames = new String[n];
        Random rand = new Random(seed);
        for(int i = 0; i < n; i++){
            try{
                fileNames[i] = "file" + i + ".txt";
                PrintWriter writer = new PrintWriter(fileNames[i], "UTF-8");
                for(int j = 0; j < rand.nextInt(bound); j++){
                    writer.println("hello world!");
                }
                writer.close();
            }catch(IOException e){
                System.out.println("Error: " + e);
            }
        }
        return fileNames;
    }
    /**
     * Returns the number of lines in the files in fileNames array
     * @param fileNames - array of file names
     * @return numOfLines - number of lines in all files
     */
    public static int getNumOfLines(String[] fileNames){
        int numOfLines = 0;
        for(int i = 0; i < fileNames.length; i++){
            try{
                BufferedReader reader = new BufferedReader(new FileReader(fileNames[i]));
                while(reader.readLine() != null){
                    numOfLines++;
                }
                reader.close();
            }catch(IOException e){
                System.out.println("Error: " + e);
            }
        }
        return numOfLines;
    }
    public static void main(String[] args) throws IOException{
        String[] fileNames = createTextFiles(5, 1, 100);
        for(int i = 0; i < fileNames.length; i++){
            System.out.println(fileNames[i]);
        }
        System.out.println("Number of lines: " + getNumOfLines(fileNames));
        deleteFiles(fileNames);
    }
}