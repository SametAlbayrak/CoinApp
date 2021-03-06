package com.samet.coinApp;


import com.samet.coinApp.ui.detail.DetailContract;
import com.samet.coinApp.ui.detail.DetailPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"javax.net.ssl.*"})
public class DetailPresenterUnitTest {


    @Mock
    private DetailContract.View view;
    private DetailPresenter presenter;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = spy(new DetailPresenter());
        presenter.takeView(view);
    }


    @Test
    public void setDetails() {
        presenter.setDetails();
        verify(view, times(1)).onSetDetails();
    }


    @Test
    public void getArguments() {
        presenter.getArguments();
        verify(view, times(1)).onGetArguments();
    }

}
