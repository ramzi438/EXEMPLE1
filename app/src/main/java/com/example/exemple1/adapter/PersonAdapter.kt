package com.example.exemple1.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.exemple1.MyDiffUtil
import com.example.exemple1.databinding.RowItemBinding
import com.example.exemple1.model.Person

class PersonAdapter : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {
    private var oldPersonList: List<Person> = emptyList()
    private var dataSet: ArrayList<Person> = arrayListOf()
    lateinit var binding:RowItemBinding

    class ViewHolder(var view: RowItemBinding) : RecyclerView.ViewHolder(view.root) {


    }


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        binding= RowItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Log.i("cch", "setData: $dataSet")

        viewHolder.view.person=dataSet[position]

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    fun setData(newPersonList:List<Person>){
        var diffUtil=MyDiffUtil(dataSet,newPersonList)
        val diffResult=DiffUtil.calculateDiff(diffUtil)
        dataSet.clear()
        dataSet.addAll(newPersonList)
        diffResult.dispatchUpdatesTo(this)

    }
}
