package io.github.moonblade.lister;

import org.junit.Test;

import io.github.moonblade.lister.Helpers.ListItem;
import io.github.moonblade.lister.Helpers.ListQueue;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ListQueueTest {
    public ListQueue getList() {
        ListItem[] listItems = new ListItem[]{
                new ListItem("1"),
                new ListItem("2"),
                new ListItem("3"),
                new ListItem("4"),
                new ListItem("5")
        };
        ListQueue listQueue = new ListQueue(listItems);
        return listQueue;
    }

    public String toString(ListQueue queue) {
        StringBuilder stringBuilder = new StringBuilder();
        for (ListItem i: queue.getQueue())
            stringBuilder.append(i.toString());
        return stringBuilder.toString();
    }

    @Test
    public void createList() {
        assertEquals(5, getList().getQueue().size());
    }

    @Test
    public void createOrder() {
        assertEquals("12345", toString(getList()));
    }

    @Test
    public void addToList() {
        ListQueue listQueue = getList();
        listQueue.add(new ListItem("6"));
        assertEquals(listQueue.getQueue().size(), 6);
    }

    @Test
    public void addOrder() {
        ListQueue listQueue = getList();
        listQueue.add(new ListItem("6"));
        assertEquals("612345",toString(listQueue));
    }

    @Test
    public void pushLastOrder() {
        ListQueue listQueue = getList();
        listQueue.pushLast(new ListItem("3"));
        assertEquals("12453",toString(listQueue));
    }

    @Test
    public void deleteOrder() {
        ListQueue listQueue = getList();
        listQueue.delete(new ListItem("3"));
        assertEquals("1245",toString(listQueue));
    }


}