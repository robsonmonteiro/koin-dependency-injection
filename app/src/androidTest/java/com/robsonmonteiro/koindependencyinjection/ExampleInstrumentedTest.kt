package com.robsonmonteiro.koindependencyinjection

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.whenever
import com.robsonmonteiro.koindependencyinjection.data.DataRepository
import com.robsonmonteiro.koindependencyinjection.model.Currency
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.standalone.inject
import org.koin.test.KoinTest
import org.koin.test.declareMock

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest : KoinTest {

    val mockDataRepository: DataRepository by inject()

    @Rule
    @JvmField
    val activity = ActivityTestRule<MainActivity>(MainActivity::class.java, false, false)

    @Before
    fun setup() {
        declareMock<DataRepository>()
    }

    @Test
    fun activityLaunches() {
        activity.launchActivity(null)
        onView(withId(R.id.recycler_currencies))
            .check(matches(isDisplayed()))
    }

    @Test
    fun checkCurrenciesDisplay() {
        val currencies = CurrencyFactory.makeCurrencyList(5)
        stubDataRepositoryGetCurrencies(currencies)
        activity.launchActivity(null)

        checkCurrenciesAreDisplayed(currencies)
    }

    private fun checkCurrenciesAreDisplayed(currencies: List<Currency>) {
        currencies.forEachIndexed { index, currency ->
            onView(withId(R.id.recycler_currencies))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(index))
            onView(RecyclerViewMatcher.withRecyclerView(R.id.recycler_currencies).atPosition(index))
                .check(matches(hasDescendant(withText(currency.name))))
        }
    }

    private fun stubDataRepositoryGetCurrencies(currencies: List<Currency>) {
        whenever(mockDataRepository.getCurrencies(any()))
            .thenReturn(currencies)
    }

}
