package com.alexm.financialeducation.di

import com.alexm.financialeducation.data.repository.FinancialEducationRepository
import com.alexm.financialeducation.data.repository.FinancialEducationRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FinancialEducationModule {

    @Binds
    abstract fun bindsFinancialEducationRepository(
        financialEducationRepository: FinancialEducationRepositoryImpl
    ): FinancialEducationRepository
}