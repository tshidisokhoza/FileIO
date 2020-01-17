import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog(null, "Please enter full name");
        String assist = JOptionPane.showInputDialog(null, "Please enter Assist");
        String age = JOptionPane.showInputDialog(null, "Please enter age");
        //String name = JOptionPane.showInputDialog(null, "Please enter full name");
        Visitor visitor = new Visitor();

        visitor.setFullName(name);
        visitor.setAge(Integer.parseInt(age));
        visitor.setAssist(assist);
        visitor.setDate(LocalDate.now());
        visitor.setTime(LocalTime.now());
        visitor.save();
        System.out.println("=========================================================");
        try {
            visitor.load("Alice Cooper");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
