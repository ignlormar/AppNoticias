package com.ignacio.appnoticias.mainModule.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.ignacio.appnoticias.R
import com.ignacio.appnoticias.classes.Noticias
import com.ignacio.appnoticias.databinding.ItemNoticiaBinding

class NoticiasAdapter(private val noticias: List<Noticias>, private val listener: OnClickListener): RecyclerView.Adapter<NoticiasAdapter.ViewHolder>() {

    private lateinit var context: Context

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ItemNoticiaBinding.bind(view)

        fun setListener(noticia: Noticias){
            binding.root.setOnClickListener {
                listener.onClick(noticia)
            }

            binding.root.setOnLongClickListener {
                listener.onLongClick(noticia)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        val view = LayoutInflater.from(context).inflate(R.layout.item_noticia, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = noticias.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val noticia = noticias[position]

        with(holder) {
            setListener(noticia)
            binding.tvTitular.text = noticia.titular
            binding.tvPreview.text = noticia.preview
            binding.tvFecha.text = noticia.fecha
            Glide.with(context)
                .load(noticia.imagen)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(binding.imgPhoto)
        }
    }
}