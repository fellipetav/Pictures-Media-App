package com.example.picturesmediaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    public override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //We have 2 different activities to Handle via Menus
        var id = item.itemId()
        if (id == R.id.menu_game) {
            val audioIntent = Intent(this, AudioActivity::class.java)
            startActivity(audioIntent)
        }
        else if(id == R.id.menu_pictures){
            val pictureIntent = Intent(this, PictureActivity::class.java)
            startActivity(pictureIntent)
        }
        return true
    }
}