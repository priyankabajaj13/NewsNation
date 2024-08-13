package com.example.newsnation

import android.graphics.Rect
import android.view.View
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration


class CustomRecyclerDecoration() : ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val itemPosition = parent.getChildAdapterPosition(view!!)
        if (itemPosition == 0) {
            return
        }
        outRect.set(0, 0, 0, -150) //<-- bo
    }
//    fun getItemOffsets(
//        outRect: Rect, view: View?,
//        parent: RecyclerView,
//        state: RecyclerView.State?
//    ) {
//        val itemPosition = parent.getChildAdapterPosition(view!!)
//        if (itemPosition == 0) {
//            return
//        }
//        outRect.set(0, 0, 0, -150) //<-- bottom
//    }
}

