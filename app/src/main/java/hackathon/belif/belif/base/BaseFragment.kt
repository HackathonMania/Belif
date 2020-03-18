package hackathon.belif.belif.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlin.reflect.KClass

abstract class BaseFragment : Fragment(){



    abstract fun setView(): Any
    abstract fun initView(view: View, savedInstanceState: Bundle?)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = setView()
        if (view is View)
            return view
        else if (view is Int)
            return inflater.inflate(view, container, false)
        return null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view, savedInstanceState)
    }


}