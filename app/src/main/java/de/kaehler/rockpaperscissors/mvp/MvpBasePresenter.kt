package de.kaehler.rockpaperscissors.mvp

internal interface MvpBasePresenter<T : MvpBaseView>{
    fun bind(view: T)

    fun unbind()

    fun unbind(view: T)
}