package hackathon.belif.belif.utils

import android.content.Context
import android.widget.ImageView
import androidx.constraintlayout.widget.Placeholder
import com.bumptech.glide.Glide

class GlideUtils(var context: Context) {
    fun show(source: Any, view: ImageView, placeholder: Int = 0, error: Int = 0){
        val e: Int = if(error == 0) placeholder else error
        Glide.with(context)
            .load(source)
            .into(view)
    }
}