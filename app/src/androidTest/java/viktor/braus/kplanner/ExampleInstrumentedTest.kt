/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package viktor.braus.kplanner

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import viktor.braus.kplanner.entity.*
import java.io.IOException

/**
 * This is not meant to be a full set of tests. For simplicity, most of your samples do not
 * include tests. However, when building the Room, it is helpful to make sure it works before
 * adding the UI.
 */

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    private lateinit var plansDAO: PlansDAO
    //private lateinit var mondayDAO: MondayPlanDAO
    private lateinit var db: PlansDatabase
    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(context, PlansDatabase::class.java)
            .allowMainThreadQueries().build()
        plansDAO = db.plansDAO
    }

    @After
    @Throws(IOException::class)
    suspend fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
     suspend fun insertAndGetNight() {
        val mainPlans = Plans()
        plansDAO.insert(mainPlans)
        val plans = plansDAO.getAll()
        assertEquals(plans?.StartTime, "")
    }
}
