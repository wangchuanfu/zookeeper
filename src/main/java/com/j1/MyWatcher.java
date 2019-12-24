package com.j1;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;


public class MyWatcher implements Watcher {
    public void process(WatchedEvent watchedEvent) {
        System.out.println("MyWatcher.process------" + watchedEvent);
    }
}
