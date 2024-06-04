package com.example.guesswhat.mynavigation

import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.tensorflow.lite.Interpreter
import java.io.FileInputStream
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel

class simuasimodelnegatif : AppCompatActivity() {
    private lateinit var interpreter: Interpreter
    private val mModelPath = "diabetes.tflite"

    private lateinit var resultText: TextView
    private lateinit var gender: EditText
    private lateinit var age: EditText
    private lateinit var hypertension: EditText
    private lateinit var smokinghistory: EditText
    private lateinit var heartdisease: EditText
    private lateinit var bmi: EditText
    private lateinit var averagebloodsugarlevel: EditText
    private lateinit var glucose: EditText
    private lateinit var checkButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simuasimodelnegatif)

        resultText = findViewById(R.id.txtResult)
        gender = findViewById(R.id.gender)
        age = findViewById(R.id.glucose)
        hypertension = findViewById(R.id.hypertension)
        heartdisease = findViewById(R.id.heartdisease)
        smokinghistory = findViewById(R.id.smokinghistory)
        bmi = findViewById(R.id.bmi)
        averagebloodsugarlevel = findViewById(R.id.averagebloodsugarlevel)
        glucose = findViewById(R.id.glucose)
        checkButton = findViewById(R.id.btnpredict)

        checkButton.setOnClickListener {
            var result = doInference(
                gender.text.toString(),
                age.text.toString(),
                hypertension.text.toString(),
                heartdisease.text.toString(),
                smokinghistory.text.toString(),
                bmi.text.toString(),
                averagebloodsugarlevel.text.toString(),
                glucose.text.toString()

            )
            runOnUiThread {
                if (result < 1) {
                    resultText.text = "Tidak Diabetes"
                } else if (result >= 1) {
                    resultText.text = "Positif Diabetes"
                }
            }

        }
        initInterpreter()

    }

    private fun initInterpreter() {
        val options = Interpreter.Options()
        options.setNumThreads(6)
        options.setUseNNAPI(true)
        interpreter = Interpreter(loadModelFile(assets, mModelPath), options)
    }

    private fun doInference(
        input1: String,
        input2: String,
        input3: String,
        input4: String,
        input5: String,
        input6: String,
        input7: String,
        input8: String
    ): Float {
        val inputVal = FloatArray(8)
        inputVal[0] = input1.toFloat()

        inputVal[1] = input2.toFloat()

        inputVal[2] = input3.toFloat()

        inputVal[3] = input4.toFloat()

        inputVal[4] = input5.toFloat()

        inputVal[5] = input6.toFloat()

        inputVal[6] = input7.toFloat()

        inputVal[7] = input8.toFloat()
        val output = Array(1) {
            FloatArray(1)
        }
        Log.e("result", (output[0].toList() + "").toString())
        interpreter.run(inputVal, output)
        return output[0][0]
    }

    private fun loadModelFile(assetManager: AssetManager, modelPath: String): MappedByteBuffer {
        val fileDescriptor = assetManager.openFd(modelPath)
        val inputStream = FileInputStream(fileDescriptor.fileDescriptor)
        val fileChannel = inputStream.channel
        val startOffset = fileDescriptor.startOffset
        val declaredLength = fileDescriptor.declaredLength
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength)
    }
}
