package com.inaka.killertask

class WhenDone<T>(val map: Map<String, Any?>) {
    val success: (T) -> Unit by map
    val failure: (Exception) -> Unit by map

    object onSuccess : MyString() {
        override fun begin(): String {
            return "success"
        }
    }

    object onFailure : MyString() {
        override fun begin(): String {
            return "failure"
        }
    }

}
