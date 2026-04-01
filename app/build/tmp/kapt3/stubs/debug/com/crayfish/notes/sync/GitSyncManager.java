package com.crayfish.notes.sync;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/crayfish/notes/sync/GitSyncManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "gitRepoDir", "Ljava/io/File;", "saveNoteToFile", "", "note", "Lcom/crayfish/notes/data/model/Note;", "syncWithRemote", "remoteUrl", "", "token", "app_debug"})
public final class GitSyncManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.io.File gitRepoDir = null;
    
    public GitSyncManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final void syncWithRemote(@org.jetbrains.annotations.NotNull()
    java.lang.String remoteUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String token) {
    }
    
    public final void saveNoteToFile(@org.jetbrains.annotations.NotNull()
    com.crayfish.notes.data.model.Note note) {
    }
}