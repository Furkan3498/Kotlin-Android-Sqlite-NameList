package com.furkanceylan.guidebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.furkanceylan.guidebook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val context = this
        var db = DataBaseHelper(context)



        binding.btnkaydet.setOnClickListener{
            var etadsoyad = binding.etadsoyad.text.toString()
            var etyas = binding.etyas.text.toString()
            if (etadsoyad.isNotEmpty()&& etyas.isNotEmpty()){
                var kullanici = Kullanici(etadsoyad,etyas.toInt())
                db.insertData(kullanici)
                var users = db.getUsers()
                binding.tvsonuc.text = ""
                for (i in 0 until users.size){
                    binding.tvsonuc.append(users.get(i).adsoyad+" "+ users.get(i).yasi + "\n")
                }
            }else{
                Toast.makeText(applicationContext,"Lütden Boş Bırakmayın",Toast.LENGTH_LONG).show()
            }
        //binding.btnoku.performClick()

        }

/* yukarıya yazdım
        binding.btnoku.setOnClickListener{
        var users = db.getUsers()
            binding.tvsonuc.text = ""
            for (i in 0 until users.size){
                binding.tvsonuc.append(users.get(i).adsoyad+" "+ users.get(i).yasi + "\n")

    }*/
        binding.btnsil.setOnClickListener{
            db.deleteData()
          //  binding.btnoku.performClick()
            var users = db.getUsers()
            binding.tvsonuc.text = ""
            for (i in 0 until users.size) {
                binding.tvsonuc.append(users.get(i).adsoyad + " " + users.get(i).yasi + "\n")
            }

            }
    }
}