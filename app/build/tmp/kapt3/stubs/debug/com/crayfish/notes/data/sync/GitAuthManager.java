package com.crayfish.notes.data.sync;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/crayfish/notes/data/sync/GitAuthManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "keyDir", "Ljava/io/File;", "privateKeyFile", "publicKeyFile", "generateKeyPairIfNeeded", "", "getPrivateKeyPath", "", "getPublicKey", "app_debug"})
public final class GitAuthManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.io.File keyDir = null;
    @org.jetbrains.annotations.NotNull()
    private final java.io.File privateKeyFile = null;
    @org.jetbrains.annotations.NotNull()
    private final java.io.File publicKeyFile = null;
    
    public GitAuthManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    /**
     * 生成 RSA 密钥对（如果不存在）
     */
    public final void generateKeyPairIfNeeded() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPublicKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPrivateKeyPath() {
        return null;
    }
}