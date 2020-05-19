package ua.nure.makieiev.factory

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        initProfileForm()
        initFilterStatistic()
        initSignOut()
    }

    private fun initProfileForm() {
        val profileButton = findViewById<Button>(R.id.profileButton)
        profileButton.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initSignOut() {
        val signOutButton = findViewById<Button>(R.id.signOutButton)
        signOutButton.setOnClickListener {
            val sharedPreference =
                this.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.remove("token")
            editor.remove("userId")
            editor.remove("login")
            finish()
        }
    }

    private fun initFilterStatistic() {
        val statisticButton = findViewById<Button>(R.id.filterStatisticButton)
        statisticButton.setOnClickListener {
            val intent = Intent(this, FilterStatisticActivity::class.java)
            startActivity(intent)
        }
    }

}