package de.kaehler.rockpaperscissors.mvp

internal interface MvpBasePresenter<T : MvpBaseView>{
    /**
     * Bind a view to this presenter
     *
     * @param view the view to bind
     */
    fun bind(view: T)

    /**
     * Unbind the view currently bound to this presenter
     */
    fun unbind()

    /**
     * Unbind the passed view AND ONLY the passed view.
     *
     * Will be ignored, if the currently bound view is not instance equal (===)
     *
     * @param view the view to unbind
     */
    fun unbind(view: T)
}