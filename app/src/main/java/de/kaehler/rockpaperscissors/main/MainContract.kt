package de.kaehler.rockpaperscissors.main

import de.kaehler.rockpaperscissors.mvp.MvpBasePresenter
import de.kaehler.rockpaperscissors.mvp.MvpBaseView

internal interface MainContract {
    interface View : MvpBaseView {
        fun hideWelcome()
        fun showPicks(playerPick : Pick, aiPick : Pick)
        fun showWin()
        fun showDraw()
        fun showLose()
    }

    interface Presenter : MvpBasePresenter<View> {
        fun onRockClicked()
        fun onPaperClicked()
        fun onScissorsClicked()
    }
}