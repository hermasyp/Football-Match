package com.catnipdev.footballmatch.ui.main.fragment.nextmatch

import com.catnipdev.footballmatch.data.model.Events
import com.catnipdev.footballmatch.network.Routes
import com.catnipdev.footballmatch.utils.reactive.SchedulerTest
import io.reactivex.Observable
import org.junit.Test

import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

/**
 * Written with love by Muhammad Hermas Yuda Pamungkas
 * Github : https://github.com/hermasyp
 */
class NextMatchPresenterTest {
    private lateinit var presenter:NextMatchPresenter
    private lateinit var observable: Observable<Events>

   /* @Mock
    private lateinit var events :Events*/

    @Mock
    private lateinit var routes: Routes

    @Mock
    private lateinit var view: NextMatchContract.View

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        presenter = NextMatchPresenter(view,SchedulerTest())
        observable = Observable.empty()
        `when` (routes.getNextEvent()).thenReturn(observable)
    }

    @Test
    fun loadData() {
        presenter.loadData()
    }


}