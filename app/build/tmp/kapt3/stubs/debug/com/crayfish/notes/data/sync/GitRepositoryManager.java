package com.crayfish.notes.data.sync;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/crayfish/notes/data/sync/GitRepositoryManager;", "", "localPath", "Ljava/io/File;", "remoteUrl", "", "privateKeyPath", "(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)V", "sshSessionFactory", "Lorg/eclipse/jgit/transport/ssh/jsch/JschConfigSessionFactory;", "commitAndPush", "", "message", "initOrClone", "pull", "app_debug"})
public final class GitRepositoryManager {
    @org.jetbrains.annotations.NotNull()
    private final java.io.File localPath = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String remoteUrl = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String privateKeyPath = null;
    @org.jetbrains.annotations.NotNull()
    private final org.eclipse.jgit.transport.ssh.jsch.JschConfigSessionFactory sshSessionFactory = null;
    
    public GitRepositoryManager(@org.jetbrains.annotations.NotNull()
    java.io.File localPath, @org.jetbrains.annotations.NotNull()
    java.lang.String remoteUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String privateKeyPath) {
        super();
    }
    
    /**
     * 初始化或克隆仓库
     */
    public final void initOrClone() {
    }
    
    /**
     * 执行 Pull 操作
     */
    public final void pull() {
    }
    
    /**
     * 执行 Commit 并 Push 操作
     */
    public final void commitAndPush(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
}