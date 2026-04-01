package com.crayfish.notes.data.sync

import android.content.Context
import java.io.File
import java.security.KeyPairGenerator
import java.util.Base64

class GitAuthManager(private val context: Context) {
    private val keyDir = File(context.filesDir, "ssh")
    private val privateKeyFile = File(keyDir, "id_rsa")
    private val publicKeyFile = File(keyDir, "id_rsa.pub")

    init {
        if (!keyDir.exists()) keyDir.mkdirs()
    }

    /**
     * 生成 RSA 密钥对（如果不存在）
     */
    fun generateKeyPairIfNeeded() {
        if (privateKeyFile.exists()) return

        val kpg = KeyPairGenerator.getInstance("RSA")
        kpg.initialize(2048)
        val kp = kpg.generateKeyPair()

        // 存储私钥 (PEM 格式简化版)
        privateKeyFile.writeText(Base64.getEncoder().encodeToString(kp.private.encoded))
        // 存储公钥
        publicKeyFile.writeText("ssh-rsa " + Base64.getEncoder().encodeToString(kp.public.encoded) + " crayfish-notes")
    }

    fun getPublicKey(): String? {
        return if (publicKeyFile.exists()) publicKeyFile.readText() else null
    }

    fun getPrivateKeyPath(): String {
        return privateKeyFile.absolutePath
    }
}
