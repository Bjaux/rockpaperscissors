package de.kaehler.rockpaperscissors

import de.kaehler.rockpaperscissors.main.MainContract
import de.kaehler.rockpaperscissors.main.MainPresenter
import de.kaehler.rockpaperscissors.main.Pick
import de.kaehler.rockpaperscissors.main.RandomPick
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

internal class MainPresenterTest {

    private lateinit var underTest: MainPresenter

    @Mock
    lateinit var viewMock : MainContract.View

    @Mock
    lateinit var randomPick: RandomPick

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        underTest = MainPresenter(randomPick)
        underTest.bind(viewMock)
    }

    @Test
    fun testOnPaperWin() {
        `when`(randomPick.random()).thenReturn(Pick.ROCK)
        underTest.onPaperClicked()
        verify(viewMock).hideWelcome()
        verify(viewMock).showPicks(Pick.PAPER, Pick.ROCK)
        verify(viewMock).showWin()
    }

}