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

import com.example.myapplication.databinding.Fragment2Binding



class Fragment2 : Fragment() {

    lateinit var binding: Fragment2Binding


    private var playMusic = false
    private var pause = true
    private var trek = 0
    private val listMusic = ArrayList<Int>()
    private val listNameMusic = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = Fragment2Binding.inflate(layoutInflater, container, false)
        listMusic.add(R.raw.yandex)
        listMusic.add(R.raw.mobile)
        listMusic.add(R.raw.itkyrs)
        listMusic.add(R.raw.games)

        listNameMusic.add("Как Яндекс развивает детское айти-образование")
        listNameMusic.add("Как стать мобильным разработчиком?")
        listNameMusic.add("Где искать бесплатные ИТ-курсы, в каком возрасте начинать учиться")
        listNameMusic.add("Как школьнику научиться разрабатывать игры?")
        // Inflate the layout for this fragment
        var mediaPlayer = MediaPlayer()
        mediaPlayer = MediaPlayer.create(context, listMusic[0])
        binding = Fragment2Binding.inflate(inflater, container, false)

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
            MAIN.navController.navigate(R.id.action_fragment2_to_homeFragment)
        }
    }
}


