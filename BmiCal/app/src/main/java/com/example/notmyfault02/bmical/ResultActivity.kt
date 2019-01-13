package com.example.notmyfault02.bmical

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //인텐트에서 데이터 꺼내기(키, 몸무게), 문자열을 Int로

        val height = intent.getStringExtra("height").toInt()
        val weight = intent.getStringExtra("weight").toInt()

        //BMI 계산, Math 메소드 사용
        val bmi = weight / Math.pow(height / 100.0, 2.0)


        //BMI별 결과
        when {
            bmi >= 35 -> resultTextView.text = "고도 비만"
            bmi >= 30 -> resultTextView.text = "2단계 비만"
            bmi >= 25 -> resultTextView.text = "1단계 비만"
            bmi >= 23 -> resultTextView.text = "과체중"
            bmi >= 18.5 -> resultTextView.text = "정상"
            else -> resultTextView.text = "저체중"
        }


        //BMI별 이미지
        when {
            bmi >= 23 ->
                imageView.setImageResource(R.drawable.ic_sentiment_very_dissatisfied_black_24dp)
            bmi >= 18.5 ->
                imageView.setImageResource(R.drawable.ic_sentiment_satisfied_black_24dp)
            else ->
                imageView.setImageResource(R.drawable.ic_sentiment_dissatisfied_black_24dp)
        }


        //Toast 메시지 추가
        Toast.makeText(this,"$bmi", Toast.LENGTH_SHORT).show()
        //toast("$bmi")
    }
}
