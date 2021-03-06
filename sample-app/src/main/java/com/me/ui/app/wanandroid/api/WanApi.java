package com.me.ui.app.wanandroid.api;

import com.me.ui.app.wanandroid.data.WanArticleBean;
import com.me.ui.app.wanandroid.data.WanBannerBean;
import com.me.ui.app.wanandroid.data.WanCommonBean;
import com.me.ui.app.wanandroid.data.WanHotKeyBean;
import com.me.ui.app.wanandroid.data.WanListModule;
import com.me.ui.app.wanandroid.data.WanLoginData;
import com.me.ui.app.wanandroid.data.WanModule;
import com.me.ui.app.wanandroid.data.WanNavigationBean;
import com.me.ui.app.wanandroid.data.WanProjectTreeBean;
import com.me.ui.app.wanandroid.data.WanTreeBean;
import com.me.ui.app.wanandroid.data.WanWebsiteBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author tangqi
 * @since 2019/04/22 21:00
 */
public interface WanApi {

    @GET("article/list/{page}/json")
    Observable<WanModule<WanArticleBean>> getMainArticleList(@Path("page") int page);

    @GET("banner/json")
    Observable<WanListModule<WanBannerBean>> getMainBanner();

    @GET("friend/json")
    Observable<WanListModule<WanWebsiteBean>> getMainWebsite();

    @GET("hotkey/json")
    Observable<WanListModule<WanHotKeyBean>> getMainHotKey();

    @GET("tree/json")
    Observable<WanListModule<WanTreeBean>> getTree();

    @GET("article/list/{page}/json")
    Observable<WanModule<WanArticleBean>> getTreeCategory(@Path("page") int page, @Query("cid") int cid);

    @GET("navi/json")
    Observable<WanListModule<WanNavigationBean>> getNavigation();

    @GET("project/tree/json")
    Observable<WanListModule<WanProjectTreeBean>> getProjectTree();

    @GET("project/list/{page}/json")
    Observable<WanModule<WanArticleBean>> getProjectCategory(@Path("page") int page, @Query("cid") int cid);

    @POST("user/register")
    @FormUrlEncoded
    Observable<WanModule<WanLoginData>> postUserRegister(@Field("username") String username, @Field("password") String password, @Field("repassword") String repassword);

    @POST("user/login")
    @FormUrlEncoded
    Observable<WanModule<WanLoginData>> postUserLogin(@Field("username") String username, @Field("password") String password);

    @GET("user/logout/json")
    Observable<WanModule<WanLoginData>> getUserLoginOut();

    @GET("lg/collect/list/{page}/json")
    Observable<WanModule<WanArticleBean>> getCollectArticleList(@Path("page") int page);

    @POST("lg/collect/{aid}/json")
    Observable<WanModule<WanCommonBean>> postCollectArticle(@Path("aid") int aid);

    @POST("lg/uncollect_originId/{aid}/json")
    Observable<WanModule<WanCommonBean>> postUncollectArticle(@Path("aid") int aid);

    @POST("article/query/{page}/json")
    @FormUrlEncoded
    Observable<WanModule<WanArticleBean>> getSearch(@Path("page") int page, @Field("k") String keywords);

}
