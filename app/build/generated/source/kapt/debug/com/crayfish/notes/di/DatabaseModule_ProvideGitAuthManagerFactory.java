package com.crayfish.notes.di;

import android.content.Context;
import com.crayfish.notes.data.sync.GitAuthManager;
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
public final class DatabaseModule_ProvideGitAuthManagerFactory implements Factory<GitAuthManager> {
  private final Provider<Context> contextProvider;

  public DatabaseModule_ProvideGitAuthManagerFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public GitAuthManager get() {
    return provideGitAuthManager(contextProvider.get());
  }

  public static DatabaseModule_ProvideGitAuthManagerFactory create(
      Provider<Context> contextProvider) {
    return new DatabaseModule_ProvideGitAuthManagerFactory(contextProvider);
  }

  public static GitAuthManager provideGitAuthManager(Context context) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideGitAuthManager(context));
  }
}
