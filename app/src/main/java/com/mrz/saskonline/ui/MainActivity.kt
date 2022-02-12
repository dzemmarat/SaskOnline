package com.mrz.saskonline.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.mrz.saskonline.R
import com.mrz.saskonline.databinding.ActivityMainBinding
import com.mrz.saskonline.extensions.gone
import com.mrz.saskonline.extensions.visible

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Инициализация биндинга для активити
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Инициализация тулбара
        setSupportActionBar(binding.toolbar)

        // Инициализация NavHostFragment
        navController = findNavController(R.id.fragmentContainerView)
        binding.bottomNavigationView.setupWithNavController(navController)

        // Отключаем обновление фрагмента при выборе той же вкладки
        binding.bottomNavigationView.setOnNavigationItemReselectedListener {  }
    }

    // Функция для вызова из фрагментов
    fun setNavigationBarVisible(isVisible: Boolean) {
        if (isVisible) {
            binding.bottomNavigationView.visible()
        } else {
            binding.bottomNavigationView.gone()
        }
    }

}