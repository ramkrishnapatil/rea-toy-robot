package com.robot.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.robot.otherTypes.FacingDirection;

public class TableTopTest {

    @Test
    public void validTableTopTest() {
        TableTop tableTop = new TableTop();
        assertNotNull(tableTop);
        tableTop = new TableTop(3, 3);
        assertNotNull(tableTop);
    }

    @Test(expected = IllegalArgumentException.class)
    public void inValidTableTopTest() {
        TableTop tableTop = new TableTop(-1, -1);
        assertNotNull(tableTop);
    }
}
