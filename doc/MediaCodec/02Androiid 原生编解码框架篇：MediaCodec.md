# Androiid 原生编解码框架篇：MediaCodec

**关于作者**

>郭孝星，非著名程序员，主要从事Android平台基础架构与中间件方面的工作，爱好广泛，技术栈主要涉及以下几个方面
>
>- Android/Linux
>- Java/Kotlin/JVM
>- Python
>- JavaScript/React/ReactNative
>- DataStructure/Algorithm
>
>文章首发于[Github](https://github.com/guoxiaoxing)，后续也会同步在[简书](http://www.jianshu.com/users/66a47e04215b/latest_articles)与
[CSDN](http://blog.csdn.net/allenwells)等博客平台上。文章中如果有什么问题，欢迎发邮件与我交流，邮件可发至guoxiaoxingse@163.com。

>MediaCodec用来访问底层媒体编解码器，即编码器/解码器的部件。

## 数据格式

编解码器处理3种类型的数据，这3种数据都可以用ByteBuffers来处理，包括：

- 压缩数据（compressed data）
- 原始音频数据（raw audio data）
- 原始视频数据（raw video data）

## 处理流程

一个编解码器通常的流程是处理输入数据并生成输出数据，具体的流程如下：

1. 创建并配置一个MediaCodec对象。
2. 循环直至完成，如果输入缓冲区就绪，读取一个输入缓冲区就绪，读取一个输入块，并复制到输入缓冲区；如果输入缓冲区就绪，则复制输出缓冲区的数据。
3. 释放MediaCodec对象。

