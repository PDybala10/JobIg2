package com.ndesigne.jobig2.presentation.offre


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.ndesigne.jobig2.R
import com.ndesigne.jobig2.presentation.acceuil.AcceuilActivity
import com.ndesigne.jobig2.presentation.offre.Fonction.cleanString
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_offre.*
import org.koin.android.ext.android.inject


class OffreActivity : AppCompatActivity() {

    val offreViewModel : OffreViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offre)

        offreViewModel.LiveOffre.observe(this, Observer {

            //company_logo_offre_activity

            /*Recuperation  de l'image*/
            val url: String = it.company_logo.toString()
            Picasso.with(this).load(url).resize(461, 134).into(company_logo_offre_activity)

            title_offre_activity.text = it.title
            tv_description_offre_activity.text = cleanString(it.description.toString())
            location_offre_activity.text = it.location
            create_offre_activity.text = it.created_at


            val apply: String = cleanString(it.how_to_apply.toString())
            apply_offre.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View) {
                    try {
                        val browserItem =
                            Intent(Intent.ACTION_VIEW, Uri.parse(apply))
                        startActivity(browserItem)
                    } catch (e: Exception) {
                        Toast.makeText(
                            applicationContext,
                            "indisponible veillez retouvez l'offre sur le site via le bouton à gauche",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            })

            val site: String = it.company_url.toString()
            web_offre.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View) {
                    try {
                        val browserItem =
                            Intent(Intent.ACTION_VIEW, Uri.parse(site))
                        startActivity(browserItem)
                    } catch (e: java.lang.Exception) {
                        Toast.makeText(
                            applicationContext,
                            " site indisponible",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            })
            val description_offre = cleanString(it.description.toString())
            share_offre.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View) {
                    var intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT, description_offre)
                    intent.type = "text/plain"
                    intent = Intent.createChooser(intent, "Share by")
                    startActivity(intent)
                }
            })


        })



    }


    fun retour(view: View) {
        val intent = Intent(this.application, AcceuilActivity::class.java)
            startActivity(intent)
    }
    override fun onBackPressed() {
        val intent = Intent(this.application, AcceuilActivity::class.java)
        startActivity(intent)
    }


}