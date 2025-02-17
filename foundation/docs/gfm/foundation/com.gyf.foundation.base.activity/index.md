//[foundation](../../index.md)/[com.gyf.foundation.base.activity](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [BaseActivity](-base-activity/index.md) | [androidJvm]<br>open class [BaseActivity](-base-activity/index.md) : [AppCompatActivity](https://developer.android.com/reference/kotlin/androidx/appcompat/app/AppCompatActivity.html), [ConfigurationOwner](../com.gyf.foundation.ext.configuration/-configuration-owner/index.md), [ITag](../com.gyf.foundation.ext.log/-i-tag/index.md)<br>这是一个基础活动类，它扩���了AppCompatActivity并实现了ITag接口。 This is a base activity class that extends AppCompatActivity and implements the ITag interface. |
| [BaseBindingActivity](-base-binding-activity/index.md) | [androidJvm]<br>open class [BaseBindingActivity](-base-binding-activity/index.md)&lt;[VB](-base-binding-activity/index.md) : ViewBinding&gt; : [BaseActivity](-base-activity/index.md)<br>这是一个基础绑定活动类，扩展了[BaseActivity](-base-activity/index.md)并使用了ViewBinding。 This is a base binding activity class that extends [BaseActivity](-base-activity/index.md) and uses ViewBinding. |
| [BaseModelActivity](-base-model-activity/index.md) | [androidJvm]<br>open class [BaseModelActivity](-base-model-activity/index.md)&lt;[VB](-base-model-activity/index.md) : ViewBinding, [VM](-base-model-activity/index.md) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)&gt; : [BaseBindingActivity](-base-binding-activity/index.md)&lt;[VB](-base-model-activity/index.md)&gt; <br>基础模型活动类，提供ViewModel和ViewBinding的集成。 Base model activity class providing integration of ViewModel and ViewBinding. |