package ru.yodata.converterdppx

// Библиотека конвертации экранных единиц dp и px друг в друга

class ConverterDpPx {
    companion object {

        fun convertDpToPixels(density: Float, dp: Int) =
            (dp * density).toInt()

        fun convertPixelsToDp(density: Float, pixels: Int) =
            (pixels / density).toInt()
    }
}
