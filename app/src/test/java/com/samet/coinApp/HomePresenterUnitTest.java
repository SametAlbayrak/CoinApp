package com.samet.coinApp;


import com.samet.coinApp.models.Data;
import com.samet.coinApp.models.Info;
import com.samet.coinApp.network.APIService;
import com.samet.coinApp.ui.home.HomeContract;
import com.samet.coinApp.ui.home.HomePresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import io.reactivex.Observable;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"javax.net.ssl.*"})
public class HomePresenterUnitTest {

    @Mock
    private HomeContract.View view;
    private HomePresenter presenter;
    private MockWebServer mockWebServer;

    @Mock
    private APIService apiService;


    @Captor
    private ArgumentCaptor<List<Data>> listDataCaptor;


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
        verify(presenter, times(1)).takeView(view);
    }

    @Test
    public void getCurrencies() {
        mockWebServer.enqueue(new MockResponse().setResponseCode(200)
                .setHeaders(HttpRequestHeader.getHttpHeaders())
                .setBody(CryptoListResponseBody.getCryptoList()));
        presenter.getCurrencies("1", "15");
        verify(presenter, times(1)).getCurrencyIconList(CryptoListResponseBody.getCrpytoList());

    }


    @Test
    public void noInternetConnection() {
        when(apiService.getListLatest("1", "15"))
                .thenReturn(Observable.error(new UnknownHostException("No internet!")));
        presenter.getCurrencies("1", "15");
        InOrder inOrder = Mockito.inOrder(view);
        inOrder.verify(view).displayError("internet baglantisi bulunamadi.");
    }

    @Test
    public void setRefreshLayout() {
        presenter.setRefreshLayoutListener();
        verify(view, times(1)).onSetRefreshLayoutListener();
    }

    @Test
    public void setInitialRequest() {
        presenter.setInitialRequest();
        verify(view, times(1)).onSetInitialRequest();
    }

    @Test
    public void initViews() {
        presenter.initViews();
        verify(view, times(1)).onInitViews();
    }


    @Test
    public void getCurrencyIconList() {
        Info infoResponse = new Info();
        presenter.getCurrencyIconList(CryptoListResponseBody.getCrpytoList());
        verify(view, times(1)).setAdapterItemList(infoResponse, CryptoListResponseBody.getCrpytoList());
    }

    @Test
    public void dropView() {
        presenter.dropView();
        Assert.assertNotNull(view);
    }

}