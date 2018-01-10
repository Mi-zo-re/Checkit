package xin.monus.checkit.daily

import android.content.Context
import android.graphics.Paint
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import xin.monus.checkit.R
import xin.monus.checkit.data.entity.Daily


class DailyListAdapter(val context: Context, list: List<Daily>, val itemClickedListener: DailyFragment.ItemClickedListener) :
        xin.monus.checkit.base.BaseAdapter<DailyListAdapter.ViewHolder>(context) {

    var list: List<Daily> = list
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            id = list[position].id
            remindTime.text = list[position].remindTime
            complete = list[position].complete
            content.text = list[position].content
            if (complete) {
                content.paint.flags = Paint.STRIKE_THRU_TEXT_FLAG or Paint.ANTI_ALIAS_FLAG
            }
            else {
                content.paint.flags = 0
            }
            if (!complete) {
                completeBtn.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.btn_normal))
            }
            else {
                completeBtn.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.btn_press))
            }

            completeBtn.setOnClickListener {
                if (!complete) {
                    println(complete)
                    completeBtn.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.btn_normal))
                    println(complete)
                }
                else {
                    println("hole")
                    completeBtn.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.btn_press))
                }
                notifyDataSetChanged()
                itemClickedListener.itemComplete(id)
            }

            holder.itemView.setOnClickListener {
                itemClickedListener.getID(id)
            }
        }
    }

    override fun getItemCount() = list.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.activity_daily_frag_item, parent, false)
        return DailyListAdapter.ViewHolder(view)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var id = -1
        val content: TextView = itemView.findViewById(R.id.daily_content)
        val remindTime: TextView = itemView.findViewById(R.id.daily_deadLine)
        var complete = false
        val completeBtn: ImageButton = itemView.findViewById(R.id.daily_complete)
    }
}