package pe.edu.upeu.asistenciaupeujcn

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.ExperimentalCoroutinesApi
import pe.edu.upeu.asistenciaupeujcn.utils.isNight

class MyApplication {
    @ExperimentalCoroutinesApi
    @HiltAndroidApp
    class MyApplication : Application(){
        override fun onCreate() {
            super.onCreate()
            val mode=if (isNight()){
                AppCompatDelegate.MODE_NIGHT_YES
            }else{
                AppCompatDelegate.MODE_NIGHT_NO
            }
            AppCompatDelegate.setDefaultNightMode(mode)
        }
    }
}