KillerTask
=====

This is a Kotlin Android library to create async background tasks. Inspired by [TinyTask](https://github.com/inaka/TinyTask), but more beautiful and easy to use for Kotlin Android developments.

### Abstract
Android's `AsyncTasks` are highly criticized for being bad, unreliable, outdated, etc. Are they perfect? No.
Do we have better alternatives? Sure, but sometimes all we want is a quick and simple way to run something in the background.

### What is it, really?
Just a wrapper around an `AsyncTask`, with a funny looking API.
The main difference between KillerTask and TinyTask is that this library is written in Kotlin language, very different from Java.
To learn how to use Kotlin in your Android app you can visit: [Android development with Kotlin](http://inaka.net/blog/2016/01/15/android-development-with-kotlin)

### How to download and install it
Add the following to your `build.gradle` file:

```groovy
repositories {
	maven {
		url "https://jitpack.io"
	}
}

dependencies {
	// ...
  compile 'com.github.inaka:killertask:v1.2'
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

    val doWork: () -> String = {
        "test" // implicit return
    }

    KillerTask(doWork, onSuccess, onFailed).go()
```
or simply:

```kotlin
    KillerTask(
            { "test" }, // task
            {result: String -> Log.wtf("result", result)}, // onSuccess actions
            {e: Exception? -> Log.wtf("result", e.toString())} // onFailed actions
        ).go()
```

Actually, the only strongly necessary parameter is the first (the main task):

```kotlin     
    KillerTask({ Log.wtf("LOG", "KillerTask is awesome") }).go() // only main task
```
```kotlin  
    KillerTask(
            { Log.wtf("LOG", "KillerTask is awesome") }, // main task
            { Log.wtf("LOG", "Super awesome!")} // onSuccess
    ).go()
```
```kotlin 
    KillerTask(
            { // main task
                Log.wtf("LOG", "KillerTask is awesome")
                "super" // implicit return
            },
            {}, // onSuccess is empty
            { e: Exception? -> Log.wtf("LOG", e.toString()) } // onFailed
    ).go()
```


### App example that use KillerTask
*[Kotlillon](https://github.com/inaka/kotlillon)


### Contact Us
For **questions** or **general comments** regarding the use of this library, please use our public
[hipchat room](http://inaka.net/hipchat).

If you find any **bugs** or have a **problem** while using this library, please [open an issue](https://github.com/inaka/KillerTask/issues/new) in this repo (or a pull request :)).

And you can check all of our open-source projects at [inaka.github.io](http://inaka.github.io)