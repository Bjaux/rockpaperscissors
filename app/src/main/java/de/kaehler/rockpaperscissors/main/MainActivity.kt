package de.kaehler.rockpaperscissors.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import de.kaehler.rockpaperscissors.R

import org.koin.android.ext.android.inject
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private val presenter: MainContract.Presenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.bind(this)
        setupButtons()
    }

    fun setupButtons() {
        main_rock_btn.setOnClickListener{ presenter.onRockClicked() }
        main_paper_btn.setOnClickListener{ presenter.onPaperClicked() }
        main_scissors_btn.setOnClickListener{ presenter.onScissorsClicked() }
    }

    override fun hideWelcome() {
        main_welcome_tv.visibility = View.GONE
    }

    override fun showPicks(playerPick: Pick, aiPick: Pick) {
        main_ai_pick_tv.visibility = View.VISIBLE
        val playerPickMessage = getPlayerPickMessage(playerPick)
        val aiPickMessage = getAIPickMessage(aiPick)
        val pickMessage = playerPickMessage + aiPickMessage
        main_ai_pick_tv.text = pickMessage
    }

    private fun getPlayerPickMessage(playerPick: Pick) : String {
        return when(playerPick) {
            Pick.ROCK -> getString(R.string.main_player_pick_rock)
            Pick.PAPER -> getString(R.string.main_player_pick_paper)
            Pick.SCISSORS -> getString(R.string.main_player_pick_scissors)
        }
    }

    private fun getAIPickMessage(aiPick: Pick) : String {
        return when(aiPick) {
            Pick.ROCK -> getString(R.string.main_ai_pick_rock)
            Pick.PAPER -> getString(R.string.main_ai_pick_paper)
            Pick.SCISSORS -> getString(R.string.main_ai_pick_scissors)
        }
    }

    override fun showWin() {
        main_result_tv.visibility = View.VISIBLE
        main_result_tv.text = getString(R.string.main_message_win)
    }

    override fun showLose() {
        main_result_tv.visibility = View.VISIBLE
        main_result_tv.text = getString(R.string.main_message_lose)
    }

    override fun showDraw() {
        main_result_tv.visibility = View.VISIBLE
        main_result_tv.text = getString(R.string.main_message_draw)
    }

}
