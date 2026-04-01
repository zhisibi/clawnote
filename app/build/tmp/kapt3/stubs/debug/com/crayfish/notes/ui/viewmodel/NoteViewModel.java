package com.crayfish.notes.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/crayfish/notes/ui/viewmodel/NoteViewModel;", "Landroidx/lifecycle/ViewModel;", "noteDao", "Lcom/crayfish/notes/data/local/dao/NoteDao;", "(Lcom/crayfish/notes/data/local/dao/NoteDao;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/crayfish/notes/ui/viewmodel/NoteListState;", "dateFormatter", "Ljava/text/SimpleDateFormat;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadNotes", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class NoteViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.crayfish.notes.data.local.dao.NoteDao noteDao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.crayfish.notes.ui.viewmodel.NoteListState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.crayfish.notes.ui.viewmodel.NoteListState> state = null;
    @org.jetbrains.annotations.NotNull()
    private final java.text.SimpleDateFormat dateFormatter = null;
    
    @javax.inject.Inject()
    public NoteViewModel(@org.jetbrains.annotations.NotNull()
    com.crayfish.notes.data.local.dao.NoteDao noteDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.crayfish.notes.ui.viewmodel.NoteListState> getState() {
        return null;
    }
    
    private final void loadNotes() {
    }
}