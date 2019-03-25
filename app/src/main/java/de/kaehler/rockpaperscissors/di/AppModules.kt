package de.kaehler.rockpaperscissors.di


import de.kaehler.rockpaperscissors.main.MainContract
import de.kaehler.rockpaperscissors.main.MainPresenter
import de.kaehler.rockpaperscissors.main.RandomPick
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val koinMainModule: Module = module {
    single { RandomPick() }
    single { MainPresenter(get()) as MainContract.Presenter }
}