import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainFamily {
    public static void main(String[] args) throws FileNotFoundException {
        int family_id, choice_0, choice_1, choice_2, choice_3,
                choice_4, choice_5,choice_6, choice_7,choice_8,
                choice_9, n_people;
        ArrayList<Family> familyArrayList = new ArrayList<>();

        //File separator
    
       String fileLocation = "C:"+ File.separator+ "Users"+ File.separator+"marce"+
               File.separator+"Desktop"+File.separator+"Licenciatura"+File.separator+
               "2Ano"+File.separator+"Es2"+File.separator+"git"+File.separator+
               "TestEsProject2"+File.separator+"src"+File.separator+"fpref.csv";

        File csvFamily = new File(fileLocation);

        //use a scanner that will read from the file
        Scanner familyScanner = new Scanner(csvFamily);

        //saltar a primeira linha
        familyScanner.nextLine();
        //read a line from the file
        while (familyScanner.hasNext()) {
            String nextLine = familyScanner.nextLine();

            System.out.println("Next Line " + nextLine);

            //slpit the file into parts
            String[] lineFamily = nextLine.split(",");

            family_id = Integer.parseInt(lineFamily[0]);
            choice_0 = Integer.parseInt(lineFamily[1]);
            choice_1 = Integer.parseInt(lineFamily[2]);
            choice_2 = Integer.parseInt(lineFamily[3]);
            choice_3 = Integer.parseInt(lineFamily[4]);
            choice_4 = Integer.parseInt(lineFamily[5]);
            choice_5 = Integer.parseInt(lineFamily[6]);
            choice_6 = Integer.parseInt(lineFamily[7]);
            choice_7 = Integer.parseInt(lineFamily[8]);
            choice_8 = Integer.parseInt(lineFamily[9]);
            choice_9 = Integer.parseInt(lineFamily[10]);
            n_people = Integer.parseInt(lineFamily[11]);
            Family family = new Family(family_id, choice_0, choice_1, choice_2, choice_3, choice_4, choice_5, choice_6, choice_7, choice_8, choice_9, n_people);

            familyArrayList.add(family);

        }
        System.out.println("print final "+familyArrayList.get(0).choice_0);

    }
}
