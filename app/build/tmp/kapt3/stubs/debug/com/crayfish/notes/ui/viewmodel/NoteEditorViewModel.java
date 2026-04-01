package com.crayfish.notes.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000fJ\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u000fJ\u0006\u0010\u0018\u001a\u00020\rJ\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001f"}, d2 = {"Lcom/crayfish/notes/ui/viewmodel/NoteEditorViewModel;", "Landroidx/lifecycle/ViewModel;", "noteDao", "Lcom/crayfish/notes/data/local/dao/NoteDao;", "(Lcom/crayfish/notes/data/local/dao/NoteDao;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/crayfish/notes/ui/viewmodel/NoteEditorState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "insertSnippet", "", "snippet", "", "loadNote", "noteId", "onColorChange", "newColor", "onContentChange", "newContent", "onTitleChange", "newTitle", "saveNote", "setPreviewMode", "enabled", "", "toggleTag", "tag", "Lcom/crayfish/notes/data/local/entity/TagEntity;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class NoteEditorViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.crayfish.notes.data.local.dao.NoteDao noteDao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.crayfish.notes.ui.viewmodel.NoteEditorState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.crayfish.notes.ui.viewmodel.NoteEditorState> state = null;
    
    @javax.inject.Inject()
    public NoteEditorViewModel(@org.jetbrains.annotations.NotNull()
    com.crayfish.notes.data.local.dao.NoteDao noteDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.crayfish.notes.ui.viewmodel.NoteEditorState> getState() {
        return null;
    }
    
    public final void loadNote(@org.jetbrains.annotations.Nullable()
    java.lang.String noteId) {
    }
    
    public final void onTitleChange(@org.jetbrains.annotations.NotNull()
    java.lang.String newTitle) {
    }
    
    public final void onContentChange(@org.jetbrains.annotations.NotNull()
    java.lang.String newContent) {
    }
    
    public final void onColorChange(@org.jetbrains.annotations.NotNull()
    java.lang.String newColor) {
    }
    
    public final void setPreviewMode(boolean enabled) {
    }
    
    public final void insertSnippet(@org.jetbrains.annotations.NotNull()
    java.lang.String snippet) {
    }
    
    public final void toggleTag(@org.jetbrains.annotations.NotNull()
    com.crayfish.notes.data.local.entity.TagEntity tag) {
    }
    
    public final void saveNote() {
    }
}