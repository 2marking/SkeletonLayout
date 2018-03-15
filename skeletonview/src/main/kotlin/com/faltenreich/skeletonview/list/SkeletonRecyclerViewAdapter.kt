package com.faltenreich.skeletonview.list

import android.support.annotation.ColorInt
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.faltenreich.skeletonview.SkeletonLayout

internal class SkeletonRecyclerViewAdapter(
        @LayoutRes private val layoutResId: Int,
        private val itemCount: Int,
        @ColorInt private val maskColor: Int,
        private val cornerRadius: Float,
        private val showShimmer: Boolean,
        @ColorInt private val shimmerColor: Int,
        private val shimmerDurationInMillis: Long
) : RecyclerView.Adapter<SkeletonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkeletonViewHolder {
        val originView = LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
        val maskView = SkeletonLayout(originView, maskColor, cornerRadius, showShimmer, shimmerColor, shimmerDurationInMillis)
        return SkeletonViewHolder(maskView)
    }

    override fun onBindViewHolder(holder: SkeletonViewHolder, position: Int) = Unit

    override fun getItemCount() = itemCount
}