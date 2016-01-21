# KillerTask
========

This is a Kotlin Android library to create async background tasks. Inspired by [TinyTask](https://github.com/inaka/TinyTask), but easier.

### Abstract
Android's `AsyncTasks` are highly criticized for being bad, unreliable, outdated, etc. Are they perfect? No.
Do we have better alternatives? Sure, but sometimes all we want is a quick and simple way to run something in the background.

### What is it, really?
Just a wrapper around an `AsyncTask`, with a funny looking API. The main difference between KillerTask and TinyTask is that this library is written in Kotlin for Kotlin Android developments.

### How to download and Install
Add the following to your `build.gradle` file:

```groovy
repositories {
	maven {
		url "https://jitpack.io"
	}
}

dependencies {
	// ...
  compile 'com.github.inaka:killertask:v1.0'
  // ...
}
```

### Code Examples


```kotlin
    val onSuccess: (String) -> Unit = {
        result: String ->
        Log.wtf("result", result)
    }

    val onFailed: (Exception?) -> Unit = {
        e: Exception? ->
      	Log.wtf("result", e.toString())
    }

    init {
        KillerTask(doWork(), onSuccess, onFailed).go()
    }

    fun doWork(): String {
        return "test"
    }
```
or simply:

```kotlin
      KillerTask(
                "test", // task
                {result: String -> Log.wtf("result", result)}, // onSuccess actions
                {e: Exception? -> Log.wtf("result", e.toString()) // onFailed actions
            }).go()
```

### Contact Us
For **questions** or **general comments** regarding the use of this library, please use our public
[hipchat room](http://inaka.net/hipchat).

If you find any **bugs** or have a **problem** while using this library, please [open an issue](https://github.com/inaka/KillerTask/issues/new) in this repo (or a pull request :)).

And you can check all of our open-source projects at [inaka.github.io](http://inaka.github.io)

### Thanks to
[TinyTask](https://github.com/inaka/TinyTask) for inspiration