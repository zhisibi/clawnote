package com.crayfish.notes.data.sync

import org.eclipse.jgit.api.Git
import org.eclipse.jgit.api.errors.GitAPIException
import org.eclipse.jgit.transport.SshSessionFactory
import org.eclipse.jgit.transport.ssh.jsch.JschConfigSessionFactory
import org.eclipse.jgit.transport.ssh.jsch.OpenSshConfig
import com.jcraft.jsch.Session
import java.io.File

class GitRepositoryManager(
    private val localPath: File,
    private val remoteUrl: String,
    private val privateKeyPath: String
) {
    private val sshSessionFactory = object : JschConfigSessionFactory() {
        override fun configure(hc: OpenSshConfig.Host, session: Session) {
            session.setConfig("StrictHostKeyChecking", "no")
        }

        override fun createDefaultJSch(fs: org.eclipse.jgit.util.FS): com.jcraft.jsch.JSch {
            val jsch = super.createDefaultJSch(fs)
            jsch.addIdentity(privateKeyPath)
            return jsch
        }
    }

    /**
     * 初始化或克隆仓库
     */
    fun initOrClone() {
        if (!localPath.exists()) {
            localPath.mkdirs()
            Git.cloneRepository()
                .setURI(remoteUrl)
                .setDirectory(localPath)
                .setTransportConfigCallback { transport ->
                    (transport as? org.eclipse.jgit.transport.SshTransport)?.sshSessionFactory = sshSessionFactory
                }
                .call()
        }
    }

    /**
     * 执行 Pull 操作
     */
    fun pull() {
        val git = Git.open(localPath)
        git.pull()
            .setTransportConfigCallback { transport ->
                (transport as? org.eclipse.jgit.transport.SshTransport)?.sshSessionFactory = sshSessionFactory
            }
            .call()
    }

    /**
     * 执行 Commit 并 Push 操作
     */
    fun commitAndPush(message: String) {
        val git = Git.open(localPath)
        git.add().addFilepattern(".").call()
        git.commit().setMessage(message).call()
        git.push()
            .setTransportConfigCallback { transport ->
                (transport as? org.eclipse.jgit.transport.SshTransport)?.sshSessionFactory = sshSessionFactory
            }
            .call()
    }
}
