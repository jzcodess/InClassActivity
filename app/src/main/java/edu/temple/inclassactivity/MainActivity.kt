package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import android.widget.SpinnerAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var spinner: Spinner? = null
    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Bind views
        spinner = findViewById(R.id.spinner)
        recyclerView = findViewById(R.id.recyclerView)

        // Fetch images into Array<Int> called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = Array(typedArray.length()) {typedArray.getResourceId(it, 0)}
        typedArray.recycle()

        // Display images specified in imageArray in Spinner and RecyclerView
        val spinnerAdapter: SpinnerAdapter = CustomSpinnerAdapter(this, imageArray)
        val recyclerAdapter: RecyclerView.Adapter<*> = CustomRecyclerAdapter(imageArray)

        spinner?.adapter = spinnerAdapter
        recyclerView?.layoutManager = GridLayoutManager(this, 3)
        recyclerView?.adapter = recyclerAdapter
    }
}