package com.crayfish.notes.di;

import android.content.Context;
import com.crayfish.notes.data.local.dao.NoteDao;
import com.crayfish.notes.data.sync.GitSyncManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class DatabaseModule_ProvideGitSyncManagerFactory implements Factory<GitSyncManager> {
  private final Provider<NoteDao> noteDaoProvider;

  private final Provider<Context> contextProvider;

  public DatabaseModule_ProvideGitSyncManagerFactory(Provider<NoteDao> noteDaoProvider,
      Provider<Context> contextProvider) {
    this.noteDaoProvider = noteDaoProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public GitSyncManager get() {
    return provideGitSyncManager(noteDaoProvider.get(), contextProvider.get());
  }

  public static DatabaseModule_ProvideGitSyncManagerFactory create(
      Provider<NoteDao> noteDaoProvider, Provider<Context> contextProvider) {
    return new DatabaseModule_ProvideGitSyncManagerFactory(noteDaoProvider, contextProvider);
  }

  public static GitSyncManager provideGitSyncManager(NoteDao noteDao, Context context) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideGitSyncManager(noteDao, context));
  }
}
