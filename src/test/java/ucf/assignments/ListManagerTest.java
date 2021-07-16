/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Orion Kinsler
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListManagerTest {
    ListManager lManager = new ListManager();
    @Test
    void createItem_name() {
        lManager.createItem("nameTest", "", "");

        String expected = "nameTest";

        assertEquals(expected, lManager.items.get(0).name);
    }

    @Test
    void createItem_description() {
        lManager.createItem("", "descriptionTest", "");

        String expected = "descriptionTest";

        assertEquals(expected, lManager.items.get(0).description);
    }

    @Test
    void createItem_dueDate() {
        lManager.createItem("", "", "dueDateTest");

        String expected = "dueDateTest";

        assertEquals(expected, lManager.items.get(0).dueDate);
    }

    @Test
    void deleteItem_first_item() {
        lManager.createItem("item1", "item1", "item1");
        lManager.createItem("item2", "item2", "item2");

        ListManager expectedList = new ListManager();
        expectedList.createItem("item2", "item2", "item2");

        lManager.deleteItem(0);

        assertEquals(expectedList.items.get(0).name, lManager.items.get(0).name);
    }

    @Test
    void deleteItem_last_item() {
        lManager.createItem("item1", "item1", "item1");
        lManager.createItem("item2", "item2", "item2");

        ListManager expectedList = new ListManager();
        expectedList.createItem("item1", "item1", "item1");

        lManager.deleteItem(1);

        assertEquals(expectedList.items.get(0).name, lManager.items.get(0).name);
    }

    @Test
    void changeItemStatus_true() {
        lManager.createItem("item1", "item1", "item1");

        lManager.changeItemStatus(0, true);

        Boolean actual = lManager.items.get(0).status;
        Boolean expected  = true;

        assertEquals(expected, actual);
    }

    @Test
    void changeItemStatus_false() {
        lManager.createItem("item1", "item1", "item1");

        lManager.changeItemStatus(0, false);

        Boolean actual = lManager.items.get(0).status;
        Boolean expected  = false;

        assertEquals(expected, actual);
    }

    @Test
    void editItemName_change() {
        lManager.createItem("nameTest", "", "");

        lManager.editItemName(0, "newNameTest");

        String expected = "newNameTest";

        assertEquals(expected, lManager.items.get(0).name);
    }

    @Test
    void editItemDate_change() {
        lManager.createItem("", "", "dueDateTest");

        lManager.editItemDate(0, "newDateTest");

        String expected = "newDateTest";

        assertEquals(expected, lManager.items.get(0).dueDate);
    }

    @Test
    void editItemDescription_change() {
        lManager.createItem("", "descriptionTest", "");

        lManager.editItemDescription(0, "newDescriptionTest");

        String expected = "newDescriptionTest";

        assertEquals(expected, lManager.items.get(0).description);
    }
}