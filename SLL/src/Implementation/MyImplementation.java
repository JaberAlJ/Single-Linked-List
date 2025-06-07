package Implementation;

import LinkedList.MyLinkedList;

import java.util.Scanner;

public class MyImplementation {
    static String OperationChoice;
    static String TypeChoice;
    static String StudentID;
    static String StudentName;
    static int StudentAge;
    static int Position;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyLinkedList mLL = new MyLinkedList();

        label:
        while (true) {
            System.out.println("""
                    ======================================================================
                    \t\t\t--> SINGLE LINKED LIST OPERATIONS <--
                    \t\t\t\t1. Insertion of Elements
                    \t\t\t\t2. Deletion of Elements
                    \t\t\t\t3. Print / Display the Elements
                    \t\t\t\t4. Searching an Elements
                    \t\t\t\t5. Counting Elements
                    \t\t\t\t6. Exit
                    """);
            OperationChoice = "";
            while (!OperationChoice.equals("1") && !OperationChoice.equals("2") && !OperationChoice.equals("3") && !OperationChoice.equals("4")
                    && !OperationChoice.equals("5") && !OperationChoice.equals("6")) {
                System.out.println("Choose operation number between[1 - 6]:");
                OperationChoice = sc.next();
            }
            System.out.println("--------------------");
            // Operation Choice #1
            switch (OperationChoice) {
                case "1" -> {
                    System.out.println("""
                            1. Insertion of Elements:-
                                a. Insert element at the beginning
                                b. Insert element at the end
                                c. Insert element at specific position
                            """);
                    TypeChoice = "";
                    while (!TypeChoice.equalsIgnoreCase("a") && !TypeChoice.equalsIgnoreCase("b")
                            && !TypeChoice.equalsIgnoreCase("c")) {
                        System.out.println("Choose insertion type[a - b - c]:-");
                        TypeChoice = sc.next().toLowerCase();
                    }
                    System.out.println("--------------------");
                    System.out.println("Input Student ID:");
                    StudentID = sc.next();
                    System.out.println("Input Student Name: ");
                    StudentName = sc.next();
                    System.out.println("Input Student Age: ");
                    StudentAge = sc.nextInt();
                    System.out.println("--------------------");
                    switch (TypeChoice) {
                        // type Choice #a
                        case "a" -> {
                            mLL.InsertAtFirst(StudentID, StudentName, StudentAge);
                        }
                        // type Choice #b
                        case "b" -> {
                            mLL.InsertAtLast(StudentID, StudentName, StudentAge);
                        }
                        // type Choice #c
                        case "c" -> {
                            System.out.println("Input Position: ");
                            Position = sc.nextInt();
                            mLL.InsertAtPosition(StudentID, StudentName, StudentAge, Position);
                        }
                    }
                }
                // Operation Choice #2
                case "2" -> {
                    System.out.println("""
                            2. Deletion of Elements:-
                                a. Delete element at the beginning
                                b. Delete element at the end
                                c. Delete element at the specific position
                                d. Delete a particular element in the list using 'Student ID'
                                e. Delete a particular element in the list using 'Student Name'
                            """);
                    TypeChoice = "";
                    while (!TypeChoice.equalsIgnoreCase("a") && !TypeChoice.equalsIgnoreCase("b")
                            && !TypeChoice.equalsIgnoreCase("c") && !TypeChoice.equalsIgnoreCase("d")
                            && !TypeChoice.equalsIgnoreCase("e")) {
                        System.out.println("Choose Deletion type[a - b - c - d - e]:-");
                        TypeChoice = sc.next().toLowerCase();
                    }
                    System.out.println("--------------------");
                    switch (TypeChoice) {
                        // type Choice #a
                        case "a" -> {
                            mLL.DeleteAtFirst();
                        }
                        // type Choice #b
                        case "b" -> {
                            mLL.DeleteAtLast();
                        }
                        // type Choice #c
                        case "c" -> {
                            System.out.println("Input Position:");
                            Position = sc.nextInt();
                            mLL.DeletePosition(Position);
                        }
                        // type Choice #d
                        case "d" -> {
                            System.out.println("Input Student ID:");
                            StudentID = sc.next();
                            mLL.DeleteParticularNodeUsingID(StudentID);
                        }
                        // type Choice #e
                        case "e" -> {
                            System.out.println("Input Student Name:");
                            StudentName = sc.next();
                            mLL.DeleteParticularNodeUsingName(StudentName);
                        }
                    }
                }
                // Operation Choice #3
                case "3" -> {
                    System.out.println("3. Print / Display the Elements:-");
                    mLL.PrintList();
                }
                // Operation Choice #4
                case "4" -> {
                    System.out.println("""
                            4. Searching an Elements:-
                                a. Search a particular element in the list using 'Student ID'
                                b. Search a particular element in the list using 'Student Name'
                            """);
                    TypeChoice = "";
                    while (!TypeChoice.equalsIgnoreCase("a") && !TypeChoice.equalsIgnoreCase("b")) {
                        System.out.println("Choose Deletion type[a - b]:-");
                        TypeChoice = sc.next().toLowerCase();
                    }
                    System.out.println("--------------------");
                    switch (TypeChoice) {
                        // type Choice #a
                        case "a" -> {
                            System.out.println("Input Student ID:");
                            StudentID = sc.next();
                            System.out.println("--------------------");
                            mLL.SearchByID(StudentID);
                        }
                        // type Choice #b
                        case "b" -> {
                            System.out.println("Input Student Name:");
                            StudentName = sc.next();
                            System.out.println("--------------------");
                            mLL.SearchByName(StudentName);
                        }
                    }
                }
                // Operation Choice #5
                case "5" -> {
                    System.out.println("5. Counting Elements:-");
                    mLL.Count();
                }
                // Operation Choice #7
                case "6" -> {
                    System.out.println("6. Exit:-");
                    System.out.println("""
                            \t\t______________________________________________
                            \t\t|   JaberAlJ — https://github.com/JaberAlJ    |
                            \t\t|_____________________________________________|""");
                    System.out.println("\n\t\t\t*** Exiting the Program ***");
                    break label;
                }
            }
        }
    }
}
