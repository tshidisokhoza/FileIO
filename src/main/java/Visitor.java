import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;

public class Visitor {
    Logger VisitorLog = LogManager.getLogger(Visitor.class);
    private String fullName;
    private int age;
    private LocalDate date;
    private LocalTime time;
    private String assist;

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }



    public void setAssist(String assist) {
        this.assist = assist;
    }

    public void save(){

        StringBuilder builder = new StringBuilder();
        builder.append("full names: "+fullName + "\n")
                .append(" ")
                .append("Age: "+age+"\n")
                .append(" ")
                .append("Date: "+date+"\n")
                .append(" ")
                .append("Time: "+time+"\n")
                .append(" ")
                .append("Assisted by:"+assist+" ");

        String full_Name = fullName.replace(" ", "_");

        String fileName = "visitor_{"+full_Name+"}.txt";
        int ar[] = new int[3];

        File file = null;
        try {

            file = new File(fileName);
            if(file.createNewFile()) {

                Files.write(Paths.get(fileName),String.valueOf(builder).getBytes());

            }
            else
                throw new IOException("File already exist");


        } catch (IOException e) {

            e.printStackTrace();
            VisitorLog.info(e);
            System.out.println("I am running");

        }

        VisitorLog.info(builder);

    }

    public String load(String searchFile) throws IOException
    {
        //String fullName = JOptionPane.showInputDialog(null,"search file");
        String full_Name = searchFile.replace(" ", "_");

        String fileName = "visitor_{"+full_Name+"}.txt";
        BufferedReader file = null;
        try {
            file = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = file.readLine()) !=null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
            VisitorLog.error(e);


        }
        return fileName;
    }
}
