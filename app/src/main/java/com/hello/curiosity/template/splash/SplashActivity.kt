package com.hello.curiosity.template.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hello.curiosity.template.main.MainActivity
import com.hello.curiosity.R
import com.hello.curiosity.template.common.SchedulerProvider

class SplashActivity : AppCompatActivity(), SplashView {

    private lateinit var presenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        presenter = SplashPresenter(SchedulerProvider.default)
    }

    override fun onResume() {
        super.onResume()
        presenter.bind(this)
    }

    override fun onPause() {
        presenter.unbind()
        super.onPause()
    }

    override fun startMainActivity() {
        startActivity(MainActivity.createIntent(this))
        finish()
    }
}
