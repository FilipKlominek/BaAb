package com.company;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String line;
            int lineNumber = 0;


            while ((line = br.readLine()) != null) {
                char current = '0';
                char previous = '0';

                boolean found = false;

                lineNumber++;
                line = line.toLowerCase();

                for (int i = 0; i < line.length(); i++) {

                    char current2 = '0';
                    char previous2 = '0';

                    current = line.charAt(i);

                    if (previous == 'b' && current == 'a') {
                        for (int j = i + 1; j < line.length(); j++) { // index out of bounds?
                            current2 = line.charAt(j);
                            if (previous2 == 'a' && current2 == 'b') {
                                found = true;
                            }
                            previous2 = current2;
                        }
                    }
                    if (previous == 'a' && current == 'b') {
                        for (int j = i + 1; j < line.length(); j++) { // index out of bounds?
                            current2 = line.charAt(j);
                            if (previous2 == 'b' && current2 == 'a') {
                                found = true;
                            }
                            previous2 = current2;
                        }
                    }


                    previous = current;
                }
                if (found) break;
            }
            System.out.println(lineNumber + ". Řádka");
        } catch (Exception e) {
            System.out.println("not found");
        }
    }
}
