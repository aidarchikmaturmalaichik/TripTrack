package com.example.triptrack.domain.manager.usecaces

import com.example.triptrack.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
  private val localUserManager: LocalUserManager
) {

  suspend operator fun invoke(): Flow<Boolean> {
    return localUserManager.readAppEntry()
  }

}

//usecases