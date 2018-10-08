package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExamRoomTest {

    @Test (expected = IllegalArgumentException.class)
    public void testErrors() {
        new ExamRoom(-1);
    }

    @Test
    public void testBasic() {
        ExamRoom examRoom = new ExamRoom(10);
        assertEquals(0, examRoom.seat());
        assertEquals(9, examRoom.seat());
        assertEquals(4, examRoom.seat());
        assertEquals(2, examRoom.seat());
        examRoom.leave(4);
        assertEquals(5, examRoom.seat());
    }
}
