### 用 add first 或 add last 这套新的 API 改写 Deque 的代码

Deque:
```java
Deque<String> deque = new LinkedList<String>();

deque.push("a");
deque.push("b");
deque.push("c");
System.out.println(deque);

String str = deque.peek();
System.out.println(str);
System.out.println(deque);

while (deque.size()>0){
    System.out.println(deque.pop());
}
System.out.println(deque);
```

Add first/Add last:
```java
Deque<String> deque = new LinkedList<>();
deque.addFirst("a"); //头部插入元素
deque.addFirst("b");
deque.addLast("c"); //尾部插入元素
System.out.println(deque);

String str = deque.peekLast();
System.out.println(str);    //输出尾部元素
System.out.println(deque);
while (deque.size()>0){
    System.out.println(deque.pop()); //逐个输出
}
System.out.println(deque);
```