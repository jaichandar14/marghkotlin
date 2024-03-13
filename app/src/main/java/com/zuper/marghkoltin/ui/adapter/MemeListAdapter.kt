package com.zuper.marghkoltin.ui.adapter


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import com.zuper.marghkoltin.R


class MemeListAdapter(var context: Context) :
    RecyclerView.Adapter<MemeListAdapter.ViewHolder>() {
    var dataSet = ArrayList<String>()

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val textView: TextView
val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val backgroundpal: LinearLayout = view.findViewById(R.id.layut)
        init {
            // Define click listener for the ViewHolder's View
//            textView = view.findViewById(R.id.name)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.meme_quotes_list, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
//        viewHolder.textView.text = dataSet.get(position)
        val currentItem = dataSet[position]

        // Load your image into a Bitmap
        val bitmap = BitmapFactory.decodeResource(viewHolder.itemView.resources, R.drawable.margh_20240313_145232)

//// Create a Palette object from the Bitmap
        Palette.from(bitmap).generate { palette ->
            // Retrieve the dominant color from the palette
            val dominantColor = palette?.getDominantColor(Color.BLACK) ?: Color.BLACK
            // Use the dominant color in your UI
            // For example, set the background color of a view
            viewHolder.backgroundpal.setBackgroundColor(dominantColor)
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int = dataSet.size

    @SuppressLint("NotifyDataSetChanged")
    fun refreshItems(
        nameIcon: ArrayList<String>,
    ) {
        Log.d("TAG", "refreshItems: $nameIcon")
        dataSet?.clear()
        dataSet?.addAll(nameIcon)
        notifyDataSetChanged()
    }

    private var callBackInterface: CallBackInterface? = null

    // Initializing CallBack Interface Method
    fun setCallBackInterface(callback: CallBackInterface) {
        callBackInterface = callback
    }

    // CallBackInterface
    interface CallBackInterface {
        fun onClickAppName(dataSet: Array<String>? = null)
    }
}

