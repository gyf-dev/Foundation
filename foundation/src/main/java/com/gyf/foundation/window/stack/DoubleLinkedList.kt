package com.gyf.foundation.window.stack

/**
 * The type Double linked list.
 *
 * @param <D> the type parameter
 * @author: Ifan Ge
 * @date: 2023 -01-16  11:02
 * @Version: design3.0
 */
open class DoubleLinkedList<D> {

    open var head: Node<D>? = null
    open var tail: Node<D>? = null

    /**
     * Size int.链表长度
     *
     * @return the int
     */
    fun size(): Int {
        var cur = head
        var count = 0
        while (cur != null) {
            count++
            cur = cur.next
        }
        return count
    }

    /**
     * Contain boolean.判断链表中是否包含某元素
     *
     * @param value the value
     * @return the boolean
     */
    fun contain(value: D): Boolean {
        var cur = head
        while (cur != null) {
            if (cur.value === value) {
                return true
            }
            cur = cur.next
        }
        return false
    }

    /**
     * Add first.头插法
     *
     * @param value the value
     */
    fun addHead(value: D) {
        if (head == null) {
            head = Node(value)
            tail = head
            return
        }
        val newNode = Node(value)
        newNode.next = head
        head!!.prev = newNode
        head = newNode
    }

    /**
     * Add last.尾插法
     *
     * @param value the value
     */
    fun add(value: D) {
        if (head == null) {
            head = Node(value)
            tail = head
            return
        }
        val newNode = Node(value)
        tail!!.next = newNode
        newNode.prev = tail
        tail = newNode
    }


    /**
     * Insert.指定位置插入元素 head逻辑下标为0
     *
     * @param index the index
     * @param data  the data
     */
    fun insert(index: Int, data: D) {
        //先判断index插入的位置是否合法
        if (index < 0 || index > size()) {
            throw RuntimeException("index insertion position is not valid!")
        }
        //头插
        if (index == 0) {
            addHead(data)
            return
        }
        //尾插
        if (index == size()) {
            add(data)
            return
        }
        //常规插入
        var cur = head
        for (i in 0 until index) {
            cur = cur!!.next
        }
        val newNode = Node(data)
        newNode.next = cur
        newNode.prev = cur!!.prev
        cur.prev!!.next = newNode
        cur.prev = newNode
    }

    /**
     * Remove.删除第一次出现的value的节点
     *
     * @param value the value
     */
    open fun remove(value: D) {
        var cur = head
        while (cur != null) {
            if (cur.value === value) {
                //头结点为要删除的节点
                if (cur === head) {
                    //只有一个头节点
                    if (head!!.next == null) {
                        head = null
                        tail = null
                        return
                    }
                    head = head!!.next
                    head!!.prev = null
                    return
                }
                //尾节点为要删除的节点
                if (cur === tail) {
                    tail = tail!!.prev
                    tail!!.next = null
                    return
                }
                cur.prev!!.next = cur.next
                cur.next!!.prev = cur.prev
                return
            }
            cur = cur.next
        }
    }

    /**
     * Remove all.删除所有value的节点
     *
     * @param value the value
     */
    fun removeAll(value: D) {
        var cur = head!!.next
        while (cur != null) {
            if (cur.value === value) {
                if (cur !== tail) {
                    cur.prev!!.next = cur.next
                    cur.next!!.prev = cur.prev
                } else {
                    tail = tail!!.prev
                    tail!!.next = null
                }
            }
            cur = cur.next
        }
        if (head!!.value === value) {
            //只有一个头结点
            if (head!!.next == null) {
                head = null
                tail = null
            } else {
                //还有后继节点
                head = head!!.next
                head!!.prev = null
            }
        }
    }

    /**
     * Clean.清空链表
     */
    fun clean() {
        var cur = head
        while (cur != null) {
            val curNext = cur.next
            cur.next = null
            cur.prev = null
            cur = curNext
        }
        //释放头尾结点
        head = null
        tail = null
    }

    /**
     * Display.
     */
    fun display(): CharSequence {
        var cur = head
        val sb = StringBuilder()
        while (cur != null) {
            sb.append(cur.value)
            sb.append("\n")
            cur = cur.next
        }
        return sb
    }

    fun forEach(action: (D) -> Unit) {
        var cur = head
        while (cur != null) {
            action(cur.value)
            cur = cur.next
        }
    }


    /**
     * Instantiates a new Node.
     *
     * @param value the value
     */
    class Node<D>(
        /**
         * The Value.
         */
        @JvmField var value: D
    ) {
        /**
         * The Next.
         */
        @JvmField
        var next: Node<D>? = null

        /**
         * The Prev.
         */
        @JvmField
        var prev: Node<D>? = null
    }
}


