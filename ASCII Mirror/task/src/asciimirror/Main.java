package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input the file path:");
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();
        File file = new File(path);

        List<String> lines = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(file)) {
            int length = 0;
            while (fileScanner.hasNext()) {
                String text = fileScanner.nextLine();
                if (length < text.length()) {
                    length = text.length();
                }

                lines.add(text);

            }


            for (String string : lines) {

                StringBuilder sb = new StringBuilder(string);
                sb.append(" ".repeat(length - string.length()));
                System.out.print(sb);
                System.out.print(" | ");
                String reverse = sb.reverse().toString();
                for (int i = 0; i < reverse.length(); i++) {
                    printMirrorChar(reverse.charAt(i));
                }
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

    }
    public static void printMirrorChar(char c) {
        if (c == '<') {
            System.out.print('>');
        } else if (c == '>') {
            System.out.print('<');
        } else if (c == '[') {
            System.out.print(']');
        } else if (c == ']') {
            System.out.print('[');
        } else if (c == '{') {
            System.out.print('}');
        } else if (c == '}') {
            System.out.print('{');
        } else if (c == '(') {
            System.out.print(')');
        } else if (c == ')') {
            System.out.print('(');
        } else if (c == '/') {
            System.out.print('\\');
        } else if (c == '\\') {
            System.out.print('/');
        } else {
            System.out.print(c);
        }
    }
}
