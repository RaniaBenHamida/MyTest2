package com.example.mytest2.views

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.mytest2.R
import com.example.mytest2.response.Astro

class AdapterTest (internal var context: Context, internal var data: List<Astro>, internal var activity: Activity) :
    BaseAdapter() {

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(pIi: Int): Long {
        return data.indexOf(getItem(pIi)).toLong()
    }

    override fun getView(position: Int, convertView: View?, pVGview: ViewGroup): View {
        var view = convertView
        var holder = ViewHolder()
        if (view == null) {
            val inflator = context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflator.inflate(R.layout.item_astro, null)
            holder.layout = view!!.findViewById<View>(R.id.layoutAstro) as LinearLayout
            holder.imgAstro = view!!.findViewById<View>(R.id.imgAstro) as ImageView
            holder.titleAstr = view!!.findViewById<View>(R.id.txtTitleAstro) as TextView
            holder.dateAstr = view!!.findViewById<View>(R.id.txtDateAstro) as TextView
            view!!.tag = holder
        } else {
            holder = view.tag as ViewHolder
        }

        holder.titleAstr!!.text = data[position].title
        holder.dateAstr!!.text = data[position].date
        Glide.with(activity).load(data[position].urlSimple).into(holder.imgAstro!!)


        holder.layout!!.setOnClickListener {

            val intent = Intent(activity, SecondActiviyy::class.java)
            intent.putExtra("Titre", data[position].title)
            intent.putExtra("Date", data[position].date)
            intent.putExtra("Url", data[position].urlHD)
            intent.putExtra("Explanation", data[position].explanation)
            intent.putExtra("Copy", data[position].copyRight)

            activity.startActivity(intent)

        }
        return view
    }

    internal inner class ViewHolder {
        var layout: LinearLayout? = null
        var imgAstro: ImageView? = null
        var titleAstr: TextView? = null
        var dateAstr: TextView? = null
    }
}
