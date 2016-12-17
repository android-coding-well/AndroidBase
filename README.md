# AndroidBase
android 基础库

## JavaDoc文档

* [在线JavaDoc](https://jitpack.io/com/github/huweijian5/AndroidBase/1.0.0/javadoc/index.html)
* 网址：`https://jitpack.io/com/github/huweijian5/AndroidBase/[VersionCode]/javadoc/index.html`
* 其中[VersionCode](https://github.com/huweijian5/AndroidBase/releases)请替换为最新版本号
* 注意文档使用UTF-8编码，如遇乱码，请在浏览器选择UTF-8编码即可

---

## 说明

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
