package com.example.unittetsingproject

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class MainActivityNavigationTest {

    //define rule to launch main activity
    @get:Rule
    val activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun testSubmitButton(){

        onView(withId(R.id.quoteAuthor)).perform(typeText("test"), closeSoftKeyboard())
        onView(withId(R.id.btnPrevios)).perform(ViewActions.click())

        onView(withId(R.id.msg)).check(matches(withText("test")))
   }
}