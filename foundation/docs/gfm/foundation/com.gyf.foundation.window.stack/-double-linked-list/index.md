//[foundation](../../../index.md)/[com.gyf.foundation.window.stack](../index.md)/[DoubleLinkedList](index.md)

# DoubleLinkedList

open class [DoubleLinkedList](index.md)&lt;[D](index.md)&gt;

The type Double linked list.

#### Author

: Ifan Ge

#### Parameters

androidJvm

| | |
|---|---|
|  | <D> the type parameter |

#### Inheritors

| |
|---|
| [WindowRecord](../-window-record/index.md) |

## Constructors

| | |
|---|---|
| [DoubleLinkedList](-double-linked-list.md) | [androidJvm]<br>constructor() |

## Types

| Name | Summary |
|---|---|
| [Node](-node/index.md) | [androidJvm]<br>class [Node](-node/index.md)&lt;[D](-node/index.md)&gt;(var value: [D](-node/index.md))<br>Instantiates a new Node. |

## Properties

| Name | Summary |
|---|---|
| [head](head.md) | [androidJvm]<br>open var [head](head.md): [DoubleLinkedList.Node](-node/index.md)&lt;[D](index.md)&gt;? |
| [tail](tail.md) | [androidJvm]<br>open var [tail](tail.md): [DoubleLinkedList.Node](-node/index.md)&lt;[D](index.md)&gt;? |

## Functions

| Name | Summary |
|---|---|
| [add](add.md) | [androidJvm]<br>fun [add](add.md)(value: [D](index.md))<br>Add last.尾插法 |
| [addHead](add-head.md) | [androidJvm]<br>fun [addHead](add-head.md)(value: [D](index.md))<br>Add first.头插法 |
| [clean](clean.md) | [androidJvm]<br>fun [clean](clean.md)()<br>Clean.清空链表 |
| [contain](contain.md) | [androidJvm]<br>fun [contain](contain.md)(value: [D](index.md)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Contain boolean.判断链表中是否包含某元素 |
| [display](display.md) | [androidJvm]<br>fun [display](display.md)(): [CharSequence](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-char-sequence/index.html)<br>Display. |
| [forEach](for-each.md) | [androidJvm]<br>fun [forEach](for-each.md)(action: ([D](index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)) |
| [insert](insert.md) | [androidJvm]<br>fun [insert](insert.md)(index: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), data: [D](index.md))<br>Insert.指定位置插入元素 head逻辑下标为0 |
| [remove](remove.md) | [androidJvm]<br>open fun [remove](remove.md)(value: [D](index.md))<br>Remove.删除第一次出现的value的节点 |
| [removeAll](remove-all.md) | [androidJvm]<br>fun [removeAll](remove-all.md)(value: [D](index.md))<br>Remove all.删除所有value的节点 |
| [size](size.md) | [androidJvm]<br>fun [size](size.md)(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)<br>Size int.链表长度 |