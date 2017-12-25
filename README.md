# AndroidBase
android 基础库，为了简化代码而生

## 说明
* 1.1版本组件逐渐独立出来，因此不兼容1.0版本
* 提供Activity,Fragment基类
* 对DataBinding进行封装
* 提供CommonAdapter,BaseRecyclerAdapter
* 提供BaseSurfaceView(后期考虑独立出来)
* 提供NoSlidingViewPager(后期考虑独立出来)
* 提供VerticalSeekBar(后期考虑独立出来)
* 提供ProgressWebViewClient(后期考虑独立出来)
* ColorSnackbar已独立出来，不再包含此库
* AutoCompleteTextViewExtend已独立出来，不再包含此库
* RecyclerViewExtend已独立出来，不再包含此库
* SegmentBar已独立出来，不再包含此库
* ...

## JavaDoc文档

* [在线JavaDoc](https://jitpack.io/com/github/huweijian5/AndroidBase/1.0.3/javadoc/index.html)
* 网址：`https://jitpack.io/com/github/huweijian5/AndroidBase/[VersionCode]/javadoc/index.html`
* 其中[VersionCode](https://github.com/huweijian5/AndroidBase/releases)请替换为最新版本号
* 注意文档使用UTF-8编码，如遇乱码，请在浏览器选择UTF-8编码即可

---

## 注意

* 为了避免引入第三方库导致工程依赖多个版本的问题，如android support库
* 故建议在个人的工程目录下的build.gradle下加入以下变量，具体请看此[build.gradle](https://github.com/huweijian5/AndroidBase/blob/master/build.gradle)
```
ext{
    minSdkVersion = 16
    targetSdkVersion = 25
    compileSdkVersion = 25
    buildToolsVersion = '25.0.1'

    // App dependencies
    supportLibraryVersion = '25.0.1'
    junitVersion = '4.12'
    espressoVersion = '2.2.2'
}
```
* 请注意，对于此库已有的变量，命名请保持一致

## 引用

* 如果需要引用此库,做法如下：
* Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```	
* and then,add the dependecy:
```
dependencies {
	        compile 'com.github.huweijian5:AndroidBase:latest_version'
}
```
* 其中latest_version请到[releases](https://github.com/huweijian5/AndroidBase/releases)中查看
