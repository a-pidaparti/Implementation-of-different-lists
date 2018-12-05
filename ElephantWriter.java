// written by pidap008

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class ElephantWriter {
    public static boolean readElephants(ElephantHerd e, String fileName){
        Scanner s = null;
        File file = null;
        try {
            file = new File(fileName);
            s = new Scanner(file);
        } catch(FileNotFoundException a){
            System.out.println("file not found/read");
            return false;
        }
        int elephantCount = 0;
        while (s.hasNextLine()){ //finds number of elephants
            elephantCount ++;
            s.nextLine();
        }
        Scanner s1;
        try {
            s1 = new Scanner(new File(fileName));
        } catch(Exception a){
            return false;
        }
        String initName = "";
        int initAge = 0;
        Double initHeight = 0.0;
        while (s1.hasNextLine()){
            String elephantInfo = s1.nextLine();
            String [] tokens = elephantInfo.split(" ");
            initName = tokens[0];
            initAge = Integer.parseInt(tokens[1]);
            initHeight = Double.parseDouble(tokens[2]);
            Elephant ellie = new Elephant(initName, initAge, initHeight);
            e.add(ellie);
        }
        return true;
    }

    public static boolean writeElephants(ElephantHerd e, String fileName){
        PrintWriter p = null;
        try{
            p = new PrintWriter(new File(fileName));
            p.write(e.toString());
            p.close();
        }
        catch (Exception a){
            System.out.println("failure to write");
            return false;
        }
        return true;
    }
}

