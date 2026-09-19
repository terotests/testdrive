package com.example.helloworld

import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View
import androidx.test.core.app.ActivityScenario
import java.io.File
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [33])
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class AppScreenScreenshotTest {

    @Test
    fun captureHelloWorldScreen() {
        ActivityScenario.launch(MainActivity::class.java).use { scenario ->
            var bitmap: Bitmap? = null
            scenario.onActivity { activity ->
                val root: View = activity.window.decorView.rootView
                root.post {
                    root.measure(
                        View.MeasureSpec.makeMeasureSpec(1080, View.MeasureSpec.EXACTLY),
                        View.MeasureSpec.makeMeasureSpec(2400, View.MeasureSpec.EXACTLY),
                    )
                    root.layout(0, 0, root.measuredWidth, root.measuredHeight)
                }
                root.postDelayed({
                    bitmap = Bitmap.createBitmap(
                        root.width.coerceAtLeast(1080),
                        root.height.coerceAtLeast(2400),
                        Bitmap.Config.ARGB_8888,
                    )
                    val canvas = Canvas(bitmap!!)
                    root.draw(canvas)
                }, 500)
            }
            Thread.sleep(1500)
            scenario.onActivity { activity ->
                val root = activity.window.decorView.rootView
                val shot = Bitmap.createBitmap(
                    root.width.coerceAtLeast(1080),
                    root.height.coerceAtLeast(2400),
                    Bitmap.Config.ARGB_8888,
                )
                root.draw(Canvas(shot))
                val dir = File(System.getenv("SCREENSHOT_DIR") ?: "/opt/cursor/artifacts/screenshots")
                dir.mkdirs()
                File(dir, "android_hello_world_ranger.png").outputStream().use { out ->
                    shot.compress(Bitmap.CompressFormat.PNG, 100, out)
                }
            }
        }
    }
}
