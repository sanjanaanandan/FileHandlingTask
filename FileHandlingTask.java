package task;

import java.io.*;
import java.util.Scanner;

public class FileHandlingTask {

	    // Write (overwrite) file
	    public static void writeFile(String fileName, String content) {
	        try (FileWriter writer = new FileWriter(fileName)) {
	            writer.write(content);
	            System.out.println("File written successfully.");
	        } catch (IOException e) {
	            System.out.println("Error writing file: " + e.getMessage());
	        }
	    }

	    // Read file
	    public static void readFile(String fileName) {
	        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	            String line;
	            System.out.println("\n--- File Content ---");
	            while ((line = reader.readLine()) != null) {
	                System.out.println(line);
	            }
	            System.out.println("--------------------");
	        } catch (IOException e) {
	            System.out.println("Error reading file: " + e.getMessage());
	        }
	    }

	    // Append file
	    public static void appendFile(String fileName, String content) {
	        try (FileWriter writer = new FileWriter(fileName, true)) {
	            writer.write("\n" + content);
	            System.out.println("Content appended successfully.");
	        } catch (IOException e) {
	            System.out.println("Error appending file: " + e.getMessage());
	        }
	    }

	    // Modify file (replace word)
	    public static void modifyFile(String fileName, String oldWord, String newWord) {
	        try {
	            File file = new File(fileName);
	            BufferedReader reader = new BufferedReader(new FileReader(file));

	            StringBuilder content = new StringBuilder();
	            String line;

	            while ((line = reader.readLine()) != null) {
	                content.append(line.replace(oldWord, newWord)).append("\n");
	            }
	            reader.close();

	            FileWriter writer = new FileWriter(file);
	            writer.write(content.toString());
	            writer.close();

	            System.out.println("Word replaced successfully.");
	        } catch (IOException e) {
	            System.out.println("Error modifying file: " + e.getMessage());
	        }
	    }

	    public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);
	        String fileName = "sample.txt";

	        while (true) {
	            System.out.println("\n===== FILE HANDLING MENU =====");
	            System.out.println("1. Write File");
	            System.out.println("2. Read File");
	            System.out.println("3. Append File");
	            System.out.println("4. Modify (Replace Word)");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");

	            int choice = input.nextInt();
	            input.nextLine(); // consume newline

	            switch (choice) {

	                case 1:
	                    System.out.print("Enter content to write: ");
	                    String writeData = input.nextLine();
	                    writeFile(fileName, writeData);
	                    break;

	                case 2:
	                    readFile(fileName);
	                    break;

	                case 3:
	                    System.out.print("Enter content to append: ");
	                    String appendData = input.nextLine();
	                    appendFile(fileName, appendData);
	                    break;

	                case 4:
	                    System.out.print("Enter word to replace: ");
	                    String oldWord = input.nextLine();
	                    System.out.print("Enter new word: ");
	                    String newWord = input.nextLine();
	                    modifyFile(fileName, oldWord, newWord);
	                    break;

	                case 5:
	                    System.out.println("Exiting program...");
	                    input.close();
	                    System.exit(0);

	                default:
	                    System.out.println("Invalid choice!");
	            }
	        }
	    }
	}