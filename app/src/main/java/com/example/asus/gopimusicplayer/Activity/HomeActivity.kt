package com.example.asus.gopimusicplayer.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.asus.gopimusicplayer.Models.SongInfoModel
import com.example.asus.gopimusicplayer.R

class HomeActivity : AppCompatActivity() {
private var listSongs=ArrayList<SongInfoModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun loadUrlOnline(){
        listSongs.add(SongInfoModel("Hamari Adhuri kahani","Benny Dayal","http://server6.mp3quran.net/thubti/001.mp3"))
        listSongs.add(SongInfoModel("Kabhi haa Kabhi naa","Albert Carto","http://server6.mp3quran.net/thubti/002.mp3"))
        listSongs.add(SongInfoModel("Listen to the woods","Roopu takariya","http://server6.mp3quran.net/thubti/003.mp3"))
        listSongs.add(SongInfoModel("Hamari Adhuri kahani","Beca pramadha","http://server6.mp3quran.net/thubti/004.mp3"))

    }

    inner class MysongAdapter:BaseAdapter{
        var myListSong=ArrayList<SongInfoModel>()
        constructor(myListSong: ArrayList<SongInfoModel>):super(){
                this.myListSong=myListSong
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getItem(position: Int): Any {
            return this.myListSong[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return this.myListSong.size
        }

    }
}
