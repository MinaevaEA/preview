package util.debugging

@RequiresOptIn(
    message = "Этот функционал предусмотрен только в целях отладки и должен включаться только в debug-сборки",
    level = RequiresOptIn.Level.WARNING
)
@Retention(AnnotationRetention.BINARY)
annotation class DebugOnlyApi
