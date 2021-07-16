/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Orion Kinsler
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListItemTest {
    ListItem testItem = new ListItem();

    @Test
    void updateName_short_special_char() {
        testItem.updateName("new@");

        String actual = testItem.name;
        String expected = "new@";

        assertEquals(expected, actual);
    }

    @Test
    void updateName_long_special_char() {
        testItem.updateName("@#$%^&* ()(!@!@#!{{}}} sjdkladjsld 3456790876");

        String actual = testItem.name;
        String expected = "@#$%^&* ()(!@!@#!{{}}} sjdkladjsld 3456790876";

        assertEquals(expected, actual);
    }

    @Test
    void updateDescription_short_special_char() {
        testItem.updateDescription("new@");

        String actual = testItem.description;
        String expected = "new@";

        assertEquals(expected, actual);
    }

    @Test
    void updateDescription_long_special_char() {
        testItem.updateDescription("@#$%^&* ()(!@!@#!{{}}} sjdkladjsld 3456790876");

        String actual = testItem.description;
        String expected = "@#$%^&* ()(!@!@#!{{}}} sjdkladjsld 3456790876";

        assertEquals(expected, actual);
    }

    @Test
    void updateDueDate_short_special_char() {
        testItem.updateDueDate("new@");

        String actual = testItem.dueDate;
        String expected = "new@";

        assertEquals(expected, actual);
    }

    @Test
    void updateDueDate_long_special_char() {
        testItem.updateDueDate("@#$%^&* ()(!@!@#!{{}}} sjdkladjsld 3456790876");

        String actual = testItem.dueDate;
        String expected = "@#$%^&* ()(!@!@#!{{}}} sjdkladjsld 3456790876";

        assertEquals(expected, actual);
    }

    @Test
    void changeStatus_false() {
        testItem.changeStatus(false);

        Boolean actual = testItem.status;
        Boolean expected = false;

        assertEquals(expected, actual);
    }

    @Test
    void changeStatus_true() {
        testItem.changeStatus(true);

        Boolean actual = testItem.status;
        Boolean expected = true;

        assertEquals(expected, actual);
    }
}