package info.sanaebadi.stackoverflowproject.util

import android.view.View
import info.sanaebadi.stackoverflowproject.model.user.UserPresentation

interface mOnItemClickListener {
    fun onItemClick(userViewModel: UserPresentation, view: View)
}