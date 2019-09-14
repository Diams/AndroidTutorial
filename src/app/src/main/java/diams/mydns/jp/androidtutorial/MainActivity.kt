package diams.mydns.jp.androidtutorial

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var sensorManager : SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    override fun onResume() {
        super.onResume()

        val accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        sensorManager.registerListener(sensorEventListener, accel, SensorManager.SENSOR_DELAY_UI)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(sensorEventListener)
    }

    val sensorEventListener = object : SensorEventListener {
        override fun onSensorChanged(sensorEvent: SensorEvent?) {
            if (sensorEvent!!.sensor.type == Sensor.TYPE_ACCELEROMETER) {
                val accel_text = String.format(
                    "x:%f\n" +
                    "y:%f\n" +
                    "z:%f",
                    0.0,    // X方向の加速度センサの値
                    0.0,    // Y方向の加速度センサの値
                    0.0)    // Z方向の加速度センサの値

                findViewById<TextView>(R.id.main_acceleration_textView).text = accel_text
            }
        }

        // 今回は使わない
        override fun onAccuracyChanged(sensor: Sensor?, accuacy: Int) {
        }
    }
}
