package com.example.memogram
import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class UserHome : AppCompatActivity() {
    lateinit var name : TextView;
    lateinit var btn_unfocus : Button;
    lateinit var btn : Button;
    lateinit var recyclerView: RecyclerView
    lateinit var photoList: ArrayList<Photos>
    lateinit var photoAdapter: PhotosAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_home)

        name = findViewById(R.id.homeusername);
        name.text = intent.getStringExtra("firstname")
        val btn = arrayOfNulls<Button>(4)
        var btn_unfocus: Button
        val btn_id = intArrayOf(R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3)

        recyclerView = findViewById(R.id.imgRecyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)


        photoList = ArrayList()

        photoList.add(Photos(R.drawable.businessman, "businessman"))
        photoList.add(Photos(R.drawable.gooderham, "gooderham"))
        photoList.add(Photos(R.drawable.brackets, "brackets"))
        photoList.add(Photos(R.drawable.cntower, "cntower"))
        photoList.add(Photos(R.drawable.hangginglights, "hangging Lights"))
        photoList.add(Photos(R.drawable.park1, "park1"))
        photoList.add(Photos(R.drawable.streetlight, "streetlight"))
        photoList.add(Photos(R.drawable.streetlight2, "streetlight1"))
        photoList.add(Photos(R.drawable.trainstation, "trainstation"))
        photoList.add(Photos(R.drawable.trainstation2, "trainstation2"))
        photoList.add(Photos(R.drawable.unionstation, "unionstation"))
        photoList.add(Photos(R.drawable.wonderingman, "wondering man"))
        photoList.add(Photos(R.drawable.fall2, "fall2"))
        photoList.add(Photos(R.drawable.fall3, "fall3"))
        photoList.add(Photos(R.drawable.cafe, "cafe"))
        photoList.add(Photos(R.drawable.cntowerbackentrance, "cntower back entrance"))
        photoList.add(Photos(R.drawable.wonderingman, "wondering man"))
        photoList.add(Photos(R.drawable.officeentrance, "office Entrance"))

        photoAdapter= PhotosAdapter(photoList)
        recyclerView.adapter = photoAdapter

        recyclerView.layoutManager = GridLayoutManager(this, 3)


        for (i in btn_id.indices){
            btn[i] = findViewById<View>(btn_id[i]) as Button
            btn[i]!!.setBackgroundColor(Color.rgb(207, 207, 207))

        }

        btn[0]!!



        //creating the action bar and show the back arrow
        val actionBar: ActionBar? = supportActionBar
        // calling the action bar
        actionBar?.setDisplayHomeAsUpEnabled(true)
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
    fun onClick(v: View) {
        //setForcus(btn_unfocus, (Button) findViewById(v.getId()));
        //Or use switch
        when (v.getId()) {
            R.id.btn0 -> setFocus(btn_unfocus, btn.findViewById(R.id.btn0))
            R.id.btn1 -> setFocus(btn_unfocus, btn.findViewById(R.id.btn1))
            R.id.btn2 -> setFocus(btn_unfocus, btn.findViewById(R.id.btn2))
            R.id.btn3 -> setFocus(btn_unfocus, btn.findViewById(R.id.btn3))
        }
    }

    private fun setFocus(btn_unfocus: Button, btn_focus: Button) {
        btn_unfocus.setTextColor(Color.rgb(49, 50, 51))
        btn_unfocus.setBackgroundColor(Color.rgb(207, 207, 207))
        btn_focus.setTextColor(Color.rgb(255, 255, 255))
        btn_focus.setBackgroundColor(Color.rgb(3, 106, 150))

    }
}