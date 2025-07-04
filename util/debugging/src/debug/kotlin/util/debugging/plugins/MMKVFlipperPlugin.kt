package util.debugging.plugins

import com.facebook.flipper.core.FlipperConnection
import com.facebook.flipper.core.FlipperObject
import com.facebook.flipper.core.FlipperPlugin
import com.tencent.mmkv.MMKV

class MMKVFlipperPlugin(
    private val mmkv: MMKV
) : FlipperPlugin {

    override fun getId(): String = "MMKV"

    override fun onConnect(connection: FlipperConnection) {
        mmkv.all.forEach { key, value ->
            FlipperObject.Builder()
                .put("Key", key)
                .put("Value", value)
                .build()
                .let(connection::newRow)
        }
    }

    override fun onDisconnect() {
        // Nothing to do
    }

    override fun runInBackground(): Boolean = false

}

private fun FlipperConnection.newRow(row: FlipperObject) {
    send("newRow", row)
}
