package com.crayfish.notes.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/crayfish/notes/di/DatabaseModule;", "", "()V", "provideDatabase", "Lcom/crayfish/notes/data/local/AppDatabase;", "context", "Landroid/content/Context;", "provideGitAuthManager", "Lcom/crayfish/notes/data/sync/GitAuthManager;", "provideGitSyncManager", "Lcom/crayfish/notes/data/sync/GitSyncManager;", "noteDao", "Lcom/crayfish/notes/data/local/dao/NoteDao;", "provideNoteDao", "db", "provideSyncUseCase", "Lcom/crayfish/notes/domain/usecase/SyncUseCase;", "gitAuthManager", "gitSyncManager", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class DatabaseModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.crayfish.notes.di.DatabaseModule INSTANCE = null;
    
    private DatabaseModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.crayfish.notes.data.local.AppDatabase provideDatabase(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.crayfish.notes.data.local.dao.NoteDao provideNoteDao(@org.jetbrains.annotations.NotNull()
    com.crayfish.notes.data.local.AppDatabase db) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.crayfish.notes.data.sync.GitAuthManager provideGitAuthManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.crayfish.notes.data.sync.GitSyncManager provideGitSyncManager(@org.jetbrains.annotations.NotNull()
    com.crayfish.notes.data.local.dao.NoteDao noteDao, @dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.crayfish.notes.domain.usecase.SyncUseCase provideSyncUseCase(@org.jetbrains.annotations.NotNull()
    com.crayfish.notes.data.sync.GitAuthManager gitAuthManager, @org.jetbrains.annotations.NotNull()
    com.crayfish.notes.data.sync.GitSyncManager gitSyncManager, @dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
}