package ru.mgusev.questbook.app;

import javax.inject.Singleton;

import dagger.Component;
import ru.mgusev.questbook.presentation.presenter.main.MainPresenter;

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {

    void inject(MainPresenter presenter);
}
