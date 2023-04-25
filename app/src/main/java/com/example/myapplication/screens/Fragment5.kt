package com.example.myapplication.screens

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.myapplication.MAIN
import com.example.myapplication.R
import com.example.myapplication.databinding.Fragment5Binding

class Fragment5 : Fragment() {

    lateinit var binding: Fragment5Binding
    private var playMusic = false
    private var pause = true
    private var trek = 0
    private val listMusic = ArrayList<Int>()
    private val listNameMusic = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment5Binding.inflate(layoutInflater, container, false)
        listMusic.add(R.raw.neschastn)
        listMusic.add(R.raw.vigoranie)
        listMusic.add(R.raw.pravilgizn)
        listMusic.add(R.raw.organizashion)

        listNameMusic.add("Привык быть несчастным. Почему всё хорошо, но удовольствия от жизни мало?")
        listNameMusic.add("Переработки и выгорание — как закончить этот ад?")
        listNameMusic.add("Как понять, что я строю свою жизнь правильно?")
        listNameMusic.add("Организация своих будней, прокрастинация и дисциплина")
        // Inflate the layout for this fragment
        var mediaPlayer = MediaPlayer()
        mediaPlayer = MediaPlayer.create(context, listMusic[0])
        binding = Fragment5Binding.inflate(inflater, container, false)

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1,
            listNameMusic)

        binding.listv.adapter = adapter
        binding.listv.setOnItemClickListener { parent, view, position, id ->


            mediaPlayer.stop()
            mediaPlayer = MediaPlayer.create(context, listMusic[position])
            mediaPlayer.start()
            playMusic = true
            listNameMusic[position] = listNameMusic[position] + "|>"
            Toast.makeText(requireContext(), "Играет ${listNameMusic[position]}",
                Toast.LENGTH_LONG).show()

        }


        binding.buttonstart.setOnClickListener{

            mediaPlayer.start()
            playMusic = true
        }

        binding.buttonpause.setOnClickListener{

            mediaPlayer.pause()
            playMusic = true
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageButtonBack.setOnClickListener{
            MAIN.navController.navigate(R.id.action_fragment5_to_homeFragment)
        }
    }


}