package com.inaka.killertask

class DoThis<T>(val map: Map<String, Any?>) {
        val ifOk: (T) -> Unit by map
        val ifNotOk: (Exception) -> Unit by map

    companion object {
        val ok:String = "ifOk"
        val notOk:String = "ifNotOk"
    }
}
