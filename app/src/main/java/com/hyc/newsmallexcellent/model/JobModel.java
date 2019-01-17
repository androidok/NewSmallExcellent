package com.hyc.newsmallexcellent.model;

import com.hyc.newsmallexcellent.base.bean.BaseRequestBean;
import com.hyc.newsmallexcellent.bean.CategoryBean;
import com.hyc.newsmallexcellent.helper.RequestHelper;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Map;

public class JobModel {

  /**
   * 请求添加分类
   * @param category
   * @return
   */
  public Observable<BaseRequestBean<Object>> jobsClassification(String category) {
    return RequestHelper.getRequestApi().jobsClassification(category)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }

  /**
   * 请求删除分类
   * @param category
   * @return
   */
  public Observable<BaseRequestBean<Object>> deleteClassification(String category) {
    return RequestHelper.getRequestApi().deleteClassification(category)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }

  public Observable<BaseRequestBean<List<CategoryBean>>> queryAllCategory(){
    return RequestHelper.getRequestApi().queryCategory()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }

  public Observable<BaseRequestBean<Object>> publishJob(int userId,Map<String,Object> map){
    map.put("userId",userId);
    return RequestHelper.getRequestApi().publishJob(map)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }



}
