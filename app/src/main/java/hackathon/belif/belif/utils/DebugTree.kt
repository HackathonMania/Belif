package hackathon.belif.belif.utils

import timber.log.Timber

class DebugTree(private val tag: String) : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement): String? {
        val log = element.fileName + ":" + element.lineNumber
        return String.format("(%s) $tag", log)
    }
}