package com.gyf.foundation.window.stack

import com.gyf.foundation.window.Window

/**
 * @author: Ifan Ge
 * @date: 2023-01-13  17:02
 * @Version: design3.0
 */
class WindowRecord : DoubleLinkedList<Window>() {
    /**
     * Contain class boolean.判断链表中是否包含某元素
     *
     * @param clazzName the clazzName
     * @return the boolean
     */
    fun containClass(clazzName: String): Boolean {
        var cur: Node<Window>? = head
        while (cur != null) {
            if (getWindowName(cur) == clazzName) {
                return true
            }
            cur = cur.next
        }
        return false
    }

    fun isHead(clazzName: String): Boolean {
        if (head == null) {
            return false
        }
        return getWindowName(head!!) == clazzName
    }

    fun pop(clazzName: String): Window? {
        var cur: Node<Window>? = head
        while (cur != null) {
            val curNext = cur.next
            if (getWindowName(cur) != clazzName) {
                cur.value.intent.mNeedShowPrevWindow = false
                cur.value.finish()
                cur.next = null
                cur.prev = null
            } else {
                cur.prev = null
                head = cur
                return cur.value
            }
            cur = curNext
        }
        return null
    }

    fun addAndHide(value: Window) {
        addHead(value)
        hideHeadNext()
    }

    private fun hideHeadNext() {
        val next: Node<Window>? = head?.next
        next?.value?.hide()
    }

    override fun toString(): String {
        return """
            size:${size()}
            display:
            ${display()}
            """.trimIndent()
    }

    private fun getWindowName(node: Node<Window>): String {
        return node.value.javaClass.name
    }

    companion object {
        private const val TAG = "WindowRecord"
    }
}
