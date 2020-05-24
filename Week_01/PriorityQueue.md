#### Queue/Priority Queue源码分析：

**Queue**:
Queue在java中被定义为接口，它的api包括：add、offer、remove、poll、element、peek等。
以LinkedList为例，它先了Queue接口，底层是双向链表实现的，插入主要由void linkLast(E e) 、删除主要由private E unlinkFirst(Node f) 实现，实现过程都是在操作当前指针与前驱、后驱指针的关系。

### API：
* boolean add(E e)：添加元素，如果成功返回true,如果因为容量限制导致失败，抛出IllegalStateException异常，如果有容量限制的队列，建议使用offer
* boolean offer(E e)：添加元素，如果成功返回true,如果因为容量限制导致失败，返回false
* E remove()：删除队列头的元素，并且返回被删除的元素，如果队列为空，抛出  NoSuchElementException
* E poll()：删除队列头的元素，并返回被删除的元素，如果队列为空，返回null
* E element()：取出队列头的元素（不删除），如果队列为空，抛出 NoSuchElementException
* E peek()：取出队列头的元素（不删除），如果队列为空，返回null


**PriorityQueue**:

实现结构：用数组实现的一个堆（子结点的值总是大于它的父节点) 。因此，在添加元素和删除元素都要想要的调整位置，满足小顶堆的条件。
常见api及时间复杂度分析：
1）添加：add、offer； 时间复杂度：O(logn）
2) 获取：peek()、element()； 时间复杂度：O(1）
3）删除：poll()、remove()； 时间复杂度：O(logn）
4) 删除指定位置元素：remove(o) 时间复杂度：O(n) [先查找O(n)，后删除O(logn)]
插入和删除操作源码分析：
1）插入：
1.1) 先进行判空和是否需要扩容判断，扩容主要通过private void grow(int minCapacity)来实现，初始容量为11。
1.2) 添加元素，如果非第一个元素，需要进行顺序调整siftUp。该方法通过指定的比较器来实现最小堆排序，比较器有2种：自己定义的Comparator、自然排序器Comparable。其中，siftUpComparable和siftUpUsingComparator底层都是进行堆排序的过程。
2）删除：
2.1）将数组最尾元素设置为null，再进行siftDown操作，siftDown中实现了删除元素之后，重新进行堆排序的过程。
注意实现：
由于PriorityQueue是由小顶堆实现的，小顶堆只能保证第一个元素为最小值，因此再遍历的过程使用System.out.println(priorityQueue); 输出的不一定是排序的结果。必须通过如下方式：
```java
int size = priorityQueue.size();
System.out.println("遍历：");
for (int i = 0; i < size; i++) {
    System.out.println(priorityQueue.poll());
}
```
这也可以看出每次poll，都会调整元素顺序，保证第一个元素为最小值。