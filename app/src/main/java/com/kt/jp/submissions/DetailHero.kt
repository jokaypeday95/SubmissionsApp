package com.kt.jp.submissions

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.toBitmap
import kotlinx.android.synthetic.main.activity_detail_hero.*
import java.io.File
import java.io.FileOutputStream

class DetailHero : AppCompatActivity() {
    private val authorities: String = "com.kt.jp.submissions.fileprovider"

    companion object{
        const val EXTRA_NAME = "name"
        const val EXTRA_RATING = "rating"
        const val EXTRA_STATUS = "status"
        const val EXTRA_DETAIL = "description"
        const val EXTRA_IMG = "img"
    }

    private var paramName = ""
    private var paramRating = ""
    private var paramStatus = ""
    private var paramDetail = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_hero)

//        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)
//        val tvName: TextView = findViewById(R.id.tv_item_name)
//        val tvDetail: TextView = findViewById(R.id.tv_item_detail)

        val tvName: TextView = findViewById(R.id.tv_item_name)
        val tvPeringkatPT: TextView = findViewById(R.id.tv_item_peringkatPT)
        val tvStatusPT: TextView = findViewById(R.id.tv_item_statusPT)
        val tvDetail: TextView = findViewById(R.id.tv_item_detail)
        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)

        paramName = intent.getStringExtra(EXTRA_NAME).toString()
        paramRating = intent.getStringExtra(EXTRA_RATING).toString()
        paramStatus = intent.getStringExtra(EXTRA_STATUS).toString()
        paramDetail = intent.getStringExtra(EXTRA_DETAIL).toString()
        imgPhoto.setImageResource(intent.getIntExtra(EXTRA_IMG, 0))

        tvName.text = paramName
        tvPeringkatPT.text = paramRating
        tvStatusPT.text = paramStatus
        tvDetail.text = paramDetail


        actionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        if (menu != null) {
            menu.findItem(R.id.btn_set_share)?.isVisible = true
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }
            R.id.btn_set_share -> {
                Toast.makeText(this, "Share $paramName", Toast.LENGTH_SHORT).show()
                val bitmap = img_item_photo.drawable.toBitmap()
                val uri: Uri? = getMageToShare(bitmap, context = this)

                val share = Intent.createChooser(Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TITLE, paramName)
                    putExtra(Intent.EXTRA_TEXT, paramDetail)
                    putExtra(Intent.EXTRA_SUBJECT, "Share Image with Text")
                    putExtra(Intent.EXTRA_STREAM, uri)
                    setDataAndType(uri, "image/*")
                    flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
                }, "Share Via...")
                startActivity(share)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getMageToShare(bitmap: Bitmap, context: Context): Uri? {
        val imageFolder = File(context.cacheDir, "MyImagesShare")
        var uri: Uri? = null
        try {
            imageFolder.mkdirs()
            val file = File(imageFolder, "shared_image.png")
            val outputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
            outputStream.flush()
            outputStream.close()
            uri = FileProvider.getUriForFile(context, authorities, file)
        } catch (e: Exception){
            Toast.makeText(context, "" + e.message, Toast.LENGTH_SHORT).show()
        }
        return uri
    }
}