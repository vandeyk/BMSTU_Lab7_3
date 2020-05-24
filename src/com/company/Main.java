package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
	// write your code here
        File input = new File("Input.txt");

        try (Scanner scan = new Scanner(input)) {
            String res_big = "";
            while (scan.hasNextLine()) {
                String buf = scan.nextLine();
                String[] sentences = buf.split("[\\!|\\.|\\?]\\s?");
                int p = 0;
                //Pattern pattern = Pattern.compile("^[AEYUIOaeyuio].*[aeyuio]$");
                for (String sentence : sentences) {
                    String[] words = sentence.split("[\\s,.:!?()\"—]+");
                    String w1 = words[0].toLowerCase(); // Переводим первое слово в lowercase
                    String w2 = words[words.length - 1];
                    String w3 = w2.substring(0, 1).toUpperCase() + w2.substring(1); // Увелич первую букву последнего слова
                    int pos = sentence.indexOf(w2);
                    String res = w3 + sentence.substring(w1.length(), pos) + w1;
                    int pos2 = buf.indexOf(res);
                    p += res.length();
                    res_big += res + buf.charAt(p) + " "; //Добавляем знак в конце предложения
                    p += 2;
                }
            }
            System.out.println(res_big);
        }
        catch (FileNotFoundException exp) {
            System.out.println("No such file found!");
        }
    }
}
