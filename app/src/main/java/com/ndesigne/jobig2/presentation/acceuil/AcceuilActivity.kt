package com.ndesigne.jobig2.presentation.acceuil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.ndesigne.jobig2.R
import com.ndesigne.jobig2.presentation.offre.OffreActivity
import kotlinx.android.synthetic.main.acceuil.*

class AcceuilActivity : AppCompatActivity(), Adapter.OnItemClickListener {
    private val list = generateDummyList(50)
    private val adapter = Adapter(list, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acceuil)

        recycleView.adapter = adapter
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.setHasFixedSize(true)
    }
    override fun onItemClick(position: Int) {

        val intent = Intent(this, OffreActivity::class.java)
        startActivity(intent)

        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem = list[position]
        clickedItem.image = R.drawable.resume
        adapter.notifyItemChanged(position)
    }
    private fun generateDummyList(size: Int): List<Item> {
        val list = ArrayList<Item>()
        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.suitcase
                1 -> R.drawable.suitcase
                else -> R.drawable.suitcase
            }
            val item = Item(drawable, "title $i", "company $i", "type $i", "location $i", "date $i")
            list += item
        }
        return list
    }
}