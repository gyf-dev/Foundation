//[foundation](../../index.md)/[com.gyf.foundation.cs.common.service](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [AbsService](-abs-service/index.md) | [androidJvm]<br>abstract class [AbsService](-abs-service/index.md) : [LifecycleService](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleService.html), [ServiceProviderOwner](../com.gyf.foundation.cs.common.service.face/-service-provider-owner/index.md), [IService](../com.gyf.foundation.cs.common.service.face/-i-service/index.md), [IServiceResponse](../com.gyf.foundation.cs.common.service.face/-i-service-response/index.md), [IMessage](../com.gyf.foundation.cs.common.face/-i-message/index.md), [IMessageQuick](../com.gyf.foundation.cs.common.face/-i-message-quick/index.md), [IServicePost](../com.gyf.foundation.cs.common.service.face/-i-service-post/index.md), [IServiceGet](../com.gyf.foundation.cs.common.service.face/-i-service-get/index.md), [ICoroutine](../com.gyf.foundation.ext.coroutine/-i-coroutine/index.md)<br>AidlService类，继承自LifecycleService，实现了ICoroutine和IService接口 |
| [AbsServiceProvider](-abs-service-provider/index.md) | [androidJvm]<br>abstract class [AbsServiceProvider](-abs-service-provider/index.md)(serviceCallback: [IService](../com.gyf.foundation.cs.common.service.face/-i-service/index.md)) : [IServiceProvider](../com.gyf.foundation.cs.common.service.face/-i-service-provider/index.md), [IMessage](../com.gyf.foundation.cs.common.face/-i-message/index.md), [IMessageQuick](../com.gyf.foundation.cs.common.face/-i-message-quick/index.md), [IServicePost](../com.gyf.foundation.cs.common.service.face/-i-service-post/index.md), [IServiceGet](../com.gyf.foundation.cs.common.service.face/-i-service-get/index.md) |
| [ServiceGet](-service-get/index.md) | [androidJvm]<br>class [ServiceGet](-service-get/index.md) : [IServiceGet](../com.gyf.foundation.cs.common.service.face/-i-service-get/index.md) |
| [ServicePost](-service-post/index.md) | [androidJvm]<br>class [ServicePost](-service-post/index.md) : [IServicePost](../com.gyf.foundation.cs.common.service.face/-i-service-post/index.md) |