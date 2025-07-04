package ru.boostconf.app.common

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.arkivanov.decompose.defaultComponentContext
import ru.boostconf.app.common.ui.CommonActivityView
import dagger.hilt.android.AndroidEntryPoint
import feature.root.RootComponent
import javax.inject.Inject

@AndroidEntryPoint
class CommonActivity : ComponentActivity() {

    @Inject
    lateinit var rootComponentFactory: RootComponent.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(Color.TRANSPARENT, Color.TRANSPARENT),
            navigationBarStyle = SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT)
        )
        super.onCreate(savedInstanceState)
        WindowCompat.getInsetsController(window, window.decorView).apply {
            isAppearanceLightStatusBars = false
            isAppearanceLightNavigationBars = false
        }
        start(intent.dataString)
    }

    private fun start(
        initialDeeplink: String?
    ) {
        val rootComponent = rootComponentFactory(
            componentContext = defaultComponentContext(),
            initialDeeplink = initialDeeplink,
            isAuthorized = false
        )

        setContent {
            CommonActivityView(rootComponent)
        }
    }

}
