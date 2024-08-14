package com.example.newsnation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(val dataSet:List<Result>):
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view)
    {
        val textViewTitlle = view.findViewById<TextView>(R.id.tv_title)
        val textViewDescription = view.findViewById<TextView>(R.id.tv_description)

    }

    //Recyclerview calls this method when it needs to create a new viewholder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item_design,parent,false)
        return  ViewHolder(view)
    }

    //used to get the size of the dataset
    override fun getItemCount()= dataSet.size

    //recyclerview calls this method when it needs to bind the viewholder with data
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewTitlle.setText(dataSet.get(position).title)
        holder.textViewDescription.setText(dataSet.get(position).description)
    }
}