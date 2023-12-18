package com.example.unittetsingproject

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.*
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import org.hamcrest.core.AllOf.allOf
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    //define rule to launch main activity
    @get:Rule
    val activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun testNextButton(){

        onView(withId(R.id.btnNext)).perform(click())
        onView(withId(R.id.btnNext)).perform(click())
        onView(withId(R.id.btnNext)).perform(click())
        onView(withId(R.id.quoteText)).check(matches(withText("If you look at what you have in life, you'll always have more. If you look at what you don't have in life, you'll never have enough.")))
    }

    @Test
    fun testShareButton_expectedIntentChooser(){
        Intents.init()
        val expected = allOf(hasAction(Intent.ACTION_SEND))
        onView(withId(R.id.floatingActionButton)).perform(click())
        intended(expected)
        Intents.release()

    }
}