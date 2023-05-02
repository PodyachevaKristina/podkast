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
import com.example.myapplication.databinding.Fragment4Binding


class Fragment4 : Fragment() {

    lateinit var binding: Fragment4Binding
    private var playMusic = false
    private var pause = true
    private var trek = 0
    private val listMusic = ArrayList<Int>()
    private val listNameMusic = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment4Binding.inflate(layoutInflater, container, false)
        listMusic.add(R.raw.pochemydymaem)
        listMusic.add(R.raw.ctraxi)
        listMusic.add(R.raw.pvsc)
        listMusic.add(R.raw.neyclozn)


        listNameMusic.add("Почему мы так много думаем?")
        listNameMusic.add("Страхи и как не бояться, когда все вокруг боятся")
        listNameMusic.add("Перфекционизм vs Самосовершенствование")
        listNameMusic.add("Как жить эту жизнь не усложняя")
        // Inflate the layout for this fragment
        var mediaPlayer = MediaPlayer()
        mediaPlayer = MediaPlayer.create(context, listMusic[0])
        binding = Fragment4Binding.inflate(inflater, container, false)

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
            MAIN.navController.navigate(R.id.action_fragment4_to_homeFragment)
        }
    }




}