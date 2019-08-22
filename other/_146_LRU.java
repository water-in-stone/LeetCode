package leetcode.other;

import java.util.*;

/**
 * @author baikal on 2019-02-12
 * @project Algorithm 最近最少使用 1.使用双向链表来存储key和value 2.定义好remove
 *          2.每1次get的时候remove新的
 */
// class Node {
//   public int key, val;
//   public Node next, prev;
//   public Node(int k, int v) {
//       this.key = k;
//       this.val = v;
//   }
// }

class DoubleList {
  private Node head, tail; // 头尾虚节点
  private int size; // 链表元素数

  public DoubleList() {
    head = new Node(0, 0);
    tail = new Node(0, 0);
    head.next = tail;
    tail.prev = head;
    size = 0;
  }

  // 节点一定存在
  public void remove(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
    size--;
  }

  public void addFirst(Node node) {
    // 建立起4条边的关系，先建立再切断
    node.next = head.next;
    node.prev = head;
    node.next.prev = node;
    head.next = node;
    size++;
  }

  // 删除链表中最后一个节点，并返回该节点
  public Node removeLast() {
    // 若当前cache表为空，则直接返回
    if (tail.prev == head)
      return null;
    Node last = tail.prev;
    remove(last);
    return last;
  }

  // 返回链表长度
  public int size() {
    return size;
  }
}

public class _146_LRU {
  // 用来获取key对应的节点的val
  private HashMap<Integer, Node> map;
  // Node(k1, v1) <-> Node(k2, v2)...
  private DoubleList cache;
  // 最大容量
  private int capacity;

  public _146_LRU(int capacity) {
      this.capacity = capacity;
      map = new HashMap<>();
      cache = new DoubleList();
  }

  public int get(int key) {
    if (!map.containsKey(key))
      return -1;
    int val = map.get(key).val;
    // 利用 put 方法把该数据提到最前面
    put(key, val);
    return val;
  }

  public void put(int key, int value) {
    // 先把新节点 x 做出来
    Node x = new Node(key, value);

    if (map.containsKey(key)) {
      // 删除旧的节点，新的插到头部
      cache.remove(map.get(key));
      cache.addFirst(x);
      // 更新 map 中对应的数据
      map.put(key, x);
    } else {
      if (capacity == cache.size()) {
        // 删除链表最后一个数据
        Node last = cache.removeLast();
        map.remove(last.key);
      }
      // 直接添加到头部
      cache.addFirst(x);
      map.put(key, x);
    }
  }
}
