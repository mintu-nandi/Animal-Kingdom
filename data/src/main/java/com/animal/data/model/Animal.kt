package com.animal.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "zoo")
data class Animal(
    @ColumnInfo(name = "active_time", collate = ColumnInfo.NOCASE)
    val active_time: String,

    @ColumnInfo(name = "type", collate = ColumnInfo.NOCASE)
    val animal_type: String,

    @ColumnInfo(name = "diet", collate = ColumnInfo.NOCASE)
    val diet: String,

    @ColumnInfo(name = "geo_location", collate = ColumnInfo.NOCASE)
    val geo_range: String,

    @ColumnInfo(name = "habitat", collate = ColumnInfo.NOCASE)
    val habitat: String,

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "url")
    val image_link: String,

    @ColumnInfo(name = "latin_name", collate = ColumnInfo.NOCASE)
    val latin_name: String,

    @ColumnInfo(name = "length_max")
    val length_max: String,

    @ColumnInfo(name = "length_min")
    val length_min: String,

    @ColumnInfo(name = "lifespan")
    val lifespan: String,

    @ColumnInfo(name = "name", collate = ColumnInfo.NOCASE)
    val name: String,

    @ColumnInfo(name = "weight_max")
    val weight_max: String,

    @ColumnInfo(name = "weight_min")
    val weight_min: String
)
