package com.learningwithmanos.uniexercise.heroes.source.local

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@OptIn(ExperimentalCoroutinesApi::class)
class HeroLocalSourceImplTest {

    private lateinit var heroLocalSourceImpl: HeroLocalSourceImpl

    private val heroesDaoMock: HeroesDao = mock()


    @Before
    fun setUp() {
        heroLocalSourceImpl = HeroLocalSourceImpl(
            heroesDaoMock
        )
    }

    @Test
    fun `when invoking isHeroDataStored verify results and interactions`() = runTest{
        // when
        heroLocalSourceImpl.isHeroDataStored()

        // then
        verify(heroesDaoMock).isEmpty()
    }

    @Test
    fun `when invoking storeHeroes verify results and interactions`() = runTest{
        // when
        heroLocalSourceImpl.storeHeroes(listOf())

        // then
        verify(heroesDaoMock).insertHeroes(listOf())
    }

    @Test
    fun `when invoking getHeroes verify results and interactions`() = runTest{
        // when
        heroLocalSourceImpl.getHeroes()

        // then
        verify(heroesDaoMock).getAllHeroes()
    }

}