package com.crayfish.notes.data.sync

import android.content.Context
import android.content.SharedPreferences

/**
 * 管理 Git 相关配置，目前只持久化 remoteUrl。
 */
class GitConfigManager(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("git_config", Context.MODE_PRIVATE)

    private val KEY_REMOTE_URL = "remote_url"
    private val KEY_UI_FONT_SCALE = "ui_font_scale"
    private val KEY_NOTE_FONT_SCALE = "note_font_scale"

    fun getRemoteUrl(defaultRemote: String): String {
        return prefs.getString(KEY_REMOTE_URL, defaultRemote) ?: defaultRemote
    }

    fun setRemoteUrl(url: String) {
        prefs.edit().putString(KEY_REMOTE_URL, url.trim()).apply()
    }

    fun getUiFontScale(): Float = prefs.getFloat(KEY_UI_FONT_SCALE, 1.0f)
    fun setUiFontScale(scale: Float) {
        prefs.edit().putFloat(KEY_UI_FONT_SCALE, scale).apply()
    }

    fun getNoteFontScale(): Float = prefs.getFloat(KEY_NOTE_FONT_SCALE, 1.0f)
    fun setNoteFontScale(scale: Float) {
        prefs.edit().putFloat(KEY_NOTE_FONT_SCALE, scale).apply()
    }
}

