package LinkedList;

import Node.MyNode;
import Object.Student;

public class MyLinkedList {
    // declaring START
    MyNode START;

    // constructor
    public MyLinkedList() {
        // when the linked list is created START will refer to null
        START = null;
    }

    // to get START of list
    public MyNode getSTART() {
        return START;
    }



                                            // ### SINGLy LINKED LIST OPERATIONS(methods) ###


                                                            // INSERTION



    /* a method to insert a node at the beginning
     * this method will insert node at the beginning of linked list
     */
    public void InsertAtFirst(String studentID, String studentName, int studentAge) {
        // creating new object
        Student data =  new Student(studentID,studentName,studentAge);
        // creating node
        MyNode NewNode = new MyNode(data);

        /* checking if list is empty
         * if(list is empty), then
         */
        if (START == null) {
            System.out.println("\t***The List was Empty and The Node has been Inserted at the Beginning***");
        }
        // else(list is not empty), then
        else {
            // setting the newnode.next to START of list
            NewNode.setNEXT(START);
            System.out.println("\t***The Node has been Inserted at the Beginning***");
        }
        // setting START to newnode
        START = NewNode;
    }


    /* a method to insert a node at the end
     * this method will insert node at the end of linked list
     */
    public void InsertAtLast(String studentID, String studentName, int studentAge) {
        // creating new object
        Student data =  new Student(studentID,studentName,studentAge);
        // creating node
        MyNode NewNode = new MyNode(data);

        /* checking if list is empty
         * if(list is empty), then
         */
        if (START == null) {
            // setting START to newnode
            START = NewNode;
            System.out.println("\t***The List was Empty and The Node has been Inserted***");
        }
        // else(list is not empty), then
        else {
            /* assigning TAMP to START
             * to traverse the list and insert node at the end
             */
            MyNode TAMP = START;

            // loop to reach end(where node.next not equal null) of linked list
            while (TAMP.getNEXT() != null) {
                /* if the next node is available
                 * updating TAMP to refer next node
                 */
                TAMP = TAMP.getNEXT();
            }
            /* when the TAMP.next equal null
             * TAMP is now referring to last node of the list
             * assigning TAMP to NewNode*/
            TAMP.setNEXT(NewNode);
            System.out.println("\t***The Node has been Inserted at the End***");
        }
    }

    public void InsertAtPosition(String studentID, String studentName, int studentAge, int pos) {
        // creating new object
        Student data =  new Student(studentID,studentName,studentAge);
        // creating node
        MyNode NewNode = new MyNode(data);

        /* checking position
         * if(position less than 1) then
         */
        if (pos < 1) {
            System.out.println("\t***Position should be Greater than or Equal 1***");
        }
        /* checking if list is empty
         * if(list is empty), then
         */
        if (START == null) {
            System.out.println("\t***The List was Empty!!***");
        }
        // else(list is not empty), then
        else {
            /* checking position
             * if(position equal to 1) then
             */
            if (pos == 1) {
                // setting the newnode.next to START of list
                NewNode.setNEXT(START);
                System.out.println("\t***The Node has been Inserted at the Beginning, Position " + pos + "***");
                // setting START to newnode
                START = NewNode;
            }
            // else(position greater than 1) then
            else {
                // assigning TAMP to START
                MyNode TAMP = START;
                // assigning p to 1
                int p = 1;

                /* loop to reach previous node of the given position
                 *(where p lees than position and TAMP.NEXT.NEXT not equal null)
                 */
                while (p < pos-1 && TAMP.getNEXT() != null) {
                    // updating TAMP
                    TAMP = TAMP.getNEXT();
                    // increment p
                    p++;
                }
                // if TAMP.NEXT equal to null, then
                if (TAMP.getNEXT() == null) {
                    System.out.println("\t***No such position in the list***");
                }
                // if TAMP.NEXT not equal to null, then
                else if (TAMP.getNEXT() != null) {
                    // setting NewNode.NEXT equal to TAMP.NEXT
                    NewNode.setNEXT(TAMP.getNEXT());
                    // setting TAMP.NEXT equal to NewNode
                    TAMP.setNEXT(NewNode);
                    System.out.println("\t***The Node has been Inserted at the Position " + pos + "***");
                }
            }
        }
    }


                                                        // DELETION

    /* a method to delete node from the beginning
     * this method will delete the first node in liked list
     */
    public void DeleteAtFirst() {
        // assigning DeletedNode
        Student DeletedNode = null;

        /* checking if list is empty
         * if yes(list is empty), then
         */
        if (START == null) {
            System.out.println("\t***The List is Empty!!***");
        }
        // if no(list is not empty), then
        else {
            // getting data from first node and assign it in DeletedNode
            DeletedNode = START.getDATA();
            // updating START to refer to next node
            START = START.getNEXT();
            System.out.println("\t***The Node at Beginning has been Deleted***");

            /* checking if list is empty
             * if yes(list is empty), then
             */
            if (START == null) {
                System.out.println("\t***The List is Empty Now!!***");
            }
        }
    }


    /* a method to delete node from the end
     * this method will delete the last node
     */
    public void DeleteAtLast() {
        // assigning DeletedNode
        Student DeletedNode = null;

        /* checking if list is empty
         * if yes(list is empty), then
         */
        if (START == null) {
            System.out.println("\t***The List is Empty!!***");
        }
        // if no(list is not empty), then
        else {
            /* assigning TAMP to START
             * to delete the last node, we have to reach the second last node
             * and set its next node reference to null
             */
            MyNode TAMP = START;

            /* assigning PREVIOUS to null
             * to store reference of previous node
             * we will use this node to delete last node
             * by setting its next node as null
             */
            MyNode PREVIOUS = null;

            // loop to reach end(where node.next not equal null) of linked list
            while (TAMP.getNEXT() != null) {
                PREVIOUS = TAMP;
                TAMP = TAMP.getNEXT();
            }
            // getting data from last node
            DeletedNode = TAMP.getDATA();
            System.out.println("\t***The Node at End has been Deleted***");

            // now previous is pointing to second last node
            if (PREVIOUS != null) {
                PREVIOUS.setNEXT(null);
            }
            // if there is only one node in the list, then update START
            else {
                START = null;
                System.out.println("\t***The List is Empty Now***");
            }
        }
    }


    /* a method to delete a specific position in the list
    * this method will search for the given position and delete it, if available
    */
    public void DeletePosition(int pos) {
        /* checking position
         * if(position less than 1) then
         */
        if (pos < 1) {
            System.out.println("\t***Position should be Greater than or Equal 1***");
        }
        /* checking if list is empty
         * if(list is empty), then
         */
        if (START == null) {
            System.out.println("\t***The List was Empty!!***");
        }
        // else(list is not empty), then
        else {
            // assigning TAMP to START
            MyNode TAMP = START;
            // assigning DeletedNode
            Student DeletedNode = null;
            // assigning p to 1
            int p = 1;

            /* checking position
             * if(position equal to 1) then
             */
            if (pos == 1) {
                /* checking TAMP.NEXT
                 * if(TAMP.NEXT equal to null) then
                 */
                if (TAMP.getNEXT() == null) {
                    // setting START to null
                    START = null;
                    System.out.println("\t***The Node at the Beginning at Position " + pos + " has been Deleted***");
                    System.out.println("\t***The List is Empty Now!!***");
                }
                // else(TAMP.NEXT not equal to null) then
                else {
                    // getting data from first node and assign it in DeletedNode
                    DeletedNode = TAMP.getDATA();
                    // updating START to refer to next node
                    START = TAMP.getNEXT();
                    System.out.println("\t***The Node at Beginning at Position " + pos + " has been Deleted***");
                }
            }
            // else(position greater than 1) then
            else {
                /* loop to reach previous node of the given position
                 *(where p lees than position and TAMP.NEXT.NEXT not equal null)
                 */
                while (p < pos-1 && TAMP.getNEXT() != null) {
                    // updating TAMP
                    TAMP = TAMP.getNEXT();
                    // increment p
                    p++;
                }
                /* checking TAMP.NEXT
                 * if(TAMP.NEXT equal to null) then
                 */
                if (TAMP.getNEXT() == null) {
                    System.out.println("\t***No such position in the list***");
                }
                // if TAMP.NEXT.NEXT equal to null, then
                else if (TAMP.getNEXT().getNEXT() == null) {
                        TAMP.setNEXT(null);
                        System.out.println("\t***The Node at End at Position " + pos + " has been Deleted***");
                }
                // if TAMP.NEXT not equal to null, then
                else if (TAMP.getNEXT() != null) {
                    // setting TAMP.NEXT equal to TAMP.NEXT.NEXT
                    TAMP.setNEXT(TAMP.getNEXT().getNEXT());
                    System.out.println("\t***The Node has been Deleted at the Position " + pos + "***");
                }
            }
        }
    }


    /* a method to delete a particular data in the list
    * this method will delete the given data in the list if it is available
    */
    public void DeleteParticularNodeUsingID(String StudentID) {
        /* checking if list is empty
         * if(list is empty), then
         */
        if (START == null) {
            System.out.println("\t***The List was Empty!!***");
        }
        // else(list is not empty), then
        else {
            // assigning TAMP to START
            MyNode TAMP = START;

            /* assigning PREVIOUS to null
             * to store reference of previous node
             * we will use this node to delete last node
             * by setting its next node as null
             */
            MyNode PREVIOUS = null;

            // assigning response
            boolean response = false;
            // assigning DeletedNode
            Student DeletedNode = null;
            // assigning pos to 1
            int pos = 1;

            /* loop to reach given Data
             *(where TAMP not equal null)
             */
            while (TAMP != null) {
                /* checking equalities between TAMP.DATA and given student ID
                 * if(AMP.DATA equal to given student ID) then
                 */
                if (TAMP.getDATA().getStudentID().equals(StudentID)) {
                    // setting response to true
                    response = true;
                    // break loop
                    break;
                }
                // setting PREVIOUS equal to TAMP
                PREVIOUS = TAMP;
                // updating Tamp
                TAMP = TAMP.getNEXT();
                // increment pos
                pos++;
            }

            /* checking response
             * if(response true) then
             */
            if (response) {
                /* checking PREVIOUS
                 * if(PREVIOUS equal to null) then
                 */
                if (PREVIOUS == null) {
                    /* checking TAMP.NEXT
                     * if(TAMP.NEXT equal to null) then
                     */
                    if (TAMP.getNEXT() == null) {
                        // setting START to null
                        START = null;
                        System.out.println("\t***The Node with Student ID(" + StudentID + ") at the Beginning at Position " + pos + " has been Deleted***");
                        System.out.println("\t***The List is Empty Now!!***");
                    }
                    // else(TAMP.NEXT not equal to null) then
                    else {
                        // getting data from first node and assign it in DeletedNode
                        DeletedNode = TAMP.getDATA();
                        // updating START to refer to next node
                        START = TAMP.getNEXT();
                        System.out.println("\t***The Node at Beginning at Position " + pos + " has been Deleted***");
                    }
                }
                // else(PREVIOUS not equal to null) then
                else {
                    /* checking TAMP.NEXT
                     * if(TAMP.NEXT equal to null) then
                     */
                    if (TAMP.getNEXT() == null) {
                        DeletedNode = TAMP.getDATA();
                        PREVIOUS.setNEXT(null);
                        System.out.println("\t***The Node with Student ID(" + StudentID + ") at the End at Position " + pos + " has been Deleted***");
                    }
                    // else(TAMP.NEXT not equal to null) then
                    else {
                        // getting data from first node and assign it in DeletedNode
                        DeletedNode = TAMP.getDATA();
                        // updating START to refer to next node
                        PREVIOUS.setNEXT(TAMP.getNEXT());
                        System.out.println("\t***The Node with Student ID(" + StudentID + ") at Position " + pos + " has been Deleted***");
                    }
                }
            }
            // else(response false) then
            else {
                System.out.println("\t***No such Node with Student ID(" + StudentID + ") in the list***");
            }
        }
    }
    public void DeleteParticularNodeUsingName(String StudentName) {
        /* checking if list is empty
         * if(list is empty), then
         */
        if (START == null) {
            System.out.println("\t***The List was Empty!!***");
        }
        // else(list is not empty), then
        else {
            // assigning TAMP to START
            MyNode TAMP = START;

            /* assigning PREVIOUS to null
             * to store reference of previous node
             * we will use this node to delete last node
             * by setting its next node as null
             */
            MyNode PREVIOUS = null;

            // assigning response
            boolean response = false;
            // assigning DeletedNode
            Student DeletedNode = null;
            // assigning pos to 1
            int pos = 1;

            /* loop to reach given Data
             *(where TAMP not equal null)
             */
            while (TAMP != null) {
                /* checking equalities between TAMP.DATA and given student Name
                 * if(AMP.DATA equal to given student Name) then
                 */
                if (TAMP.getDATA().getStudentName().equals(StudentName)) {
                    // setting response to true
                    response = true;
                    // break loop
                    break;
                }
                // setting PREVIOUS equal to TAMP
                PREVIOUS = TAMP;
                // updating Tamp
                TAMP = TAMP.getNEXT();
                // increment pos
                pos++;
            }

            /* checking response
             * if(response true) then
             */
            if (response) {
                /* checking PREVIOUS
                 * if(PREVIOUS equal to null) then
                 */
                if (PREVIOUS == null) {
                    /* checking TAMP.NEXT
                     * if(TAMP.NEXT equal to null) then
                     */
                    if (TAMP.getNEXT() == null) {
                        // setting START to null
                        START = null;
                        System.out.println("\t***The Node with Student Name(" + StudentName + ") at the Beginning at Position " + pos + " has been Deleted***");
                        System.out.println("\t***The List is Empty Now!!***");
                    }
                    // else(TAMP.NEXT not equal to null) then
                    else {
                        // getting data from first node and assign it in DeletedNode
                        DeletedNode = TAMP.getDATA();
                        // updating START to refer to next node
                        START = TAMP.getNEXT();
                        System.out.println("\t***The Node at Beginning at Position " + pos + " has been Deleted***");
                    }
                }
                // else(PREVIOUS not equal to null) then
                else {
                    /* checking TAMP.NEXT
                     * if(TAMP.NEXT equal to null) then
                     */
                    if (TAMP.getNEXT() == null) {
                        DeletedNode = TAMP.getDATA();
                        PREVIOUS.setNEXT(null);
                        System.out.println("\t***The Node with Student Name(" + StudentName + ") at the End at Position " + pos + " has been Deleted***");
                    }
                    // else(TAMP.NEXT not equal to null) then
                    else {
                        // getting data from first node and assign it in DeletedNode
                        DeletedNode = TAMP.getDATA();
                        // updating START to refer to next node
                        PREVIOUS.setNEXT(TAMP.getNEXT());
                        System.out.println("\t***The Node with Student Name(" + StudentName + ") at Position " + pos + " has been Deleted***");
                    }
                }
            }
            // else(response false) then
            else {
                System.out.println("\t***No such Node with Student Name(" + StudentName + ") in the list***");
            }
        }
    }


                                                            // PRINTING / DISPLAYING


    /* a method to print/display the list
     * this method will print each node in the list
     */
    public void PrintList() {
        // assigning TAMP to START
        MyNode TAMP = START;

        /* checking if list is empty
         * if(list is empty), then
         */
        if (START == null) {
            System.out.println("\t***The List is Empty!!***");
        }
        // if no(list is not empty), then
        else {
            System.out.println("Elements in the List:-");
            //traversing the linked list and will print each node.
            while (TAMP != null) {
                // print TAMP.DATA for each node
                System.out.print(TAMP.getDATA());

                // updating TAMP
                TAMP = TAMP.getNEXT();

                /*checking TAMP
                * if(TAMP equal to null), then
                */
                if (TAMP != null) {
                    System.out.print(" ---> ");
                }
            }
            System.out.println("\n\t***All Elements has been Displayed in Order***");
        }
    }


                                                                    // SEARCHING

    /* a method to search data in the list
     * this method will return:
     * - true(if Node having given data found)
     * - false(else)
     */
    public void SearchByID(String StudentID) {
        // assigning TAMP to START
        MyNode TAMP = START;

        /* checking if list is empty
         * if(list is empty), then
         */
        if (START == null) {
            System.out.println("\t***The List is Empty!!***");
        }
        // else(list is not empty), then
        else {
            // assigning response to 0
            int response = 0;

            /* traversing the linked list
             * and will check each node for given ID
             */
            while (TAMP != null) {
                // checking for data at each node
                if (TAMP.getDATA().getStudentID().equals(StudentID)) {
                    // setting response to 1
                    response = 1;
                    // break loop
                    break;
                }
                // updating temp
                TAMP = TAMP.getNEXT();
            }
            /* checking response
             * if(response equal to 1), then
             */
            if (response == 1) {
                System.out.println("\t***The Node with Student ID(" + StudentID + ") is Present***");
            }
            // else(response equal to 0), then
            else {
                System.out.println("\t***The Node with Student ID(" + StudentID + ") is Not Present***");
            }
        }
    }
    public void SearchByName(String StudentName) {
        // assigning TAMP to START
        MyNode TAMP = START;

        /* checking if list is empty
         * if(list is empty), then
         */
        if (START == null) {
            System.out.println("\t***The List is Empty!!***");
        }
        // else(list is not empty), then
        else {
            // assigning response to 0
            int response = 0;

            /* traversing the linked list
             * and will check each node for given Name
             */
            while (TAMP != null) {
                // checking for data at each node
                if (TAMP.getDATA().getStudentName().equals(StudentName)) {
                    // setting response to 1
                    response = 1;
                    // break loop
                    break;
                }
                // updating temp
                TAMP = TAMP.getNEXT();
            }
            /* checking response
             * if(response equal to 1), then
             */
            if (response == 1) {
                System.out.println("\t***The Node with Student ID(" + StudentName + ") is Present***");
            }
            // else(response equal to 0), then
            else {
                System.out.println("\t***The Node with Student ID(" + StudentName + ") is Not Present***");
            }
        }
    }


                                                                    // COUNTING

    /* a method to count number of elements in the list
    * this method will return number of nodes
    */
    public void Count() {
        /* checking if list is empty
         * if(list is empty), then
         */
        if (START == null) {
            System.out.println("\t***The List is Empty!!***");
        }
        // else(list is not empty), then
        else {
            // assigning TAMP to START
            MyNode TAMP = START;
            // assigning c to 1
            int c = 1;

            /* loop to count nodes
             *(where TAMP.NEXT not equal null)
             */
            while (TAMP.getNEXT() != null) {
                // updating TAMP
                TAMP = TAMP.getNEXT();
                // increment c
                c++;
            }
            System.out.println("\t***The number of Elements/Nods in the List is/are " + c + "***");
        }
    }
}
