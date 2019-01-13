package com.example.notmyfault02.bmical

import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) //
        setContentView(R.layout.activity_main)

        loadData()

        //결과버튼 눌렀을 때 ResultActivity로
        resultButton.setOnClickListener {
            //데이터 저장, Int형으로 반환해서 저장
            saveData(heightEditText.text.toString().toInt(),
                weightEditText.text.toString().toInt())

            startActivity<ResultActivity>(
                //key와 값을 받는다(키, 몸무게)
                "height" to heightEditText.text.toString(),
                "weight" to weightEditText.text.toString()
            )
        }

    }

    //데이터 저장 메소드
    private fun saveData(height: Int, weight: Int) {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()

        editor.putInt("KEY_HEIGHT", height)
            .putInt("KEY_WEIGHT", weight)
            .apply()
    }

    //데이터 불러오기 메소드
    private fun loadData() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val height = pref.getInt("KEY_HEIGHT", 0)
        val weight = pref.getInt("KEY_WEIGHT", 0)

        if (height != 0 && weight != 0) {
            heightEditText.setText(height.toString())
            weightEditText.setText(weight.toString())
        }
    }
}
