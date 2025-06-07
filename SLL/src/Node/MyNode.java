package Node;

import Object.Student;

public class MyNode {
    // to store data value
    private Student DATA;
    // to store reference of next node
    private MyNode NEXT;

    /* constructor to create node for linked list
     * and initialize its DATA and NEXT as null
     */
    public MyNode(Student data) {
        this.DATA = data;
        this.NEXT = null;
    }

    // getter to get DATA
    public Student getDATA() {
        return DATA;
    }
    // a setter to set DATA
    public void setDATA(Student DATA) {
        this.DATA = DATA;
    }

    // getter to get NEXT
    public MyNode getNEXT() {
        return NEXT;
    }
    // a setter to set NEXT
    public void setNEXT(MyNode NEXT) {
        this.NEXT = NEXT;
    }
}
