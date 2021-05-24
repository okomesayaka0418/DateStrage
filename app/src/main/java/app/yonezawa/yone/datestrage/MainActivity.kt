package app.yonezawa.yone.datestrage

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //"DateStore"という名前でインスタンスを作成
        val dateStore: SharedPreferences = getSharedPreferences("DateStore",Context.MODE_PRIVATE)
         saveButton.setOnClickListener {
             //エディットテキストのテキスト取得
             val stringText = editText.text.toString()
             saveText.text = stringText

             //入力文字列を”Input”に書き込む
             val editor = dateStore.edit()
             editor.putString("Input",stringText)

             editor.apply()


         }
        readButton.setOnClickListener {
            //"Input"から読みだす
            val str = dateStore.getString("Input","Nodate")
            readText.text = str
        }
    }
}