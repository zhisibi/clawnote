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

    fun getRemoteUrl(defaultRemote: String): String {
        return prefs.getString(KEY_REMOTE_URL, defaultRemote) ?: defaultRemote
    }

    fun setRemoteUrl(url: String) {
        prefs.edit().putString(KEY_REMOTE_URL, url.trim()).apply()
    }
}
