package de.kaehler.rockpaperscissors.main

import de.kaehler.rockpaperscissors.mvp.AbstractPresenter

internal class MainPresenter(val randomPick: RandomPick) : AbstractPresenter<MainContract.View>(), MainContract.Presenter{
    override fun onPaperClicked() {
        evaluatePick(Pick.PAPER)
    }

    override fun onScissorsClicked() {
        evaluatePick(Pick.SCISSORS)
    }

    override fun onRockClicked() {
        evaluatePick(Pick.ROCK)
    }

    private fun evaluatePick(playerPick: Pick) {
        val aiPick = randomPick.random()
        view?.hideWelcome()
        view?.showPicks(playerPick, aiPick)
        when(playerPick) {
            Pick.ROCK ->
                when(aiPick) {
                    Pick.ROCK -> view?.showDraw()
                    Pick.PAPER -> view?.showLose()
                    Pick.SCISSORS -> view?.showWin()
                }
            Pick.PAPER ->
                when(aiPick) {
                    Pick.ROCK -> view?.showWin()
                    Pick.PAPER -> view?.showDraw()
                    Pick.SCISSORS -> view?.showLose()
                }
            Pick.SCISSORS ->
                when(aiPick) {
                    Pick.ROCK -> view?.showLose()
                    Pick.PAPER -> view?.showWin()
                    Pick.SCISSORS -> view?.showDraw()
                }
        }
    }
}