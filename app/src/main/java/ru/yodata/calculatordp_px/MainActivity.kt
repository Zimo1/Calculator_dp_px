package ru.yodata.calculatordp_px

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
// Подключение своей библиотеки конвертации из другого модуля в этом же проекте
import ru.yodata.converterdppx.ConverterDpPx

// Калькулятор для конвертации экранных единиц dp и px друг в друга
class MainActivity : AppCompatActivity() {
    // Масштаб преобразования dp в px
    var density = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Получить значение текущего масштаба преобразования dp в px
        density = this.resources.displayMetrics.density
        // Отобразить его на экране
        findViewById<TextView>(R.id.dpiTv).text = density.toString()
        // Назначить слушателей кнопкам конвертации
        findViewById<ImageButton>(R.id.dp2pxButton).setOnClickListener {onDp2PxButtonClick()}
        findViewById<ImageButton>(R.id.px2dpButton).setOnClickListener {onPx2DpButtonClick()}
    }

    // Обработчик кнопки конвертации dp -> px
    fun onDp2PxButtonClick() {
        val dpStringValue = findViewById<TextView>(R.id.dpEdt).text.toString().trim()
        if (dpStringValue.isNotEmpty()) {
            findViewById<TextView>(R.id.pxEdt).text =
                    ConverterDpPx.convertDpToPixels(density, dpStringValue.toInt()).toString()
        }
    }

    // Обработчик кнопки конвертации px -> dp
    fun onPx2DpButtonClick() {
        val pxStringValue = findViewById<TextView>(R.id.pxEdt).text.toString().trim()
        if (pxStringValue.isNotEmpty()) {
            findViewById<TextView>(R.id.dpEdt).text =
                    ConverterDpPx.convertPixelsToDp(density, pxStringValue.toInt()).toString()
        }
    }
}