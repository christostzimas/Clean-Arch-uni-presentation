package com.learningwithmanos.uniexercise.heroes.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("heroes")
data class HeroEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo("name")
    val name: String,

    @ColumnInfo("name")
    val availableComics: Int,

    @ColumnInfo("name")
    val imageUrl: String
)