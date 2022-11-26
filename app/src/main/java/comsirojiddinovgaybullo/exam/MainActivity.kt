package comsirojiddinovgaybullo.exam

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import comsirojiddinovgaybullo.exam.databinding.ActivityMainBinding
import comsirojiddinovgaybullo.exam.databinding.ConfigActivityBinding.inflate
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        }
    }
