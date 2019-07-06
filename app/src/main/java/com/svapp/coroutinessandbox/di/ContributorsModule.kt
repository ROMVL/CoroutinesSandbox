package com.svapp.coroutinessandbox.di

import com.svapp.coroutinessandbox.data.repository.IContributorsRepository
import com.svapp.coroutinessandbox.data.repository.ContributorsRepository
import com.svapp.coroutinessandbox.presentation.contributors.ContributorsViewModel
import org.koin.dsl.module.module

/**
 * Created by Valentyn on 03.03.2019.
 */
val contributorsModule = module {
    single<IContributorsRepository> { ContributorsRepository(get()) }
    factory { ContributorsViewModel(get()) }
}