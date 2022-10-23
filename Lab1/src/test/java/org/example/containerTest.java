package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class containerTest<T> extends container{
    containerTest<Integer> contain;

    @BeforeEach
    public void init(){
        contain = new containerTest<>();
    }

    @AfterEach public void clear(){
        contain.print();
        contain = new containerTest<>();
        contain = null;
    }

    @Test
    public void addToTop(){
        contain.insertHead(3);
        contain.insertHead(2);
        contain.insertHead(1);
        assertEquals(1, contain.data);
    }


    @Test
    public void addToList(){
        contain.insertEnd(4);
        contain.insertEnd(5);
        contain.insertEnd(6);
        assertEquals(6, contain.next.next.data);
    }



    @Test
    public void listPop(){
        contain.insertHead(1);
        contain.insertEnd(2);
        contain.insertEnd(3);
        assertEquals(1, contain.extraction());
    }

    @Test
    public void removeData(){
        contain.insertEnd(1);
        contain.insertEnd(2);
        contain.insertEnd(3);
        assertTrue(contain.del(3));
    }

    @Test
    public void removeNotData(){
        contain.insertEnd(1);
        contain.insertEnd(2);
        contain.insertEnd(3);
        assertFalse(contain.del(12));
    }

}