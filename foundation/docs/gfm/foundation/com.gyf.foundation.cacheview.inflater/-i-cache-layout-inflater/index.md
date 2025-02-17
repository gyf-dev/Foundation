//[foundation](../../../index.md)/[com.gyf.foundation.cacheview.inflater](../index.md)/[ICacheLayoutInflater](index.md)

# ICacheLayoutInflater

interface [ICacheLayoutInflater](index.md)&lt;[T](index.md), [R](index.md)&gt;

#### Inheritors

| |
|---|
| [LayoutCacheLayoutInflater](../-layout-cache-layout-inflater/index.md) |
| [ViewBindingCacheLayoutInflater](../-view-binding-cache-layout-inflater/index.md) |

## Properties

| Name | Summary |
|---|---|
| [layoutInflater](layout-inflater.md) | [androidJvm]<br>open val [layoutInflater](layout-inflater.md): [LayoutInflater](https://developer.android.com/reference/kotlin/android/view/LayoutInflater.html) |

## Functions

| Name | Summary |
|---|---|
| [inflate](inflate.md) | [androidJvm]<br>abstract fun [inflate](inflate.md)(target: [T](index.md), layoutParams: [ViewGroup.LayoutParams](https://developer.android.com/reference/kotlin/android/view/ViewGroup.LayoutParams.html)?): [ViewCache](../../com.gyf.foundation.cacheview.view/-view-cache/index.md)&lt;[R](index.md)&gt; |