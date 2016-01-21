package com.inaka.killertask

class WhenDone<T>(val map: Map<String, Any?>) {

    val success: (T) -> T by map
    val failure: (Exception?) -> T by map

    companion object {
        public val success = "success"
        public val failed = "failure"
    }

}
