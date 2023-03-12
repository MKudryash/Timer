package com.example.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.timer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startTimer()
    }
    //метод для таймера
    fun startTimer()
    {
        /**
         * 1 parameter (millislnFuture) - количество миллексунд для таймера (40000 - 40 секунд)
         * 2 parameter (countDownInterval) - количество миллексунд для одного тика (1000 - 1 секунда)
         */
        val timer = object: CountDownTimer(40000, 1000) {
            //Метод onTick вызывается каждый раз по истечению одного тика
            override fun onTick(millisUntilFinished: Long) {
                val elapsedSeconds = millisUntilFinished / 1000 //переводим миллесекунды в секунды
                binding.txtTimer.text ="$elapsedSeconds sec" // кладем в textView
            }

            override fun onFinish() {
                //Что будет происходить после окончания таймера
            }
        }
        timer.start() //Запуск таймера
    }

}