package com.devlomi.ayaturabbi.db.ayahinfo

import android.graphics.RectF
import androidx.room.*


@Entity(
    tableName = "glyphs", indices = arrayOf(
        Index("sura_number", "ayah_number", name = "sura_ayah_idx", unique = false),
        Index("page_number", name = "page_idx", unique = false)
    )
)
data class AyahInfo(

    @PrimaryKey val glyph_id: Int,

//    @ColumnInfo(name = "page_number")
    val page_number: Integer,
//    @ColumnInfo(name = "line_number")
    val line_number: Int,
//    @ColumnInfo(name = "sura_number")
    val sura_number: Int,
//    @ColumnInfo(name = "ayah_number")
    val ayah_number: Int,
//    @ColumnInfo(name = "position")
    val position: Int,
//    @ColumnInfo(name = "min_x")
    val min_x: Int,
//    @ColumnInfo(name = "max_x")
    val max_x: Int,
//    @ColumnInfo(name = "min_y")
    val min_y: Int,
//    @ColumnInfo(name = "max_y")
    val max_y: Int,

    ) {
    fun getBounds() = RectF(min_x.toFloat(), min_y.toFloat(), max_x.toFloat(), max_y.toFloat())
    fun engulf(other: RectF) = getBounds().union(other)
    fun withBounds(other: RectF): AyahInfo {
        return this.copy(
            min_x = other.left.toInt(),
            min_y = other.top.toInt(),
            max_x = other.right.toInt(),
            max_y = other.bottom.toInt()
        )
    }
}

