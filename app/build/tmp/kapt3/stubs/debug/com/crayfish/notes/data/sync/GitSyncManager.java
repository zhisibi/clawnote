package com.crayfish.notes.data.sync;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/crayfish/notes/data/sync/GitSyncManager;", "", "noteDao", "Lcom/crayfish/notes/data/local/dao/NoteDao;", "gitRepoDir", "Ljava/io/File;", "(Lcom/crayfish/notes/data/local/dao/NoteDao;Ljava/io/File;)V", "json", "Lkotlinx/serialization/json/Json;", "exportToGit", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "importFromGit", "app_debug"})
public final class GitSyncManager {
    @org.jetbrains.annotations.NotNull()
    private final com.crayfish.notes.data.local.dao.NoteDao noteDao = null;
    @org.jetbrains.annotations.NotNull()
    private final java.io.File gitRepoDir = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.serialization.json.Json json = null;
    
    public GitSyncManager(@org.jetbrains.annotations.NotNull()
    com.crayfish.notes.data.local.dao.NoteDao noteDao, @org.jetbrains.annotations.NotNull()
    java.io.File gitRepoDir) {
        super();
    }
    
    /**
     * 将本地数据库中的所有笔记导出为 Git 仓库中的文件。
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object exportToGit(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * 从 Git 仓库中的文件导入到本地数据库。
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object importFromGit(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}