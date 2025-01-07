// Anna Strömberg anst5816

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class InputScanner {

    private static ArrayList<InputStream> inputStreamDoesExist = new ArrayList<>();
    private Scanner input;

    public InputScanner(InputStream inputStream) {
        if(inputStreamDoesExist.contains(inputStream)) {
            throw new IllegalStateException("Error: InputStream already exist");
        }
        Scanner input = new Scanner(inputStream);
        inputStreamDoesExist.add(inputStream);

        this.input = input;
    }

    public InputScanner() {
        this(System.in);
    }

    public String readText(String textPrompt) {
        System.out.print(textPrompt + "?>");
        String text = input.nextLine();
        return text;
    }

    public int readInt(String intPrompt) {
        System.out.print(intPrompt + "?>");
        int number = input.nextInt();
        input.nextLine();
        return number;
    }

    public double readDouble(String doublePrompt) {
        System.out.print(doublePrompt + "?>");
        double decimal = input.nextDouble();
        input.nextLine();
        return decimal;
    }

    public void close() {
        input.close();
    }
}
