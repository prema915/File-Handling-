package com.file.handling;
	import java.io.File;
	import java.io.FileWriter;
	import java.io.FileReader;
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.util.Scanner;

	public class file {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("1. Create File");
	            System.out.println("2. Write to File");
	            System.out.println("3. Read from File");
	            System.out.println("4. Delete File");
	            System.out.println("5. Stop Program");
	            System.out.print("Enter your choice: ");

	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    createFile();
	                    break;
	                case 2:
	                    writeToFile();
	                    break;
	                case 3:
	                    readFromFile();
	                    break;
	                case 4:
	                    deleteFile();
	                    break;
	                case 5:
	                    System.out.println("Program stopped.");
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please enter a valid option.");
	            }
	        }
	    }

	    private static void createFile() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter the file name: ");
	        String fileName = scanner.nextLine();

	        try {
	            File file = new File(fileName);

	            if (file.createNewFile()) {
	                System.out.println("File created: " + file.getName());
	            } else {
	                System.out.println("File already exists.");
	            }
	        } catch (IOException e) {
	            System.out.println("An error occurred while creating the file.");
	            e.printStackTrace();
	        }
	    }

	    private static void writeToFile() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter the file name: ");
	        String fileName = scanner.nextLine();

	        try (FileWriter writer = new FileWriter(fileName, true)) {
	            System.out.print("Enter text to write to the file: ");
	            String content = scanner.nextLine();

	            writer.write(content + "\n");
	            System.out.println("Text written to the file successfully.");
	        } catch (IOException e) {
	            System.out.println("An error occurred while writing to the file.");
	            e.printStackTrace();
	        }
	    }

	    private static void readFromFile() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter the file name: ");
	        String fileName = scanner.nextLine();

	        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	            String line;
	            System.out.println("Content of the file:");

	            while ((line = reader.readLine()) != null) {
	                System.out.println(line);
	            }
	        } catch (IOException e) {
	            System.out.println("An error occurred while reading from the file.");
	            e.printStackTrace();
	        }
	    }

	    private static void deleteFile() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter the file name: ");
	        String fileName = scanner.nextLine();

	        File file = new File(fileName);

	        if (file.delete()) {
	            System.out.println("File deleted: " + file.getName());
	        } else {
	            System.out.println("Unable to delete the file. File may not exist.");
	        }
	    }
	}


