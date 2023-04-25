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
import com.example.myapplication.databinding.Fragment3Binding




class Fragment3 : Fragment() {
    lateinit var binding: Fragment3Binding
    private var playMusic = false
    private var pause = true
    private var trek = 0
    private val listMusic = ArrayList<Int>()
    private val listNameMusic = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment3Binding.inflate(layoutInflater, container, false)
        listMusic.add(R.raw.fond)
        listMusic.add(R.raw.money)
        listMusic.add(R.raw.kopit)
        listMusic.add(R.raw.bank)

        listNameMusic.add("Как заработать на фондовом рынке")
        listNameMusic.add("Как тратить деньги разумно")
        listNameMusic.add("Как перестать транжирить и начать копить")
        listNameMusic.add("Как банки обманывают на кредитных картах")
        // Inflate the layout for this fragment
        var mediaPlayer = MediaPlayer()
        mediaPlayer = MediaPlayer.create(context, listMusic[0])
        binding = Fragment3Binding.inflate(inflater, container, false)

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
            MAIN.navController.navigate(R.id.action_fragment3_to_homeFragment)
        }
    }



}