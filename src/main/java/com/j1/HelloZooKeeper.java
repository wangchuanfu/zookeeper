package com.j1;

import java.util.List;

import org.apache.zookeeper.AsyncCallback.ChildrenCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import com.j1.MyWatcher;

public class HelloZooKeeper {
	public static void main(String[] args) throws Exception {
		String connectString = "127.0.0.1:2181"; // 服务器地址
		int sessionTimeout = 3000; // 超时时间，单位为毫秒
		Watcher watcher = new MyWatcher();

		ZooKeeper zkClient = new ZooKeeper(connectString, sessionTimeout, watcher);
		/**
		 * 查看zk节点
		 */
		List<String> children = zkClient.getChildren("/", true);
		System.out.println(children);

		/**
		 * 创建节点
		 */
		Stat stat = new Stat();
		// zkClient.create("/world", "世界".getBytes(),
		// ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		//byte[] data = zkClient.getData("/world", true, null);
		//System.out.println(new String(data));

		// System.out.println(stat);
		// System.out.println(stat.getCtime());
		// System.out.println(stat.getVersion());
		// System.out.println(stat.getDataLength());
		// System.out.println(zkClient.exists("/hello", false));
		/**
		 * 修改
		 */
		//zkClient.setData("/world", "世界很大".getBytes(),-1 );
		/**
		 * 删除节点
		 */
		zkClient.delete("/world", -1);
		/**
		 * 关闭节点
		 */
		// zkClient.close();
	}
}
