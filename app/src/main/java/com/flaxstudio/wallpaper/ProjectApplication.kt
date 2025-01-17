package com.flaxstudio.wallpaper

import android.app.Application
import com.flaxstudio.wallpaper.source.database.CategoryRepo
import com.flaxstudio.wallpaper.source.database.LikedWallpaperRepo
import com.flaxstudio.wallpaper.source.database.WallpaperDatabase
import com.flaxstudio.wallpaper.source.database.WallpaperRepo

class ProjectApplication : Application() {
    // No need to cancel this scope as it'll be torn down with the process

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    private val database by lazy { WallpaperDatabase.getInstance(this) }
    val wallpaperRepository by lazy { WallpaperRepo(database.wallpaperDao()) }
    val categoryRepository by lazy { CategoryRepo(database.categoryDao()) }
    val likedWallpaperRepository by lazy { LikedWallpaperRepo(database.likedWallpaperDao()) }

    override fun onCreate() {
        super.onCreate()
    }
}