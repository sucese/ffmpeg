# FFmpeg

**关于作者**

>郭孝星，程序员，吉他手，主要从事Android平台基础架构方面的工作，欢迎交流技术方面的问题，可以去我的[Github](https://github.com/guoxiaoxing)提issue或者发邮件至guoxiaoxingse@163.com与我交流。

本系列文章主要讨论Android平台视频编解码相关理论与实践，主要包含以下方面的内容。

>硬解码：由显卡核心GPU来对视频进行解码工作，优点是播放流畅，功耗低，缺点是收视频格式限制，画质比软解码查一些。

>软解码：由CPU来对视频进行解码，优点是不受视频格式限制，画质略好于硬解码，缺点是会占用额外的CPU资源。

播放器框架

- [ExoPlayer](https://github.com/google/ExoPlayer)：基于MediaCodec的硬解码播放器框架。支持mp4、mkv、mp3、aac、webm、mpeg-ts等媒体格式，同时支持HLS
DASH、smooth streaming等流媒体协议。
- [ijkplayer](https://github.com/Bilibili/ijkplayer)：在MediaCodec的基础上添加了基于ffmpeg和sdl的软解码方式，即ijkplayer既支持硬解，也支持软解。


## 编解码

### MediaCodec

- [01Androiid原生编解码框架篇：编解码框架概览](https://github.com/guoxiaoxing/awesome-android-video/blob/master/doc/MediaCodec/01Androiid原生编解码框架篇：编解码框架概览.md)
- [01Androiid原生编解码框架篇：MediaCodec](https://github.com/guoxiaoxing/awesome-android-video/blob/master/doc/MediaCodec/01Androiid原生编解码框架篇：MediaCodec.md)

### FFmpeg

- [01FFmpeg编解码框架篇：FFmpeg框架概览](https://github.com/guoxiaoxing/awesome-android-video/blob/master/doc/MediaCodec/01FFmpeg编解码框架篇：FFmpeg框架概览.md)

## 播放器

### 视频播放器
### 直播播放器
