package com.ndesigne.jobig2.presentation.acceuil

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ndesigne.jobig2.R
import com.ndesigne.jobig2.data.model.Offre
import com.ndesigne.jobig2.presentation.acceuil.AcceuilActivity.staticVariable.listOfrre
import com.ndesigne.jobig2.presentation.acceuil.AcceuilActivity.staticVariable.positionG
import com.ndesigne.jobig2.presentation.main.MainActivity
import com.ndesigne.jobig2.presentation.offre.AcceuilViewModel
import com.ndesigne.jobig2.presentation.offre.OffreActivity
import kotlinx.android.synthetic.main.acceuil.*
import kotlinx.android.synthetic.main.item_recycleview.*
import org.koin.android.ext.android.inject

class AcceuilActivity : AppCompatActivity(), Adapter.OnItemClickListener {
     val  acceuilViewModel : AcceuilViewModel by inject()

    object staticVariable {
        var listOfrre = ArrayList<Offre>()
         var positionG :Int = 0
    }
    val list = ArrayList<Item>()
    lateinit var adapter : Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acceuil)
        recycleView.visibility = View.GONE
        progressBar.visibility = View.VISIBLE


        acceuilViewModel.getOffres()
        acceuilViewModel.myResponse.observe(this, Observer { response ->
            if(response.isSuccessful){
                response.body()?.let {

                    listOfrre = it
                    for (i in 0 until it.size) {
                        val drawable = when (i % 3) {
                            0 -> R.drawable.suitcase
                            1 -> R.drawable.suitcase
                            else -> R.drawable.suitcase
                        }


                        val item = Item(drawable,
                            it.get(i).title.toString(),
                            it.get(i).company.toString(),
                            it.get(i).type.toString(),
                            it.get(i).location.toString(),
                            it.get(i).created_at.toString() )
                        list += item
                    }
                     adapter = Adapter(list, this)
                    recycleView.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                    recycleView.adapter = adapter
                    recycleView.layoutManager = LinearLayoutManager(this)
                }
            }else {
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })

    }
    override fun onItemClick(position: Int) {

        Toast.makeText(this, "Offre $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem = list[position]
        positionG = position
        clickedItem.image = R.drawable.resume
        adapter.notifyItemChanged(position)


        val intent = Intent(this, OffreActivity::class.java)
        startActivity(intent)
    }
    override fun onBackPressed() {
        val a = Intent(Intent.ACTION_MAIN)
        a.addCategory(Intent.CATEGORY_HOME)
        a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(a)
    }

    fun deconect(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}