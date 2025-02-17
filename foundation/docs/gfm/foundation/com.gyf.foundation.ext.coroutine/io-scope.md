//[foundation](../../index.md)/[com.gyf.foundation.ext.coroutine](index.md)/[ioScope](io-scope.md)

# ioScope

[androidJvm]\
val [ICoroutine](-i-coroutine/index.md).[ioScope](io-scope.md): CoroutineScope

ICoroutine 的 IO 协程作用域属性，如果不存在则创建一个新的 IO 协程作用域并存入 ioScopeHashMap。