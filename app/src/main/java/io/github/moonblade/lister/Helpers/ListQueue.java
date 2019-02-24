package io.github.moonblade.lister.Helpers;

import android.util.Log;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class ListQueue {
    ArrayList<ListItem> queue;

    public ListQueue() {
        this.queue = new ArrayList<>();
    }

    public ListQueue(ArrayList<ListItem> queue) {
        this.queue = queue;
    }

    public ListQueue(ListItem[] queue) {
       this.queue = new ArrayList<>();
       for (ListItem listItem: queue) {
           this.queue.add(listItem);
       }
    }

    public void add(ListItem listItem) {
        queue.add(0, listItem);
    }

    public boolean delete(ListItem listItem) {
        return this.queue.remove(listItem);
    }

    public void pushLast(ListItem listItem) {
        if (this.queue.remove(listItem))
            this.queue.add(listItem);
    }

    public ArrayList<ListItem> getQueue() {
        return queue;
    }
}
