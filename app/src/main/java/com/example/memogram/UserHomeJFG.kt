package com.example.memogram

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView


class UserHomeJFG : AppCompatActivity() {

    lateinit var name : TextView;
    lateinit var btn_unfocus : Button;
    lateinit var btn : Button;
    lateinit var recyclerView: RecyclerView
    lateinit var photoList: ArrayList<Photos>
    lateinit var photoAdapter: PhotosAdapter
    lateinit var bottomNav : BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_home)

        name = findViewById(R.id.homeusername);
        name.text = intent.getStringExtra("firstname2")



        recyclerView = findViewById(R.id.imgRecyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)


        photoList = ArrayList()

//        photoList.add(Photos(R.drawable.businessman, "businessman"))
//        photoList.add(Photos(R.drawable.gooderham, "gooderham"))
//        photoList.add(Photos(R.drawable.brackets, "brackets"))
//        photoList.add(Photos(R.drawable.cntower, "cntower"))
//        photoList.add(Photos(R.drawable.hangginglights, "hangging Lights"))
//        photoList.add(Photos(R.drawable.park1, "park1"))
//        photoList.add(Photos(R.drawable.streetlight, "streetlight"))
//        photoList.add(Photos(R.drawable.streetlight2, "streetlight1"))
//        photoList.add(Photos(R.drawable.trainstation, "trainstation"))
//        photoList.add(Photos(R.drawable.trainstation2, "trainstation2"))
//        photoList.add(Photos(R.drawable.unionstation, "unionstation"))
//        photoList.add(Photos(R.drawable.wonderingman, "wondering man"))
//        photoList.add(Photos(R.drawable.fall2, "fall2"))
//        photoList.add(Photos(R.drawable.fall3, "fall3"))
//        photoList.add(Photos(R.drawable.cafe, "cafe"))
//        photoList.add(Photos(R.drawable.cntowerbackentrance, "cntower back entrance"))
//        photoList.add(Photos(R.drawable.wonderingman, "wondering man"))
//        photoList.add(Photos(R.drawable.officeentrance, "office Entrance"))

        photoAdapter= PhotosAdapter(photoList)
        recyclerView.adapter = photoAdapter

        recyclerView.layoutManager = GridLayoutManager(this, 3)




        loadFragment(AddFragment())
        bottomNav = findViewById(R.id.bottomNavigationView) as BottomNavigationView
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(AddFragment())
                    true
                }
                R.id.connection -> {
                    loadFragment(ConnectionFragment())
                    true
                }
                R.id.shareFrag -> {
                    loadFragment(ShareFragment())
                    true
                }
                else -> {

                    loadFragment(AddFragment())
                    true

                }
            }
        }

        //creating the action bar and show the back arrow
        val actionBar: ActionBar? = supportActionBar
        // calling the action bar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun onAdd(view: View){
        val intent = Intent(this,AddActivity::class.java)
        //intent.putExtra("firstname", name.text.toString());
        startActivity(intent)
    }

    //method called when click on back arrow
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }

    private fun setFocus(btn_unfocus: Button, btn_focus: Button) {
        btn_unfocus.setTextColor(Color.rgb(49, 50, 51))
        btn_unfocus.setBackgroundColor(Color.rgb(207, 207, 207))
        btn_focus.setTextColor(Color.rgb(255, 255, 255))
        btn_focus.setBackgroundColor(Color.rgb(3, 106, 150))

    }
}