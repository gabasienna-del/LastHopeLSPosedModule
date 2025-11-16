package com.laibandis.gaba

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    private lateinit var statusTv: TextView
    private lateinit var pickBtn: Button
    private lateinit var startBtn: Button
    private lateinit var stopBtn: Button
    private lateinit var licenseEt: EditText

    private val pickImageLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val uri: Uri? = data?.data
            if (uri != null) {
                readAndStoreUri(uri)
            } else {
                statusTv.text = "Фото не выбрано"
            }
        } else {
            statusTv.text = "Выбор фото отменён"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        statusTv = findViewById(R.id.statusTv)
        pickBtn = findViewById(R.id.pickBtn)
        startBtn = findViewById(R.id.startBtn)
        stopBtn = findViewById(R.id.stopBtn)
        licenseEt = findViewById(R.id.licenseEt)

        pickBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.type = "image/*"
            pickImageLauncher.launch(intent)
        }

        startBtn.setOnClickListener {
            statusTv.text = "Старт подмены (демо)"
        }

        stopBtn.setOnClickListener {
            PhotoStore.clear()
            statusTv.text = "Стоп — фото очищено"
        }
    }

    private fun readAndStoreUri(uri: Uri) {
        try {
            val input: InputStream? = contentResolver.openInputStream(uri)
            if (input != null) {
                val bytes = input.readBytes()
                input.close()
                PhotoStore.setPhoto(bytes)
                statusTv.text = "Фото выбрано, размер ${'$'}{bytes.size} байт"
            } else {
                statusTv.text = "Не удалось открыть файл"
            }
        } catch (e: Exception) {
            statusTv.text = "Ошибка чтения фото: ${'$'}{e.message}"
        }
    }
}
