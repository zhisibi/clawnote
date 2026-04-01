package com.crayfish.notes.di

import android.content.Context
import androidx.room.Room
import com.crayfish.notes.data.local.AppDatabase
import com.crayfish.notes.data.local.dao.NoteDao
import com.crayfish.notes.data.sync.GitAuthManager
import com.crayfish.notes.data.sync.GitRepositoryManager
import com.crayfish.notes.data.sync.GitSyncManager
import com.crayfish.notes.domain.usecase.SyncUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.io.File
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "crayfish_notes.db"
        ).build()
    }

    @Provides
    fun provideNoteDao(db: AppDatabase): NoteDao = db.noteDao()

    @Provides
    @Singleton
    fun provideGitAuthManager(@ApplicationContext context: Context): GitAuthManager {
        return GitAuthManager(context).apply { generateKeyPairIfNeeded() }
    }

    @Provides
    @Singleton
    fun provideGitSyncManager(noteDao: NoteDao, @ApplicationContext context: Context): GitSyncManager {
        val gitRepoDir = File(context.filesDir, "git_repo")
        return GitSyncManager(noteDao, gitRepoDir)
    }

    @Provides
    @Singleton
    fun provideSyncUseCase(
        gitAuthManager: GitAuthManager,
        gitSyncManager: GitSyncManager,
        @ApplicationContext context: Context
    ): SyncUseCase {
        val gitRepoDir = File(context.filesDir, "git_repo")
        // TODO: 后续可从 DataStore 或设置中读取 remoteUrl
        val defaultRemote = "git@github.com:zhisibi/clawnote-notes.git"
        val gitRepoManager = GitRepositoryManager(
            localPath = gitRepoDir,
            remoteUrl = defaultRemote,
            privateKeyPath = gitAuthManager.getPrivateKeyPath()
        )
        return SyncUseCase(gitRepoManager, gitSyncManager)
    }
}
