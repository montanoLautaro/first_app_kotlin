package com.example.firstapp.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.firstapp.databinding.ActivityDetailSuperHeroBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailSuperHeroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailSuperHeroBinding

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSuperHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.getStringExtra(EXTRA_ID).orEmpty()
        getSuperHeroInformation(id)

    }

    private fun getSuperHeroInformation(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val superHeroDetail =
                getRetrofit().create(ApiServiceSuperHero::class.java).getSuperHeroDetail(id)
            println("-----------------------------------${superHeroDetail.body()?.image?.url}")
            if(superHeroDetail.body() != null){
                runOnUiThread {
                    createUi(superHeroDetail.body()!!)
                }
            }
        }
    }

    private fun createUi(body: SuperHeroDetailResponse) {
        Picasso.get().load(body.image.url).into(binding.ivSuperHero)
        binding.tvSuperHeroName.text = body.name
        prepareStats(body.powerstats)
    }

    private fun prepareStats(powerstats: PowerStatsResponse) {
        updateHeight(binding.viewIntelligence, powerstats.intelligence.toInt())
        updateHeight(binding.viewStrength, powerstats.strength.toInt())
        updateHeight(binding.viewSpeed, powerstats.speed.toInt())
        updateHeight(binding.viewDurability, powerstats.durability.toInt())
        updateHeight(binding.viewPower, powerstats.power.toInt())
        updateHeight(binding.viewCombat, powerstats.combat.toInt())
    }

    private fun updateHeight(view: View, stat : Int){
        val params = view.layoutParams
        params.height = stat
        view.layoutParams = params
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}