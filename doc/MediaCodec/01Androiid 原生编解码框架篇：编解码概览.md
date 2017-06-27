# Androiid 原生编解码框架篇：编解码框架概览

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

MediaCodec官方文档：https://developer.android.com/reference/android/media/MediaCodec.html

MediaCodec等一系列的类主要用来编解码音视频，整个家族成员主要包括以下几个类：

- MediaCodec：用来访问底层媒体编解码器，即编码器/解码器的部件。
- MediaExtractor
- MediaSync
- MediaMuxer
- MediaCrypto
- MediaDrm
- Image
- Surface
- AudioTrack


# 附录

- [Android MediaCodec stuff](http://bigflake.com/mediacodec/)
