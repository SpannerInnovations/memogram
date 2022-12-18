package com.example.memogram
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.provider.MediaStore
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.memogram.R
import java.io.File
import java.io.FileOutputStream
import java.util.jar.Manifest

class PhotoActivity : AppCompatActivity() {

    var btnClick: Button? = null

    var btnSharePhoto: Button? = null

    var imageviewPicture: ImageView? = null

    var draw: Drawable? = null

    var bitMapPic: Bitmap? = null


    private var our_request_code: Int = 123

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

        btnClick = findViewById<Button>(R.id.buttonClickPicture)
        imageviewPicture = findViewById<ImageView>(R.id.imageViewPicture)

        btnSharePhoto = findViewById(R.id.buttonShare) as Button

        if(ContextCompat.checkSelfPermission(applicationContext,android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), our_request_code)

            btnClick!!.setOnClickListener {
                try {
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(intent, our_request_code)
                } catch (e: java.lang.Exception) {
                    e.stackTrace
                }

            }//end btnClick
        }//end if

        btnSharePhoto?.setOnClickListener {
            //call function shareImage()
            shareImage()

        }//end btnSharePhoto


        //creating the action bar and show the back arrow
        val actionBar: ActionBar? = supportActionBar
        // calling the action bar
        actionBar?.setDisplayHomeAsUpEnabled(true)




    }//end onCreate

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == our_request_code && resultCode == RESULT_OK){
            val bitmap = data?.extras?.get("data") as Bitmap
            imageviewPicture!!.setImageBitmap(bitmap)
        }

    }//end onActivityResult

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

    //shareImage function
      fun  shareImage(){
             var builder : StrictMode.VmPolicy.Builder  = StrictMode.VmPolicy.Builder()
            StrictMode.setVmPolicy(builder.build())
            //getting the picture taken with click button in the Photo Activity
            draw = imageviewPicture?.drawable as BitmapDrawable
            bitMapPic = (draw as BitmapDrawable).bitmap

            var file : File = File( externalCacheDir,"/" + "newpic" + ".png")
            var intent: Intent =  Intent()

            try{
                var outputS: FileOutputStream = FileOutputStream(file)
                bitMapPic!!.compress(Bitmap.CompressFormat.JPEG,100,outputS)
                outputS.flush()
                outputS.close()
                intent = Intent(Intent.ACTION_SEND)
                intent.setType("image/*")
                intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file))
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

            }catch (e: java.lang.Exception){
                throw RuntimeException(e)
            }

            startActivity(Intent.createChooser(intent,"Share image via: "))

      }

}