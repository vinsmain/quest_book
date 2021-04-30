package ru.mgusev.questbook.app;

import javax.inject.Singleton;

import dagger.Component;
import ru.mgusev.questbook.presentation.presenter.main.CharacterListPresenter;
import ru.mgusev.questbook.presentation.presenter.main.MainPresenter;
import ru.mgusev.questbook.presentation.presenter.menu.MenuPresenter;

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {

    void inject(MainPresenter presenter);
    void inject(MenuPresenter presenter);
    void inject(CharacterListPresenter presenter);
}
