package com.example.asus.gopimusicplayer.Activity

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.SeekBar
import com.example.asus.gopimusicplayer.Models.SongInfoModel
import com.example.asus.gopimusicplayer.R
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.song_ticket.view.*

class HomeActivity : AppCompatActivity() {
    private var listSongs = ArrayList<SongInfoModel>()
    private var adapter: MysongAdapter? = null
    private var mp: MediaPlayer? = null
    private lateinit var sbMusicProgress:SeekBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initView()
        loadUrlOnline()
        adapter = MysongAdapter(listSongs)
        lvListSong.adapter = adapter
        var myTrack=trackSong()
        myTrack.start()
    }

    fun initView(){
        sbMusicProgress=findViewById(R.id.sbMusicProgress)
    }

    fun loadUrlOnline() {
        listSongs.add(SongInfoModel("Hamari Adhuri kahani", "Benny Dayal", "http://server6.mp3quran.net/thubti/001.mp3"))
        listSongs.add(SongInfoModel("Kabhi haa Kabhi naa", "Albert Carto", "http://server6.mp3quran.net/thubti/002.mp3"))
        listSongs.add(SongInfoModel("Listen to the woods", "Roopu takariya", "http://server6.mp3quran.net/thubti/003.mp3"))
        listSongs.add(SongInfoModel("Amar akbar Anthony", "Beca pramadha", "http://server6.mp3quran.net/thubti/004.mp3"))
        listSongs.add(SongInfoModel("Heart Buzz ", "Beca pramadha", "http://server6.mp3quran.net/thubti/005.mp3"))

    }

    inner class MysongAdapter : BaseAdapter {
        var myListSong = ArrayList<SongInfoModel>()

        constructor(myListSong: ArrayList<SongInfoModel>) : super() {
            this.myListSong = myListSong
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val myView: View = layoutInflater.inflate(R.layout.song_ticket, null)
            val song: SongInfoModel = this.myListSong[position]
            myView.tvSongName.text = song.title
            myView.tvAuthorName.text = song.author
            myView.btnPlay.setOnClickListener(View.OnClickListener {
                mp = MediaPlayer()
                if (myView.btnPlay.text == "Stop") {
                    mp!!.stop()
                    myView.btnPlay.text = "Play"

                } else {
                    try {
                        mp!!.setDataSource(song.songUrl)
                        mp!!.prepare()
                        mp!!.start()
                        myView.btnPlay.text = "Stop"
                        sbMusicProgress.max = mp!!.duration
                    } catch (e: Exception) {

                    }
                }

            })
            return myView
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

    inner class trackSong() : Thread() {
        override fun run() {
            while(true){
                try {
                    Thread.sleep(1000)
                } catch (e: Exception) {

                }
                runOnUiThread {
                    if (mp != null) {
                        sbMusicProgress.progress = mp!!.currentPosition
                    }
                }
            }

        }
    }
}
