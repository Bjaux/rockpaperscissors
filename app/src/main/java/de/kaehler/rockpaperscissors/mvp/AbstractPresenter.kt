package de.kaehler.rockpaperscissors.mvp

internal abstract class AbstractPresenter<T : MvpBaseView> : MvpBasePresenter<T> {
    var view: T? = null

    override fun bind(view: T) {
        this.view = view
        onBound(view)
    }

    override fun unbind() {
        view = null
        onUnBound()
    }

    override fun unbind(view: T){
        if(this.view === view) {
            this.view = null
            onUnBound()
        }
    }

    /**
     * optional override, get's called after {@link #bind(MvpBaseView)}
     */
    open fun onBound(view: T) {

    }

    /**
     * optional override, get's called after {@link #unbind()}
     */
    open fun onUnBound() {

    }

    /**
     * Check if a view is currently attached
     */
    fun isViewAttached() = view != null
}