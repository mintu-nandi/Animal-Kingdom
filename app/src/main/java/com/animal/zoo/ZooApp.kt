package com.animal.zoo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class ZooApp @Inject constructor() : Application()