# 비만도 계산기
## 핵심 내용
### Anko 라이브러리 사용 
* 두번째 화면으로 이동하는 코드인데, 첫 번째 코드는 자주 사용하는 코드, 두 번째 코드는 Anko 라이브러리를 이용한 코드이다.    
* 이 Anko 라이브러리는 많이 쓰일 것 같으므로 자세히 알아볼 예정이다.
~~~kotlin
val intent = Intent(this, ResultActivity::class.java)
startActivity(intent)
~~~
~~~kotlin
startActivity<ResultActivity>()
~~~
~~~kotiln
//Toast 코드도 마찬가지다
Toast.makeText(this. "$bmi", Toast.LENGTH_SHORT).show()

//Anko 적용된 토스트 코드
toast("$bmi")
~~~

### 간단한 데이터 저장 시에는 _SharedPreference_ 를 사용한다.
~~~kotlin
//데이터 저장 메소드
private fun saveData(height: Int, weight: Int) {
    val pref = PreferenceManager.getDefaultSharedPreferences(this)
    val editor = pref.edit()

    editor.putInt("KEY_HEIGHT", height)
        .putInt("KEY_WEIGHT", weight)
        .apply()
}
~~~

~~~kotlin
//데이터 불러오기 메소드
private fun loadData() {
    val pref = PreferenceManager.getDefaultSharedPreferences(this)
    val height = pref.getInt("KEY_HEIGHT", 0)
    val weight = pref.getInt("KEY_WEIGHT", 0)

    if(height != 0 && weight != 0) {
        heightEditText.setText(height.toString())
        weightEditText.setText(weight.toString())
    }
}
~~~