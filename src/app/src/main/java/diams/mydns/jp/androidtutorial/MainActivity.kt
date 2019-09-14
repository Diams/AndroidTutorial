package diams.mydns.jp.androidtutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    val handler = Handler();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 500msecごとに加速度センサを値を表示する
        Timer().schedule(object : TimerTask() {
            override fun run() {

                val x = 0.0
                val y = 0.0
                val z = 0.0

                // 文字を表示する
                handler.post {
                    val textView = findViewById<TextView>(R.id.main_acceleration_textView)
                    textView.text =
                        "x:" + x + "\n" +
                        "y:" + y + "\n" +
                        "z:" + z
                }
            }
        }, 0, 500)
    }
}
