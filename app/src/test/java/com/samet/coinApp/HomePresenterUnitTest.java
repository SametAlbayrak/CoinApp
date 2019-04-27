package com.samet.coinApp;


import com.samet.coinApp.ui.home.HomeContract;
import com.samet.coinApp.ui.home.HomePresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;

import okhttp3.mockwebserver.MockWebServer;

import static org.mockito.Mockito.spy;


@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"javax.net.ssl.*"})
public class HomePresenterUnitTest {

    @Mock
    private HomeContract.View view;
    private HomePresenter presenter;
    private MockWebServer mockWebServer;

    @BeforeClass
    public static void setUpRxSchedulers() {
        RxJavaSchedulers.schedulers();
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockWebServer = new MockWebServer();
        presenter = spy(new HomePresenter());
        try {
            mockWebServer.start();
        } catch (IOException e) {
            Assert.fail();
        }
        presenter.takeView(view);
        String server = mockWebServer.url("/").toString();
    }

  /*  @Test
    public void getCurrencies(String start, String limit) throws Exception {
        presenter.
        verify(presenter, times(1)).setNameResponse(any(EmptyResponse.class));
    }


    @Test
    void getCurrencyIconList(final List<Data> cList) throws Exception {
        Info infoResponse = new Info();
        verify(view, times(1)).setAdapterItemList(infoResponse);
    }*/

    @Test
    public void dropView() {
        presenter.dropView();
        Assert.assertNotNull(view);
    }


}